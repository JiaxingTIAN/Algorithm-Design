public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        //Count the characters
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            odd += (map.get(c)%2 == 1)? 1:-1;
        }
        //Return empty if odd character is larger then 1
        if(odd > 1)
            return res;
            
        String mid = "";    //Character in the middle
        List<Character> list = new ArrayList<>();   //List of character for permutation
        for(char key : map.keySet()){
            int val = map.get(key);
            if(val%2 != 0)
                mid += key;
            for(int i=0; i<val/2; i++)
                list.add(key);  //build the list
        }
        findPermutation(res, list, new StringBuilder(), mid, new boolean[list.size()]);
        return res;
    }
    
    public void findPermutation(List<String> res, List<Character> list, StringBuilder sb, String mid, boolean[] used){
        if(sb.length() == list.size()){
            String tmp = sb.toString() + mid + sb.reverse().toString();
            res.add(tmp);
            sb.reverse();   //Dont forget to reverse back
            return;
        }
        for(int i=0; i<list.size(); i++){
            if(used[i])
                continue;
            if(i > 0 && !used[i-1] && list.get(i) == list.get(i-1))
                continue;
            sb.append(list.get(i)); used[i] = true;
            findPermutation(res, list, sb, mid, used);
            sb.deleteCharAt(sb.length()-1); used[i] = false;
        }
    }
}
