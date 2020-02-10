package misc;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int size = numbers.length;
        System.out.println("array size: " + size);
        int arraySum = 0;
        for (int i = 0; i < size; i++) {
            arraySum += numbers[i];
        }
        System.out.println("array sum: " + arraySum);

        System.out.println("ideal sum of integers from 1 to 10:");
        int n = 10;
        int idealSum = n * (n + 1) / 2;
        System.out.println("ideal sum: " + idealSum);
        System.out.println("missing number is " + (idealSum - arraySum));
    }
}
