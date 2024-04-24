class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
      //Sort the array based on the start time.
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    } 
}