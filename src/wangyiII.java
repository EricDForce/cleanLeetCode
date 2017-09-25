import java.util.Scanner;

public class wangyiII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        if(x<=n){
            System.out.println(1);
        }else if(x>6*n){
            System.out.println(0);
        }
        printProbabilityOfDice2(n, x);
    }
    public static void printProbabilityOfDice2(int n, int x){
        if(n<1){
            return;
        }
        int MAX = 6;
        double total=Math.pow(MAX, n);
        int maxSum=n*MAX;
        long[][] f=new long[n+1][n*MAX+1];
        for(int i=1;i<=MAX;i++){
            f[1][i]=1;
        }
        for(int k=2;k<=n;k++){
            for(int sum=n;sum<=maxSum;sum++){
                for(int i=1;sum-i>=1&&i<=MAX;i++){
                    f[k][sum]+=f[k-1][sum-i];
                }
            }
        }
        long tt = 0;
        for(int sum=x;sum<=maxSum;sum++){
            tt += f[n][sum];
        }
        System.out.println(tt/f(tt, (long) total)+"/"+(long) total/f(tt, (long) total));
    }
    public static long f(long a,long b){//求公约数
        int count = 0;
        for(int i=1;i<=Math.min(a, b);i++){
            if(a%i==0&&b%i==0){
                count = i;
            }
        }
        return count;
    }
}
