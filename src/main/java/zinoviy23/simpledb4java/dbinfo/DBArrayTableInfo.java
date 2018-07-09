package zinoviy23.simpledb4java.dbinfo;

/**
 * Class for information about arrays fields in classes. It creates additional table.
 */
public class DBArrayTableInfo {
    /**
     * Type, that contains array of second type
     */
    private final String firstType;

    /**
     * Type of array
     */
    private final String secondType;

    /**
     * field name(in class definition)
     */
    private final String fieldName;

    /**
     * Constructor, that takes types
     * @param firstType first type
     * @param secondType second type
     * @param fieldName fieldName
     */
    public DBArrayTableInfo(String firstType, String secondType, String fieldName) {
        this.firstType = firstType;
        this.secondType = secondType;
        this.fieldName = fieldName;
    }

    /**
     * Gets first type
     * @return first type
     */
    public String getFirstType() {
        return firstType;
    }

    /**
     * Gets second type
     * @return second type
     */
    public String getSecondType() {
        return secondType;
    }

    /**
     * Gets field name
     * @return field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Gets table name
     * @return table name
     */
    public String getTableName() {
        return String.format("%s_%s_%s", firstType, secondType, fieldName);
    }

    /**
     * Gets query representation of class. Query is intended for creation this table.
     * @return query for creating table.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ").append(getTableName()).append("(").append("first INTEGER, second ");
        switch (secondType) {
            case "int":
                sb.append("INT");
                break;
            case "float":
                sb.append("FLOAT");
                break;
            case "String":
                sb.append("VARCHAR(255)");
                break;
            default:
                sb.append("INTEGER");
                break;
        }
        sb.append(")");
        return sb.toString();
    }
}
