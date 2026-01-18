// ############################# Singly Circular #####################################

public class Main1{
    public static void main(String[] args){
           CLL linkedlist = new CLL();
        linkedlist.insertFirst(13);
        linkedlist.insertFirst(12);
        linkedlist.insertFirst(11);
        linkedlist.insertFirst(10);
linkedlist.insertLast(14);
linkedlist.insertLast(15);
linkedlist.deleteFirst();
linkedlist.deleteLast();
        linkedlist.display();

    }
}

 class Node{
 public int data;
 public Node next;

 public Node(int data){
    this.data = data;
 }
}

class CLL{
    private Node head;
    private Node tail;
    private int size=-1;

    public void insertFirst(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail=node;
            tail.next=node;
        }
        else{
            node.next=head;
            tail.next=node;
            head=node;
        }
        size+=1;
    }

    public void insertLast(int data){
        if(head==null){
            insertFirst(data);
        }else{
            Node node = new Node(data);
            node.next=head;
            tail.next=node;
            tail=node;
        }
        size+=1;
    }

    public void deleteFirst(){
        if(head==tail){
            head=null;
            tail=null;
        }else{
            tail.next = head.next;
            head=head.next;
        }
        size-=1;
    }

    public void deleteLast(){
        if(head==tail) {
            head=null;
            tail=null;
        }
        else{
          Node temp = head;
          for(int i=0 ; i<=size-1 ;i++){
            temp=temp.next;
          }
          temp.next=head;
          tail=temp;
        }
        size--;
    }

    public void display(){
        Node temp = head;
        for(int i=0 ; i<=size; i++){
         System.out.print(temp.data + "->");
         temp=temp.next;
        }
        System.out.println("END");
    }
}