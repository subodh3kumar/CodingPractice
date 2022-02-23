package workshop.records;

import java.util.Iterator;

public class RangeIterator {

    public static void main(String[] args) {

        record Range(int begin, int end) implements Iterable<Integer> {

            Range {
                if (begin > end) {
                    throw new IllegalArgumentException("begin should be smaller than end");
                }
            }


            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {

                    private int index = Range.this.begin;

                    @Override
                    public boolean hasNext() {
                        return index < Range.this.end;
                    }

                    @Override
                    public Integer next() {
                        return index++;
                    }
                };
            }
        }

        var range = new Range(0, 5);
        for (int index : range) {
            System.out.println("index: " + index);
        }

        System.out.println("Range: " + range);
    }
}
