package datastructuresfirst.queue;

public class Queue {
    private final int[] items;
    private final int size;
    private int front;
    private int rear;

    public Queue(int size) {
        this.items = new int[size];
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }

    private boolean isFull() {
        return front == 0 && rear == size - 1;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;

            items[++rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            int element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted " + element);
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Empty QueueF");
        } else {
            System.out.println("Front index -> " + front);
            System.out.println("Items -> ");
            for (int i = front; i < rear; i++) {
                System.out.println(items[i]);
            }
            System.out.println("Rear index -> " + rear);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.deQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);

        queue.display();

        queue.deQueue();

        queue.display();
    }
}
