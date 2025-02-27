class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int n = arr.size(), maxLength = 0;
        unordered_map<int, int> indexMap;
        vector<vector<int>> dp(n, vector<int>(n,2));

        for(int i = 0; i < n; i++){
            indexMap[arr[i]] =i;
            for(int j = 0; j < i; j++){
                int prevValue = arr[i] - arr[j];
                if (indexMap.count(prevValue) && indexMap[prevValue] < j){
                    dp[j][i] = dp[indexMap[prevValue]][j] + 1;
                    maxLength = max(maxLength, dp[j][i]);
                }
            }
        }
        return maxLength > 2 ? maxLength : 0;
    }
};