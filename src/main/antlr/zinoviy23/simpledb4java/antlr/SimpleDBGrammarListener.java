// Generated from /home/sanusha/Proga/SimpleDB4Java/src/main/antlr/SimpleDBGrammar.g4 by ANTLR 4.7
package zinoviy23.simpledb4java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleDBGrammarParser}.
 */
public interface SimpleDBGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SimpleDBGrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SimpleDBGrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#fileHeader}.
	 * @param ctx the parse tree
	 */
	void enterFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#fileHeader}.
	 * @param ctx the parse tree
	 */
	void exitFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void enterFieldDef(SimpleDBGrammarParser.FieldDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void exitFieldDef(SimpleDBGrammarParser.FieldDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(SimpleDBGrammarParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(SimpleDBGrammarParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#dottedId}.
	 * @param ctx the parse tree
	 */
	void enterDottedId(SimpleDBGrammarParser.DottedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#dottedId}.
	 * @param ctx the parse tree
	 */
	void exitDottedId(SimpleDBGrammarParser.DottedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleDBGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleDBGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#arrIndexList}.
	 * @param ctx the parse tree
	 */
	void enterArrIndexList(SimpleDBGrammarParser.ArrIndexListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#arrIndexList}.
	 * @param ctx the parse tree
	 */
	void exitArrIndexList(SimpleDBGrammarParser.ArrIndexListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#callArgList}.
	 * @param ctx the parse tree
	 */
	void enterCallArgList(SimpleDBGrammarParser.CallArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#callArgList}.
	 * @param ctx the parse tree
	 */
	void exitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#simpleCommand}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCommand(SimpleDBGrammarParser.SimpleCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#simpleCommand}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCommand(SimpleDBGrammarParser.SimpleCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#queryDef}.
	 * @param ctx the parse tree
	 */
	void enterQueryDef(SimpleDBGrammarParser.QueryDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#queryDef}.
	 * @param ctx the parse tree
	 */
	void exitQueryDef(SimpleDBGrammarParser.QueryDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#funcArgList}.
	 * @param ctx the parse tree
	 */
	void enterFuncArgList(SimpleDBGrammarParser.FuncArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#funcArgList}.
	 * @param ctx the parse tree
	 */
	void exitFuncArgList(SimpleDBGrammarParser.FuncArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleDBGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleDBGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#forCycle}.
	 * @param ctx the parse tree
	 */
	void enterForCycle(SimpleDBGrammarParser.ForCycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#forCycle}.
	 * @param ctx the parse tree
	 */
	void exitForCycle(SimpleDBGrammarParser.ForCycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleDBGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleDBGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(SimpleDBGrammarParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(SimpleDBGrammarParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleDBGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(SimpleDBGrammarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleDBGrammarParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(SimpleDBGrammarParser.ArrayContext ctx);
}