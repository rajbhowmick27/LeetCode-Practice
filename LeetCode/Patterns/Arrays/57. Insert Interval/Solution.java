class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] input = Arrays.copyOf(intervals, intervals.length + 1);
        input[input.length - 1] = newInterval;

        Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] curInterval = input[0];
        res.add(curInterval);

        for(int i=1;i<input.length;i++){
            int currentEnd = curInterval[1];
            int nextStart = input[i][0];
            int nextEnd = input[i][1];
            
            if(currentEnd >= nextStart){
                curInterval[1] = Math.max(currentEnd,nextEnd);
            } else {
                curInterval = input[i];
                res.add(curInterval);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}