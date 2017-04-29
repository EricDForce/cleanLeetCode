/**
 * Created by eric-d on 2017/4/29.
 */
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Map;

public class Zigzag {
    public static void main(String[] args){
        System.out.println(new Zigzag().convert("ABC", 2));
    }
    public String convert(String s, int numRows) {
        Map<Integer, String> map = new HashMap<>();
        boolean bool  = false;  //向下
        int index = 0;
        int t = 0;
        while(index < s.length())
        {
            if((t+1) == numRows || t==0){
                bool = !bool;
            }
            map.put(t, map.get(t)==null ? ""+s.charAt(index) : map.get(t)+s.charAt(index));

            if (bool){
                t++;
            }else {
                t--;
            }
            index++;
        }
        StringBuilder res = new StringBuilder();
        for(int i : map.keySet()){
            res.append(map.get(i));
        }
        return res.toString();
    }
}
