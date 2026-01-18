import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        InfixToPrefix converter = new InfixToPrefix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
       
       converter.infixToPrefix(exp);
    }
}



class InfixToPrefix {
    public int priorityCheck(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*' || c == '%') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public void infixToPrefix(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                reversed += ')';
            } else if (c == ')') {
                reversed += '(';
            } else {
                reversed += c;
            }
        }

        Stack<Character> mystack = new Stack<>();
        String result = "";

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result += c;
            } else if (c == '(') {
                mystack.push('(');
            } else if (c == ')') {
                while (mystack.peek() != '(') {
                    result += mystack.pop();
                }
                mystack.pop();
            } else {
                while (!mystack.isEmpty() && priorityCheck(c) < priorityCheck(mystack.peek())) {
                    result += mystack.pop();
                }
                mystack.push(c);
            }
        }

        while (!mystack.isEmpty()) {
            result += mystack.pop();
        }

        String prefix = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            prefix += result.charAt(i);
        }
        
        System.out.println(prefix);
    }
}