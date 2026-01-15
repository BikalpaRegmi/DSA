public class Main{
  public static void main(String[] args){
    DLL linkedlist = new DLL();
 linkedlist.insertFirst(13);
linkedlist.insertFirst(12);
linkedlist.insertFirst(11);
linkedlist.insertLast(15);
linkedlist.insertAt(14,3);
    linkedlist.deleteFirst();
    linkedlist.deleteLast();
    linkedlist.deleteAt(1);
    linkedlist.display();
  }
}

class Node{
  public Node next;
  public Node prev;
  public int data;

  public Node(int data){
    this.data=data;
  }
  
}

class DLL{
  private Node head;
  private Node tail;
  private int size;
  
  public void insertFirst(int data){
    Node node = new Node(data);
    node.next=head;
    if(head!=null){
    head.prev=node;
    }
    head=node;
    
    if(tail==null){
      tail=head;
    }
    size++;
  }
  
  public void insertLast(int data){
  if(size<1){
    insertFirst(data);
    return;
  }  
  Node node = new Node(data);
  
  node.prev=tail;
  tail.next=node;
  tail=node;
  size++;
  }
  
  public void insertAt(int data, int index){
  if(index==0){
    insertFirst(data);
    return;
  }  
  if(index==size){
    insertLast(data);
    return;
  }
  Node temp = get(index-1);
  Node node = new Node(data);
  node.prev=temp;
  node.next=temp.next;
  temp.next.prev=node;
  temp.next=node;
  size++;
  }
  
  public void deleteFirst(){
  if(head==tail){
    head=tail=null;
  }else{
    head=head.next;
    head.prev=null;
  }
  size--;
  }
  
  public void deleteLast(){
  if(head==tail){
    head=null;
    tail=null;
  }  else{
    Node secondLast=get(size-2);
    secondLast.next=null;
    tail=secondLast;
  }
    size--;
  }

  public void deleteAt(int index){
    Node node = get(index);
    if(index==0){
        deleteFirst();
        return;
    }
    if(index==size-1){
        deleteLast();
        return;
    }
    node.prev.next=node.next;
    node.next.prev=node.prev;
    node.next=node.prev=null;
    size--;
  }

  public Node get(int index){
  Node temp = head;
  for(int i=0;i<index;i++){
    temp=temp.next;
  }
  return temp;
  }
  
  public void display(){
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data + "-><-");
      temp=temp.next;
    }
    System.out.print("END" + "\n" + size + "\n");
  }
}


