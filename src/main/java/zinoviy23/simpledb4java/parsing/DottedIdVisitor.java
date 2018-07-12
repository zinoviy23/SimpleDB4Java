package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.Utils;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Visitor for dotted id
 */
public class DottedIdVisitor extends SimpleDBGrammarBaseVisitor<TypeCheckingTreeResult> {
    /**
     * Class name
     */
    private final String currentClass;

    /**
     * is this ID first
     */
    private final boolean isFirst;

    public enum StaticStatus {
        STATIC, CANT_BE_STATIC, CAN_BE_STATIC;
    }

    /**
     * status for being static
     */
    private final StaticStatus status;

    /**
     * Constructor
     * @param currentClass current class
     * @param isFirst is this ID first
     * @param status status for being static
     */
    public DottedIdVisitor(String currentClass, boolean isFirst, StaticStatus status) {
        this.currentClass = currentClass;
        this.isFirst = isFirst;
        this.status = status;
    }

    @Override
    public TypeCheckingTreeResult visitDottedId(SimpleDBGrammarParser.DottedIdContext ctx) {
        String name = ctx.ID().getText();
        String type = null;
        // this is class name or field or variable
        if (ctx.LPAR() == null) {

            StaticStatus currentStatus = StaticStatus.CAN_BE_STATIC;

            boolean isField = true;
            if (isFirst)
                type = SimpleDBGrammarListenerImpl.findVariable(name);
            if (type == null) {
                if (SimpleDBGrammarParser.fieldsSymbolTable.get(currentClass).containsKey(name)) {
                    type = SimpleDBGrammarParser.fieldsSymbolTable.get(currentClass).get(name);
                    currentStatus = StaticStatus.CANT_BE_STATIC;
                }
            } else {
                isField = false;
            }
            if (isFirst && type == null) {
                if (SimpleDBGrammarParser.classesSymbolTable.contains(name)) {
                    type = name;
                    currentStatus = StaticStatus.STATIC;
                    isField = false;
                }
            }
            if (type == null) {
                throw new RuntimeException(String.format("Unknown id %s. In line %s", name, ctx.getStart().getLine()));
            }
            if (status == StaticStatus.STATIC && isField)
                throw new RuntimeException(String.format("Field can't be static. %s in class %s. In line %s", name,
                        currentClass, ctx.getStart().getLine()));

            if (ctx.dottedId() != null) {
                TypeCheckingTreeResult result = ctx.dottedId().accept(new DottedIdVisitor(type, false, currentStatus));
                return new TypeCheckingTreeResult(result.type, String.format("%s.%s",
                        (currentStatus == StaticStatus.STATIC) ? name : ((isField) ? "get" + Utils.getStringWithCapitalFirstChar(name) + "()" : name),
                        result.value));
            } else {
                return new TypeCheckingTreeResult(type, (currentStatus == StaticStatus.STATIC) ?
                    name : ((isField) ? "get" + Utils.getStringWithCapitalFirstChar(name) + "()" : name));
            }
        } else { // for functions
            SimpleDBGrammarParser.MethodInfo methodInfo = null;
            if (SimpleDBGrammarParser.methodsSymbolTable.get(currentClass).containsKey(name))
                methodInfo = SimpleDBGrammarParser.methodsSymbolTable.get(currentClass).get(name);

            if (methodInfo == null) {
                throw new RuntimeException(String.format("Unknown method id %s. In line %s", name, ctx.getStart().getLine()));
            }

            if (status == StaticStatus.CANT_BE_STATIC && methodInfo.isStatic)
                throw new RuntimeException(String.format("%s is static method in line %s", name, ctx.getStart().getLine()));
            if (status == StaticStatus.STATIC && !methodInfo.isStatic)
                throw new RuntimeException(String.format("%s is not static method in line %s", name, ctx.getStart().getLine()));

            if (methodInfo.arguments != null) {
                List<TypeCheckingTreeResult> args = ctx.callArgList().accept(new CallListArgsVisitor(currentClass));

                if (methodInfo.arguments.size() == args.size()) {
                    final ListIterator<TypeCheckingTreeResult> it = args.listIterator();
                    methodInfo.arguments.forEach((argName, argType) -> {
                        TypeCheckingTreeResult current = it.next();
                        TypeCheckingTreeResult.TypeCompareResult res = TypeCheckingTreeResult.compareTypes(argType, current.type);
                        if (res != TypeCheckingTreeResult.TypeCompareResult.EQ && res != TypeCheckingTreeResult.TypeCompareResult.GREAT)
                            throw new RuntimeException(
                                    String.format("Wrong param type for %s in class %s in method %s. Expected %s, actual %s. In line %s",
                                            argName, currentClass, name, argType, current.type, ctx.getStart().getLine()));
                    });
                } else {
                    throw new RuntimeException(
                            String.format("Wrong param arguments count for %s in class %s. In line %s",
                                    name, currentClass, ctx.getStart().getLine()));
                }

                String argsStr = String.join(", ", args.stream().map(arg -> arg.value).collect(Collectors.toList()));
                if (!name.equals("getById")) {
                    if (ctx.dottedId() != null) {
                        TypeCheckingTreeResult result = ctx.dottedId().accept(new DottedIdVisitor(methodInfo.type, false,
                                StaticStatus.CANT_BE_STATIC));
                        return new TypeCheckingTreeResult(result.type, String.format("%s(%s).%s", name, argsStr, result.value));
                    } else {
                        return new TypeCheckingTreeResult(methodInfo.type, String.format("%s(%s)", name, argsStr));
                    }
                } else {
                    if (ctx.dottedId() != null) {
                        TypeCheckingTreeResult result = ctx.dottedId().accept(new DottedIdVisitor(methodInfo.type, false,
                                StaticStatus.CANT_BE_STATIC));
                        return new TypeCheckingTreeResult(result.type, String.format("%s(%s).orElse(null).%s",
                                name, argsStr, result.value));
                    } else {
                        return new TypeCheckingTreeResult(methodInfo.type, String.format("%s(%s).orElse(null)", name, argsStr));
                    }
                }
            } else {
                if (ctx.ID().getText().equals("min") || ctx.ID().getText().equals("max")) {
                    if (ctx.dottedId() != null) {
                        TypeCheckingTreeResult result = ctx.dottedId().accept(new DottedIdVisitor(methodInfo.type, false,
                                StaticStatus.CANT_BE_STATIC));
                        return new TypeCheckingTreeResult(result.type, String.format("%s(%s).orElse(null).%s",
                                name, ctx.callArgList().accept(new CallArgListForMinMaxVisitor(currentClass)), result.value));
                    } else {
                        return new TypeCheckingTreeResult(methodInfo.type, String.format("%s(%s).orElse(null)", name,
                                ctx.callArgList().accept(new CallArgListForMinMaxVisitor(currentClass))));
                    }
                } else  {
                    if (ctx.dottedId() != null) {
                        TypeCheckingTreeResult result = ctx.dottedId().accept(new DottedIdVisitor(methodInfo.type, false,
                                StaticStatus.CANT_BE_STATIC));
                        if (name.equals("find")) {
                            return new TypeCheckingTreeResult(result.type, String.format("%s(%s).orElse(null).%s",
                                    name, ctx.callArgList().accept(new CallArgListForFindVisitor(currentClass)).value, result.value));
                        }
                        return new TypeCheckingTreeResult(result.type, String.format("%s(%s).%s",
                                name, ctx.callArgList().accept(new CallArgListForFindVisitor(currentClass)).value, result.value));
                    } else {
                        if (name.equals("find")) {
                            return new TypeCheckingTreeResult(methodInfo.type, String.format("%s(%s).orElse(null)", name,
                                    ctx.callArgList().accept(new CallArgListForFindVisitor(currentClass)).value));
                        }
                        return new TypeCheckingTreeResult(methodInfo.type, String.format("%s(%s)", name,
                                ctx.callArgList().accept(new CallArgListForFindVisitor(currentClass)).value));
                    }
                }
            }
        }
    }
}
