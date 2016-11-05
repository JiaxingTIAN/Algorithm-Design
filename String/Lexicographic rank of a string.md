#Lexicographic rank of a string
>Given a string, find its rank among all its permutations sorted lexicographically. For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6. 

For simplicity, let us assume that the string does not contain any duplicated characters.

One simple solution is to initialize rank as 1, generate all permutations in lexicographic order. After generating a permutation, check if the generated permutation is same as given string, if same, then return rank, if not, then increment the rank by 1. The time complexity of this solution will be exponential in worst case. Following is an efficient solution.

Let the given string be “STRING”. In the input string, ‘S’ is the first character. There are total 6 characters and 4 of them are smaller than ‘S’. So there can be 4 * 5! smaller strings where first character is smaller than ‘S’, like following
```
R X X X X X
I X X X X X
N X X X X X
G X X X X X
```
>Now let us Fix S’ and find the smaller strings staring with.
Repeat the same process for T, rank is 4*5! + 4*4! +…
Now fix T and repeat the same process for R, rank is 4*5! + 4*4! + 3*3! +…
Now fix R and repeat the same process for I, rank is 4*5! + 4*4! + 3*3! + 1*2! +…
Now fix I and repeat the same process for N, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! +…
Now fix N and repeat the same process for G, rank is 4*5! + 4*4 + 3*3! + 1*2! + 1*1! + 0*0!
Rank = 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0! = 597

