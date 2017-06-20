import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eric-d on 2017/6/19.
 */
public class FindSubstring {
    public static void main(String[] args){
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(new FindSubstring().findSubstring(str, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int l = words[0].length();
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= len - l * words.length; i++) {
            HashMap<String, Integer> map1 = (HashMap<String, Integer>) map.clone();
            int cnt = words.length;
            int j = i;
            while (j <= len-l) {
//                System.out.println("i : " + i);
//                System.out.println("j : " + j);
                if (map1.containsKey(s.substring(j, j + l)) && map1.get(s.substring(j, j + l)) > 0) {
                    cnt--;
                    map1.put(s.substring(j, j + l), map1.get(s.substring(j, j + l)) - 1);
                } else {
                    break;
                }
                j = j + l;
            }
            if (cnt == 0) {
                res.add(i);
            }
        }
        return res;
    }

}
