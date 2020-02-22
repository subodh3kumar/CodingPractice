package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 4, 9, 3, 1, 2, 6, 5};
        System.out.println("Before sorting:");
        display(array);
        sort(array);
        System.out.println("\nAfter sorting:");
        display(array);
    }

    private static void sort(int[] array) {

    }

    private static void display(int[] array) {
        System.out.println(Arrays.stream(array).boxed().map(num -> String.valueOf(num)).collect(Collectors.joining(" ")));
    }
}
