import java.util.LinkedList;
import java.util.Scanner;

public class toutiao {

    private static int sx, sy, ex, ey, bx, by;

    static class Pos {

        public Pos(int px, int py, int bx, int by) {
            // TODO Auto-generated constructor stub
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
        }

        int px;
        int py;
        int bx;
        int by;
    }

    private static int bfs(char[][] data) {

        int N = data.length;
        int M = data[0].length;

        int[] moveX = { 1, -1, 0, 0 };
        int[] moveY = { 0, 0, 1, -1 };
        int[][][][] history = new int[50][50][50][50];

        LinkedList<Pos> queue = new LinkedList<>();
        Pos pos = new Pos(sx, sy, bx, by);
        queue.add(pos);
        history[pos.px][pos.py][pos.bx][pos.by] = 1;

        while (queue.size() > 0) {
            Pos ePos = queue.poll();
            if (ePos.bx == ex && ePos.by == ey)
                return history[ePos.px][ePos.py][ePos.bx][ePos.by] - 1;
            for (int i = 0; i < 4; i++) {
                int nx = ePos.px + moveX[i];
                int ny = ePos.py + moveY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || data[nx][ny] == '#')
                    continue;

                if (nx == ePos.bx && ny == ePos.by) {

                    int nbx = nx + moveX[i];
                    int nby = ny + moveY[i];

                    if (nbx < 0 || nbx >= N || nby < 0 || nby >= M || data[nbx][nby] == '#'
                            || history[nx][ny][nbx][nby] != 0)
                        continue;
                    Pos e = new Pos(nx, ny, nbx, nby);
                    history[nx][ny][nbx][nby] = history[ePos.px][ePos.py][ePos.bx][ePos.by] + 1;
                    queue.add(e);

                } else {
                    if (history[nx][ny][ePos.bx][ePos.by] != 0)
                        continue;
                    Pos e = new Pos(nx, ny, ePos.bx, ePos.by);
                    history[nx][ny][ePos.bx][ePos.by] = history[ePos.px][ePos.py][ePos.bx][ePos.by] + 1;
                    queue.add(e);
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] data = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            data[i] = str.toCharArray();
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (data[i][j] == 'O') {
                    bx = i;
                    by = j;
                } else if (data[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        System.out.println(bfs(data));
    }
}