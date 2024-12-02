class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words using space as a delimiter
        String[] words = sentence.split(" ");
        int searchLen = searchWord.length();
        
        // Iterate through the words
        for (int i = 0; i < words.length; i++) {
            // Check if the current word is at least as long as the searchWord
            if (words[i].length() >= searchLen) {
                // Compare characters one by one
                boolean isPrefix = true;
                for (int j = 0; j < searchLen; j++) {
                    if (words[i].charAt(j) != searchWord.charAt(j)) {
                        isPrefix = false;
                        break;
                    }
                }
                // If it is a prefix, return the 1-indexed position
                if (isPrefix) {
                    return i + 1;
                }
            }
        }
        
        // If no word matches, return -1
        return -1;
    }
}
