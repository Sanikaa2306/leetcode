import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set of banned numbers for quick lookup
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        
        int count = 0;
        int currentSum = 0;

        // Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip the number if it is banned or adding it exceeds maxSum
            if (bannedSet.contains(i) || currentSum + i > maxSum) {
                continue;
            }
            
            // Add the number to the sum and increase the count
            currentSum += i;
            count++;
        }
        
        return count;
    }
}
