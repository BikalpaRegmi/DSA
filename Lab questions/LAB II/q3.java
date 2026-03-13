import java.util.Stack;

public class ReverseStringWithStack {
    public static void main(String[] args) {
        String input = "Bikalpa";
        System.out.println("Reversed: " + reverseUsingStack(input));
    }

    private static String reverseUsingStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder(s.length());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}