
    public static void mergeSort(int[]arr, int low, int high){
        if(low >= high)
            return;
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        //Merge
        int[] tmp = new int[high - low + 1];
        int j = mid + 1, idx = 0;
        for (int i=low; i<=mid; i++){
            while(j <= high && arr[j] < arr[i])
                tmp[idx++] = arr[j++];
            tmp[idx++] = arr[i];
        }
        System.arraycopy(tmp, 0, arr, low, j - low);
    }

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
