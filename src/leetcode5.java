import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by eric-d on 16/9/6.
 */
public class leetcode5 {

    public static void main(String[] args)
    {
        List<Interval> test = new ArrayList<Interval>();
        Interval newInter = new Interval(5, 7);
        List<Interval> result = new leetcode5().insert(test, newInter);
        System.out.println(result.get(0).start + "," + result.get(0).end);
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0)
        {
            intervals.add(newInterval);
            return intervals;
        }

        ListIterator<Interval> it = intervals.listIterator();

        while (it.hasNext())
        {
            Interval tmpInterval = it.next();

            if (newInterval.end < tmpInterval.start)
            {
                it.previous();
                it.add(newInterval);
                return intervals;
            }else{
                if (tmpInterval.end < newInterval.start)
                {
                    continue;
                }else{
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);
                    newInterval.end = Math.max(tmpInterval.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
