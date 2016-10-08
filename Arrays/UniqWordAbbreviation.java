public class ValidWordAbbr {
    Map<String, Set<String>> map;    //Store the abbreviation and word set
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String str:dictionary){
            
            String sb = abbreviation(str);
            map.putIfAbsent(sb, new HashSet<String>());
            map.get(sb).add(str);
        }
    }

    public boolean isUnique(String word) {
        if(word == null){
            return false;
        }
        
        String str = abbreviation(word);
        
        if(!map.containsKey(str)){
            return true;
        }
        
        if(map.get(str).contains(word) && map.get(str).size() == 1){
            return true;
        }
        
        return false;
    }
    
    public String abbreviation(String str){
        int count = str.length() - 2;
        StringBuilder sb = new StringBuilder();
            
        if(count <= 0){
            return str;
        }
        else{
            sb.append(str.charAt(0)).append(count).append(str.charAt(str.length()-1));
        }
        
        return sb.toString();
    }
}
// Optimization with space complexity
public class ValidWordAbbr {
    //Store the abbrevation and only word pair, since two or more words will invalid each other
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();  
        for(String word:dictionary){
            String abbr = getAbbr(word);
            if(!map.containsKey(abbr)){
                //If only word, put it into the map
                map.put(abbr, word);    
            }else if(!map.get(abbr).equals(word)){
                //If already have another word exist in the map, invalid by make ""
                map.put(abbr, "");
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    
    public String getAbbr(String str){
        if(str.length() <= 2){
            return str;
        }
        return str.charAt(0) + String.valueOf(str.length() - 2) + str.charAt(str.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
