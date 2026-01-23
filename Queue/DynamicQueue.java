public class DynamicQueue{
 public static void main(String[] args){
    DQ queue = new DQ();
    queue.enqueue(0);
    queue.enqueue(1);
    queue.enqueue(3);
    queue.enqueue(5);
    queue.enqueue(7);
    queue.enqueue(9);
    queue.enqueue(12);

    queue.display();
 }
}

class DQ {
    private int[] data;
    private int front;
    private int size;

    public DQ() {
        data = new int[5]; 
        front = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == data.length) {
        int[] newData = new int[data.length * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        }

        int rear = (front + size) % data.length;
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int removed = data[front];
        front = (front + 1) % data.length;
        size--;
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % data.length] + " ");
        }
        System.out.println();
    }
}
