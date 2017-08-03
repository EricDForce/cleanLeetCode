import java.util.*;

public class pinduoduo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] min = new long[2];
        long[] max = new long[3];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t < 0) {
                if (t < min[0]) {
                    min[1] = min[0];
                    min[0] = t;
                } else if (t < min[1]) {
                    min[1] = t;
                }
            } else {
                if (t > max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = t;
                } else if (t > max[1]) {
                    max[2] = max[1];
                    max[1] = t;
                } else if (t > max[2]) {
                    max[2] = t;
                }
            }
        }
        long res1 = max[0] * max[1] * max[2];
        long res2 = max[0] * min[0] * min[1];
        System.out.println(Math.max(res1, res2));
    }

    public int get(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] h = new Integer[n];
        for (int i=0;i<n;i++){
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Integer[] w = new Integer[m];
        for (int i=0;i<m;i++){
            w[i] = sc.nextInt();
        }
        Arrays.sort(h, new Comparator<Integer>(){
            public int compare(Integer arg0, Integer arg1){
                Integer a=(Integer)arg0;
                Integer b=(Integer)arg1;
                int temp=Integer.compare(a,b);
                return -temp;
            }
        });
        Arrays.sort(w, new Comparator<Integer>(){
            public int compare(Integer arg0, Integer arg1){
                Integer a=(Integer)arg0;
                Integer b=(Integer)arg1;
                int temp=Integer.compare(a,b);
                return -temp;
            }
        });

        int i = 0, j = 0;
        int num = 0;
        while (i < n && j < m)
        {
            if (w[j] >= h[i])
            {
                num++;
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        System.out.println(num);
        return num;
    }
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
