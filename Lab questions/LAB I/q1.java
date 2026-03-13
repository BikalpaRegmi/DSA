public class SimpleArrayList {
    private static int[] arr = new int[10];
    private static int size = 0;
    
    public static void insert(int pos, int val) {
        if (pos < 0 || pos > size || size == arr.length) {
            System.out.println("Cannot insert at position " + pos);
            return;
        }
        for (int i = size; i > pos; i--) arr[i] = arr[i-1];
        arr[pos] = val;
        size++;
        System.out.println("Inserted " + val + " at " + pos);
    }
    
    public static int delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position " + pos);
            return -1;
        }
        int val = arr[pos];
        for (int i = pos; i < size-1; i++) arr[i] = arr[i+1];
        size--;
        System.out.println("Deleted " + val + " from " + pos);
        return val;
    }
    
    public static void display() {
        if (size == 0) System.out.println("List is empty");
        else {
            System.out.print("List: [");
            for (int i = 0; i < size; i++) 
                System.out.print(arr[i] + (i < size-1 ? ", " : ""));
            System.out.println("] (size: " + size + ")");
        }
    }
    
    public static void main(String[] args) {
        insert(0, 10);    
        insert(1, 30);    
        insert(1, 20);    
        display();
        
        delete(1);         
        display();
        
        insert(2, 40);    
        insert(0, 5);     
        display();
    }
}