package dev.subodh.spilca.ex1;

import java.security.SecureRandom;

public class EvenNumberThread extends Thread {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i + ", thread name: " + Thread.currentThread().getName());
            int number = SECURE_RANDOM.nextInt(2000);
            //System.out.println("sleep ms: " + number);
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
