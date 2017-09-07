import java.util.*;


//Set和Map都是无序的，ArrayList是有序的
public class testHashMap {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(4);
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");
        for (String iter : map.keySet()){
            System.out.println("key : "+iter + ", value : "+map.get(iter));
        }
    }
}
