/**
 * Created by eric-d on 2017/6/20.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args){
        String s = "ABBB";
        String t = "B";
        System.out.println("string:"+new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        char[] st = t.toCharArray();
        int[] charMap = new int[256];
        int[] curMap = new int[256];
        for (int i=0;i<t.length();i++){
            charMap[t.charAt(i)]++;
        }
        int start = 0, cnt = t.length(), MX = Integer.MAX_VALUE;
        String result = "";
        while (start < s.length() && charMap[s.charAt(start)]==0) start++;  //从字符串s的第一个
        for (int i=start; i<s.length(); i++){
            if (charMap[s.charAt(i)] != 0){
                curMap[s.charAt(i)]++;
                if (curMap[s.charAt(i)] <= charMap[s.charAt(i)])
                cnt--;
                if (cnt==0){
                    while (start < s.length()&&(charMap[s.charAt(start)]==0 || curMap[s.charAt(start)]>charMap[s.charAt(start)])) {
                        if (curMap[s.charAt(start)]>charMap[s.charAt(start)])
                        curMap[s.charAt(start)]--;
                        start++;
                    }
                    if ((i-start) < MX){
                        MX = (i-start);
                        result = s.substring(start, i+1);
                    }
                }
            }
        }
        return result;
    }
}
