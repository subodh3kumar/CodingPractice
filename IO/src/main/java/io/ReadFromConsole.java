package io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFromConsole {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            String name = input.next();
            int age = input.nextInt();
            map.put(name, age);
        }
        map.forEach((k, v) -> System.out.println(k + ", " + v));
    }
}
