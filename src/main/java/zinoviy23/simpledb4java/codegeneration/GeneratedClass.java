package zinoviy23.simpledb4java.codegeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for generated class.
 * @author zinoviy23@gmail.com
 */
public class GeneratedClass {
    /**
     * List of simpleFields
     */
    private List<SimpleField> simpleFields = new ArrayList<>();

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
     * Adds simple field to class
     * @param simpleField simple field
     * @return result of adding field to class
     */
    public boolean addSimpleField(SimpleField simpleField) {
        return simpleFields.add(simpleField);
    }

    /**
     * Gets unmodifiable list of simpleFields
     * @return list of simple fields
     */
    public List<SimpleField> getSimpleFields() {
        return Collections.unmodifiableList(simpleFields);
    }

    /**
     * Creates class source code.
     * @return string representation of class source code.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("class ").append(name).append(" {\n");
        for (SimpleField simpleField : simpleFields) {
            sb.append(simpleField);
        }
        sb.append("}");
        
        return sb.toString();
    }
}
