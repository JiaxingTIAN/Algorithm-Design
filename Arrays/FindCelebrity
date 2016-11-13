#Find Celebrith
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do 
is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the 
celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int 
findCelebrity(n), your function should minimize the number of calls to knows.

**ALG**

The first pass is to pick out the candidate. If candidate knows i, then switch candidate. 
if cand knows i, cand cannot be celeb but i can be celeb
if cand dont know i, i cannot be celeb, cand can be celeb

The second pass is to check whether the candidate is real.
If candidate knows anyone other than himself, or
any other people dont know candidate return -1

```java
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <= 0)
            return -1;
        int candidate = 0;
        for(int i=1; i<n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i=0; i<n; i++){
            if((i!=candidate && knows(candidate, i)) || !knows(i, candidate))
                return -1;
        }
        return candidate;
    }
}
```
  
