import java.util.*;
public class sort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("input array: ");
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        int i = 0;
        for(String n:s){
            nums[i++] = Integer.valueOf(n);
        }
        if(args[0].equals("1")){
            System.out.println("MergeSort: ");
            mergeSort(nums, 0, nums.length - 1);
        }else{
            System.out.println("QuickSort: ");
            quickSort(nums, 0, nums.length - 1);
        }
        for(int n:nums){
            System.out.print(n);
        }
        System.out.println();
    }
    
    public static void mergeSort(int[]nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int mid = lo + (hi - lo)/2;
        //Continue divide into half
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        //Merge
        int idx = 0, j = mid + 1;
        int[] tmp = new int[hi - lo + 1];
        for(int i=lo; i<=mid; i++){
            //If the upper half is larger than i put them in the front
            while(j <= hi && nums[j] < nums[i])
                tmp[idx++] = nums[j++];
            tmp[idx++] = nums[i];   //Then put i int the tmp
        }
        System.arraycopy(tmp, 0, nums, lo, j - lo);
    }
    
    public static void quickSort(int[]nums, int lo, int hi){
        if(lo >= hi)
            return;
        int l = lo, r = hi;
        int pivot = nums[hi];
        while(l < r){
            if(nums[l++] > pivot)
                swap(nums, --l, --r);
        }
        swap(nums, hi, r);
        quickSort(nums, lo, l-1);
        quickSort(nums, l+1, hi);
    }
    
    public static void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
