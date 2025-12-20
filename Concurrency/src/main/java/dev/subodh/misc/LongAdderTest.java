package dev.subodh.misc;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

    public static void main(String[] args) {

        LongAdder counter = new LongAdder();

        Runnable task = counter::increment;
        task.run();

        System.out.println("counter: " + counter);
    }
}
