package spilca.ex1;

public class EvenNumberThreadMain {

    public static void main(String[] args) {
        EvenNumberThread t1 = new EvenNumberThread();
        t1.start();
        System.out.println("End!!, thread name: " + Thread.currentThread().getName());
    }
}
