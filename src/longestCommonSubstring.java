public class longestCommonSubstring {
    public static void main(String[] args){
        String str1 = "dengli", str2 = "engli";
        System.out.println(new longestCommonSubstring().getLongestCommonSubstringDp(str1, str2));
    }
    public String getLongestCommonSubstring(String str1, String str2){
        int size1 = str1.length(), size2 = str2.length();
        String result = "";
        int maxlength = 0;
        for (int i=0; i<size1; i++){
            for (int j=0; j<size2; j++){
                int m = i, n = j;
                int length = 0;
                while (m < size1 && n < size2){
                    if (str1.charAt(m) != str2.charAt(n)) break;
                    length++;
                    m++;
                    n++;
                }
                if (maxlength < length){
                    maxlength = length;
                    result = str1.substring(i, m);
                }
            }
        }
        return result;
    }
    public String getLongestCommonSubstringDp(String str1, String str2){
        int size1 = str1.length(), size2 = str2.length();
        int[][] dp = new int[size1+1][size2+1];
        for (int i=0; i<=size1; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<=size2; j++){
            dp[0][j] = 0;
        }
        int start1 = 0, start2 = 0, max = 0;
        for (int i=1; i<=size1; i++){
            for (int j=1; j<=size2; j++){
                dp[i][j] = (str1.charAt(i-1) == str2.charAt(j-1)) ? (dp[i-1][j-1]+1) : 0;
                if (dp[i][j] > max){
                    max = dp[i][j];
                    start1 = i;
                    start2 = j;
                }
            }
        }
        return str1.substring(start1-dp[start1][start2], start1);
    }
}
