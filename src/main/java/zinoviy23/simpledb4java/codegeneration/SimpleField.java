package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.NotNull;

/**
 * Class for information and code generation for fields. <b>(Without arrays)</b>
 * @author zinoviy23@gmail.com
 */
public class SimpleField {
    /**
     * SimpleField type like int, String and etc.
     */
    private final String type;

    /**
     * SimpleField name
     */
    private final String name;

    /**
     * Constructor with type and name parameter
     * @param type field type
     * @param name field name
     */
    public SimpleField(@NotNull String type, @NotNull String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Gets type
     * @return type
     */
    @NotNull
    public String getType() {
        return type;
    }

    /**
     * Gets name
     * @return name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Generates code for field with getters.
     * @return field declaration and getter method.
     */
    @Override
    public String toString() {
        return String.format(
                "    private %s %s;\n" +
                "\n" +
                "    public %s get%s() {\n" +
                "        return %s;\n" +
                "    }\n" +
                "\n", type, name, type, Utils.getStringWithCapitalFirstChar(name), name);
    }
}
