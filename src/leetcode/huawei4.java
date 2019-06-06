import java.util.Scanner;

public class huawei4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] nums = new int[1];
        if (judge(input, nums)){
            if (nums[0]==10){
                System.out.println(input+"-X");
            }else{
                System.out.println(input+"-"+String.valueOf(nums[0]));
            }
        }else{
            System.out.println("ERROR");
        }
    }
    public static boolean judge(String str, int[] num){
        int len = str.length();
        if (len != 11){
            return false;
        }
        if (str.charAt(1) != '-' || str.charAt(5) != '-')
            return false;

        String[] strsplit = str.split("-");
        if (strsplit.length != 3)
            return false;
        if (strsplit[0].length() != 1 || strsplit[1].length()!=3 || strsplit[2].length() != 5)
            return false;
        String result = strsplit[0]+strsplit[1]+strsplit[2];
        int t = 0;
        for (int i=0; i < result.length(); i++){
            if (!Character.isDigit(result.charAt(i))){
                return false;
            }else{
                t += Integer.valueOf(result.charAt(i)+"")*(i+1);
            }
        }
        num[0] = t % 11;
        return true;
    }
}
