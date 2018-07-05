package zinoviy23.simpledb4java.dbinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about table
 * @author zinoviy23@gmail.com
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
         * Inf field
         */
        INT,

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
        OTHER_ID,

        /**
         * Array of ints. It is used with additional table
         */
        ARRAY_INT,

        /**
         * Array of strings. It is used with additional table
         */
        ARRAY_STRING,

        /**
         * Array of floats. It is used with additional table
         */
        ARRAY_FLOAT,

        /**
         * Array of other_id. It is used with additional table  
         */
        ARRAY_ID,
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
                case STRING:
                    sb.append("VARCHAR(255)");
                    break;
                case FLOAT:
                    sb.append("FLOAT");
                    break;
                case OTHER_ID:
                    sb.append("INTEGER");
                    break;
                case ARRAY_INT:
                    //TODO: create table
                    break;
                case ARRAY_STRING:
                    //TODO: create table
                    break;
                case ARRAY_FLOAT:
                    //TODO: create table
                    break;
                case ARRAY_ID:
                    //TODO: create table
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
     * @param name
     * @param columnInfos columns
     */
    public TableInformation(String name, List<ColumnInfo> columnInfos) {
        this.name = name;
        this.columnInfos = columnInfos;
    }

    /**
     * Constructor, which creates empty table
     * @param name
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
