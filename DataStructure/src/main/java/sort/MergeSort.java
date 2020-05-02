package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

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

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftArraySize = (mid - left) + 1;
        int rightArraySize = right - mid;

        int[] tempLeftArray = new int[leftArraySize];
        int[] tempRightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; ++i) {
            tempLeftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArraySize; ++i) {
            tempRightArray[i] = array[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArraySize && j < rightArraySize) {
            if (tempLeftArray[i] <= tempRightArray[j]) {
                array[k] = tempLeftArray[i];
                i++;
            } else {
                array[k] = tempRightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize) {
            array[k] = tempLeftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            array[k] = tempRightArray[j];
            j++;
            k++;
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
