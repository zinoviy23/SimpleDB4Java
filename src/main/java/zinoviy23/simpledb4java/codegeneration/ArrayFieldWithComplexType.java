package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.NotNull;

/**
 * Class for array fields of generated class
 */
public class ArrayFieldWithComplexType implements GeneratedField {
    /**
     * Array type
     */
    private final String type;
    /**
     * field name
     */
    private final String name;
    /**
     * array table name
     */
    private final String tableName;

    /**
     * Constructor with parameters for all fields
     * @param type array type
     * @param name field name
     * @param tableName array table name
     */
    public ArrayFieldWithComplexType(@NotNull String type, @NotNull String name, @NotNull String tableName) {
        this.type = type;
        this.name = name;
        this.tableName = tableName;
    }

    /**
     * Gets array type
     * @return array type
     */
    @NotNull
    public String getType() {
        return type;
    }

    /**
     * Gets field name
     * @return field name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Gets array table name
     * @return field name
     */
    @NotNull
    public String getTableName() {
        return tableName;
    }

    /**
     * Creates code for get---() method
     * @return code of get array method
     */
    String getArrayMethod() {
        return
                String.format(
                        "    public List<%s> get%s() {\n" +
                        "        return DBService().getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select second from %s where first=%%d\", id),\n" +
                        "            set -> {\n" +
                        "                List<%s> list = new ArrayList<>();\n" +
                        "                while (set.next()) {\n" +
                        "                    %s.getById(set.getLong(1)).ifPresent(list::add);\n" +
                        "                }\n" +
                        "                return list;\n" +
                        "            });\n" +
                        "    }\n\n",
                        type, Utils.getStringWithCapitalFirstChar(name), tableName, type, type);
    }

    /**
     * Generates code for add method for array
     * @return code of add method
     */
    String getAddMethod() {
        return
                String.format("" +
                        "    public void add%s(%s %s) {\n" +
                        "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                        "            String.format(\"insert into %s (first, second) values (%%d, %%d)\", id, %s.getId())\n" +
                        "        );\n" +
                        "    }\n\n",
                        Utils.getStringWithCapitalFirstChar(name), type, name, tableName, name);
    }

    /**
     * Generates code for remove method of array
     * @return code of remove method
     */
    String getRemoveMethod() {
        return
                String.format("" +
                        "    public void remove%s(%s %s) {\n" +
                        "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                        "            String.format(\"delete from %s where first=%%d and second=%%d\", id, %s.getId())\n" +
                        "        );\n" +
                        "    }\n\n", Utils.getStringWithCapitalFirstChar(name), type, name, tableName, name);
    }

    /**
     * Simple toString
     * @return information about fields
     */
    @Override
    public String toString() {
        return "ArrayFieldWithComplexType{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }

    /**
     * Creates code for this type of field
     * @return generated code for field
     */
    @Override
    public String getGeneratedCode() {
        return getArrayMethod() + getAddMethod() + getRemoveMethod();
    }
}
