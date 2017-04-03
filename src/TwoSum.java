/**
 * Created by eric-d on 2017/4/2.
 */
import java.util.*;
public class TwoSum {
    private Map<Integer, Integer> table = new HashMap<>();

    public void add(int input){
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count+1);
    }

    public boolean find(int input){
        for (Map.Entry<Integer, Integer> entry : table.entrySet()){
            int num = entry.getKey();
            int val = input-num;
            if (val == num){
                if (table.get(val) >=2)
                    return true;
            }else if (table.containsKey(val)){
                return true;
            }
        }
        return false;
    }
}
