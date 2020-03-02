package hackerearth.basics.io;
/**
 * get out the seat number facing you and the seat type, i.e. WS, MS or AS.
 * Window Seat - WS - 1
 * Middle Seat - MS - 2
 * Aisle Seat  - AS - 3
 */

import java.util.Scanner;

public class SeatingArrangement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        input.close();
        for (int i = 0; i < size; i++) {
            String facingSeatWithType = facingSeatNumberWithType(array[i]);
            System.out.println(facingSeatWithType);
        }
    }

    private static String facingSeatNumberWithType(int seatNumber) {
        int remainder = seatNumber % 12;
        int facingSeatNumber = 0;
        if (remainder >= 1 && remainder <= 6) {
            if (remainder == 1) {
                facingSeatNumber = seatNumber + 11;
            } else if (remainder == 2) {
                facingSeatNumber = seatNumber + 9;
            } else if (remainder == 3) {
                facingSeatNumber = seatNumber + 7;
            } else if (remainder == 4) {
                facingSeatNumber = seatNumber + 5;
            } else if (remainder == 5) {
                facingSeatNumber = seatNumber + 3;
            } else if (remainder == 6) {
                facingSeatNumber = seatNumber + 1;
            }
        } else if (remainder >= 7 && remainder <= 11) {
            if (remainder == 7) {
                facingSeatNumber = seatNumber - 1;
            } else if (remainder == 8) {
                facingSeatNumber = seatNumber - 3;
            } else if (remainder == 9) {
                facingSeatNumber = seatNumber - 5;
            } else if (remainder == 10) {
                facingSeatNumber = seatNumber - 7;
            } else if (remainder == 11) {
                facingSeatNumber = seatNumber - 9;
            }
        } else {
            facingSeatNumber = seatNumber - 11;
        }
        String seatType = facingSeatType(Math.abs(facingSeatNumber - seatNumber));
        return (facingSeatNumber + " " + seatType);
    }

    private static String facingSeatType(int num) {
        if (num == 1 || num == 11) {
            return "WS";
        } else if (num == 5 || num == 7) {
            return "AS";
        } else {
            return "MS";
        }
    }
}
