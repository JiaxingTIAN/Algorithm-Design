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
