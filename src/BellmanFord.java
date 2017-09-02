import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        int n=4,m=4,f=2;
        int[][] tt = {{1,2,5},{2,3,10},{3,4,20},{1,4,1}};
        int[][] tl = {{2, 65}, {3, 15}};
        int[] result = new BellmanFord().maxRestTime(n, m, tt,f, tl);
        for (int i : result){
            System.out.println(i);
        }
    }
    public int[] maxRestTime(int numCities, int numRoads,
                             int[][] travelTime, int numDeliveries, int[][] timeLimit)
    {
        int[] fromVertex, toVertex, weightVertex, dis, preNode;
        int Inf = 100000;
        //初始化数据
        fromVertex = new int[numRoads];
        toVertex = new int[numRoads];
        weightVertex = new int[numRoads];
        dis = new int[numCities];
        preNode = new int[numCities];

        for (int i = 0; i < numRoads; i++) {
            fromVertex[i] = travelTime[i][0];
            toVertex[i] = travelTime[i][1];
            weightVertex[i] = travelTime[i][2];;
        }
        //初始化dis
        dis[0] = 0;
        preNode[0] = 1;
        for (int i = 1; i < numCities; i++) {
            dis[i] = Inf;
        }

        boolean flag;
        //开始处理边，寻找最短路径
        //dis[i-1]存放的是从1开始到第i个节点的最短路径
        for (int k = 0; k < numCities - 1; k++) {
            flag = true;
            for (int i = 0; i < numRoads; i++) {
                if (dis[toVertex[i] - 1] > dis[fromVertex[i] - 1] + weightVertex[i]) {
                    dis[toVertex[i] - 1] = dis[fromVertex[i] - 1] + weightVertex[i];
                    //记录终点顶点的前一个顶点
                    //用于输出路径，目标顶点的前一个点到目标顶点一定最短
                    preNode[toVertex[i] - 1] = fromVertex[i];
                    flag = false;
                }
            }
            //如果没有更新过最短路径，表示最短路径寻找完毕。
            if (flag) {
                break;
            }
        }
        int[] result = new int[timeLimit.length];
        for (int i = 0; i < timeLimit.length; i++) {
            showPath(preNode, 1, timeLimit[i][0]);
            if (timeLimit[i][1] <= 2*dis[timeLimit[i][0]-1]){
                result[i] = 0;
            }else{
                result[i] = timeLimit[i][1] - 2*dis[timeLimit[i][0]-1];
            }
        }
        return result;
    }
    public static void showPath(int[] path, int from, int to) {
        int pre;
        if (from == to) {
            System.out.print(to + " ");
            return;
        }
        pre = path[to - 1];
        showPath(path, from, pre);
        System.out.print(" " + to + " ");
    }
}
