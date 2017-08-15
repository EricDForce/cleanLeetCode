import java.util.*;

public class wangyi2 {
    public static void main(String[] args){
        int[] x = new int[55];
        int[] y = new int[55];
        int[] ans = new int[55];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
            x[i] = in.nextInt();
        for(int i = 0; i < n; i++)
            y[i] = in.nextInt();
        for(int i = 0; i < n; i++)
            ans[i] = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                int sx = x[i];
                int sy = y[j];
                List<Integer> sum = new ArrayList<>();
                for(int z = 0; z < n; z++){
                    sum.add(Math.abs(x[z]-sx) + Math.abs(y[z]-sy));
                }
                Collections.sort(sum);
                int now = 0;
                for(int z =0; z < n; z++){
                    now += sum.get(z);
                    ans[z] = Math.min(now,ans[z]);
                }

            }
        for(int i = 0; i < n-1; i++)
            System.out.print(ans[i] + " ");
        System.out.println(ans[n-1]);
    }
}
