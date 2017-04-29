import java.util.Arrays;
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
        int j=0, n=s.length(),maxlen = Integer.MIN_VALUE;
        if(n==0) return 0;

        for (int i=0;i<n;i++){
            if (map.get(s.charAt(i))!= null && map.get(s.charAt(i))>=j)
                j=map.get(s.charAt(i))+1;
            map.put(s.charAt(i), i);
            maxlen = Math.max(i - j + 1, maxlen);
        }
        return maxlen;
    }
    public int lengthOfLongestSubstring2(String s) {
        int[] charMap = new int[256];       //对于字符类型的hashMap使用整形数组即可，字符就是8位整形
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
}
