import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tmp = new int[N];
        for (int i=0; i<N; i++){
            tmp[i] = sc.nextInt();
        }
        Arrays.sort(tmp);
        if (N==1){
            System.out.println("No");
            return ;
        }else if (N==2){
            if (tmp[0]==tmp[1]){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            return;
        }
        int max = tmp[N-1], sum = 0;
        for (int i=N-2; i>=1; i--){
            sum += tmp[i];
            if (sum>=max){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
