public class main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.enqueue(8);
        pq.enqueue(9);
        pq.enqueue(6);
        pq.enqueue(4);
        pq.enqueue(1);
        pq.dequeue();
        
        pq.enqueue(2); 
        
        pq.display();
    }
}

class PriorityQueue {
    int[] queue;
    int rear, front;
    
    public PriorityQueue(int capacity) {
        queue = new int[capacity];
        rear = front = -1;
    }
    
    public void enqueue(int data) {
        if (rear == queue.length - 1) {
            System.out.println("Sorry, Failed to enqueue - Queue is full");
            return;
        }
        
        if (front == -1) {
            queue[++rear] = data;
            front = 0;
            System.out.println("Inserted: " + data);
            return;
        }
        
        int i;
        for (i = rear; i >= front; i--) {
            if (queue[i] > data) {
                queue[i + 1] = queue[i]; 
            } else {
                break;
            }
        }
        
        queue[i + 1] = data;
        rear++;
        System.out.println("Inserted: " + data);
    }
    
    public void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty - Nothing to dequeue");
            return;
        }
        
        int removed = queue[front];
        for (int i = front; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        queue[rear] = 0; 
        rear--;
        
        if (rear < front) {
            front = rear = -1;
        }
        
        System.out.println("Removed highest priority: " + removed);
    }
    
    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Priority Queue is empty");
            return;
        }
        
        System.out.print("Priority Queue (higher priority first): ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i < rear) {
                System.out.print(" < ");
            }
        }
        System.out.println();
    }
    
    public void getFront() {
        if (front == -1 || front > rear) {
            System.out.println("Priority Queue is empty");
            return;
        }
        System.out.println("Highest priority element: " + queue[front]);
    }
    
    public void peek() {
        getFront();
    }
    
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
    
    public int size() {
        if (isEmpty()) return 0;
        return rear - front + 1;
    }
}