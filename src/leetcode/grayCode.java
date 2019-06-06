/**
 * Created by eric-d on 2016/12/9.
 */
import java.io.File;
import java.util.*;
import java.math.*;

public class grayCode {
    public static void main(String[] args)
    {
        grayCode t = new grayCode();
        List<Integer> ret = t.grayCode(3);
        for (int iter : ret)
        {
            System.out.println(iter);
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(n==1) {
            tmp.add(0);
            tmp.add(1);
            return tmp;
        }
        tmp = grayCode(n-1);
        result.addAll(tmp);
        for(int i=tmp.size()-1;i>=0;i--)
        {
            int temp = tmp.get(i);
            result.add(temp+(int)(Math.pow(2, n-1)));
        }
        return result;
    }
}
