import java.util.Scanner;

public class vmware {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int in2int = Integer.parseInt(in);
        int n = in.length();
        String res = "1";
        for (int i=0;i<n;i++){
            res +="0";
        }
        int res2int = Integer.parseInt(res)/2;
        int result1 = res2int + in2int;
        int result2 = in2int + res2int;
        int result3 = res2int - in2int;
        int result4 = in2int - res2int;

        String s1 = String.valueOf(result1);
        String s2 = String.valueOf(result2);
        String s3 = String.valueOf(result3);
        String s4 = String.valueOf(result4);
        if (s1.length()==n)
            System.out.println(s1);
        else if (s2.length() == n)
            System.out.println(s2);
        else if (s3.length() == n)
            System.out.println(s3);
        else if (s4.length() == n)
            System.out.println(s3);
    }
}
