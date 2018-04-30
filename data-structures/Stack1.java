// implementation of stack using dynamically resizing arraylist
import java.util.Arrays;

public class Stack1 {
    private ArrayList data;
    private int size = 0;

    public Stack1() {
        this.data = new ArrayList();
    }

    public Object peek() {
        if (this.size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.data.get(this.size-1);
    }


    public void push(Object item) {
        this.data.add(item);
        this.size++;
    }

    public void pop() {
        this.data.remove(this.size-1);
        this.size--;
    }

    public int size() {
        return this.size();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private class ArrayList {
        private Object[] data;
        private int size = 0;
        private int DEFAULT_CAPACITY = 10;

        public ArrayList() {
            this.data = new Object[DEFAULT_CAPACITY];
        }

        public void add(Object item) {
            // add object to arraylist
            if (data.length - this.size <= 5) {
                increaseArraySize();
            }
            this.data[this.size++] = item;
        }

        public void remove(int idx) {
            // remove item at given index
            if (idx < this.size) {
                Object item = this.data[idx];
                this.data[idx] = null;
                int tmp = idx;
                while (tmp < this.size) {
                    this.data[tmp] = this.data[tmp+1];
                    this.data[tmp+1] = null;
                    tmp++;
                }
                this.size--;
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public Object get(int idx) {
        // return object at given index
            if (idx > this.size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return this.data[idx];
        }

        public int size() {
            return this.size;
        }

        private void increaseArraySize() {
            this.data = Arrays.copyOf(this.data, this.data.length * 2);
        }
    }

    public static void main(String[] args) {
        Stack1 testStack = new Stack1();
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