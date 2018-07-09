package zinoviy23.simpledb4java.codegeneration;

import org.jetbrains.annotations.NotNull;

/**
 * Class for array fields of generated class
 */
public class ArrayField {
    private final String type;
    private final String name;
    private final String tableName;

    public ArrayField(@NotNull String type, @NotNull String name, @NotNull String tableName) {
        this.type = type;
        this.name = name;
        this.tableName = tableName;
    }

    @NotNull
    public String getType() {
        return type;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getTableName() {
        return tableName;
    }
}
