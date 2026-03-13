import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixDetailed {
    
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    
    public static void convertWithSteps(String infix) {
        System.out.println("\nConverting: " + infix);

        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            }
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() != '(') {
                output.append(stack.pop());
            } else {
                stack.pop();
            }
        }
        
        System.out.println("\nFinal Postfix: " + output.toString());
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = "A-B/D*C(F^G)";
        convertWithSteps(infix);
            }
}