package datastructuresfirst.deque;

/**
 * @author Muhammed Shaheer
 * @since 25 April 2021
 */

public class Deque {
    int[] arr;
    int front;
    int rear;
    int size;

    public Deque(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = 0;
    }

    boolean isFull() {
        return (front == 0 && rear == size - 1) || front == rear + 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void insertFront(int element) {
        if (isFull()) {
            System.out.println("Overflow!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }
        arr[front] = element;
    }

    void insertRear(int element) {
        if (isFull()) {
            System.out.println("Overflow!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = element;
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Queue underflow!");
            return -1;
        }
        return arr[rear];
    }

    public static void main(String[] args) {
        Deque deque = new Deque(4);
        deque.insertRear(12);
        deque.insertRear(14);
        System.out.println("Rear element " + deque.getRear());
        deque.deleteRear();
        deque.insertFront(13);
        System.out.println("Front element " + deque.getFront());
        deque.deleteFront();
        System.out.println("Front element " + deque.getFront());
    }
}
