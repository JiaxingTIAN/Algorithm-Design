public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] ans = new String[k];
        //Dont forget about k == 0
        if(words == null || words.length == 0 || k == 0){
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }
        // Comparator to compare class Word
        Comparator<Word> cmp = new Comparator<Word>(){
            public int compare(Word w1, Word w2){
                if(w1.count != w2.count)
                    return w1.count - w2.count;
                //If the word count is equal order by alphbet order
                return w2.word.compareTo(w1.word);
            }
        };
        //Min Heap to with comarator and size k
        Queue<Word> heap = new PriorityQueue<>(k, cmp);
        
        for(String word:map.keySet()){
            Word newWord = new Word(word, map.get(word));
            if(heap.size() < k){
                heap.offer(newWord);
            //Use comparator to compare the two word
            }else if(cmp.compare(newWord, heap.peek()) > 0){
                heap.poll();
                heap.offer(newWord);
            }
        }
        
        for(int i=k-1; i>=0; i--){
            ans[i] = heap.poll().word;
        }
        return ans;
    }
    
    class Word{
        String word;
        int count;
        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}
