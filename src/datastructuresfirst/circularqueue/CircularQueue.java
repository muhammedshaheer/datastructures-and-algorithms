package datastructuresfirst.circularqueue;

/**
 * @author Muhammed Shaheer
 * @since 20 April 2021
 */

public class CircularQueue {
    private final int[] items;
    private final int size;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.items = new int[size];
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }

    private boolean isFull() {
        if (front == 0 && rear == size - 1)
            return true;
        return front == rear + 1;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return element;
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty queue");
        } else {
            System.out.println("Front -> " + front);
            for (i = front; i != rear; i = (i + 1) % size) {
                System.out.print(items[i] + " ");
            }
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.deQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        queue.enQueue(6);

        queue.display();

        int elem = queue.deQueue();
        if (elem != -1)
            System.out.println("Deleted element is -> " + elem);

        queue.display();

        queue.enQueue(7);

        queue.display();

        queue.enQueue(8);
    }
}
