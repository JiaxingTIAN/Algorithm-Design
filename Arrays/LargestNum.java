public class Solution {
	public int getMax(int num){
		String n = String.valueOf(num);
		int idx = 0;
		int pre = n.charAt(0)-'0';
		int cur, next;
		for(idx = 0;idx<n.length()-1;idx++){
			cur = n.charAt(idx) - '0';
			next = n.charAt(idx+1) - '0';
			if(cur>=pre&&cur>next) break;
			pre = cur;
		}
		return Integer.valueOf(n.substring(0, idx+1) + n.charAt(idx) + n.substring(idx+1));
	}
}
