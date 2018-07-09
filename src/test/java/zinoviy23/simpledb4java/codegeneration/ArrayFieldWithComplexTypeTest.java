package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing complex array field
 */
public class ArrayFieldWithComplexTypeTest {
    /**
     * Tests method, which generates code for get method
     */
    @Test
    public void getArrayMethodTest() {
        ArrayFieldWithComplexType field = new ArrayFieldWithComplexType("Animal", "field", "User_Animal_field");

        assertEquals("    public List<Animal> getField() {\n" +
                "        return DBService().getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select second from User_Animal_field where first=%d\", id),\n" +
                "            set -> {\n" +
                "                List<Animal> list = new ArrayList<>();\n" +
                "                while (set.next()) {\n" +
                "                    Animal.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                }\n" +
                "                return list;\n" +
                "            });\n" +
                "    }\n\n", field.getArrayMethod());
    }

    /**
     * Tests method, which generates code for add method
     */
    @Test
    public void getAddMethodTest() {
        ArrayFieldWithComplexType field = new ArrayFieldWithComplexType("Animal", "field", "User_Animal_field");

        assertEquals("    public void addField(Animal field) {\n" +
                "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into User_Animal_field (first, second) values (%d, %d)\", id, field.getId())\n" +
                "        );\n" +
                "    }\n\n", field.getAddMethod());
    }

    /**
     * Tests method, which generates code for remove method
     */
    @Test
    public void getRemoveMethodTest() {
        ArrayFieldWithComplexType field = new ArrayFieldWithComplexType("Animal", "field", "User_Animal_field");

        assertEquals("    public void removeField(Animal field) {\n" +
                "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"delete from User_Animal_field where first=%d and second=%d\", id, field.getId())\n" +
                "        );\n" +
                "    }\n\n", field.getRemoveMethod());
    }

    /**
     * Tests method, which generates all code
     */
    @Test
    public void toStringTest() {
        ArrayFieldWithComplexType field = new ArrayFieldWithComplexType("Animal", "field", "User_Animal_field");

        assertEquals("    public List<Animal> getField() {\n" +
                "        return DBService().getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select second from User_Animal_field where first=%d\", id),\n" +
                "            set -> {\n" +
                "                List<Animal> list = new ArrayList<>();\n" +
                "                while (set.next()) {\n" +
                "                    Animal.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                }\n" +
                "                return list;\n" +
                "            });\n" +
                "    }\n" +
                "\n" +
                "    public void addField(Animal field) {\n" +
                "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into User_Animal_field (first, second) values (%d, %d)\", id, field.getId())\n" +
                "        );\n" +
                "    }\n" +
                "\n" +
                "    public void removeField(Animal field) {\n" +
                "        DBService().getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"delete from User_Animal_field where first=%d and second=%d\", id, field.getId())\n" +
                "        );\n" +
                "    }\n" +
                "\n", field.getGeneratedCode());
    }
}