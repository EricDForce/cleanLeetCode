import java.util.Scanner;

/**
 * Created by eric-d on 2017/5/13.
 */
public class firstProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

//        char[][] array = new char[H][W];

        String[] array = new String[H];
        for (int i=0;i<H;i++){
            array[i] = sc.next();
        }
        String[] output = new String[H];
        for (int i=0;i<H;i++){
            output[i] = array[i];
            for (int j=0;j<B-1;j++){
                output[i] += array[i];
            }
        }

        for (int i=0;i<A;i++){
            for (int j=0;j<H;j++){
                System.out.println(output[j]);
            }
        }
    }
}
