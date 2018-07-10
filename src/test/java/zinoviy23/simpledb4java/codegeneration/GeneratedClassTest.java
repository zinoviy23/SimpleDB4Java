package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing GeneratedClass class.
 */
public class GeneratedClassTest {

    /**
     * Code generation test
     */
    @Test
    public void getGeneratedCodeTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));

        assertEquals(
                "package db;\n\nimport java.util.*;\n\npublic class A {\n    private long id;\n\n" +
                "    public long getId() {\n        return id;\n    }\n\n" +
                "    private int a;\n\n    public int getA() {\n        return a;\n    }\n\n" +
                "    public void setA(int a) {\n        this.a = a;\n        update();\n    }\n\n" +
                "    private String B;\n\n    public String getB() {\n        return B;\n    }\n\n" +
                "    public void setB(String B) {\n        this.B = B;\n        update();\n    }\n\n" +
                        "    public static List<A> all() {\n" +
                        "        return DBService.getInstance().getExecutor().executeQuery(\"select id from A\",\n" +
                        "            set -> {\n" +
                        "                List<A> list = new ArrayList<>();\n" +
                        "                    while (set.next()) {\n" +
                        "                        A.getById(set.getLong(1)).ifPresent(list::add);\n" +
                        "                    }\n" +
                        "                    return list;\n" +
                        "            });\n" +
                        "    }\n" +
                        "\n" +
                        "    public static Optional<A> getById(long id) {\n" +
                        "        A obj = DBService.getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select a, B from A where id=%d\", id),\n" +
                        "            set -> !set.isClosed() ? new A(set.getInt(1), set.getString(2)) : null);\n" +
                        "        if (obj == null)\n" +
                        "            return Optional.empty();\n" +
                        "        obj.id = id;\n" +
                        "        return Optional.of(obj);\n" +
                        "    }\n" +
                        "\n" +
                        "    public static Optional<A> min(Comparator<A> comparator) {\n" +
                        "        return all().stream().min(comparator);\n" +
                        "    }\n" +
                        "\n" +
                        "    public static Optional<A> max(Comparator<A> comparator) {\n" +
                        "        return all().stream().max(comparator);\n" +
                        "    }\n" +
                        "\n" +
                        "    public static Optional<A> find(String sql) {\n" +
                        "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select id from A where %s\", sql),\n" +
                        "            set -> !set.isClosed() ? A.getById(set.getLong(1)) : Optional.empty());\n" +
                        "    }\n" +
                        "\n" +
                        "    public static List<A> findAll(String sql) {\n" +
                        "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                        "            String.format(\"select id from A where %s\", sql),\n" +
                        "            set -> {\n" +
                        "                List<A> list = new ArrayList<>();\n" +
                        "                while (set.next()) {\n" +
                        "                    A.getById(set.getLong(1)).ifPresent(list::add);\n" +
                        "                }\n" +
                        "                return list;\n" +
                        "             });\n" +
                        "    }\n" +
                        "\n" +
                        "    private A(int a, String B) {\n" +
                        "        this.a = a;\n" +
                        "        this.B = B;\n" +
                        "    }\n" +
                        "\n" +
                        "    public static A create(int a, String B) {\n" +
                        "        A obj = new A(a, B);\n" +
                        "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                        "            String.format(\"insert into A (a, B) values ('%s', '%s')\", a, B));\n" +
                        "        obj.id = DBService.getInstance().getExecutor().executeQuery(\"select last_insert_rowid()\",\n" +
                        "                set -> set.getLong(1));\n" +
                        "        return obj;\n" +
                        "    }\n" +
                        "\n" +
                        "    private void update() {\n" +
                        "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                        "            String.format(\"update A set a='%s', B='%s' where id=%d\"\n" +
                        "                , a, B, id));\n" +
                        "    }" +
                        "\n\n" +
                        "    public static void removeById(long id) {\n" +
                        "        DBService.getInstance().getExecutor().executeUpdate(" +
                        "String.format(\"delete from A where id=%d\", id));\n" +
                        "    }\n" +
                        "\n}",
                generatedClass.getGenereatedCode());
    }

    /**
     * Test all() generation method
     */
    @Test
    public void getAllMethodTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");

        assertEquals("    public static List<A> all() {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\"select id from A\",\n" +
                "            set -> {\n" +
                "                List<A> list = new ArrayList<>();\n" +
                "                    while (set.next()) {\n" +
                "                        A.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                    }\n" +
                "                    return list;\n" +
                "            });\n" +
                "    }\n" +
                "\n", generatedClass.getAllMethod());
    }

    /**
     * Tests getById() generation method
     */
    @Test
    public void getGetByIdMethodTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));
        generatedClass.addField(new SimpleFieldWithComplexType("L", "lol"));

        assertEquals("    public static Optional<A> getById(long id) {\n" +
                "        A obj = DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select a, B, lol from A where id=%d\", id),\n" +
                "            set -> !set.isClosed() ? new A(set.getInt(1), set.getString(2), \n" +
                "                L.getById(set.getLong(3)).orElseThrow(() -> new RuntimeException(" +
                "\"Wrong data! Can't find L by id!\"))\n" +
                "            ) : null);\n" +
                "        if (obj == null)\n" +
                "            return Optional.empty();\n" +
                "        obj.id = id;\n" +
                "        return Optional.of(obj);\n" +
                "    }\n\n", generatedClass.getGetByIdMethod());
    }

    /**
     * Tests min() and max() generation methods
     */
    @Test
    public void getMinMaxMethodsTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));

        assertEquals("    public static Optional<A> min(Comparator<A> comparator) {\n" +
                "        return all().stream().min(comparator);\n" +
                "    }\n" +
                "\n" +
                "    public static Optional<A> max(Comparator<A> comparator) {\n" +
                "        return all().stream().max(comparator);\n" +
                "    }\n" +
                "\n", generatedClass.getMinMaxMethods());
    }

    /**
     * Tests find() and findAll() generation method
     */
    @Test
    public void getFindMethods() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");

        assertEquals("    public static Optional<A> find(String sql) {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select id from A where %s\", sql),\n" +
                "            set -> !set.isClosed() ? A.getById(set.getLong(1)) : Optional.empty());\n" +
                "    }\n" +
                "\n" +
                "    public static List<A> findAll(String sql) {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select id from A where %s\", sql),\n" +
                "            set -> {\n" +
                "                List<A> list = new ArrayList<>();\n" +
                "                while (set.next()) {\n" +
                "                    A.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                }\n" +
                "                return list;\n" +
                "             });\n" +
                "    }\n" +
                "\n", generatedClass.getFindMethods());
    }

    /**
     * Tests constructor generation
     */
    @Test
    public void getConstructorTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));
        generatedClass.addField(new SimpleFieldWithComplexType("L", "lol"));

        assertEquals("    private A(int a, String B, L lol) {\n" +
                "        this.a = a;\n" +
                "        this.B = B;\n" +
                "        this.lol = lol.getId();\n" +
                "    }\n" +
                "\n", generatedClass.getConstructor());
    }

    /**
     * Tests generation of create() method
     */
    @Test
    public void getCreateMethodTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));
        generatedClass.addField(new SimpleFieldWithComplexType("L", "lol"));

        assertEquals("    public static A create(int a, String B, L lol) {\n" +
                "        A obj = new A(a, B, lol);\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into A (a, B, lol) values ('%s', '%s', '%s')\", a, B, lol.getId()));\n" +
                "        obj.id = DBService.getInstance().getExecutor().executeQuery(\"select last_insert_rowid()\",\n" +
                "                set -> set.getLong(1));\n" +
                "        return obj;\n" +
                "    }\n" +
                "\n", generatedClass.getCreateMethod());
    }

    /**
     * Tests generation of update method
     */
    @Test
    public void getUpdateMethodTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));
        generatedClass.addField(new SimpleFieldWithComplexType("L", "lol"));

        assertEquals("    private void update() {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"update A set a='%s', B='%s', lol='%s' where id=%d\"\n" +
                "                , a, B, lol, id));\n" +
                "    }\n" +
                "\n", generatedClass.getUpdateMethod());

    }

    /**
     * Tests removeById() method generation
     */
    @Test
    public void getRemoveByIdMethodTest() {
        GeneratedClass generatedClass = new GeneratedClass("A", "db");
        generatedClass.addField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addField(new SimpleFieldWithSimpleType("String", "B"));
        generatedClass.addField(new SimpleFieldWithComplexType("L", "lol"));

        assertEquals("    public static void removeById(long id) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(String.format(\"delete from A where id=%d\", id));\n" +
                "    }\n" +
                "\n", generatedClass.getRemoveByIdMehtod());
    }
}