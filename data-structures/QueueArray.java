// implementation of a Queue using Arraylist
import java.util.Arrays;

public class QueueArray {
    ArrayList data;
    int size;
    public QueueArray() {
        this.data = new ArrayList();
        this.size = 0;
    }

    public void enqueue(Object item) {
        this.data.add(item);
        this.size++;
    }

    public void dequeue() {
        if (this.size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data.remove(0);
        this.size--;
    }

    public Object peek() {
        return this.data.get(0);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.data.size(); i++) {
            sb.append(this.data.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueArray testQueue = new QueueArray();
        testQueue.enqueue("hello");
        testQueue.enqueue("world");
        assert testQueue.size == 2;
        assert testQueue.toString() == "hello world";
        testQueue.dequeue();
        assert testQueue.size == 1;
        assert testQueue.toString() == "world";
    }



}