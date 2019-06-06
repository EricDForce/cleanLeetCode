import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eric-d on 16/9/12.
 */
public class leetcode6 {

//    public static int cnt = 0;
    HashMap<Integer, String> res = new HashMap();

    public String getPermutation(int n, int k) {

        if (k<=0)
            return "";

        int[] nums = new int[n];

        for (int i=0;i<n;i++)
        {
            nums[i] = i+1;
        }
        List<String> result = getString(nums, n);

        int len = result.size();

        int idx = k%len;
        int time = k/len;

        if (idx == 0)
        {
            idx = len;
        }

        char[] res = result.get(idx-1).toCharArray();
        System.out.println(idx+":"+time);
        if (idx == len)
        {
            time = time-1;
        }
        for (int i=0;i<=time;i++)
        {
            int id = 0;
            for (int j=0;j<res.length;j++)
            {
                if ((res[j]+"").equals((i+1)+""))
                {
                    id = j;
                    break;
                }
            }
            res[id] = res[0];
            res[0] = String.valueOf(i+1).charAt(0);
        }
        return String.valueOf(res);
    }

    public List<String> getString(int[] nums, int n)
    {

        List<String> result = new ArrayList<String>();
        if (nums.length == 1)
        {
            result.add(nums[0] + "");
            return result;
        }
        int cnt = 0;
        int[] tmp = new int[nums.length-1];

        for (int i=0;i<nums.length;i++)
        {
            int pos = 0;
            for (int j=0;j<nums.length;j++)
            {
                 if (j != i)
                 {
                     tmp[pos++] = nums[j];
                 }
            }
            List<String> subString = getString(tmp, n);

            for (String str : subString)
            {
                String add = nums[i] + str;
                result.add(add);
                cnt++;
            }
            if (nums.length == n && i==0) {
                return result;
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        int n = 9;
        int k = 171669;

        leetcode6 test = new leetcode6();
        System.out.println(test.getPermutation(n, k));
//        String str = "dengli";

    }
}
