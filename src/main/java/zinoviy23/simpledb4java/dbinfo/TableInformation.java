package zinoviy23.simpledb4java.dbinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about table
 * @author zinoviy23@gmail.com
 */
public class TableInformation {

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
         * Array of elements. It is used with additional table
         */
        //TODO: arrays of types
        ARRAY
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
    }

    /**
     * Columns
     */
    private List<ColumnInfo> columnInfos = new ArrayList<>();

    /**
     * Constructor with list parameter
     * @param columnInfos columns
     */
    public TableInformation(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    /**
     * Constructor, which creates empty table
     */
    public TableInformation() {
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
}
