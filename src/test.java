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
        String result = s;
        s = "sf";
        System.out.println("result :" + result);
        System.out.println("s : " + s);
//        permutation1(s, result, s.length());
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
