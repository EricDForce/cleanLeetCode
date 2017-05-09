import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric-d on 2017/5/4.
 */
public class sllsl {
    public static void main(String[] args){
        String s = "a", t = "a";
        System.out.println(new sllsl().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] charMap = new int[256];
        Map<Character, Boolean> map = new HashMap<>();
        int[] start = new int[256];
        Arrays.fill(start, -1);
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), true);
            charMap[t.charAt(i)]++;
        }
        int minlen = Integer.MAX_VALUE;
        int cnt = t.length();
        String res = "";
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null){
                continue;
            }else{
                System.out.println("1");
                charMap[s.charAt(i)]--;
                cnt--;
            }

            if(cnt == 0){
                while(map.get(s.charAt(j)) == null){
                    j++;
                }
                if(i-j+1 < minlen){
                    System.out.println("2: "+s.substring(j, i+1));
                    minlen = i-j+1;
                    res = s.substring(j, i+1);
                }
                while(j < i){
                    if(charMap[s.charAt(j)] == 0){
                        if(i-j+1 < minlen){
                            minlen = i-j+1;
                            res = s.substring(j, i+1);
                            System.out.println("res: " + res);
                        }
                        charMap[s.charAt(j)]++;
                        cnt++;
                        j++;
                        break;
                    }else if(charMap[s.charAt(j)] < 0){
                        charMap[s.charAt(j)]++;
                    }
                    j++;
                }
            }
        }
        return res;
    }

}
