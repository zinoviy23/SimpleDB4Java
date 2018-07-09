package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests simple field with complex type field
 */
public class SimpleFieldWithComplexTypeTest {

    /**
     * Tests code generation
     */
    @Test
    public void getGeneratedCodeTest() {
        SimpleFieldWithComplexType field = new SimpleFieldWithComplexType("Animal", "animal");

        assertEquals("    private long animal;\n" +
                "\n" +
                "    public Optional<Animal> getAnimal() {\n" +
                "        return Animal.getById(animal);\n" +
                "    }\n" +
                "\n" +
                "    public void setAnimal(Animal animal) {\n" +
                "        this.animal = animal.getId();\n" +
                "        update();\n" +
                "    }\n" +
                "\n", field.getGeneratedCode());
    }
}