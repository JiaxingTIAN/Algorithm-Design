//1.3
public class Solution{
	public String replaceSpaces(String string, int trueLength){
		int count = 0;
		char[] str = string.toCharArray();
		//Count the number of spaces in the character array within true length
		for(int i=0;i<trueLength;i++){
			if(str[i]==' ')
				count++;
		}
		int idx = trueLength + count*2;
		if(idx < str.length) str[idx]='\0'; //Extra buffer End of array
		//Start from end of array, avoid over write
		for(int i = trueLength-1;i>=0;i--){
			if(str[i]==' '){
				str[--idx] = '0';
				str[--idx] = '2';
				str[--idx] = '%';
			}else{
				str[--idx] = str[i];
			}
		}
		return new String(str);
	}
}
