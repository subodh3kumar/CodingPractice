package dev.subodh.spilca.ex3;

public class DB2Runnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            IO.println("DB 2 querying ended...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
