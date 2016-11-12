#Sorting Alg
* Merge Sort divide and conquer
```java
    public static void mergeSort(int[]arr, int low, int high){
        if(low >= high)
            return;
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        //Merge
        int[] tmp = new int[high - low + 1];    //A good solution is keep reuse same tmp array
        int j = mid + 1, idx = 0;
        for (int i=low; i<=mid; i++){
            while(j <= high && arr[j] < arr[i])
                tmp[idx++] = arr[j++];
            tmp[idx++] = arr[i];
        }
        System.arraycopy(tmp, 0, arr, low, j - low);
    }
```
* Long version

```java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        merge(A, start, mid, end, temp);
    }
    
    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = start;
        
        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }
}
```

* Quick Sort 
```java
    public static void quickSort(int[]arr, int low, int high){
        if(low >= high)
            return;
        int i = low, j = high;
        int pivot = arr[high];
        while (i < j){
            if(arr[i++] > pivot)
                swap(arr, --i, --j);
        }
        swap(arr, i, high);
        quickSort(arr, low, i-1);
        quickSort(arr, i+1, high);
    }

    public static void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
```
A long version
```java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
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
}
```
