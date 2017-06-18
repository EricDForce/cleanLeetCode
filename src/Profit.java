/**
 * Created by eric-d on 2017/1/4.
 */
import java.util.*;

public class Profit {

    public static void main(String[] args)
    {
        int[] nums = {6,1,3,2,4,7};

        System.out.println(new Profit().maxProfit(nums));
    }
    public int maxProfit(int[] prices) {

        int len = prices.length;

        if(len<=0)
        {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        int low = 0;
        int high = len-1;
        left[0] = 0;
        right[len-1] = 0;
        for(int i=1;i<len;i++)
        {
            if(prices[i] < prices[low])
            {
                low = i;
            }

            left[i] = Math.max(prices[i] - prices[low], left[i-1]);
        }

        for(int i=len-2;i>=0;i--)
        {
            if(prices[high] < prices[i])
            {
                high = i;
            }

            right[i] = Math.max(prices[high] - prices[i], right[i+1]);
        }
        int profit = 0;
        for(int i=0;i<len;i++)
        {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;

    }

}
