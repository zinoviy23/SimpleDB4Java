package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Class with utils for working with code generation
 */
public class Utils {

    /**
     * private constructor
     */
    private Utils() {

    }

    /**
     * Gets string with first capital latter
     * @param str string, where is needed to change case of first latter
     * @return string with first capital latter
     */
    @NotNull
    public static String getStringWithCapitalFirstChar(@NotNull String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * Gets name of wrapping type for simple type
     * @param typeName simple type name
     * @return wrapping type name
     */
    @Contract(pure = true)
    @NotNull
    public static String getWrappingTypeName(@NotNull String typeName) {
        switch (typeName) {
            case "int":
                return "Integer";
            case "long":
                return "Long";
            case "float":
                return "Float";
            default:
                return typeName;
        }
    }

    /**
     * Gets part of get* method name by type name
     * @param typeName type name
     * @return part of method name
     */
    @Contract(pure = true)
    public static String getMethodNameByType(@NotNull String typeName) {
        switch (typeName) {
            case "int":
                return "Int";
            case "long":
                return "Long";
            case "float":
                return "Float";
            case "String":
                return "String";
            default:
                return "Long";
        }
    }

}
