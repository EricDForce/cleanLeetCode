/**
 * Created by eric-d on 16/9/3.
 */
import java.util.*;
public class leetcode4 {
//    public class Interval {
//             int start;
//             int end;
////             Interval() { start = 0; end = 0; }
//             Interval(int s, int e) { start = s; end = e; }
//         }
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();

        if(intervals.size()==0)
            return result;
        else if(intervals.size()==1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)
                {
                    return o1.end-o2.end;
                }else{
                    return o1.start-o2.start;
                }
            }
        });

        Interval pre = intervals.get(0);

        for (int i=0;i<intervals.size();i++)   //采用双指针的方法进行遍历
        {
            Interval cur = intervals.get(i);
            if(cur.start>pre.end)
            {
                result.add(pre);
                pre = cur;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
                pre = merged;
            }
        }

        result.add(pre);
        return result;

    }

    public static void main(String[] args)
    {
        List<Interval> test = new ArrayList<Interval>();
//        System.out.println("OK1");
        leetcode4 t = new leetcode4();
        test.add(new Interval(1,3));
        test.add(new Interval(1,3));
//        System.out.println("OK2");
//        System.out.println(test);
        List<Interval> result = t.merge(test);

        for (int i=0;i<result.size();i++)
            System.out.println(result.get(i).start + "," + result.get(i).end);
    }
}
