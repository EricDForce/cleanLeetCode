import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class pingankeji {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        String result = "";
        int i=str.length()-1;
        while(i>=0){
            if (str.charAt(i) == '['){
                i--;
                int t = Integer.parseInt(""+str.charAt(i));
                String tmp = "";
                while(!stack.isEmpty() && stack.peek() != ']'){
                    tmp += stack.pop();
                }
                if(!stack.isEmpty())
                    stack.pop();
                String tt = tmp;
                for (int j=1;j<t;j++){
                    tmp += tt;
                }
                for(int k=tmp.length()-1;k>=0;k--){
                    stack.push(tmp.charAt(k));
                }
            }else {
                stack.push(str.charAt(i));
            }
            i--;
        }
        String string = "";
        while(!stack.isEmpty()){
            string += stack.pop();
        }
        System.out.println(string);
    }
}
