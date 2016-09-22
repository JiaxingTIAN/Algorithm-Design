// Bound of comparison sort: Merge sort, Quick sort, Heap Sort => O(nlogn)
// Counting Sort (bucket sort) => O(n + u) # u is the range of the numbers 1 to u (When u = n^2 useless)
// Radix sort => O(d*(n + b)) d: how many digits, n: arrary length, b: base
/*
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index 
  stores the sum of previous counts. 
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7
  
  output 
*/
public static void Countsort(char arr[])
    {
        int n = arr.length;
 
        // The output character array that will have sorted arr
        char output[] = new char[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }
