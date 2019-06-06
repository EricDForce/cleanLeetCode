import java.util.Scanner;

public class huawei {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int length = s1.length();
        if (s1.length() != s2.length()){
            System.out.println(-1);
            return ;
        }
        int max = 0, start = 0;
        for (int i = 0; i<length; i++){
            if (!Character.isDigit(s1.charAt(i)) || !Character.isDigit(s2.charAt(i))){
                System.out.println(-1);
                return ;
            }
            if (s1.charAt(i) != s2.charAt(i)){
                start = i+1;
            }else {
                max = Math.max(max, (i - start + 1));
            }
        }
        System.out.println(max);
    }
}
