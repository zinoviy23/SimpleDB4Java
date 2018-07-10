package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests array of simple type generator
 */
public class ArrayFieldWithSimpleTypeTest {

    /**
     *get- method test
     */
    @Test
    public void getArrayMethodTest() {
        ArrayFieldWithSimpleType field = new ArrayFieldWithSimpleType("int", "ints", "User_int_ints");

        assertEquals(
                "    public List<Integer> getInts() {\n" +
                        "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select second from User_int_ints where first=%d\", id),\n" +
                        "            set -> {\n" +
                        "                List<Integer> list = new ArrayList<>();\n" +
                        "                while (set.next()) {\n" +
                        "                    list.add(set.getInt(1));\n" +
                        "                }\n" +
                        "                return list;\n" +
                        "            });\n" +
                        "    }\n" +
                        "\n", field.getArrayMethod());
    }

    /**
     * tests add method generator
     */
    @Test
    public void getAddMethodTest() {
        ArrayFieldWithSimpleType field = new ArrayFieldWithSimpleType("int", "ints", "User_int_ints");

        assertEquals("    public void addInts(int ints) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into User_int_ints (first, second) values(%d, '%s')\", id, ints)\n" +
                "        );\n" +
                "    }\n" +
                "\n", field.getAddMethod());
    }

    /**
     * tests remove method generator
     */
    @Test
    public void getRemoveMethodTest() {
        ArrayFieldWithSimpleType field = new ArrayFieldWithSimpleType("String", "str", "User_String_str");

        assertEquals("    public void removeStr(String str) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"delete from User_String_str where first=%d and second='%s'\", id, str)\n" +
                "        );\n" +
                "    }\n" +
                "\n", field.getRemoveMethod());
    }

    @Test
    public void getGeneratedCodeTest() {
        ArrayFieldWithSimpleType field = new ArrayFieldWithSimpleType("int", "ints", "User_int_ints");

        assertEquals("    public List<Integer> getInts() {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select second from User_int_ints where first=%d\", id),\n" +
                "            set -> {\n" +
                "                List<Integer> list = new ArrayList<>();\n" +
                "                while (set.next()) {\n" +
                "                    list.add(set.getInt(1));\n" +
                "                }\n" +
                "                return list;\n" +
                "            });\n" +
                "    }\n" +
                "\n" +
                "    public void addInts(int ints) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into User_int_ints (first, second) values(%d, '%s')\", id, ints)\n" +
                "        );\n" +
                "    }\n" +
                "\n" +
                "    public void removeInts(int ints) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"delete from User_int_ints where first=%d and second='%s'\", id, ints)\n" +
                "        );\n" +
                "    }\n" +
                "\n", field.getGeneratedCode());
    }
}