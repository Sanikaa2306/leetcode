class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set to 0 and continue loop to handle carry
            digits[i] = 0;
        }

        // If all digits were 9, we need a new array with an extra digit
        int[] result = new int[n + 1];
        result[0] = 1; // The rest default to 0
        return result;
    }
}
