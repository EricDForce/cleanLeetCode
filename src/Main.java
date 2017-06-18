import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by eric-d on 2016/10/29.
 */
public class Main {
    public static void main(String[] args)
    {
        char[] biao ={'a','b','c','d','e','f','g','h','i','j'};
        Scanner sc = new Scanner(System.in);

        String inString = sc.next();
        int inNumber = sc.nextInt();

        char[] inString2char = inString.toCharArray();

        int[] cnt = new int[10];

        for (int i=0;i<inString.length();i++)
        {
            cnt[inString2char[i]-'a']++;
        }

        int[] sum = new int[10];
        sum[0] = cnt[0];

        for (int i=1;i<10;i++)
        {
            sum[i] = sum[i-1] + cnt[i];
        }
        int pos = 0;
        for(int i=0;i<10;i++)
        {
            if(inNumber <= sum[i])
            {
                pos = i;
                break;
            }
        }

        int cha = sum[pos] - inNumber;
        char[] result = new char[sum[pos]];
        char[] ret = new char[inNumber];
        int index = 0;
        for (int i=0;i<inString.length();i++)
        {
            if (inString2char[i] <= biao[pos])
            {
                result[index++] = inString2char[i];
            }
        }

        if (cha == 0)
            System.out.println(result);
        else
        {
            for (int i=sum[pos]-1;i>=0;i--)
            {
                if(result[i] == biao[pos])
                {
                    result[i] = 'z';
                    cha--;
                }
                if(cha==0) {
                    break;
                }
            }
            int ind = 0;
            for (int i=0;i<=sum[pos]-1;i++)
            {
                if(result[i] != 'z')
                {
                    ret[ind++] = result[i];
                }
            }
            System.out.println(ret);
        }
    }
}
