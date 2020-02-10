package misc;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = input.nextInt();
        String binary = decimalToBinary(num);
        System.out.println("Binary number of " + num + " is " + binary);
        input.close();
    }

    public static String decimalToBinary(int num) {
        String reminders = getRemindersAsString(num);
        int[] array = reverse(reminders);
        String binary = getBinary(array);
        return binary;
    }

    private static String getBinary(int[] array) {
        String binary = "";
        for (int i = 0; i < array.length; i++) {
            binary += array[i];
        }
        return binary;
    }

    private static int[] reverse(String reminders) {
        int[] array = reminders.chars().map(ch -> ch - '0').toArray();
        int j = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
        return array;
    }

    private static String getRemindersAsString(int num) {
        String reminders = "";
        while (num > 0) {
            int reminder = num % 2;
            num = num / 2;
            reminders += reminder;
        }
        return reminders;
    }
}
