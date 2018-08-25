import java.util.Stack;

public class staticDemo {
    public static int a = 10;              //全局变量，所有类公用
    public static void main(String[] args) {
//        staticDemo ts1 = new staticDemo();
//        staticDemo ts2 = new staticDemo();
//        ts1.a = 20;
//        System.out.println(ts1.a);
//        System.out.println(ts2.a);
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(12);
        stack1.push(13);
        System.out.println(stack1.peek());
    }
    public static int getValue(){
        return a;
    }
}
