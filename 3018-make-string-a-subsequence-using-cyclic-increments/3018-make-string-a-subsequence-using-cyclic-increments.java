class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // If str2 is longer than str1, it's impossible for str2 to be a subsequence of str1
        if (str2.length() > str1.length()) {
            return false;
        }

        int i = 0; // Pointer for str1
        int j = 0; // Pointer for str2

        while (i < str1.length() && j < str2.length()) {
            // If the characters match directly
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            } 
            // Check if the character in str1 can be incremented cyclically to match the character in str2
            else if ((str1.charAt(i) - 'a' + 1) % 26 + 'a' == str2.charAt(j)) {
                j++;
            }
            i++;
        }

        // If we've matched all characters in str2, return true
        return j == str2.length();
    }
}
