package Assignment7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalTest {

    @Test
    void merge() {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(6,8));

        MergeInterval mi = new MergeInterval();
        List<Interval> result = mi.merge(intervals);

        List<Interval> expect = new ArrayList<>();
        expect.add(new Interval(1,4));
        expect.add(new Interval(5,8));

        for (int i = 0;i < result.size();i++){
            assertEquals(expect.get(i).start,result.get(i).start);
            assertEquals(expect.get(i).end,result.get(i).end);
        }
    }
}