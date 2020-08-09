package spilca.ex2;

public class OddNumberRunnableMain {

    public static void main(String[] args) {

        var oddNumberRunnable = new OddNumberRunnable();

        Thread t1 = new Thread(oddNumberRunnable, "t1");
        Thread t2 = new Thread(oddNumberRunnable, "t2");

        t1.start();
        t2.start();
    }
}
