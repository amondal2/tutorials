// implementation of a stack using a linked list
import java.util.LinkedList;

public class Stack2 {
    private LinkedList data;
    private int size = 0;

    public Stack2() {
        this.data = new LinkedList();
    }

    public Object peek() {
        if (this.size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.data.get(0);
    }

    public void push(Object item) {
        this.data.addFirst(item);
        this.size++;
    }

    public Object pop() {
        if (this.size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.size--;
        return this.data.remove();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        Stack2 testStack = new Stack2();
        assert testStack.isEmpty() == true;
        testStack.push("Hello");
        testStack.push("World");
        assert testStack.size() == 2;
        assert testStack.peek() == "World";
    
        testStack.pop();
        assert testStack.size() == 1;
        assert testStack.peek() == "Hello";
    }
}