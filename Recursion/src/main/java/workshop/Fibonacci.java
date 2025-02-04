package workshop;

public class Fibonacci {

    public int nthFibonacci(int num) {
        if (num <= 1) {
            return 1;
        }
        return nthFibonacci(num - 1) + nthFibonacci(num - 2);
    }
}
