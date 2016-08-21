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

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList();
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return res;
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<Sum> heap = new PriorityQueue(new Comparator<Sum>(){
          public int compare(Sum s1, Sum s2){
            return s1.sum - s2.sum;
          }
        });
        for(int i=0;i<m;i++)
            heap.offer(new Sum(0,i,nums1[0]+nums2[i]));
        for(int i=0;i<Math.min(k,m*n);i++){
            Sum s = heap.poll();
            res.add(new int[]{nums1[s.x], nums2[s.y]});
            if(s.x<n-1){
                heap.offer(new Sum(s.x+1, s.y, nums1[s.x+1]+nums2[s.y]));
            }
        }
        return res;
    }
    class Sum{
        int x;
        int y;
        int sum;
        public Sum(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    
}
