import java.util.Scanner;

public class aiqiyi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cnt = 0, count=0;
        for (int i=0; i<str.length(); i++){
            if (cnt<0) {
                count += Math.abs(cnt);
                cnt = 0;
            }
            if (str.charAt(i)=='(') cnt++;
            else cnt--;
        }
        count += (cnt > 0) ? cnt : 0;
        System.out.println(Math.abs(count));
    }
}
