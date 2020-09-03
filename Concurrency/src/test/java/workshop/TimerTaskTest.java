package workshop;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTaskTest {

    @Test
    public void testTimerTask() {
        Timer timer = new Timer("dots", false);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("|");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    @Test
    public void testSingleThreadScheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> System.out.println(".");
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }
}
