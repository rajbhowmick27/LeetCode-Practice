class Pair {
    int start;
    int end;

    public Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendarTwo {

    private List<Pair> intervals;

    public MyCalendarTwo() {
        this.intervals = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for overlaps with existing bookings
        for(Pair p : intervals){
            int x = p.start, y = p.end;

            // Check if the new booking overlaps with the existing interval
            if(start < y && end > x){
                // Calculate the overlapping sub-interval
                int newStart = Math.max(x,start);
                int newEnd = Math.min(y,end);

                // Check if the sub-interval overlaps more than once
                if(check(newStart,newEnd)){
                    return false; // Overlapping more than once, booking fails
                }
            }
        }
        
        // If there are no conflicts, add the booking
        intervals.add(new Pair(start,end));
        return true; // Booking successful
    }

    // Check if the sub-interval overlaps more than once
    private boolean check(int start, int end) {
        int overlapCount = 0;

        for (Pair p : intervals) {
            int a = p.start, b = p.end;

            // Check for strict overlap
            if (start < b && end > a) {
                overlapCount++;
                if (overlapCount == 2) {
                    return true;  // Found more than one overlap
                }
            }
        }

        return false;  // No overlapping found
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */