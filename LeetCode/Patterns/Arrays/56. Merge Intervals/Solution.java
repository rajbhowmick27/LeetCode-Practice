class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
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