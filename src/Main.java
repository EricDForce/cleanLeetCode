import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by eric-d on 2016/10/29.
 */
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i=0;i<n;i++) {
            input[i] = sc.nextInt();
        }
        int[] max = new int[1];
        helper(0, n-1, input, max);
        System.out.println(max[0]);
    }
    public static void helper(int l, int r, int[] num, int[] max)
    {
        if(l > r) return ;
        int min = 112, pos = l;
        int sum = 0;
        for(int i = l; i <= r; i++)
        {
            if(num[i] < min)
            {
                min = num[i];
                pos = i;
            }
            sum += num[i];
        }
        max[0] = Math.max(max[0], sum*min);
        helper(l, pos-1, num, max);
        helper(pos+1, r, num, max);
    }

}
