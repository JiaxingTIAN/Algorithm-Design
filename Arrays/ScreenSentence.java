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
