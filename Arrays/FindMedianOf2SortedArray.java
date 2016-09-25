public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if((n&1) == 1){   //odd length
            return findKthSmall(nums1, nums2, 0, 0, (n+1)>>1);
        }else{
            return (findKthSmall(nums1, nums2, 0, 0, n>>1) + findKthSmall(nums1, nums2, 0, 0, (n>>1)+1))/2.0;
        }
    }
    
    public int findKthSmall(int[]nums1, int[]nums2, int s1, int s2, int k){
        //reach the end of nums1
        if(s1 >= nums1.length){
            return nums2[s2 + k - 1];
        }
        if(s2 >= nums2.length){ //Reach the end of s2
            return nums1[s1 + k - 1];
        }
        if(k == 1){ //return the smaller of two
            return Math.min(nums1[s1], nums2[s2]);
        }
        int a1 = s1 + k/2 - 1 < nums1.length? nums1[s1+k/2-1]:Integer.MAX_VALUE;
        int a2 = s2 + k/2 - 1 < nums2.length? nums2[s2+k/2-1]:Integer.MAX_VALUE;
        if(a1 < a2){    //exclude the upper half of nums1
            return findKthSmall(nums1, nums2, s1 + k/2, s2, k-k/2);
        }else{  //exclude the upper half of nums2
            return findKthSmall(nums1, nums2, s1, s2 + k/2, k-k/2);
        }
    }
}
