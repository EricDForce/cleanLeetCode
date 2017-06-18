import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 2017/2/9.
 */
public class PalindromePartitioning {
    public static void main(String[] args){
        String test = "aaabb";
//        List<List<String>> res = new PalindromePartitioning().partition(test);
//        for (List<String> iter : res){
//            for (String it : iter){
//                System.out.print(it + " ");
//            }
//            System.out.println();
//        }
        System.out.println(new PalindromePartitioning().minCut(test));
    }

    public List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len<=0)
        {
            return res;
        }
        for (int i=1;i<=len;i++){
            String tt = s.substring(0, i);
            if (judge(tt)){
                List<List<String>> tmp = partition(s.substring(i, len));
                if (tmp.size() == 0)      //s为空时返回的为空
                {
                    List<String> list = new ArrayList<>();
                    list.add(tt);
                    res.add(list);
                }
                for (List<String> it : tmp){
                    List<String> list = new ArrayList<>();
                    list.addAll(it);
                    list.add(0, tt);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public int minCut(String s) {
        int len = s.length();
        int[] cuts = new int[len+1];
        boolean[][] dp = new boolean[len][len];  //dp[i][j]用来判断s(i)~s(j)是否为回文串
        cuts[0] = 0;
        if (len == 0)
        {
            return 0;
        }
        for (int i=0;i<len;i++){
            cuts[i] = len - i;
        }
        for (int i=len-1;i>=0;i--){
            for (int j=i; j<len; ++j){
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))
                        || (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
                }
            }
        }
        return cuts[0] - 1;
    }

    public boolean judge(String s){
        int left = 0;
        int right = s.length()-1;
        while (left<=right)
        {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
