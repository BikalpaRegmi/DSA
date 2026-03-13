import java.util.Arrays;

public class HashTableLinearProbing {
    private int[] table;
    private int size;
    
    public HashTableLinearProbing(int size) {
        this.size = size;
        this.table = new int[size];
        Arrays.fill(table, -1); 
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    public void insert(int key) {
        int index = hash(key);
        int originalIndex = index;
        
        while (table[index] != -1) {
            index = (index + 1) % size;
            if (index == originalIndex) {
                System.out.println("Hash table is full! Cannot insert " + key);
                return;
            }
        }
        
        table[index] = key;
    }
  
    public void display() {
        System.out.println("\nHash Table (Index: Value):");
        for (int i = 0; i < size; i++) {
            if (table[i] == -1) {
                System.out.println("  " + i + ": empty");
            } else if (table[i] == -2) {
                System.out.println("  " + i + ": deleted");
            } else {
                System.out.println("  " + i + ": " + table[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] data = {33, 55, 12, 90, 2, 44, 76, 89, 32};
        HashTableLinearProbing ht = new HashTableLinearProbing(10);
        
        for (int num : data) {
            ht.insert(num);
        }
        ht.display();
        
    }
}