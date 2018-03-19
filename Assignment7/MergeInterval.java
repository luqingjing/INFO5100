package Assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {

            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> result = new ArrayList<Interval>();

        for (int i = 0, j = 0; i < n; i++) {

            if (i == n - 1 || starts[i + 1] > ends[i]) {

                result.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return result;
    }
}

class Interval {

    int start;
    int end;
    Interval(int s, int e) {

        this.start = s;
        this.end = e;
    }
}