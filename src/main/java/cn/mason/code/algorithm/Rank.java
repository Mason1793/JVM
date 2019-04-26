package cn.mason.code.algorithm;
/**
 * 二分查找
 * @Author zz
 * @Date
 **/
public class Rank {
    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7,8,9,10};
//        System.out.print(new Rank().rank(nums,0));
        int i=4,j=5;

    }

    public int rank(int[] nums,int target){
        int lo=0,hi=nums.length-1;
        while (lo<=hi){
            int mid=lo+(hi - lo)/2;
            if(target > nums[mid]){
                lo = mid+1;
            }else if(target < nums[mid]){
                hi = mid-1;
            }else {
                return mid;
            }
        }
        return 0;
    }


}
