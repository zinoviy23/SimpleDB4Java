package zinoviy23.simpledb4java.codegeneration;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.stream.Collectors;

/**
 * Represents generated method
 */
public class GeneratedMethod {
    /**
     * Method info
     */
    private  final SimpleDBGrammarParser.MethodInfo methodInfo;

    /**
     * Method body
     */
    private final String body;

    public GeneratedMethod(SimpleDBGrammarParser.MethodInfo methodInfo, String body) {
        this.methodInfo = methodInfo;
        this.body = body;
    }

    public String getGeneratedCode() {
        String args = String.join(", ",
                methodInfo.arguments.entrySet().stream()
                        .map(entry -> String.format("%s %s", entry.getValue(), entry.getKey())).collect(Collectors.toList()));
        String type = methodInfo.type.endsWith("[]")
                ? String.format("List<%s>", Utils.getWrappingTypeName(methodInfo.type.replace("[]", "")))
                : methodInfo.type;
        return String.format("public %s%s %s(%s)\n%s\n\n", methodInfo.isStatic ? "static " : "", type, methodInfo.name, args, body);
    }
}
