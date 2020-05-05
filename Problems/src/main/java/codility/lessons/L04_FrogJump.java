package codility.lessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Count minimal number of jumps from position X to Y
 */
public class L04_FrogJump {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int position = Integer.parseInt(reader.readLine());
            int destination = Integer.parseInt(reader.readLine());
            int jump = Integer.parseInt(reader.readLine());
            System.out.println(solution(position, destination, jump));
            System.out.println(solution2(position, destination, jump));
        }
    }

    /**
     * Time complexity o(1)
     */
    private static int solution2(int position, int destination, int jump) {
        long startTime = System.nanoTime();
        int distance = destination - position;
        int result = distance / jump;
        if (distance % jump != 0) {
            result++;
        }
        
        long endTime = System.nanoTime();
        System.out.println("time taken(2): " + (endTime - startTime));
        return result;
    }

    /**
     * Time complexity o(destination - position)
     */
    private static int solution(int position, int destination, int jump) {
        long startTime = System.nanoTime();
        int result = 0;
        while (position != destination) {
            position += jump;
            result++;
            if (position >= destination) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("time taken: " + (endTime - startTime));
        return result;
    }
}
