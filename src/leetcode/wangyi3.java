import java.util.Scanner;

public class wangyi3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getUglyNumber2(n));
    }
    public static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = Math.min(Math.min(pUglyNumbers[p2] * 2, pUglyNumbers[p3] * 3), pUglyNumbers[p5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pUglyNumbers[p2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (pUglyNumbers[p3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (pUglyNumbers[p5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return pUglyNumbers[nextUglyIndex - 1];
    }
}
