import java.util.Scanner;

public class pinduoduo2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[] matrix = new String[m];
        int startx = 0, starty = 0;
        int endx = 0, endy = 0;

        for (int i=0;i<m;i++){
            matrix[i] = sc.next();
            for (int j=0;j<n;j++){
                if (matrix[i].charAt(j)=='2'){
                    startx = i;
                    starty = j;
                }
                if (matrix[i].charAt(j)=='3'){
                    endx = i;
                    endy = j;
                }
            }
        }
        char[][] str2char = new char[matrix.length][matrix[0].length()];
        for (int i=0;i<matrix.length;i++){
            str2char[i] = matrix[i].toCharArray();
        }
    }
}
