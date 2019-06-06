import java.util.*;

/**
 * Created by eric-d on 2016/10/18.
 */
public class testsplit {
    public class Order{
        int start;
        String temp;
        public Order(int t){
            String tmp = String.valueOf(t);
            start = tmp.charAt(0) - '0';
            temp = tmp;
        }
    }

    public static void main(String[] args)
    {
        String str1 = "dengli and libowen or you are friends";
        String str2 = "/../";
        String[] names1 = str1.split("and|or");
        String[] names2 = str2.split("/");
//        System.out.println(names1.length);
        List<String> strlist = new ArrayList<>();
        str1.toCharArray();
        Integer[] nums = {1,2,5,67,23,54};
        testsplit t = new testsplit();
        Arrays.sort(nums, t.new Cmp1());
        String a = "dengli";
        String b = "nihao";
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.remove(4);

        for (int tmp : set){
            System.out.println(tmp);
        }

//        System.out.println(a.concat(b));
//        System.out.println(a + b);
//        System.out.println(new testsplit().largestNumber(nums));
//        for (String str : strlist)
//        {
//            System.out.println(str);
//        }
//
//        for (int i=0;i<names1.length;i++)
//        {
//            System.out.println("------------"+ names1[i]+ "------------------");
//        }

    }
    public void getnumSort(Integer[] nums){
        Arrays.sort(nums, new Cmp1());
    }
    public String largestNumber(int[] nums){
        String res = "";
        int len = nums.length;
        Order[] orders = new Order[len];
        for (int i=0;i<len;i++){
            orders[i] = new Order(nums[i]);
        }
        Arrays.sort(orders, new Comparator<Order>(){
            public int compare(Order t1, Order t2){
                String str1 = t1.temp;
                String str2 = t2.temp;
                int len1 = str1.length();
                int len2 = str2.length();
                int pos1 = 0;
                int pos2 = 0;
                while (pos1<len1 && pos2<len2){
                    if(str1.charAt(pos1) == str2.charAt(pos2)){
                        pos1++;
                        pos2++;
                    }else if (str1.charAt(pos1)>str2.charAt(pos2)){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                int tmp1 = 0;
                int tmp2 = 0;
                while (pos1<len1){
                    if(str1.charAt(pos1) == str2.charAt(tmp2)){
                        pos1++;
                    }else if (str1.charAt(pos1)>str2.charAt(tmp2)){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                while (pos2<len2){
                    if(str1.charAt(tmp1) == str2.charAt(pos2)){
                        pos2++;
                    }else if (str1.charAt(tmp1)>str2.charAt(pos2)){
                        return -1;
                    }else{
                        return 1;
                    }
                }

                if(str1.charAt(--pos1)>str2.charAt(--pos2)){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        for(int i=0;i<len;i++){
            res +=orders[i].temp;
        }
        if(res.length() > 0 && res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }

    public String largestNumber2(int[] nums){
        String res  = "";
        int len = nums.length;
        String[] strlist = new String[len];

        for (int i=0;i<len;i++){
            strlist[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strlist, new Cmp());

        for(String str : strlist){
            res += str;
        }

        if (Integer.valueOf(res) == 0){
            return "0";
        }

        return res;
    }

    class Cmp1 implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            if (a>b){
                return 1;
            }else if (a < b){
                return -1;
            }else {
                return 0;
            }
        }
    }
    class Cmp implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String ab = a + b;
            String ba = b + a;
            return Integer.valueOf(ab) - Integer.valueOf(ba);
        }
    }
}
