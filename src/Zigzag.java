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
        boolean bool  = true;  //向下
        int index = 0;
        int t = 0;
        while(index < s.length())
        {
            if((t+1) == numRows){
                bool = false;
            }else if(t==0){
                bool = true;
            }
            if(bool){
                if(map.get(t) == null){
//                    System.out.println("----1d"+s.charAt(index));
                    map.put(t, ""+s.charAt(index));
                }else{
//                    System.out.println("----2d"+s.charAt(index));
                    map.put(t, map.get(t)+s.charAt(index));
                }
                t++;
            }else{
                if(map.get(t) == null){
//                    System.out.println("----3d"+s.charAt(index));
                    map.put(t, ""+s.charAt(index));
                }else{
//                    System.out.println("----4d"+s.charAt(index));
                    map.put(t, map.get(t)+s.charAt(index));
                }
                t--;
            }
            index++;
        }
        StringBuilder res = new StringBuilder();
        for(int i : map.keySet()){
            System.out.println("------"+i+":"+map.get(i));
            res.append(map.get(i));
        }

        return res.toString();
    }
}
