package zinoviy23.simpledb4java.codegeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for generated class.
 */
public class GeneratedClass {
    /**
     * List of generatedFields
     */
    private List<GeneratedField> generatedFields = new ArrayList<>();

    /**
     * List of generated methods
     */
    private List<GeneratedMethod> generatedMethods = new ArrayList<>();

    /**
     * Class name
     */
    private final String name;

    /**
     * Package name
     */
    private final String packageName;

    /**
     * Constructor with name
     * @param name class name
     * @param packageName package name
     */
    public GeneratedClass(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    /**
     * Gets class name
     * @return class name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds field to class
     * @param field field
     * @return result of adding field to class
     */
    public boolean addField(GeneratedField field) {
        return generatedFields.add(field);
    }

    /**
     * Adds method to class
     * @param generatedMethod generated method
     * @return result of adding
     */
    public boolean addMethod(GeneratedMethod generatedMethod) {
        return generatedMethods.add(generatedMethod);
    }

    /**
     * Gets unmodifiable list of generatedFields
     * @return list of simple fields
     */
    public List<GeneratedField> getGeneratedFields() {
        return Collections.unmodifiableList(generatedFields);
    }

    /**
     * Generated code for id
     */
    private static final String genereatedIdCode =
                "    private long id;\n" +
                "\n" +
                "    public long getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n";

    /**
     * Simple toString
     * @return string representation
     */
    @Override
    public String toString() {
        return "GeneratedClass{" +
                "generatedFields=" + generatedFields +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }

    /**
     * Creates class source code.
     * @return string representation of class source code.
     */
    public String getGenereatedCode() {
        StringBuilder sb = new StringBuilder("package ").append(packageName).append(";\n\n").append("import java.util.*;\n\n")
                .append("public class ").append(name).append(" {\n").append(genereatedIdCode);
        for (GeneratedField field : generatedFields) {
            sb.append(field.getGeneratedCode());
        }

        for (GeneratedMethod method : generatedMethods) {
            sb.append(method.getGeneratedCode());
        }

        sb.append(getAllMethod()).append(getGetByIdMethod()).append(getMinMaxMethods()).append(getFindMethods())
            .append(getConstructor()).append(getCreateMethod()).append(getUpdateMethod())
                .append(getRemoveByIdMehtod()).append("}");


        return sb.toString();
    }

    /**
     * Gets package name
     * @return package name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Generates method all()
     * @return code of all() method
     */
    String getAllMethod() {
        return String.format("    public static List<%s> all() {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\"select id from %s\",\n" +
                "            set -> {\n" +
                "                List<%s> list = new ArrayList<>();\n" +
                "                    while (set.next()) {\n" +
                "                        %s.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                    }\n" +
                "                    return list;\n" +
                "            });\n" +
                "    }\n\n",
                name, name, name, name);
    }

    /**
     * Generates getById() method
     * @return code of getById()
     */
    String getGetByIdMethod() {
        StringBuilder fieldNamesSb = new StringBuilder();
        StringBuilder constructorArgsSb = new StringBuilder();
        boolean somethingAdded = false;

        int ind = 1;
        for (GeneratedField field: generatedFields) {
            if (! (field instanceof ArrayFieldWithSimpleType || field instanceof ArrayFieldWithComplexType)) {
                somethingAdded = true;
                fieldNamesSb.append(field.getName()).append(", ");
                if (field instanceof SimpleFieldWithSimpleType)
                    constructorArgsSb.append("set.get").append(Utils.getMethodNameByType(field.getType())).append("(").append(ind++)
                            .append("), ");
                else
                    constructorArgsSb.append("\n                ").append(field.getType())
                            .append(".getById(set.getLong(").append(ind++)
                            .append(")).orElseThrow(() -> new RuntimeException(\"Wrong data! Can't find ")
                            .append(field.getType()).append(" by id!\"").append("))\n            , ");

            }
        }

        if (somethingAdded) {
            fieldNamesSb.delete(fieldNamesSb.length() - 2, fieldNamesSb.length());
            constructorArgsSb.delete(constructorArgsSb.length() - 2, constructorArgsSb.length());
        }

        return String.format("    public static Optional<%s> getById(long id) {\n" +
                "        %s obj = DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select %s from %s where id=%%d\", id),\n" +
                "            set -> !set.isClosed() ? new %s(%s) : null);\n" +
                "        if (obj == null)\n" +
                "            return Optional.empty();\n" +
                "        obj.id = id;\n" +
                "        return Optional.of(obj);\n" +
                "    }\n\n",
                name, name, fieldNamesSb.toString(), name, name, constructorArgsSb.toString());
    }

    /**
     * Generates code for min and max methods
     * @return code for min and max methods
     */
    String getMinMaxMethods() {
        return String.format("    public static Optional<%s> min(Comparator<%s> comparator) {\n" +
                "        return all().stream().min(comparator);\n" +
                "    }\n" +
                "\n" +
                "    public static Optional<%s> max(Comparator<%s> comparator) {\n" +
                "        return all().stream().max(comparator);\n" +
                "    }\n" +
                "\n",
                name, name, name, name);
    }

    /**
     * Generates code for find and findAll methods
     * @return code for find and findAll methods
     */
    String getFindMethods() {
        return String.format("    public static Optional<%s> find(String sql) {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select id from %s where %%s\", sql),\n" +
                "            set -> !set.isClosed() ? %s.getById(set.getLong(1)) : Optional.empty());\n" +
                "    }\n" +
                "\n" +
                "    public static List<%s> findAll(String sql) {\n" +
                "        return DBService.getInstance().getExecutor().executeQuery(\n" +
                "            String.format(\"select id from %s where %%s\", sql),\n" +
                "            set -> {\n" +
                "                List<%s> list = new ArrayList<>();\n" +
                "                while (set.next()) {\n" +
                "                    %s.getById(set.getLong(1)).ifPresent(list::add);\n" +
                "                }\n" +
                "                return list;\n" +
                "             });\n" +
                "    }\n\n", name, name, name, name, name, name, name);
    }

    /**
     * Generates constructor of class
     * @return code of constructor
     */
    String getConstructor() {
        StringBuilder argumentsSb = new StringBuilder();
        StringBuilder fieldInitializationSb = new StringBuilder();

        boolean isSomethingAdded = false;
        for (GeneratedField field : generatedFields) {
            if (!(field instanceof ArrayFieldWithComplexType || field instanceof ArrayFieldWithSimpleType)) {
                isSomethingAdded = true;
                argumentsSb.append(field.getType()).append(" ").append(field.getName()).append(", ");

                fieldInitializationSb.append("this.").append(field.getName()).append(" = ");
                if (field instanceof SimpleFieldWithComplexType) {
                    fieldInitializationSb.append(field.getName()).append(".getId();");
                }
                else {
                    fieldInitializationSb.append(field.getName()).append(";");
                }
                fieldInitializationSb.append("\n        ");
            }
        }

        if (isSomethingAdded) {
            argumentsSb.delete(argumentsSb.length() - 2, argumentsSb.length());
            fieldInitializationSb.delete(fieldInitializationSb.length() - 8, fieldInitializationSb.length());
        }

        return String.format("    private %s(%s) {\n" +
                "        %s" +
                "    }\n" +
                "\n", name, argumentsSb.toString(), fieldInitializationSb.toString());
    }

    /**
     * Generates create method
     * @return code of create method
     */
    String getCreateMethod() {
        StringBuilder argumentsSb = new StringBuilder();
        StringBuilder simpleTypeValuesSb = new StringBuilder();
        StringBuilder namesSb = new StringBuilder();
        StringBuilder formaterSb = new StringBuilder();

        boolean isSomethingAdded = false;
        for (GeneratedField field : generatedFields) {
            if (!(field instanceof ArrayFieldWithComplexType || field instanceof ArrayFieldWithSimpleType)) {
                isSomethingAdded = true;

                argumentsSb.append(field.getType()).append(" ").append(field.getName()).append(", ");

                simpleTypeValuesSb.append(field.getName());
                if (field instanceof SimpleFieldWithComplexType)
                    simpleTypeValuesSb.append(".getId()");
                simpleTypeValuesSb.append(", ");

                namesSb.append(field.getName()).append(", ");

                formaterSb.append("'%s', ");
            }
        }

        if (isSomethingAdded) {
            argumentsSb.delete(argumentsSb.length() - 2, argumentsSb.length());
            simpleTypeValuesSb.delete(simpleTypeValuesSb.length() - 2, simpleTypeValuesSb.length());
            namesSb.delete(namesSb.length() - 2, namesSb.length());
            formaterSb.delete(formaterSb.length() - 2, formaterSb.length());
        }


        return String.format("    public static %s create(%s) {\n" +
                "        %s obj = new %s(%s);\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"insert into %s (%s) values (%s)\", %s));\n" +
                "        obj.id = DBService.getInstance().getExecutor().executeQuery(\"select last_insert_rowid()\",\n" +
                "                set -> set.getLong(1));\n" +
                "        return obj;\n" +
                "    }\n" +
                "\n",
                name, argumentsSb.toString(), name, name, namesSb.toString(), name,
                namesSb.toString(), formaterSb.toString(), simpleTypeValuesSb.toString());
    }

    /**
     * Generates update method
     * @return code of update method
     */
    String getUpdateMethod() {
        StringBuilder queryParamsSb = new StringBuilder();
        StringBuilder formatterParamsSb = new StringBuilder(", ");

        boolean isSomethingAdded = false;
        for (GeneratedField field : generatedFields) {
            if (!(field instanceof ArrayFieldWithComplexType || field instanceof ArrayFieldWithSimpleType)) {
                isSomethingAdded = true;

                queryParamsSb.append(field.getName()).append("='%s', ");

                formatterParamsSb.append(field.getName());
                formatterParamsSb.append(", ");
            }
        }

        if (isSomethingAdded) {
            queryParamsSb.delete(queryParamsSb.length() - 2, queryParamsSb.length());
            formatterParamsSb.delete(formatterParamsSb.length() - 2, formatterParamsSb.length());
        } else {
            formatterParamsSb.delete(0, formatterParamsSb.length());
        }

        return String.format("    private void update() {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(\n" +
                "            String.format(\"update %s set %s where id=%%d\"\n" +
                "                %s, id));\n" +
                "    }\n\n", name, queryParamsSb.toString(), formatterParamsSb.toString());
    }

    /**
     * Generates code for removeById method
     * @return code for removeById method
     */
    String getRemoveByIdMehtod() {
        return String.format("    public static void removeById(long id) {\n" +
                "        DBService.getInstance().getExecutor().executeUpdate(String.format(\"delete from %s where id=%%d\", id));\n" +
                "    }\n\n", name);
    }

}
