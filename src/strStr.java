/**
 * Created by eric-d on 2017/4/8.
 */
public class strStr {
    public int strstr(String haystack, String needle){
        if(needle.length() > haystack.length()){
            return -1;
        }

        int i=needle.length(), j=haystack.length();
        for (int t=0;t<j;t++){
            if ((t+i)>j)
                break;
            if (haystack.substring(t, t+i).equals(needle))
                return t;
        }
        return -1;
    }
}
