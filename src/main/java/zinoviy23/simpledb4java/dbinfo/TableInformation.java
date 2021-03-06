package zinoviy23.simpledb4java.dbinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about table
 */
public class TableInformation {

    /**
     * Gets table name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Types of columns
     */
    public enum ColumnType {
        /**
         * ID for table elements
         */
        ID,

        /**
         * Int field
         */
        INT,

        /**
         * Long field
         */
        LONG,

        /**
         * Char field
         */
        STRING,

        /**
         * floating field
         */
        FLOAT,

        /**
         * ID of element from other table
         */
        OTHER_ID;

        /**
         * Gets column type by string
         * @param string string representation of type
         * @return column type
         */
        public static ColumnType fromString(String string) {
            switch (string) {
                case "int":
                    return INT;
                case "String":
                    return STRING;
                case "float":
                    return FLOAT;
                case "long":
                    return LONG;
                default:
                    return OTHER_ID;
            }
        }
    }

    /**
     * Inner class for column information
     */
    public static class ColumnInfo {
        /**
         * Column name
         */
        private final String name;

        /**
         * Column type
         */
        private final ColumnType type;


        /**
         * Constructor for column info
         * @param name column name
         * @param type column type
         */
        public ColumnInfo(String name, ColumnType type) {
            this.name = name;
            this.type = type;
        }

        /**
         * Gets column name
         * @return column name
         */
        public String getName() {
            return name;
        }

        /**
         * Gets column type
         * @return column type
         */
        public ColumnType getType() {
            return type;
        }

        /**
         * Converts column info to sql column definition
         * @return sql column
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name).append(" ");
            switch (type) {
                case ID:
                    sb.append("INTEGER PRIMARY KEY AUTOINCREMENT");
                    break;
                case INT:
                    sb.append("INT");
                    break;
                case LONG:
                    sb.append("INTEGER");
                    break;
                case STRING:
                    sb.append("VARCHAR(255)");
                    break;
                case FLOAT:
                    sb.append("FLOAT");
                    break;
                case OTHER_ID:
                    sb.append("INTEGER");
                    break;
            }
            return sb.toString();
        }
    }

    /**
     * Table name
     */
    private final String name;

    /**
     * Columns
     */
    private List<ColumnInfo> columnInfos = new ArrayList<>();

    /**
     * Constructor with list parameter
     * @param name table name
     * @param columnInfos columns
     */
    public TableInformation(String name, List<ColumnInfo> columnInfos) {
        this.name = name;
        this.columnInfos = columnInfos;
    }

    /**
     * Constructor, which creates empty table
     * @param name table name
     */
    public TableInformation(String name) {
        this.name = name;
    }

    /**
     * Gets column at <i>index</i> position
     * @param index position, where needed column is placed
     * @return column at <i>index</i>
     */
    public ColumnInfo get(int index) {
        return columnInfos.get(index);
    }

    /**
     * Adds new column at end of table.
     * @param element new column
     */
    public void add(ColumnInfo element) {
        columnInfos.add(element);
    }

    /**
     * Gets column count
     * @return amount of columns at table
     */
    public int size() {
        return columnInfos.size();
    }

    /**
     * Gets string representation like sql query
     * @return sql query
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ").append(name).append(" (");

        for (ColumnInfo ci: columnInfos) {
            sb.append(ci);
            sb.append(", ");
        }
        if (columnInfos.size() > 0)
            sb.delete(sb.length() - 2, sb.length());

        sb.append(")");

        return sb.toString();
    }
}
