public class main {
    public static void main(String[] args) {
        StaticQueue sq = new StaticQueue(5);
        sq.enqueue(8);
        sq.enqueue(9);
        sq.enqueue(6);
        sq.enqueue(4);
        sq.enqueue(1);
        sq.dequeue();
        
        sq.enqueue(2);
        
        sq.display();
    }
}

class StaticQueue {
    int[] queue;
    int rear, front;

    public StaticQueue(int capacity) {
        queue = new int[capacity];
        rear = front = -1;
    }

    public void enqueue(int data) {
        if ((rear + 1) % queue.length == front) {
            System.out.println("Sorry, Failed to enque");
            return;
        }
        if (front == -1) {
            front = 0;
        } 
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
    }

    public void dequeue() {
        if (front == -1) {
            System.out.println("Front doesn't have data");
            return;
        }
        queue[front] = 0; 
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue has nothing");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + "|");
            if (i == rear) break;
            i = (i + 1) % queue.length;
        }
        System.out.println();
    }

    public void getFront() {
        if (front == -1) {
            System.out.println("Front doesn't have any data");
            return;
        }
        System.out.println("Front Queue is: " + queue[front]);
    }
}

""" 
Action	Front (F)	Rear (R)	Array Visualization
Initial	   -1	     -1	            [ , , , , ]
enqueue(8)	0	      0	            [8, , , , ]
enqueue(4)	0	      3	            [8, 9, 6, 4, ]
enqueue(1)	0	      4	            [8, 9, 6, 4, 1]
dequeue()	1	      4	            [ , 9, 10, 13, 1]
enqueue(2)	1	      0	            [2, 9, 10, 13, 1]
dequeue()	2	      0	            [6, , 10, 13, 1] 
"""