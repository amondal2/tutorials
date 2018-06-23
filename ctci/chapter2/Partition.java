package chapter2;

public class Partition {
    public static LinkedListNode partition(LinkedListNode node, int x) {
        // given a partition number, we create two linked lists:
        // one with elements less than or equal to the partition
        // and one with greater than. then we merge the lists and return
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}