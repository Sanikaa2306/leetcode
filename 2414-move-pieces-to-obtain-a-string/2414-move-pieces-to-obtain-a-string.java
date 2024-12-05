class Solution {
    public boolean canChange(String start, String target) {
        // Remove all '_' characters and check if the sequences of 'L' and 'R' match
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        // Iterate through both strings
        while (i < n && j < n) {
            // Skip '_' in start
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            // Skip '_' in target
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // If both indices reach the end, break the loop
            if (i == n && j == n) {
                break;
            }

            // If one index reaches the end but the other does not, return false
            if (i == n || j == n) {
                return false;
            }

            // If the characters don't match, return false
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // Check movement constraints
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            // Move to the next character
            i++;
            j++;
        }

        return true;
    }
}