/**
 * Created by eric-d on 2017/4/8.
 */
public class RWS {
    public static void main(String[] args){
        String str = "the sky is blue";
        System.out.println(new RWS().reverseWords(str));
    }

    public String reverseWords(String s){
        StringBuilder reversed = new StringBuilder(); //经常改变的String,
        int j=s.length();                            //用StringBuilder比较快
        for (int i=s.length()-1;i>=0;i--) {
            if (Character.isWhitespace(s.charAt(i))) j = i;
            else if (i == 0 || Character.isWhitespace(s.charAt(i - 1))) {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
    public void ReverseWords(char[] s){
        int j=0;
        for (int i=0;i<s.length;i++){
            if (s[i] == ' ')
            {
                reverse(s, j, i-1);
                j=i+1;
            }
        }
        reverse(s, 0, s.length-1);
    }

    public void reverse(char[] s, int i, int j){
        while (i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
