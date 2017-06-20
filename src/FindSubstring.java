import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eric-d on 2017/6/19.
 */
public class FindSubstring {
    public static void main(String[] args){
        String str = "abaababbaba";
        String[] words = {"ba","ab","ab"};
        System.out.println(new FindSubstring().findSubstring2(str, words));
    }

    //O(n**2)的复杂度
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

    //O(n)的复杂度
    public List<Integer> findSubstring2(String s, String[] words){
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        int l = words[0].length();
        int len = s.length();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i])+1);   //统计words里面的词频
            }else{
                map.put(words[i], 1);
            }
        }
        for(int i=0;i<l;i++){
            HashMap<String, Integer> curMap = new HashMap<>();     //统计词窗里面的词频
            int cnt = words.length;
            int start = i;
            for (int j=i;j<=len-l;j=j+l){
                String str = s.substring(j, j+l);
                if(map.containsKey(str)){
                    curMap.put(str, curMap.containsKey(str) ? curMap.get(str)+1 : 1);
                    cnt--;
                    while (curMap.get(str) > map.get(str)){   //如果当前词语的个数多于words里面该词语的个数，
                        // 就将该词窗内第一次出现该词的位置之前的数据清掉
                        String sub = s.substring(start, start+l);
                        curMap.put(sub, curMap.get(sub)-1);
                        start = start+l;
                        cnt++;
                    }
                }else{ //如果没有出现该词语，就将记录清零
                    start = j+l;
                    curMap.clear();
                    cnt = words.length;
                }
                if(cnt == 0){
                    res.add(start);
                    curMap.put(s.substring(start, start+l), curMap.get(s.substring(start, start+l))-1);
                    start = start+l;
                    cnt = 1;
                }
            }
        }
        return res;
    }
}
