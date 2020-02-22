package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 4, 9, 3, 1, 2, 6, 5};
        System.out.println("Before sorting:");
        display(array);
        sort(array);
        System.out.println("\nAfter sorting:");
        display(array);
    }

    private static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            sort(array, start, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start;
        for (int index = start; index < end; index++) {
            if (array[index] <= pivot) {
                swap(array, index, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void display(int[] array) {
        System.out.println(Arrays.stream(array).boxed().map(num -> String.valueOf(num)).collect(Collectors.joining(" ")));
    }
}
