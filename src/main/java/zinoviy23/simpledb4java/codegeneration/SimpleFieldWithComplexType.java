package zinoviy23.simpledb4java.codegeneration;

/**
 * Generator for field with complex type
 */
public class SimpleFieldWithComplexType implements GeneratedField {

    /**
     * type of field
     */
    private final String type;

    /**
     * field name
     */
    private final String name;


    /**
     * Constructor with parameters for all fields
     * @param type field type
     * @param name field name
     */
    public SimpleFieldWithComplexType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Gets generated code
     * @return generated code
     */
    @Override
    public String getGeneratedCode() {
        return String.format("    private long %s;\n" +
                "\n" +
                "    public Optional<%s> get%s() {\n" +
                "        return %s.getById(%s);\n" +
                "    }\n" +
                "\n" +
                "    public void set%s(%s %s) {\n" +
                "        this.%s = %s.getId();\n" +
                "        update();\n" +
                "    }\n" +
                "\n",
                name, type, Utils.getStringWithCapitalFirstChar(name), type, name,
                Utils.getStringWithCapitalFirstChar(name), type, name, name, name);
    }

    /**
     * Gets field type
     * @return field type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets field name
     * @return field name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SimpleFieldWithComplexType{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
