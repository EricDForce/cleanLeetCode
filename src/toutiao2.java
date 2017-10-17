import java.util.Scanner;

public class toutiao2{

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), x = sc.nextInt();

    int[] room = new int[n];

    for (int i = 0; i < n; i++) room[i] = sc.nextInt();

    x--;
    int c = 0;
    while (room[x] > 0) {
        room[x] -= 1;
        x--;
        c++;
        if (x < 0) x = n - 1;
    }

    room[x] += c;
    for (int i = 0; i < n - 1; i++)
        System.out.print(room[i]+ " ");
    System.out.println(room[n - 1]);
    }
}

