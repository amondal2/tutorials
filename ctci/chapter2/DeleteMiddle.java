package chapter2; 

public class DeleteMiddle { 
    public boolean deleteMiddle(LinkedListNode n) {
        // to delete a middle node with no reference
        // to its head, we simple set the next node's
        // data to the given node, and then delete the next
        if (n == null || n.next == null) return false;
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}