package hackerrank.algos;

public class LinkedListLoop {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    
    boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head.next;
        
        while(slow.next != null && fast.next != null && fast.next.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedListLoop loop = new LinkedListLoop();
        Node head = loop.new Node(0);
        Node current = head;
        for (int i=1; i <= 10; i++) {
            Node newNode= loop.new Node(i);
            current.next = newNode;
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        
        System.out.println(loop.hasCycle(head));
    }
}
