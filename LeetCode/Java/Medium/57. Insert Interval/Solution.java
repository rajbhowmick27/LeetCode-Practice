class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        
        // Iterate through all slots
        for(int[] slot : intervals)
        {
            
            // if newInterval before slot insert newInterval & update slot as new interval
            if(newInterval[1] < slot[0])
            {
                result.add(newInterval);
                newInterval = slot;
            } 
            
            // if slot is lesser than new Interval insert slot
            else if(slot[1] < newInterval[0])
            {
                result.add(slot);
            } 
            
            // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }
        
        // insert the last newInterval
        result.add(newInterval);
        
        // convert to int[][] array
        return result.toArray(new int[result.size()][]);


        // int[][] input = Arrays.copyOf(intervals, intervals.length + 1);
        // input[input.length - 1] = newInterval;

        // Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));

        // List<int[]> res = new ArrayList<>();

        // int[] curInterval = input[0];
        // res.add(curInterval);

        // for(int i=1;i<input.length;i++){
        //     int currentEnd = curInterval[1];
        //     int nextStart = input[i][0];
        //     int nextEnd = input[i][1];
            
        //     if(currentEnd >= nextStart){
        //         curInterval[1] = Math.max(currentEnd,nextEnd);
        //     } else {
        //         curInterval = input[i];
        //         res.add(curInterval);
        //     }
        // }
        
        // return res.toArray(new int[res.size()][]);
    }
}