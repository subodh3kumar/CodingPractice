package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class SubListTest {

    @Test
    @DisplayName("test sublist")
    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("original list: " + list);

        List<String> subList = list.subList(2, 4);
        System.out.println("sub list: " + subList);
        Assertions.assertEquals(2, subList.size());
    }

    @Test
    @DisplayName("test smaller list")
    public void createSubListUsingTraditionally() {
        List<Integer> integers = getIntegerList();
        List<Integer> temp = new ArrayList<>();

        if (integers.size() > 5) {
            final var iterator = integers.iterator();
            while (iterator.hasNext()) {
                final var num = iterator.next();
                temp.add(num);
                if (temp.size() % 5 == 0) {
                    display(temp);
                }
                iterator.remove();
            }
        } else {
            display(integers);
        }
        if (!temp.isEmpty()) {
            display(temp);
        }
    }

    @Test
    public void testRandomIntList() {
        List<Integer> integers = new SecureRandom()
                .ints(10, 10, 50)
                .boxed()
                .toList();
        integers.forEach(System.out::println);
        Assertions.assertEquals(10, integers.size());
    }

    @Test
    public void testUniqueRandomInt() {
        List<Integer> integers = ThreadLocalRandom.current()
                .ints(10, 10, 50)
                .boxed()
                .toList();
        integers.forEach(System.out::println);
        Assertions.assertEquals(10, integers.size());
    }

    private void display(List<Integer> list) {
        list.forEach(System.out::println);
        System.out.println("---------");
        Objects.requireNonNull(list);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    private List<Integer> getIntegerList() {
        final var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(21);
        list.add(22);
        list.add(23);
        list.add(24);
        list.add(25);
        list.add(31);
        list.add(32);
        list.add(33);
        list.add(34);
        list.add(35);
        list.add(41);
        list.add(42);
        list.add(43);
        list.add(44);
        list.add(45);
        list.add(51);
        list.add(52);
        list.add(53);
        list.add(54);
        list.add(55);
        list.add(61);
        list.add(62);
        list.add(63);
        return list;
    }
}
