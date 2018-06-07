import java.util.HashSet;

public class RemoveDuplicates {
    static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            this.data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
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

        public void removeDuplicates() {
            HashSet<Integer> frequencies = new HashSet<Integer>();
            Node previous = null;
            Node current = this;
            while (current != null) {
                int currVal = current.data;
                if (frequencies.contains(currVal)) {
                    previous.next = current.next;
                } else {
                    frequencies.add(currVal);
                    previous = current;
                }
                current = current.next;
        }
    }

    }


    public static void main(String[] args) {
        Node n = new Node(5);
        n.appendToTail(6);
        n.appendToTail(5);
        n.removeDuplicates();
        assert n.toString() == "5 6";
    }
}