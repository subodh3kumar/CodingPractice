package workshop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JoinTest {

    @Test
    void testJoin() {
        String joinStr = String.join(",", "Hello", "World");
        System.out.println(joinStr);
        Assertions.assertThat(joinStr).isEqualTo("Hello,World");
    }
}
