package hackerearth.basics.io;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String word1 = input.next();
        String word2 = input.next();
        input.close();

        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();

        //fillingWithChar(charArr1, charArr2);
        //charCountStoreArray(word1, word2);
        compareWordCount(word1, word2);
    }

    private static void compareWordCount(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        int[] charCount1 = new int[26];

        char[] charArray2 = word2.toCharArray();
        int[] charCount2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            charCount1[charArray1[i] - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            charCount2[charArray2[i] - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(charCount1[i] - charCount2[i]);
        }
        System.out.println(count);
    }

    private static void charCountStoreArray(String word1, String word2) {
        int count = 0;
        count += charCount(word1, word2);
        count += charCount(word2, word1);
        System.out.println(count);
    }

    private static int charCount(String word1, String word2) {
        int[] charCount = new int[26];
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            charCount[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (charCount[word2.charAt(i) - 'a']-- <= 0) {
                count++;
            }
        }
        return count;
    }

    private static void fillingWithChar(char[] charArr1, char[] charArr2) {
        int count = 0;
        for (int i = 0; i < charArr1.length; i++) {
            for (int j = 0; j < charArr2.length; j++) {
                if (charArr1[i] == charArr2[j] && charArr1[i] != '0' && charArr2[j] != '0') {
                    charArr1[i] = '0';
                    charArr2[j] = '0';
                }
            }
        }
        for (int i = 0; i < charArr1.length; i++) {
            if (charArr1[i] != '0') {
                count++;
            }
        }
        for (int i = 0; i < charArr2.length; i++) {
            if (charArr2[i] != '0') {
                count++;
            }
        }
        System.out.println(count);
    }
}
