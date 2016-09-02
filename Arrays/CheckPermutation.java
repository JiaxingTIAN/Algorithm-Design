// Give two strings, write a method to decide if one is a permutation of the other
public class Solution {
  //Sort the character array and compare
	public boolean permutation(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String str1 = new String(c1);
		String str2 = new String(c2);
		return str1.equals(str2);
	}
	//using bucket to count the number of letters
	public boolean permutation2(String s1, String s2){
		if(s2.length()!=s2.length())
			return false;
		int[] bucket = new int[256];
		for(char c:s1.toCharArray()){
			bucket[c]++;
		}
		for(char c:s2.toCharArray()){
			bucket[c]--;
			if(bucket[c]<0)
				return false;
		}
		return true;
	}
}
