package examples.stack;

public class Main {
  public static void main(String []args)
    {
        StackImp stack = new StackImp();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(40);
        stack.push(40);
        stack.showElemetsofStack();
        System.out.println("1st POP->"+stack.pop());
        System.out.println("2nd POP->"+stack.pop());

    }
}
