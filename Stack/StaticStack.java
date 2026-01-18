import java.util.*;

public class StaticStack{
  public static void main(String[] args){
    Stack stk = new Stack(5);
    stk.push(1);
    stk.push(11);
    stk.push(21);
    stk.push(31);
    stk.push(41);
    stk.display();
  }
}

class Stack{
  private int topPointer;
  private int[] stack;
  private int capacity;
  
  public Stack(int size){
    this.stack = new int[size];
    topPointer=-1;
    capacity = size;
  }
  
  public void push(int value){
    if(topPointer==capacity-1){
      System.out.println("Array out of bound");
    }
    topPointer+=1;
    stack[topPointer]=value;
  }
  
  public int pop(){
    if(topPointer==-1){
      System.out.println("Array in bound");
    }
    return stack[topPointer--];
  }
  
  public int peek(){
     if(topPointer==-1){
      System.out.println("Array in bound");
    }
    return stack[topPointer];
  }
  
  public void display(){
    for(int i=0 ; i<=topPointer ;i++){
      System.out.print(stack[i] + "|");
    }
  }
}