package dev.subodh.spilca.ex3;

public class DB1Runnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            IO.println("DB 1 querying ended...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
