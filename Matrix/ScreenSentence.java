public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        if (n == 0) {
            return 0;
        }
        int[] len = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            len[i] = sentence[i].length() + 1;
            if (len[i] > cols + 1) {
                return 0;
            }
            sum += len[i];
        }
        int answer = 0;
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            int remain = cols + 1;
            answer += remain / sum;
            remain %= sum;
            while (remain >= len[cur]) {
                remain -= len[cur++];
                if (cur == n) {
                    cur = 0;
                    answer++;
                }
            }
        }
        return answer;
    }
}


public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // repeat sentence->hello world hello world hello world hello world
        // Find the start location for each row => start from a word
        // Find the rows + 1 start location and that is acutally the reachable length
        String s = String.join(" ", sentence) + " ";
        int len = s.length();
        int start = 0;
        for(int i=0; i<rows; i++){
            start += cols;
            if(s.charAt(start%len) == ' ')
                start++;    //white space increase to next word
            else{
                while(start > 0 && s.charAt((start-1)%len) != ' ')
                    start--;
            }
        }//Reach start of rows + 1 => actual fitting length
        return start/len;
    }
}
