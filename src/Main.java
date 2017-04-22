import java.util.*;

/**
 * Created by eric-d on 2017/4/22.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][n];
        List<Integer> res = new Main().spiralOrder(matrix, m);
        System.out.print(res.get(0)+" "+res.get(1));
    }

    public List<Integer> spiralOrder(int[][] matrix, int m) {
        List<Integer> res = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int right_max = matrix[0].length - 1;
        int left_min = 0;
        int up_max = 1;
        int down_max = matrix.length - 1;
        int cnt = 1;

        String flag = "right";

        while (true) {

            while (flag.equals("right")) {
                if (cnt == m) {
                    res.add(i + 1);
                    res.add(j + 1);
                }
                cnt++;
                if (j >= matrix[0].length) {
                    flag = "exit";
                    break;
                }
                if (j == right_max) {
                    if (i == down_max) {
                        flag = "exit";
                        break;
                    }
                    right_max = right_max - 1;
                    flag = "down";
                }
            }

            while (flag.equals("down")) {
                if (cnt == m) {
                    res.add(i + 1);
                    res.add(j + 1);
                }
                cnt++;
                if (i >= matrix.length) {
                    flag = "exit";
                    break;
                }
                if (i == down_max) {
                    if (j == left_min) {
                        flag = "exit";
                        break;
                    }
                    down_max = down_max - 1;
                    flag = "left";
                }
            }

            while (flag.equals("left")) {
                if (cnt == m) {
                    res.add(i + 1);
                    res.add(j + 1);
                }
                cnt++;
                if (j == left_min) {
                    if (i == up_max) {
                        flag = "exit";
                        break;
                    }
                    left_min = left_min + 1;
                    flag = "up";
                }
            }

            while (flag.equals("up")) {
                if (cnt == m) {
                    res.add(i + 1);
                    res.add(j + 1);
                }
                cnt++;
                if (i == up_max) {
                    if (j == right_max) {
                        flag = "exit";
                        break;
                    }
                    up_max = up_max + 1;
                    flag = "right";
                }
            }

            if (flag.equals("exit")) {
                if (i >= matrix.length || j >= matrix[0].length) {
                    break;
                }
                break;
            }
        }
        if (res.size() == 0) {
            res.add(i + 1);
            res.add(j + 1);
        }
        return res;
    }
}
