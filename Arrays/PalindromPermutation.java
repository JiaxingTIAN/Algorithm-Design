public class Solution{
	public boolean palindromPermutation(String str){
		// Use bucket to count the number of appearance of each letter
		if(str==null||str.length()==0) return false;
		int[] letter = new int[26];
		char[] ch = str.toCharArray();
		for(char c:ch){
			if(c == ' ')	continue;
			letter[c-'a']++;
		}
		
		boolean odd = false;
		for(int i:letter){
			if(i%2==1){
				if(odd) return false;
				else	odd = true;
			}
		}
		return true;
	}
}
