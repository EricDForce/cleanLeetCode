/**
 * Created by eric-d on 2017/4/9.
 */
public class ValidNumber {
    public static void main(String[] args) {
        String str = "2e10";
        System.out.println(new ValidNumber().isNumber(str));
    }

    public boolean isNumber(String s) {   //遍历一遍，复杂度是O(n)

        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if ((i < n) && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean numeric = false;
        int cnt = 0;
        while ((i < n) && (Character.isDigit(s.charAt(i)))) {
            i++;
            cnt++;
            numeric = true;
        }
        if ((i < n) && s.charAt(i) == '.') {
            i++;
            while ((i < n) && (Character.isDigit(s.charAt(i)))) {
                i++;
                cnt++;
                numeric = true;
            }
        }
        int count = 0;
        boolean flag = false;
        if (numeric && (i < n) && s.charAt(i) == 'e') {
            i++;
            numeric = false;
            flag = true;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while ((i < n) && Character.isDigit(s.charAt(i))) {
                i++;
                count++;
                numeric = true;
            }
        }
        while ((i < n) && (Character.isWhitespace(s.charAt(i)))) {
            i++;
            numeric = true;
        }
        return numeric && (i == n) && (cnt != 0) && ((flag && count != 0) || (!flag));
    }
}
