import java.util.*;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    public LinkedList() {
        head = null;
    }

    private class Node<T> {
        private T data;
        private Node<T> next;
        // constructor
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addFirst(T item) {
        head = new Node<T>(item, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T removeFirst() {
        T oldHeadData = getFirst();
        head = head.next;
        return oldHeadData;
    }

    public void addLast(T item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(item, null);
        }
    }

    public T getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void clear() {
        head = null;
    }

    public boolean contains(T item) {
        for (T data : this) {
            if(data.equals(item)) return true;
        }
        return false;
    }

    public T get(int idx) {
        if (head == null) throw new IndexOutOfBoundsException();
        Node<T> tmp = head;
        for (int k = 0; k < idx; k++) tmp = tmp.next;
        if (tmp == null) throw new IndexOutOfBoundsException();
        return tmp.data;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Object x : this) {
            result.append(x + " ");
        }
        return result.toString();
    }

    public void insertAfter(T key, T toInsert) {
        Node<T> tmp = head;
        while (tmp != null && !tmp.data.equals(key)) {
            tmp = tmp.next;
        }

        if ( tmp != null ) {
            tmp.next = new Node<T>(toInsert, tmp.next);
        }
    }

    public void insertBefore(T key, T toInsert) {
        Node<T> tmp = head;
        if (head == null) {
            return;
        }

        if (head.data.equals(key)) {
            addFirst(toInsert);
            return;
        }

        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null && !curr.data.equals(key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev = new Node<T>(toInsert, curr);
        }
    }
    public void remove(T key) {
        if (head == null) {
            throw new RuntimeException("Empty List");
        }

        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null && !curr.data.equals(key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            throw new RuntimeException("Empty List");
        }

        prev.next = curr.next;
    }

    public LinkedList<T> copy() {
        LinkedList<T> twin = new LinkedList<T>();
        Node<T> tmp = head;
        while(tmp != null) {
            twin.addFirst(tmp.data);
            tmp = tmp.next;
        }

        return twin.reverse();
    }

    public LinkedList<T> reverse() {
        LinkedList<T> list = new LinkedList<T>();
        Node<T> tmp = head;
        while(tmp != null) {
            list.addFirst(tmp.data);
            tmp = tmp.next;
        }
        return list;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> nextNode;
        public LinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}