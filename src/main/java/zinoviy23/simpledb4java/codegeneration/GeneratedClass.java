package zinoviy23.simpledb4java.codegeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for generated class.
 */
public class GeneratedClass {
    /**
     * List of simpleFieldWithSimpleTypes
     */
    private List<SimpleFieldWithSimpleType> simpleFieldWithSimpleTypes = new ArrayList<>();

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
     * @param simpleFieldWithSimpleType simple field
     * @return result of adding field to class
     */
    public boolean addSimpleField(SimpleFieldWithSimpleType simpleFieldWithSimpleType) {
        return simpleFieldWithSimpleTypes.add(simpleFieldWithSimpleType);
    }

    /**
     * Gets unmodifiable list of simpleFieldWithSimpleTypes
     * @return list of simple fields
     */
    public List<SimpleFieldWithSimpleType> getSimpleFieldWithSimpleTypes() {
        return Collections.unmodifiableList(simpleFieldWithSimpleTypes);
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
        for (SimpleFieldWithSimpleType simpleFieldWithSimpleType : simpleFieldWithSimpleTypes) {
            sb.append(simpleFieldWithSimpleType.getGeneratedCode());
        }
        sb.append("}");
        
        return sb.toString();
    }
}
