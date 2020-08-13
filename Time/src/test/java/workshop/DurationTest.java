package workshop;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

public class DurationTest {

    @Test
    public void durationInSecAndMillis() {
        Instant start = Instant.now();
        try {
            Thread.sleep(2024);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("%d seconds and %d millisecond", duration.toSeconds(), duration.toMillis());
    }


}
