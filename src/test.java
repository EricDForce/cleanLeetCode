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
        int te = 100;
        String t = "dengli";
//        map.containsKey()
        t = t.substring(0, 3) + "(" + t.substring(3, t.length()) + ")";
//        System.out.println("t :" + t);
//        System.out.println(String.valueOf(te));
//        map1.put("dengli", "bowen");
//        map1.put("dengli", "jinke");
//        Set<String> ketSet = map1.keySet();
//        for (String key : ketSet){
//            System.out.println(map1.get(key));
//        }
//        String t = "e";
//        t.toCharArray();
//        String[] tmp = t.split("1e");
//        String tt = "dengli";
//        tt.charAt(0);
//        List<Integer> list = new ArrayList<>();

//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
        
//        list.add(1);
//        list.add(2);

//        list.add(0, 5);
//        String str = "01";
//        System.out.println(str.substring(0,0).length());
//
//        char s2c = '5';
//
//        if (s2c == '5')
//        {
//            System.out.println(s2c);
//        }
//        System.out.println(Integer.parseInt(str));

//        for (int iter : list)
//        {
//            System.out.println(iter);
//        }

//        System.out.println(new test().fractionToDecimal(-2147483648, 1));
//         System.out.println(new test().trailingZeroes(1808548329));
//        System.out.println(new test().trailingZeroes1(1808548329));
        int a = 1234;
        String str = String.valueOf(a);
        System.out.println(str);
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
