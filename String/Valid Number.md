# Valid Number

Validate if a given string is numeric.
```
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
```
* Ask for clearification of the problem, + - . e and space 
```java
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean dot = false;    //Has dot appeared in the string
        boolean e = false;  
        boolean num = false;
        boolean nume = true;    //Number after e
        for(int i = 0; i < s.length(); i++){
            char d = s.charAt(i);
            if(d >= '0' && d <= '9'){
                num = true;
                nume = true;
            }else if(d == '.'){
                if(dot || e)
                    return false;
                dot = true;
            }else if(d == 'e'){
                if(e || !num)
                    return false;
                e = true;
                nume = false;
            }else if(d == '+' || d == '-'){
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }else
                return false;
        }
        return num && nume;
    }
}
```
