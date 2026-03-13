class DNode {
    int data;
    DNode prev, next;
    
    DNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class DoublyLinkedList {
    private DNode head;
    
    // Insert at any position
    public void insertAtPosition(int data, int position) {
        DNode newNode = new DNode(data);
        
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        
        // Insert at beginning
        if (position == 1) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            return;
        }
        
        // Find position
        DNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of range");
            return;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }
    
    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
    }
    
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Test insertions
        list.insertAtPosition(10, 1);  // [10]
        list.insertAtPosition(20, 2);  // [10, 20]
        list.insertAtPosition(30, 2);  // [10, 30, 20]
        list.insertAtPosition(5, 1);   // [5, 10, 30, 20]
        list.insertAtPosition(25, 4);  // [5, 10, 30, 25, 20]
        
        list.displayForward();
    }
}