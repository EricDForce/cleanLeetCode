import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric-d on 2017/2/8.
 */
public class Surrounded {
    public class Pairs{
        int x;
        int y;
        boolean visited = false;
        public Pairs(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
//        boolean[][] flag = new boolean[2][2];
//        System.out.println(flag[0][0]);
        char[][] board = new char[3][3];
        String[] test = {"OOO","OOO","OOO"};
        for (int i=0;i<test.length;i++){
            board[i] = test[i].toCharArray();
        }
        new Surrounded().solve(board);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void solve(char[][] board){
        int rows = board.length;
        if (rows <= 0){
            return ;
        }
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        if (board[0][0] == 'O')
        {
            board[0][0] = 'D';
        }

        for (int i=1;i<rows;i++){
            bfs(board, i, 0, visited);
            bfs(board, i, cols-1, visited);
        }

        for (int j=1;j<cols;j++){
            bfs(board, 0, j, visited);
            bfs(board, rows-1, j, visited);
        }

        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols;j++){
                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'D')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int x, int y)      //递归栈深，大数据集栈溢出
    {
        if (x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y] != 'O')
            return ;

        board[x][y] = 'D';
        dfs(board, x-1, y);
        dfs(board, x+1, y);
        dfs(board, x, y-1);
        dfs(board, x, y+1);
    }

    public void bfs(char[][] board, int x, int y, boolean[][] visited)      //采用队列存储连通的"O"的坐标
    {
        Queue<Pairs> queue = new LinkedList<>();
        if (board[x][y] == 'O')
        {
            queue.offer(new Pairs(x, y));
        }

        while (!queue.isEmpty()){
            Pairs current = queue.poll();
            int tmpx = current.x;
            int tmpy = current.y;
            if (tmpx<0 || tmpx>=board.length || tmpy<0 || tmpy>=board[0].length || board[tmpx][tmpy] != 'O' || visited[tmpx][tmpy])
                continue ;

            board[tmpx][tmpy] = 'D';
            visited[tmpx][tmpy] = true;
            queue.offer(new Pairs(current.x-1, current.y));
            queue.offer(new Pairs(current.x+1, current.y));
            queue.offer(new Pairs(current.x, current.y-1));
            queue.offer(new Pairs(current.x, current.y+1));
        }
    }
}
