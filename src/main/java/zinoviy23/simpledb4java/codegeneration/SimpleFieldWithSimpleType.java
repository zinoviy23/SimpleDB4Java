package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.NotNull;

/**
 * Class for information and code generation for fields of simple types(like int, long, float, String). <b>(Without arrays)</b>
 */
public class SimpleFieldWithSimpleType implements GeneratedField {
    /**
     * SimpleFieldWithSimpleType type like int, String and etc.
     */
    private final String type;

    /**
     * SimpleFieldWithSimpleType name
     */
    private final String name;

    /**
     * Constructor with type and name parameter
     * @param type field type
     * @param name field name
     */
    public SimpleFieldWithSimpleType(@NotNull String type, @NotNull String name) {
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
     * Simple toString
     * @return information about fields
     */
    @Override
    public String toString() {
        return "SimpleFieldWithSimpleType{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Generates code for field with getters.
     * @return field declaration and getter method.
     */
    @Override
    public String getGeneratedCode() {
        return String.format(
                "    private %s %s;\n" +
                        "\n" +
                        "    public %s get%s() {\n" +
                        "        return %s;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void set%s(%s %s) {\n" +
                        "        this.%s = %s;\n" +
                        "        update();\n" +
                        "    }\n" +
                        "\n", type, name, type, Utils.getStringWithCapitalFirstChar(name), name,
                Utils.getStringWithCapitalFirstChar(name), type, name, name, name);
    }
}
