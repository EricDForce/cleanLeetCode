/**
 * Created by eric-d on 2017/4/8.
 */
public class isPalindrome {

    public static void main(String[] args){
        String ts = "A man, a plan, a canal: Panama";
        System.out.println(new isPalindrome().ispalindrome(ts));
    }
    public boolean ispalindrome(String s){
        int i=0, j=s.length()-1;
        while (i<j){
            while (i<j && !Character.isLetterOrDigit(i)) i++;
            while (i<j && !Character.isLetterOrDigit(j)) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
