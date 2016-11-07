#Cut Cake
> A string end connect to start, cut the string so that each cut has the same pattern, output maximum number of cut

Example:
```
ababcababcababc
ouput 3 for ababc ababc ababc
```
**ALG**

try for every cut cake.substring(0, i) for i=1 to cake.length()
recursive check for the rest of the string
Time complexity O(n^2)

```java
    public int cutCake(String cake){
        int n = cake.length();
        int i=1;
        for(; i<=n; i++){
            if(cutCake(cake, cake.substring(0,i), i))
                break;
        }
        return n/i;
    }
    public boolean cutCake(String cake, String cut, int i){
        if(i == cake.length())
            return true;
        int idx = cake.indexOf(cut, i);
        if(idx != i)
            return false;
        return cutCake(cake, cut, i+cut.length());
    }
```
