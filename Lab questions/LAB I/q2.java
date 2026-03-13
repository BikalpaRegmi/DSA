import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListMenu {
    private Node head;
    
    // Insert at first
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Insert at last
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted " + data + " at end");
    }
    
    // Insert at given position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        
        if (position == 1) {
            insertFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of range");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    // Delete by data
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted " + data);
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println(data + " not found");
        } else {
            current.next = current.next.next;
            System.out.println("Deleted " + data);
        }
    }
    
    // Search operation
    public void search(int data) {
        Node current = head;
        int position = 1;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println(data + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println(data + " not found");
    }
    
    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Menu-driven program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedListMenu list = new SinglyLinkedListMenu();
        int choice, data, position;
        
        do {
            System.out.println("\n=== SINGLY LINKED LIST MENU ===");
            System.out.println("1. Insert at first");
            System.out.println("2. Insert at last");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete by data");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertFirst(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertLast(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    System.out.print("Enter data to delete: ");
                    data = sc.nextInt();
                    list.delete(data);
                    break;
                case 5:
                    System.out.print("Enter data to search: ");
                    data = sc.nextInt();
                    list.search(data);
                    break;
                case 6:
                    list.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 7);
        
        sc.close();
    }
}