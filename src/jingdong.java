import java.util.Scanner;

public class jingdong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(getNum(n));
    }
    public static int getNum(long n){
        int t = (int)Math.sqrt(2*n);
        int t1 = t-1;
        int t2 = t-2;
        int t3 = t+1;
        if(t3*(t3+1)>=2*n && (t3-1)*(t3)<2*n){
            return t3;
        }
        return t;
    }
}
