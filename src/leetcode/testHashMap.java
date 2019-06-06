import java.util.*;


//Set和Map都是无序的，ArrayList是有序的
public class testHashMap {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(4);
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        integerSet.add(13);
        integerSet.add(11);
        integerSet.add(14);
        for (int tmp : integerSet) {
            System.out.println("tmp:" + tmp);
        }
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");
        for (String iter : map.keySet()){
            System.out.println("key : "+iter + ", value : "+map.get(iter));
        }
    }
}
