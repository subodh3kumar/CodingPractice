package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 4, 9, 3, 1, 2, 6, 5};
        System.out.println("Before sorting:");
        display(array);
        sort(array);
        System.out.println("\nAfter sorting:");
        display(array);
    }

    private static void sort(int[] array) {
        int size = array.length - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void display(int[] array) {
        String result = Arrays.stream(array)
                .boxed()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
