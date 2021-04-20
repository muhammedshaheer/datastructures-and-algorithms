package datastructuresfirst.stack;

/**
 * @author Muhammed Shaheer
 * @since 17 April 2021
 */

public class Stack {
    private final int[] arr;
    private int top;
    private final int capacity;

    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }
        return arr[top--];
    }

    public int size() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i < size(); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Popping " + stack.pop());
        System.out.println("Popping " + stack.pop());
        System.out.println("Popping " + stack.pop());

        System.out.println("\nAfter popping out");
        stack.printStack();
    }
}
