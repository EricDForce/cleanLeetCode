import java.util.*;

/**
 * Created by eric-d on 2017/7/2.
 */
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node){
        if (node == null) return null;
        if (map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode curr = q.poll();
            // 将curr旧节点的邻居节点都加入curr的新节点
            for(UndirectedGraphNode oldNeighbor : curr.neighbors){
                // 判断是否已经生成过该邻居节点的新节点
                if(!map.containsKey(oldNeighbor)){
                    // 如果是第一次生成该新节点，将其加入队列中
                    map.put(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                    q.offer(oldNeighbor);
                }
                // 将新邻居加入新curr节点的neighbors中
                map.get(curr).neighbors.add(map.get(oldNeighbor));
            }
        }
        return root;
    }
}
