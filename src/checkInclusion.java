import java.util.Arrays;

/**
 * Created by eric-d on 2017/4/30.
 */
public class checkInclusion {
    public static void main(String[] args) {
        String t1 = "1234";
        System.out.println(Integer.valueOf(t1));
        System.out.println(new checkInclusion().checkInclusion2("hello", "ooolleoooleh"));
        System.out.println(new checkInclusion().checkInclusion3("ccc", "cbac"));
    }

    public boolean checkInclusion2(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        char[] t1 = s1.toCharArray();
        Arrays.sort(t1);
        String t = String.valueOf(t1);

        for(int i=0;i<l2;i++){
            if((i+l1)>l2)
                break;
            char[] t2 = s2.substring(i, i+l1).toCharArray();
            Arrays.sort(t2);
            String tmp =  String.valueOf(t2);
            if(tmp.equals(t)){
                System.out.println("tmp: " + tmp);
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusion3(String s1, String s2){
        int[] charMap = new int[256];
        int[] start = new int[256];
        Arrays.fill(charMap, -1);
        int l1 = s1.length(), l2 = s2.length();
        for(int i=0;i<l1;i++){
            if(charMap[s1.charAt(i)]==-1)
                charMap[s1.charAt(i)]=1;
            else
                charMap[s1.charAt(i)]++;
        }
        int i=0,j=0, cnt = l1;
        int[] charcopy = new int[256];
        System.arraycopy(charMap, 0, charcopy, 0, 256);
        while(i <= l2-l1){
            j = i;
            while(j < l2){
                if(cnt == 0){
                    return true;
                }
                if(charcopy[s2.charAt(j)]==-1){
                    i = j + 1;
                    System.arraycopy(charMap, 0, charcopy, 0, 256);
                    Arrays.fill(start, -1);
                    cnt = l1;
                    break;
                }else if(charcopy[s2.charAt(j)]==0){
                    i = start[s2.charAt(j)]+1;
                    Arrays.fill(start, -1);
                    System.arraycopy(charMap, 0, charcopy, 0, 256);
                    cnt = l1;
                    break;
                }else{
                    if(start[s2.charAt(j)]==-1){
                        start[s2.charAt(j)] = j;
                    }
                    charcopy[s2.charAt(j)]--;
                    cnt--;
                }
                j++;
            }
        }
        return false;
    }
}
