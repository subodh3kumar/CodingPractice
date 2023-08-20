package workshop.list;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NearestValue {

    private static final int NEAREST_DIGIT = 25;

    public static void main(String[] args) {
        NearestValue obj = new NearestValue();
        obj.process();
    }

    private void process() {
        List<Integer> numberList = Arrays.asList(20, 21, 24, 26, 35, 38, 40, 44);

        String value = numberList.stream()
                .collect(Collectors.toMap(this::keyMapper, String::valueOf, (s, a) -> s + "," + a, TreeMap::new))
                .firstEntry()
                .getValue();

        System.out.println(value);
    }

    private Integer keyMapper(Integer value) {
        return Math.abs(NEAREST_DIGIT - value);
    }
}
