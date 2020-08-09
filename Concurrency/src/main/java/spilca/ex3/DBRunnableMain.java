package spilca.ex3;

public class DBRunnableMain {

    public static void main(String[] args) {
        var db1 = new DB1Runnable();
        var db2 = new DB2Runnable();

        var t1 = new Thread(db1);
        var t2 = new Thread(db2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("processing...");
    }
}
