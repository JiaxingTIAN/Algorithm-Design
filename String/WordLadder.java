public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord))
            return 1;
        if(wordList.size()==0)
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.remove(beginWord);
        int dis = 1;
        while(!queue.isEmpty()){
            dis++;
            int size = queue.size();
            for(int k=0; k<size; k++){
                String str = queue.poll();
                System.out.println(String.valueOf(str));
                for(int i=0; i<str.length(); i++){
                    char[] ch = str.toCharArray();
                    for(char c = 'a'; c<='z'; c++){
                        ch[i] = c;
                        String next = String.valueOf(ch);
                        System.out.print(next + " ");
                        if(next.equals(endWord))
                            return dis;
                        if(wordList.contains(next)){
                            queue.offer(next);
                            wordList.remove(next);
                        }
                    }
                }
            }
            System.out.println(wordList);
        }

        return 0;
    }
