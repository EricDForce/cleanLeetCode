/**
 * Created by eric-d on 16/8/27.
 */
public class leetcode3 {

    public static void main(String[] args)
    {
        int[] test = new int[]{};
        System.out.print(new leetcode3().canJump(test));
    }

    public boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;
        if(nums[0] >= (nums.length - 1))
            return true;

        int maxlen = nums[0];
        if (maxlen==0)
            return false;

        for (int i=1;i<nums.length-1;i++)     //复杂度为O(n), maxlen纪录从零可以到达的最远地方,不断更新maxlen即可,分两段
        {
            if (maxlen >= i && (nums[i]+i)>=nums.length-1)
                return true;
            if (maxlen<=i && nums[i] == 0)
                return false;
            if (nums[i]+i > maxlen)
                maxlen = nums[i]+i;
        }

      return false;
    }

    public boolean canGetend(int[] nums, int index,int[] temp)  //复杂度为O(n^2)
    {
        int len = nums.length;

        if (index >= len)
        {
            return false;
        }else if (index == len-1)
        {
            temp[index] = 2;
            return true;
        }else if (nums[index]==0 && index != len-1)
        {
            temp[index] = 1;
            return false;
        }

        int t = nums[index];

        boolean flag = false;
        for (int i=1;i<=t;i++)
        {
            if (temp[index+i] == 2)
            {
                flag = true;
                break;
            }else if (temp[index+i] == 1)
            {
                continue;
            }else
            {
                if (canGetend(nums, index+i, temp))
                {
                    temp[index] = 2;
                    flag = true;
                    break;
                }
            }
        }
        if (flag == false)
        {
            temp[index] = 1;
        }
        return flag;
    }
}

