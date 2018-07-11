package zinoviy23.simpledb4java.parsing;

public class TypeCheckingTreeResult {
    public final String type;

    public final String value;

    public TypeCheckingTreeResult(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TypeCheckingTreeResult{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public enum TypeCompareResult {
        LESS,
        GREAT,
        EQ,
        ERROR
    }

    public static TypeCompareResult compareTypes(String type1, String type2) {
        if (type1.equals("null") && !(type2.equals("int") || type2.equals("float") || type2.equals("long")))
            return TypeCompareResult.EQ;

        if (type2.equals("null") && !(type1.equals("int") || type1.equals("float") || type1.equals("long")))
            return TypeCompareResult.EQ;

        if (type1.equals(type2))
            return TypeCompareResult.EQ;

        if ((type1.equals("long") || type1.equals("float")) && type2.equals("int"))
            return TypeCompareResult.GREAT;

        if ((type1.equals("int") && (type2.equals("float") || type2.equals("long"))))
            return TypeCompareResult.LESS;

        if (type1.equals("long") && type2.equals("float"))
            return TypeCompareResult.LESS;

        if (type1.equals("float") && type2.equals("long"))
            return TypeCompareResult.GREAT;

        return TypeCompareResult.ERROR;
    }
}
