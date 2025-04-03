import java.util.*;

class Solution {
    void getPerms(List<Integer> nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.size()) {
            ans.add(new ArrayList<>(nums)); // Add a deep copy of the list
            return;
        }

        Set<Integer> seen = new HashSet<>(); // Track elements at the current index level

        for (int i = idx; i < nums.size(); i++) {
            if (seen.contains(nums.get(i))) continue; // Skip duplicate swaps

            seen.add(nums.get(i)); // Mark this number as seen
            Collections.swap(nums, idx, i);
            getPerms(nums, idx + 1, ans);
            Collections.swap(nums, idx, i); // Backtrack
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) numList.add(num); 

        Collections.sort(numList); // Sort to handle duplicates easily
        getPerms(numList, 0, ans);
        return ans;
    }
}
