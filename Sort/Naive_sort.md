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

# Insertion Sort

* Worst Case/Average Case: O(n^2)
* Best Case: O(n)

```java
public void insertionSort(int[]data){
    int n = data.length;
    int insert;
    for(int i=1; i<n; i++){
        insert = data[i];
        for(int j = i; j > 0 && data[j-1] > insert; j--)
            data[j] = data[j-1];
        data[j] = insert
    }
}
            
