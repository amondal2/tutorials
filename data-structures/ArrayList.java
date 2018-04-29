// implementation of dynamically-resizing arraylist
import java.util.Arrays;

public class ArrayList {
    private Object[] data;
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public Object get(int idx) {
        // return object at given index
        if (idx > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.data[idx];
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

    public int size() {
        return this.size;
    }

    private void increaseArraySize() {
        this.data = Arrays.copyOf(this.data, this.data.length * 2);
    }

}