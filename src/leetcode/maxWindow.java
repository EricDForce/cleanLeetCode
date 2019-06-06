import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class maxWindow {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(1);
        System.out.println(maxInWindows(list, 3));
    }
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();
        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<>();
        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //  添加索引
            idx.addLast(i);
        }
        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));       //idx.getFirst保存窗口中最大的值的下标
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }
            // 可能的最大的下标索引入队
            idx.addLast(i);
        }
        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));
        return windowMax;
    }
    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}
