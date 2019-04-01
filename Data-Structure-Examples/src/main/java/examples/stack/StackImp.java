package examples.stack;

public class StackImp {

    int[] stack = new int[5];
    int top = -1;

    public void push(int data) {
        if (top >= 5) {
            System.out.println("Overflow");
        }
        top++;
        stack[top] = data;


    }

    public int pop() {
        if (top == -1) {
            System.out.println("UnderFlow");
        }
        int data;
        data = stack[top];
        stack[top] = 0;
        top--;
        return data;

    }

    public int peek() {
        int data;
        data = stack[top - 1];
        return data;

    }

    public void showElemetsofStack() {
        for (int i = 4; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
