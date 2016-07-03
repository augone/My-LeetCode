// The following is a brilliant method for solving this problem;
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null||intervals.length<1)
            return 0;
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for(int i = 0 ; i < intervals.length; i++)
        {
            startTime[i] = intervals[i].start;
            endTime[i] = intervals[i].end;
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int roomNum = 0;
        int endIndex = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            if(startTime[i] < endTime[endIndex])
                roomNum++;
            else
                endIndex++;
                
        }
        return roomNum;
    }
}
/*To understand why it works, first let’s define two events: Meeting Starts Meeting Ends

 Next, we acknowledge three facts: The numbers of the intervals give chronological orders 
When an ending event occurs, there must be a starting event has happened before that, 
where “happen before” is defined by the chronological orders given by the intervals Meetings 
that started which haven’t ended yet have to be put into different meeting rooms, and the number 
of rooms needed is the number of such meetings

So, what this algorithm works as follows:

for example, we have meetings that span along time as follows:

|_____|
      |______|
|________|
        |_______|

Then, the start time array and end time array after sorting appear like follows:

||    ||
     |   |   |  |

Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, 
we’ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (
we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, 
we’ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that 
it points to the next end event. What happens here can be thought of as one of the two previous meetings ended
, and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this 
time and move both of the pointers forward. Next, because endsItr moves to the next end event, we’ll find that 
the start event pointed by i happens before the end event pointed by endsItr. Thus, now we have 4 meetings 
started but only one ended, so we need one more room. And it goes on as this.
 */

/* import java.util.*;
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
class Solution{
	public static void main(String[] args )
	{
		
		Interval[] intervals = {new Interval(2,5),
		new Interval(3,14),
		new Interval(12,17),
		new Interval(4,11),
		};
		sop(minMeetingRooms(intervals));

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static int minMeetingRooms(Interval[] intervals) {
        if(intervals == null||intervals.length<1)
            return 0;
        List<Interval> list = new ArrayList<Interval>();
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        for(int i = 0 ; i < intervals.length; i++)
        {
            list.add(intervals[i]);
        }
        int lastEnd = Integer.MIN_VALUE;
        boolean meetingLeft = true;
        int roomNum = 1;
        while(meetingLeft)
        {
            boolean add = true;
			meetingLeft = false;
            for(int i = 0 ; i < intervals.length; i++)
            {
                
                if(intervals[i] == null)
                    continue;
                sop("lastEnd:"+lastEnd);
                if(intervals[i].start >= lastEnd)
                {
                    lastEnd = intervals[i].end;
					sop("lastEnd:"+lastEnd);
                    intervals[i] = null;
                }
                else
                {
                    meetingLeft = true;
                    sop("what the hell");
                    if(add)
                    {
                        add = false;
                        roomNum++;
                    }
                }
            }
			sop("");
			for(Interval i : intervals)
			{
				if(i != null)
				{
					System.out.print("  start:"+i.start+"  end:"+i.end);
				}
			}
			sop("");
			sop("roomNum:"+roomNum);
			//
            lastEnd = Integer.MIN_VALUE;
			sop(meetingLeft);
        }
        return roomNum;
            
    }
	
}
 */