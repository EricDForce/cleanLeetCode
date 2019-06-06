import java.util.Scanner;

public class didi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        String[] strList = sc.nextLine().split(" ");
        int result = Integer.parseInt(strList[0]);
        for (int i=1; i<strList.length; i++){
            result = Math.max(result+Integer.parseInt(strList[i]), Integer.parseInt(strList[i]));
            max = Math.max(max, result);
        }
        max = Math.max(max, result);
        System.out.println(max);
    }
}
