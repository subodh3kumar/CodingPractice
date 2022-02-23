package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextBlockTest {

    @Test
    void testTextBlockReplace() {
        var message = """
                class $class {
                    String $name;
                    public String toString() {
                        return this.$name;
                    }
                }
                """
                .replace("$class", "Developer")
                .replace("$name", "firstName");

        System.out.println(message);
        Assertions.assertNotNull(message);
    }
}
