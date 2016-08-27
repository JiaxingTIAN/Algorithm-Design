public int longestPath(String s){
		
		int n = s.length();
		if(n==0) return 0;
		Stack<String> stack = new Stack<>();
		
		String[] str = s.split("\n");
		int len  = 0, maxLen = 0;
		for(int i=0;i<str.length;){
			String cur = str[i];
			//Count the number of spaces
			int space  = 0;
			for(int j=0;j<cur.length();j++){
				if(cur.charAt(j)==' ')
					space++;
				else
					break;
			}
			String file = cur.substring(space);
			if(space == stack.size()){
				if(file.contains("jpeg")||file.contains("png")||file.contains("gif")){
					stack.push(file);
					len += file.length()+1;
					maxLen = Math.max(len, maxLen);
					//Output 
					if(len==maxLen){
						for(String f:stack)
							System.out.print("\\" + f);
						System.out.println();
					}
				}else{
					len += file.length()+1;
					stack.push(file);
				}
				i++;
			}else if(space<stack.size()){
				while(space<stack.size()){
					String tmp = stack.pop();
					len -= tmp.length() - 1;
				}
			}
		}
		return maxLen;
	}
