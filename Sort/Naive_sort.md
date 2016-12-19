# Selection Sort

* Worst Case/Best Case: O(n^2)
* Space: O(n)
```java
public void selectionSort(int[]data){
    int idx;
    int n = data.length;
    for(int i = n-1; i > 0; i--){
        idx = 0;
        for(int j = 0; j <= i; j--){
            if(data[j] > data[idx])
                idx = j;
        swap(data, idx, i);
    }
}
```
