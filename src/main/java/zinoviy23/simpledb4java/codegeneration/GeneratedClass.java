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
     * Class name
     */
    private final String name;

    /**
     * Constructor with name
     * @param name class name
     */
    public GeneratedClass(String name) {
        this.name = name;
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
     * Creates class source code.
     * @return string representation of class source code.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("class ").append(name).append(" {\n").append(genereatedIdCode);
        for (GeneratedField field : generatedFields) {
            sb.append(field.getGeneratedCode());
        }
        sb.append("}");
        
        return sb.toString();
    }
}
