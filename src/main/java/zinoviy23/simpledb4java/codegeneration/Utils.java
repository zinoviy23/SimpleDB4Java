package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.NotNull;

/**
 * Class with utils for working with code generation
 * @author zinoviy23@gmail.com
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

}
