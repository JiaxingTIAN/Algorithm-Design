public class Solution {
//Time Complexity O(N) - O(nlogn) - O(n^2)
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        char[] ch = s.toCharArray();
        return divideAndConquer(ch, 0, s.length()-1, k);
    }
    public int divideAndConquer(char[] ch, int start, int end, int k){
        if(start > end)  return 0;
        if(end - start + 1 < k)    return 0;   //substring length smaller than k
        int[]count = new int[26];   //count the character
        for(int i=start; i<=end; i++){
            count[ch[i] - 'a']++;
        }
        for(int i=start; i<=end; i++){
            if(count[ch[i] - 'a'] == 0)   continue;   //skip if not exit
            if(count[ch[i] - 'a'] < k){   //repeating smaller than k
                //divide into left and right half character cannot be included
                return Math.max(divideAndConquer(ch, start, i-1, k), divideAndConquer(ch, i+1, end, k));
            }
        }
        //Here means no character smaller than k
        return end - start + 1;
    }
}
