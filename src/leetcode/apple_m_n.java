import java.util.ArrayList;
import java.util.List;

public class apple_m_n {
    public static void main(String[] args){
        int m=4, n=5;
        List<Integer> tmp = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        new apple_m_n().dfs(5, 1, tmp, 1, result);
        for (int i=0;i<result.size();i++){
            for (int j=0;j<result.get(i).size();j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public int get_m_n(int n, int m){
        if (n==1 || m==0){
            return 1;
        }
        if (n>m)
            return get_m_n(m, m);
        else
            return get_m_n(n, m-n) + get_m_n(n-1, m);
    }
    public int Dynamics(int n, int k, int min, int B) //将n分为k个整数，最小的大于等于min,最大的不超过B
    {
        if(n < min) return 0;     //当剩下的比min小，则不符合要求，返回0
        if(k == 1) return 1;
        int sum = 0;
        for(int t = min; t <= B; t++)
        {
            sum += Dynamics(n-t, k-1, t, B);
        }
        return sum;
    }

    public void dfs(int m, int n, List<Integer> tmpresult, int last_result, ArrayList<List<Integer>> result){
        if (n < 0) return;
        if (m < 0) return;
        if (m==0){
            result.add(new ArrayList<>(tmpresult));
            return;
        }
        for (int i=last_result; i<=m; i++){
            tmpresult.add(i);
            dfs(m-i, n-1, tmpresult, i, result);
            tmpresult.remove(tmpresult.size()-1);
        }
    }
}
