class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        /* 
            Scenario A: Sorting by End Time ❌If we sort by end time, the order becomes: [2, 3], [4, 5], [1, 10].We start with [2, 3].We look at [4, 5]. Since 4 is greater than 3, we assume they don't overlap. We save [2, 3] and move on to [4, 5].We look at [1, 10]. It overlaps with [4, 5], so we merge them into [1, 10].The Failure: We already skipped and locked in [2, 3]. We completely missed the fact that [1, 10] was supposed to swallow [2, 3] as well.Your final result would incorrectly be: [2, 3], [1, 10]

            Scenario B: Sorting by Start TimeIf we sort by start time, the order becomes: [1, 10], [2, 3], [4, 5].We start with [1, 10].We look at [2, 3]. Since 2 is less than 10, it overlaps! We merge them: Math.max(10, 3) = 10. The current interval remains [1, 10].We look at [4, 5]. Since 4 is less than 10, it also overlaps! We merge them: Math.max(10, 5) = 10. The current interval remains [1, 10].Your final result is correctly: [1, 10].
         */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] curInterval = intervals[0];
        res.add(curInterval);

        for(int i=1;i<intervals.length;i++){
            int currentEnd = curInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            if(currentEnd >= nextStart){
                curInterval[1] = Math.max(currentEnd,nextEnd);
            } else {
                curInterval = intervals[i];
                res.add(curInterval);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}