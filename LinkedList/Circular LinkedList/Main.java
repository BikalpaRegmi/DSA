// ################################### Doubly Circular ####################################

public class Main{
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
    public Node next;
    public Node prev;
    public int data;

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
     head=node;
     tail=node;
     head.prev=tail;
     tail.next=head;
    }else{
     node.next=head;
     head.prev=node;
     node.prev=tail;
     tail.next=node;
     head=node;
    }
    size+=1;
}

public void insertLast(int data){
Node node = new Node(data);
if(head==null || size<1){
    insertFirst(data);
    return;
}
node.prev=tail;
node.next=head;
tail.next=node;
head.prev=node;
tail=node;
size++;
}

public Node get(int index){
Node temp = head;
for(int i=0 ; i<index ; i++){
    temp=temp.next;
}
return temp;
}

public void deleteFirst(){
if(head==tail){
    head=null;
    tail=null;
}else{
head.next.prev = tail;
tail.next=head.next;
head=head.next;
}
size--;
}

public void deleteLast(){
if(head==tail){
    deleteFirst();
    return;
}
Node secondLast = get(size-1);
secondLast.next=head;
head.prev=secondLast;
tail=secondLast;
size--;
}

public void display(){
    Node temp = head;
    for(int i=0 ; i<=size ; i++){
        System.out.print(temp.data + "-><-");
        temp=temp.next;
    }
    System.out.print("END");
}
}