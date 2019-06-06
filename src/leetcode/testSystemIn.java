import java.util.Scanner;
import java.util.Stack;

public class testSystemIn {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strList = sc.nextLine().split(" ");
        for (int i=0; i<strList.length; i++){
            System.out.println(strList[i]);
        }
        int k = sc.nextInt();
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < strList.length){
            while (Integer.valueOf(strList[index]) < Integer.valueOf(stack.peek()) && (index-stack.peek())<k){

            }
        }
    }
}
