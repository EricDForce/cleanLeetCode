import java.util.Scanner;

public class ali {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i=0; i<k; i++){
            if (getSum(i)<k && getSum(i+1)>=k){
                System.out.println(k-getSum(i));
            }
        }
    }
    public static int getSum(int k){
        return k*(k+1)/2;
    }
}
