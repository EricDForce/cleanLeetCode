import java.util.*;

public class huawei2 {
    public static Map<String, String> result = new HashMap<>();
    public static Set<String> set = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> InDegree = new HashMap<>();
        while (true){
            String tmp = sc.next();
            String[] tmpList = tmp.split("\\{|\\}|\\,\\ ");
            set.add(tmpList[1]);
            set.add(tmpList[2]);
            if (!InDegree.containsKey(tmpList[1])){
                InDegree.put(tmpList[1], 0);
            }
            if (!InDegree.containsKey(tmpList[2])){
                InDegree.put(tmpList[2], 1);
            }else {
                InDegree.put(tmpList[2], InDegree.get(tmpList[2]) + 1);
            }
            if (map.containsKey(tmpList[1])){
                map.get(tmpList[1]).add(tmpList[2]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(tmpList[2]);
                map.put(tmpList[1], list);
            }
            if (tmp.charAt(tmp.length()-1)!=',')
                break;
        }
        new huawei2().topoSort(map, InDegree);
        for (String res : result.keySet()){
            System.out.println("{"+res+", " + result.get(res) + "}");
        }
        for (String str : InDegree.keySet()){
            System.out.println("str : " + InDegree.get(str));
        }
    }
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
    public void depthSearch(Map<String, List<String>> map, Set<String> visited, String cur, Set<String> set){
        if (!map.containsKey(cur)){
            return ;
        }
        for (String iter : map.get(cur)){
            if (visited.contains(cur)){
                continue;
            }else {
                visited.add(iter) ;
                set.add(iter);
                depthSearch(map, visited, iter, set);
            }
        }
    }
    public void nonrecurdepthSearch(Map<String, List<String>> map, Set<String> visited, String cur, List<String> result){
        Stack<String> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()){
            String tmp = stack.peek();
            if (!visited.contains(tmp)){
                result.add(tmp);
                visited.add(tmp);
            }
            if (map.containsKey(tmp)){
                for (String iter : map.get(tmp)){
                    if (!visited.contains(iter)){
                        stack.push(iter);
                    }
                }
            }else{
                stack.pop();
            }
        }
    }
    public void breadSearch(Map<String, List<String>> map, Set<String> visited, String cur, List<String> result){
        Queue<String> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()){
            String t = queue.poll();
            if (map.containsKey(t)){
                for (String str : map.get(t)){
                    if (!visited.contains(str)){
                        result.add(str);
                        queue.offer(str);
                    }
                }
            }
        }
    }
}
