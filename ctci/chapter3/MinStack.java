import java.util.Stack;

public class MinStack extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    public static void main(String[] args) {
        MinStack testStack = new MinStack();
        testStack.push(5);
        assert testStack.min() == 5;
        testStack.push(6);
        assert testStack.min() == 5;
        testStack.push(3);
        assert testStack.min() == 3;

    }
}

class NodeWithMin {
    public int value;
    public int min;
    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        sb.append(" ");
        sb.append(this.min);
        return sb.toString();
    }
}