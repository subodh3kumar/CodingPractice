package devoxx;

import java.util.Arrays;
import java.util.List;

public class ListView {

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E", "F"};
        System.out.print("Array-----> ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.print("\nList-----> ");
        List<String> list = Arrays.asList(array);
        list.forEach(e -> System.out.print(e + " "));

        System.out.print("\nNew List-----> ");
        array[0] = "XX";
        list.forEach(e -> System.out.print(e + " "));

        System.out.print("\nNew Array-----> ");
        list.set(1, "YY");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // We can not change the size of the list i.e. We can not add element in the list.
        //list.add("X");
        //list.forEach(System.out::println);

        //list.remove(3);
        //list.forEach(System.out::println);
    }
}
