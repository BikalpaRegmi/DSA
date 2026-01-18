import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
    Infixtopostfix obj = new Infixtopostfix();
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    obj.infixToPostfix(exp);
  }

}

 class Infixtopostfix {
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

  public void infixToPostfix(String s) {
    Stack<Character> mystack = new Stack<>();
    String result = "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

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
        while (!mystack.isEmpty() && priorityCheck(c) <= priorityCheck(mystack.peek())) {
          result += mystack.pop();
        }
        mystack.push(c);
      }
    } 

    while (!mystack.isEmpty()) {
      result += mystack.pop();
    }
    System.out.println(result.toString());
  }

}
