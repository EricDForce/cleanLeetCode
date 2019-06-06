import java.util.*;

public class topoSort_rewrite {
    public static Map<String, String> result = new HashMap<>();
    public static Set<String> set = new HashSet<>();


    /*
    map是图的邻接表示，inDegree是每个节点的入度
    * */
    public void topoSort(Map<String, List<String>> map, Map<String, Integer> inDegree) {
        int count = 0;    //判断是否所有的顶点都出队了, 若有顶点未入队(组成环的顶点)，则这些顶点肯定不会出队
        Queue<String> queue = new LinkedList<>();
        for (String str : inDegree.keySet()) {
            if (inDegree.get(str) == 0) {
                queue.offer(str);
            }
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            System.out.println("here : " + cur);
            result.put(cur, "false");
            count++;
            if (map.containsKey(cur)) {
                for (String item : map.get(cur)) {
                    inDegree.put(item, inDegree.get(item)-1);
                    if (inDegree.get(item) == 0) {
                        queue.offer(item);
                    }
                }
            }
        }
        if (count != set.size()) {
            for (String tt : set) {
                if (!result.keySet().contains(tt)) {
                    result.put(tt, "true");
                }
            }
        }
    }
}
