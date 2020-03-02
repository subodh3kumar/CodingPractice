package hackerearth.basics.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoos {

    public static void main(String[] args) {
        String word = getInput();
        Map<Character, Integer> map = getCharCounts(word);
        System.out.println(map);
    }

    private static String getInput() {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        input.close();
        return word;
    }

    private static Map<Character, Integer> getCharCounts(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                int value = map.get(word.charAt(i));
                map.put(word.charAt(i), ++value);
            } else {
                map.put(word.charAt(i), 1);
            }
        }
        return map;
    }
}
