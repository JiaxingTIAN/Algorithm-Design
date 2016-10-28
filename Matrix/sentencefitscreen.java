public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length();   //pad the sentence with space
        int start = 0;  //start is the start index for row in the repeating sentence
        //Find the start index of the rows + 1 row => the total length of fitting sentences
        //Divide by sentence length is the total fitting sentence
        for(int i = 0; i < rows; i++){
            start += cols;
            if(s.charAt(start%len) == ' '){
                start++;
            }else{
                while(start > 0 && s.charAt((start-1)%len) != ' ')
                    start--;
            }
        }
        return start/len;
    }
}
