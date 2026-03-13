import java.util.LinkedList;

public class JavaLinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("=== Java LinkedList Operations ===\n");
        
        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add(): " + list);
        
        list.add(1, "Orange");
        System.out.println("After add(1, 'Orange'): " + list);
        
        // Add at beginning and end
        list.addFirst("Grape");
        list.addLast("Mango");
        System.out.println("After addFirst/addLast: " + list);
        
        // Get elements
        System.out.println("\nFirst element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));
        
        // Remove elements
        System.out.println("\nRemoved first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removals: " + list);
        
        // Search
        System.out.println("\nContains 'Banana'? " + list.contains("Banana"));
        System.out.println("Index of 'Cherry': " + list.indexOf("Cherry"));
        
        // Size
        System.out.println("List size: " + list.size());
        
    }
}