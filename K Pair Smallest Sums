public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
  List<int[]> result = new ArrayList();
  k = Math.min(k, nums1.length*nums.length);
  if(k==0) return result;
  int[] idx = new int[nums1.length];
  while(k-->0){
    int min = Integer.MAX_VALUE;
    int t = 0;
    for(int i=0;i<nums1.length;i++){
      if(idx[i]<nums.length&&nums1[i]+nums2[idx[i]]<min){
        t = i;
        min = nums1[i]+nums2[idx[i]];
      }
    }
    int[] arr = {nums1[t], nums2[idx[t]]);
    result.add(arr);
    idx[t]++;
    }
  return result;
}
