import java.util.Scanner;

public class RemoveOddIndexUnderscore {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = input.next();
        System.out.println("Entered word: " + word);
        String newWord = removeUnderscoreFromOddIndex(word);
        //String newWord = removeUnderscoreFromOddIndex2(word);
        System.out.println("Expected word: " + newWord);
    }

    private static String removeUnderscoreFromOddIndex2(String word) {
        return null;
    }

    private static String removeUnderscoreFromOddIndex(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!(i % 2 != 0 && word.charAt(i) == '_')) {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }
}
