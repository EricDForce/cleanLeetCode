import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric-d on 2017/4/9.
 */
public class LSWRC {
    public static void main(String[] args){
        String str = "tmmzuxt";
        System.out.println(new LSWRC().lengthOfLongestSubstring(str));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, n=s.length(),maxlen = Integer.MIN_VALUE;
        if(n==0) return 0;
        while (i<n && j<n){
            if (map.get(s.charAt(i))==null){
                map.put(s.charAt(i), i);
                maxlen = Math.max(i - j + 1, maxlen);
                i++;
            }else{
                if (map.get(s.charAt(i))>=j)
                    j=map.get(s.charAt(i))+1;
                else
                    maxlen = Math.max(i - j + 1, maxlen);
                map.put(s.charAt(i), i);
                i++;
            }
        }
        return maxlen;
    }
}
