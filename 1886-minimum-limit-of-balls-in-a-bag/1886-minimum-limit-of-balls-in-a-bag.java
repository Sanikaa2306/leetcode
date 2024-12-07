class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                result = mid; // Mid is a feasible penalty
                right = mid - 1; // Try for a smaller penalty
            } else {
                left = mid + 1; // Increase penalty
            }
        }

        return result;
    }

    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / penalty; // Calculate splits needed for this bag
            if (operations > maxOperations) {
                return false; // Exceeded allowed operations
            }
        }
        return true;
    }
}
