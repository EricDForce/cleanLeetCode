import java.util.*;

public class Main2 {
    class point{
        public int x=0;
        public int y=0;
    }
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        point[] points = new point[n];
        for (int i=0; i<n; i++){
            points[i] = new Main2().new point();
            points[i].x = sc.nextInt();
            points[i].y = sc.nextInt();
        }
        Arrays.sort(points, new Comparator<Main2.point>() {
            @Override
            public int compare(Main2.point o1, Main2.point o2) {
                return o1.x-o2.x;
            }
        });
        int maxy = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--){
            if (points[i].y > maxy){
                maxy = points[i].y;
            }else continue;
            System.out.println(points[i].x + " " + points[i].y);
        }
    }
}
