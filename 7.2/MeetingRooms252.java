/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null||intervals.length<2)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return b.start - a.start;
            }
        });
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].end>intervals[i-1].start)
                return false;
        }
        return true;
    }
}