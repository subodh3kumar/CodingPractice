package list;

import java.util.LinkedList;

public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public void add(E e) {
        linkLast(e);
    }

    private void linkLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public String display() {
        Node<E> current = head;
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current != null) {
            sb.append(current.getElement());
            sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        String result = sb.toString().replace(", ]", "]");
        return result;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
