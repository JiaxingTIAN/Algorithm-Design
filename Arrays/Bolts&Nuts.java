public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null||bolts == null) return;
        if(nuts.length!=bolts.length) return;
        
        quickSort(nuts, bolts, compare, 0, nuts.length-1);
    }
    
    public void quickSort(String[] nuts, String[] bolts, NBComparator compare, int lo, int hi){
        if(lo >= hi) return;
        int idx = partition(nuts, lo, hi, compare, bolts[hi]);
        partition(bolts, lo, hi, compare, nuts[idx]);
        //Partition the rest of the array
        quickSort(nuts, bolts, compare, lo, idx-1);
        quickSort(nuts, bolts, compare, idx+1, hi);
    }
    
    public int partition(String[]str, int lo, int hi, NBComparator compare, String pivot){
        int l = lo, h = hi;
        //Put the pivot to the end
        for(int i=l;i<h;i++){
            if(compare.cmp(str[i], pivot)==0
            ||compare.cmp(pivot, str[i])==0){
                swap(str, i, h);
                break;
            }
        }
        //Partitioning 
        while(l < h){
            if(compare.cmp(str[l], pivot)==1
            ||compare.cmp(pivot,str[l])==-1){
                swap(str, l--, --h);
            }
            l++;
        }
        swap(str, l, hi);
        return l;
    }
    
    public void swap(String[] str, int i, int j){
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
};
