/**
 * Created by eric-d on 2017/6/26.
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args)
    {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=0)
        {
            return 0;
        }
        int l = prices[0], max = 0;
        for (int i=1; i<prices.length; i++)
        {
            l = Math.min(l, prices[i]);
            max = Math.max(max, prices[i]-l);
        }
        return max;
    }
}
