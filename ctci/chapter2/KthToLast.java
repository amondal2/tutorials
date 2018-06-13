import java.util.HashSet;

public class KthToLast {
    static class Node {
        Node next = null;
        int data;
        int size;

        public Node(int d) {
            this.data = d;
            this.size = 1;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
            this.size++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node n = this;
            while (n != null) {
                sb.append(n.data);
                sb.append(" ");
                n = n.next;
            }
            return sb.toString();
        }

        public int size() {
            Node n = this;
            int count = 1;
            while (n.next != null) {
                count++;
                n = n.next;
            }
            return count;
        }

        public int kthToLast(int k) {
            // kth to last is size - idx + 1
            int idx = this.size-k+1;
            int nodeIdx = 0;
            Node n = this;
            while (nodeIdx != idx-1) {
                n = n.next;
                nodeIdx++;
            }
            return n.data;
        }
    }

    public static void main(String[] args) {
        Node testList = new Node(6);
        testList.appendToTail(5);
        testList.appendToTail(7);
        testList.appendToTail(8);
        assert testList.kthToLast(1) == 8;
        assert testList.kthToLast(2) == 7;
        assert testList.kthToLast(3) == 5;
        assert testList.kthToLast(4) == 6;
    }
}