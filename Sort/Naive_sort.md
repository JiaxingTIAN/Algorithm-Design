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
```

# Merge Sort

* Average Case: O(nlogn)

```java
public void mergeSort(int[]data, int lo, int hi){
    if(lo >= hi)
        return;
    int mid = (lo + hi)/2;
    mergeSort(data, lo, mid);
    mergeSort(data, mid+1, hi);
    merge(data, lo, hi);
}
public void merge(int[]data, int lo, int mid, int hi){
    int l = lo, r = mid + 1;
    int idx = 0;
    int[] tmp = new int[l - r + 1];
    while(l <= mid && r <= hi){
        if(data[l] < data[r])
            tmp[idx++] = data[l++];
        else
            tmp[idx++] = data[r++];
    }
    
    while(l <= mid)
        tmp[idx++] = data[l++];
    while(r <= hi)
        tmp[idx++] = data[r++];
    
    System.arraycopy(tmp, 0, data, lo, hi - lo + 1);
}
```

# QuickSort

* Average Case: O(nlogn)

```java
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
```
