/**
 * Created by eric-d on 2017/4/8.
 */
public class atoi {
    public static void main(String[] args){
        System.out.println("max : " + Integer.MAX_VALUE);
        System.out.println("min : " + Integer.MIN_VALUE);
        System.out.println(new atoi().myAtoi("2147483648"));
    }
    public int myAtoi(String str) {
        int i=0, n=str.length();
        int numDiv10 = Integer.MAX_VALUE/10;
        while (i<n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i<n && str.charAt(i)=='+'){
            i++;
        }else if (i<n && str.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        int num = 0;
        while (i<n && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            if (num >numDiv10 || num==numDiv10 && digit>=8){      //  &&优先级高于||
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10+digit;
            i++;
        }
        return num*sign;
    }
}
