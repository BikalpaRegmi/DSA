public class main{
  public static void main(String[] args){
    StaticQueue sq = new StaticQueue(5);
    sq.enqueue(8);
    sq.enqueue(9);
    sq.enqueue(6);
    sq.enqueue(4);
    sq.enqueue(1);
    sq.dequeue();
    
    sq.enqueue(2)
    
    sq.display();
  }
}



class StaticQueue{
  int[] queue;
  int rear , front;
  
  public StaticQueue(int capacity){
    queue = new int[capacity];
    rear = front = -1;
  }
  
  public void enqueue(int data){
    if(rear==queue.length-1){
      System.out.println("Sorry, Failed to enque");
      return;
    }
    
    queue[++rear] = data;
    if(front==-1){
      front=0;
    }
  }
  
  public void dequeue(){
    if(front==-1 || front>rear){
      System.out.println("Front doesn't have data");
      return;
    }
    queue[front++]=0;
  }
  
  public void display(){
    if(front==-1 || front>rear){
      System.out.println("Queue has nothing");
      return;
    }
    
    for(int i=front; i<=rear ; i++){
      System.out.print(queue[i]+"|");
    }
    System.out.println();
  }
  
  public void getFront(){
    if(front==-1 || front>rear){
      System.out.println("Front doesn't have any data");
      return;
    }
    System.out.println("Front Queue is: " + queue[front]);
  }
}