import java.util.stream.IntStream;

public class IntegerStream {

    public int getMaxValue(int[] array) {
        int max = IntStream.of(array).max().getAsInt();
        System.out.println("Max: " + max);
        return max;
    }
}
