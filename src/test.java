import com.sun.tools.corba.se.idl.InterfaceGen;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by eric-d on 16/9/7.
 */
public class test {
    public static void main(String[] args)
    {
        List<Integer>  test = new ArrayList<Integer>();
        HashMap<Integer, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        String s = "aabc";
//        System.out.println("s : " + s);
//        LinkedList<String> listStr = new LinkedList<>();
//        allPermutation(s.toCharArray(), listStr, 0);
//        System.out.println(listStr);
        Integer[] t = {9,45,3,2};
        new test().sortArray(t);
        for (Integer i : t){
            System.out.println(i);
        }
    }

    public static void permutation1(String str ,String result ,int len){
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if(result.length()==len){            //表示遍历完了一个全排列结果
            System.out.println(result);
        }
        else{
            for(int i=0;i<str.length();i++){
                if(result.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                    //System.out.println("字母："+str.charAt(i));
                    permutation1(str, result+str.charAt(i), len);
                }
            }
        }
    }

    public static void permutation2(String str ,String result ,int len, ArrayList<String> res){
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if(result.length()==len){            //表示遍历完了一个全排列结果
            res.add(result);
        }
        else{
            for(int i=0;i<str.length();i++){
                if(result.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                    //System.out.println("字母："+str.charAt(i));
                    permutation1(str, result+str.charAt(i), len);
                }
            }
        }
    }

    private static void allPermutation(char[] c, LinkedList<String> listStr, int start){


        if(start == c.length-1)
            listStr.add(String.valueOf(c));
        else{
            for(int i = start; i <= c.length-1; i++)
            {
                if (!isSwap(c, start, i)) {    //之前交换过的就不交换了
                    swap(c, i, start);//相当于: 固定第 i 个字符
                    allPermutation(c, listStr, start + 1);//求出这种情形下的所有排列
                    swap(c, start, i);//复位
                }
            }
        }
    }
    private static boolean isSwap(char[] c, int start, int end)
    {
        for(int i = start; i < end; i++)
        {
            if(c[i] == c[end])
                return true;
        }
        return false;
    }
    private static void swap(char[] c, int i, int j){
        char tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
    public int trailingZeroes(int n) {
        if(n<1) return 0;
        int c = 0;

        while(n/5 > 0) {
            n /= 5;
            c += n;
        }

        return c;
    }

    public int trailingZeroes1(int n) {
        int cnt = 0;

        for(int i=2;i<=n;i++){
            int tmp = i;
            while(tmp > 0){
                int r = tmp % 5;

                if(r == 0){
                    cnt++;
                }else{
                    break;
                }
                tmp = tmp/5;
            }
        }
        return cnt;
    }
class numCompare implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        String s1 = String.valueOf(o1);
        String s2 = String .valueOf(o2);
        return (s1+s2).compareTo((s2+s1));
    }
}
    public Integer[] sortArray(Integer[] nums){
        Arrays.sort(nums, new numCompare());
        return nums;
    }
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        boolean flag = false;

        long  n = Math.abs((long)numerator);
        long  d = Math.abs((long)denominator);
        System.out.println("n: " + n);
        System.out.println("d: " + d);
        System.out.println((numerator<=0)&&(denominator<=0));
        System.out.println((numerator>=0)&&(denominator>=0));
        if(((numerator<=0)&&(denominator<=0)) || ((numerator>=0)&&(denominator>=0))){
            flag = true;
        }
        String result = "";
        long num = n/d;
        long r = n%d;
        result += num;
        if(r == 0)
            return result;
        else
            result +=".";

        while(r != 0){
            if(map.containsKey(r)){
                result = result.substring(0, map.get(r))+ "(" + result.substring(map.get(r), result.length())+")";
                break;
            }

            map.put(r, result.length());

            r *= 10;
            result += String.valueOf(r/d);
            r = r%d;
        }
        if(flag){
            System.out.println(flag);
            return result;
        }
        else{
            System.out.println("-"+result);
            return ("-"+result);
        }
    }
}
