package hackerearth.basics.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoos {

    public static void main(String[] args) {
        String word = getInput().toLowerCase();
        //String answer = withMap(word);
        String answer = withArray(word);
        System.out.println(answer);
    }

    private static String withArray(String word) {
        char[] chars = word.toCharArray();
        int zCount = 0;
        int oCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'z') {
                zCount++;
            } else {
                oCount++;
            }
        }
        return (2 * zCount == oCount) ? "Yes" : "No";
    }

    private static String withMap(String word) {
        Map<Character, Integer> map = getCharCounts(word);
        return verifyCharCount(map);
    }

    private static String verifyCharCount(Map<Character, Integer> map) {
        int zCount = 0;
        int oCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals('z')) {
                zCount = map.get('z');
            } else {
                oCount = map.get('o');
            }
        }
        return (2 * zCount == oCount) ? "Yes" : "No";
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
