package codility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Count minimal number of jumps from position X to Y
 */
public class FrogJump {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int position = Integer.parseInt(reader.readLine());
            int jump = Integer.parseInt(reader.readLine());
            int destination = Integer.parseInt(reader.readLine());
            System.out.println(solution(position, destination, jump));
        }
    }

    private static int solution(int position, int destination, int jump) {
        long startTime = System.nanoTime();
        int result = 0;

        while (position <= destination) {
            position += jump;
            result++;
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution): " + (endTime - startTime));
        return result;
    }
}
