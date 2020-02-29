package list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SinglyLinkedListTest {
    private SinglyLinkedList<String> linkedList;

    @BeforeAll
    public void init() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testAddFirst() {
        linkedList.addFirst("subodh");
        linkedList.addFirst("juli");
        assertEquals("juli", linkedList.getFirst());
    }

    @Test
    public void testAddLast() {
    linkedList.addLast("kumar");
    linkedList.addLast("kumari");
    assertEquals("kumari", linkedList.getLast());
    }
}