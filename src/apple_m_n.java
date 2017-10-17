public class apple_m_n {
    public static void main(String[] args){
        System.out.println(new apple_m_n().get_m_n(5, 4));
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
        if(n < min) return 0;  //当剩下的比min小，则不符合要求，返回0
        if(k == 1) return 1;
        int sum = 0;
        for(int t = min; t <= B; t++)
        {
            sum += Dynamics(n-t, k-1, t, B);
        }
        return sum;
    }

}
