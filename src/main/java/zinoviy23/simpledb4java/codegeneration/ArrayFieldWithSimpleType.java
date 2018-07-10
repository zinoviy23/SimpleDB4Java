package zinoviy23.simpledb4java.codegeneration;

/**
 * Class for array field of simple types
 */
public class ArrayFieldWithSimpleType implements GeneratedField{

    /**
     * field type
     */
    private final String type;

    /**
     * field name
     */
    private final String name;

    /**
     * table name
     */
    private final String tableName;

    /**
     * Constructor with parameters for all fields
     * @param type field type
     * @param name field name
     * @param tableName table name
     */
    public ArrayFieldWithSimpleType(String type, String name, String tableName) {
        this.type = type;
        this.name = name;
        this.tableName = tableName;
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

    /**
     * Gets table name
     * @return table name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Creates code for get---() method
     * @return code of get array method
     */
    String getArrayMethod() {
        return String.format(
                "    public List<%s> get%s() {\n" +
                        "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select second from %s where first=%%d\", id),\n" +
                        "            set -> {\n" +
                        "                List<%s> list = new ArrayList<>();\n" +
                        "                while (set.next()) {\n" +
                        "                    list.add(set.get%s(1));\n" +
                        "                }\n" +
                        "                return list;\n" +
                        "            });\n" +
                        "    }\n" +
                        "\n",
                Utils.getWrappingTypeName(type), Utils.getStringWithCapitalFirstChar(name), tableName,
                Utils.getWrappingTypeName(type), Utils.getMethodNameByType(type)
        );
    }

    /**
     * Generates add method
     * @return add method code
     */
    String getAddMethod() {
        return String.format("    public void add%s(%s %s) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into %s (first, second) values(%%d, '%%s')\", id, %s)\n" +
                "        );\n" +
                "    }\n" +
                "\n",
                Utils.getStringWithCapitalFirstChar(name), type, name, tableName, name);
    }

    /**
     * Generates remove method
     * @return remove method code
     */
    String getRemoveMethod() {
        return String.format("    public void remove%s(%s %s) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"delete from %s where first=%%d and second='%%s'\", id, %s)\n" +
                "        );\n" +
                "    }\n" +
                "\n",
                Utils.getStringWithCapitalFirstChar(name), type, name, tableName, name);
    }

    @Override
    public String getGeneratedCode() {
        return getArrayMethod() + getAddMethod() + getRemoveMethod();
    }

    @Override
    public String toString() {
        return "ArrayFieldWithSimpleType{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
