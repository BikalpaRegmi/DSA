public class Main{
    public static void main(String[] args) {
        SLL linkedlist= new SLL();
        linkedlist.insertFirst(11);
        linkedlist.insertFirst(10);
        linkedlist.insertLast(12);
        linkedlist.insertLast(14);
        linkedlist.insertAt(13, 3);
        linkedlist.insertAt(15, 5);
        linkedlist.deleteFirst();
        linkedlist.deleteLast();
        linkedlist.display();
    }
}

class Node{
    public Node next;
    public int data;

    public Node(int data){
        this.data=data;
    }
}

class SLL{
    private int size=-1;
    private Node head;
    private Node tail;

    public void insertFirst(int data){
        Node node = new Node(data);

        if(tail==null){
            tail=node;
        }
         node.next=head;
         head = node;
         size+=1;
    }

    public void insertLast(int data){
        if(head==null){
            insertFirst(data);
            return;
        }
     Node node = new Node(data);
     tail.next = node;
     tail=node;
     size+=1;
    }

    public void insertAt(int data, int index){
        if(index == 0){
            insertFirst(data);
            return;
        }
        if(index==size+1){
            insertLast(data);
            return;
        }
        Node temp = head;
        
        for(int i=0 ; i<index-1;i++){
            temp=temp.next;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next=node;

        size++;
    }

    public void deleteFirst(){
        if(head==tail){
            head=null;
            tail=null;
            
        }else{

        head=head.next;
        }
        size--;
    }

    public void deleteLast(){
        if(head==tail) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for(int i=0 ; i<=size-2 ;i++){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }

    public void deleteAt(int index){
        if(index==0){
            deleteFirst();
            return;
        }
        if(index==size){
            deleteLast();
            return;
        }
        Node temp = head;
        for(int i=0 ;i<index-1;i++){
            temp=temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("END" + "\n \n" + size);
    }
}