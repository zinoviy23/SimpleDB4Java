// Generated from /home/sanusha/Proga/SimpleDB4Java/src/main/antlr/SimpleDBGrammar.g4 by ANTLR 4.7
package zinoviy23.simpledb4java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleDBGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleDBGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SimpleDBGrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#fileHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeId(SimpleDBGrammarParser.TypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#fieldDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDef(SimpleDBGrammarParser.FieldDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(SimpleDBGrammarParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(SimpleDBGrammarParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#incrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrExpr(SimpleDBGrammarParser.IncrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#unaryPostExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPostExpr(SimpleDBGrammarParser.UnaryPostExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#dottedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedId(SimpleDBGrammarParser.DottedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#arrayElementGetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementGetting(SimpleDBGrammarParser.ArrayElementGettingContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleDBGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#arrIndexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrIndexList(SimpleDBGrammarParser.ArrIndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(SimpleDBGrammarParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#callArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#simpleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCommand(SimpleDBGrammarParser.SimpleCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#queryDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryDef(SimpleDBGrammarParser.QueryDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#funcArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgList(SimpleDBGrammarParser.FuncArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleDBGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#forCycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCycle(SimpleDBGrammarParser.ForCycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SimpleDBGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(SimpleDBGrammarParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SimpleDBGrammarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleDBGrammarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SimpleDBGrammarParser.ConstantContext ctx);
}