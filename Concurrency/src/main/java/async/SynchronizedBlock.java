package async;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedBlock {

    public static final int NUM_THREADS = 5000;
    public static final int BLOCKING_TIME_MS = 5;
    public static final int CPU_WORK_ITERATION = 10000;

    public static final AtomicInteger completedTasks = new AtomicInteger(0);
    public static volatile double busyWorkSink = 0;

    private static void doCpuWork() {
        double result = 0;
        for (int i = 0; i < CPU_WORK_ITERATION; i++) {
            result += Math.sin(i) + Math.cos(i);
        }
        busyWorkSink += result;
    }

    public static void main(String[] args) {
        System.setProperty("jdk.virtualThreadScheduler.parallelism", "1");

        System.out.println("Running with java version: " + System.getProperty("java.version"));
        System.out.printf("Launching %,d virtual threads%n", NUM_THREADS);
        System.out.printf("Each thread does cpu work for %,d iterations, then acquires lock and blocked for %d ms%n", CPU_WORK_ITERATION, BLOCKING_TIME_MS);

        ThreadFactory factory = Thread.ofVirtual().factory();
        try (var executor = Executors.newThreadPerTaskExecutor(factory)) {
            Instant start = Instant.now();

            for (int i = 0; i < NUM_THREADS; i++) {
                final Object lock = new Object();

                executor.submit(() -> {
                    try {
                        doCpuWork();
                        synchronized (lock) {
                            Thread.sleep(Duration.ofMillis(BLOCKING_TIME_MS));
                        }
                        completedTasks.incrementAndGet();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            executor.shutdown();
            boolean finished = executor.awaitTermination(5, TimeUnit.MINUTES);

            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);

            if (finished) {
                System.out.printf("All %,d tasks completed.\n", completedTasks.get());
                System.out.printf("Total execution time: %.3f seconds\n", duration.toMillis() / 1000.0);
            } else {
                System.out.println("Timed out after5 minutes");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
