/**
 * Created by eric-d on 2017/4/10.
 */
public class LSATDC {
    public static void main(String[] args){
        String s = "abaac";
        System.out.println(new LSATDC().lengthOfLongestSubstringTwoDistinctK(s, 2));
    }
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int i=0, j=-1, maxLen = 0;
        for (int k = 1; k < s.length(); k++){
            if (s.charAt(k-1) == s.charAt(k)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)){
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxLen);
    }

    public int lengthOfLongestSubstringTwoDistinctK(String s, int k){
        int[] countMap = new int[256];
        int numDistinct = 0, j = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++){
            if (countMap[s.charAt(i)] == 0) numDistinct++;
            countMap[s.charAt(i)]++;
            while (numDistinct > k){
                countMap[s.charAt(j)]--;
                if (countMap[s.charAt(j)] == 0) numDistinct--;
                j++;
            }
            maxLen = Math.max(i - j + 1, maxLen);
        }
        return maxLen;
    }
}
