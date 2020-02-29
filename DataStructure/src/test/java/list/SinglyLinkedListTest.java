package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest {

    private SinglyLinkedList<String> linkedList;

    @BeforeEach
    public void init() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("test addFirst()")
    public void testAddFirst() {
        linkedList.addFirst("subodh");
        linkedList.addFirst("juli");
        assertEquals("juli", linkedList.getFirst());
    }

    @Test
    @DisplayName("test addLast()")
    public void testAddLast() {
        linkedList.addLast("kumar");
        linkedList.addLast("kumari");
        assertEquals("kumari", linkedList.getLast());
    }

    @Test
    @DisplayName("test add()")
    public void testAdd() {
        linkedList.add("subodh");
        linkedList.add("kumar");
        linkedList.add("juli");
        assertEquals(3, linkedList.size());
    }

    @Test
    @DisplayName("test display()")
    public void testDisplay() {
        linkedList.add("subodh");
        linkedList.add("juli");
        assertEquals("[subodh, juli]", linkedList.display());
    }
}