import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        
        // TreeMap to store maximum values of events ending before a given time
        TreeMap<Integer, Integer> endTimeMap = new TreeMap<>();
        int maxSingleEvent = 0; // Tracks the maximum value of a single event
        int maxSum = 0; // Tracks the overall maximum sum of two events
        
        for (int[] event : events) {
            int startTime = event[0];
            int endTime = event[1];
            int value = event[2];
            
            // Find the maximum value of events that end before the current event's start time
            Integer previousEventEndTime = endTimeMap.floorKey(startTime - 1);
            int maxPreviousValue = (previousEventEndTime != null) ? endTimeMap.get(previousEventEndTime) : 0;
            
            // Update the maximum sum with the current event and the best non-overlapping event
            maxSum = Math.max(maxSum, maxPreviousValue + value);
            
            // Update the maximum value for a single event
            maxSingleEvent = Math.max(maxSingleEvent, value);
            
            // Update the TreeMap with the maximum value of events ending up to this point
            endTimeMap.put(endTime, Math.max(endTimeMap.getOrDefault(endTime, 0), maxSingleEvent));
        }
        
        return maxSum;
    }
}
