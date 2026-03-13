import java.util.ArrayList;

public class ArrayListDynamicStack {
    public static void main(String[] args) {
        DynamicStackAL stack = new DynamicStackAL();
        
        for (int i = 1; i <= 10; i++) {
            stack.push(i * 10);
        }
        
        stack.pop();
        
        stack.display();
    }
}

class DynamicStackAL {
    private ArrayList<Integer> stack;
    
    public DynamicStackAL() {
        stack = new ArrayList<>();
    }
    
    public void push(int value) {
        stack.add(value);
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stack.remove(stack.size() - 1);
    }
    
    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }
    

    
    public void display() {
       for(int i=0 ; i<stack.size() ; i++){
         System.out.print(stack.get(i) + "|");
       }
        System.out.println();
    }
}