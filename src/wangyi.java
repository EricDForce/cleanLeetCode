import java.util.Arrays;
import java.util.Scanner;

public class wangyi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i=0;i<n;i++){
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        int dif = input[1] - input[0];
        for (int i=1;i<n;i++){
            int tmp = input[i]-input[i-1];
            if (tmp != dif){
                System.out.println("Impossible");
                return ;
            }
        }
        System.out.println("Possible");
    }
}
