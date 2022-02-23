package workshop.records;

public class RangeDemo {

    public static void main(String[] args) {

        record Range(int begin, int end) {
            Range {
                if (begin > end) {
                    throw new IllegalArgumentException("begin should be smaller than end");
                }
            }

            Range() {
                this(0, 0);
            }

            Range(int end) {
                this(0, end);
            }
        }

        Range range = new Range(0, 10);
        System.out.println("Range: " + range);

        Range range2 = new Range();
        System.out.println("Range: " + range2);

        Range range3 = new Range(10);
        System.out.println("Range: " + range3);
    }
}


