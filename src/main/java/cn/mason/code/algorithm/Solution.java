package cn.mason.code.algorithm;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Array;
import java.util.*;

/**
  @Author zz
  @Date
 **/


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}

public class Solution {
    public static void main(String[] args){
//        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
//        for(ThreadInfo threadInfo:threadInfos){
//            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
//        }
            System.out.println(UUID.randomUUID());
//        int[][] arr = {{1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
//
//        int A[]={8,5,1,7,10,12};
//
//        System.out.print(new Solution().bstFromPreorder(A));
    }
    public int findTilt(TreeNode root) {
        int ans=0;
        return search(root.left)+search(root.right);
    }

    public int search(TreeNode root){
        if(root ==null)return 0;
        if(root.left!=null && root.right!=null){
            return Math.abs(root.right.val-root.left.val);
        }
        return root.val;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            fun(preorder[i],root);
        }
        return root;
    }

    public TreeNode fun(int v,TreeNode root){
        if(root == null){
            TreeNode node=new TreeNode(v);
            return node;
        }
        if(root.val > v) {
            root.left=fun(v,root.left);
        } else if(root.val<v){
            root.right=fun(v,root.right);
        }
        return root;
    }

//    public int[] sortedSquares(int[] A) {
//        int mid=0;//mid是第一个正数
//        while (mid<A.length && A[mid]<0 ){
//            mid++;
//        }
//        int[] ans=new int[A.length];
//        int i=mid,j=mid-1;
//        int k=0;
//        while (i<A.length && j>=0){
//            if((A[i]A[i])>(A[j]A[j])){
//                ans[k]=A[j]A[j];
//                j--;
//            }else {
//                ans[k]=A[i]A[i];
//                i++;
//            }
//            k++;
//        }
//
//        while (i<A.length){
//            ans[k++]=A[i]A[i++];
//        }
//
//        while (j>=0){
//            ans[k++]=A[j]A[j--];
//        }
//        return  ans;
//    }
//
//
//    public void sortedSquaresQuick(int[] A,int lo,int hi){
//        if(lo>=hi)return;
//        int index= partition(A,lo,hi);
//        sortedSquaresQuick(A,lo,index-1);
//        sortedSquaresQuick(A,index+1,hi);
//    }
//
//    public int partition(int[] A,int lo,int hi){
//        int i=lo,j=hi+1;
//        int v=Math.abs(A[lo]);
//        while (true){
//            while (Math.abs(A[++i])<v)if(i==hi)break;
//            while (v<Math.abs(A[--j]))if(j==lo)break;
//            if(i>=j)break;
//            int temp=A[i];
//            A[i]=A[j];
//            A[j]=temp;
//        }
//        int temp=A[lo];
//        A[lo]=A[j];
//        A[j]=temp;
//        return j;
//    }
//
//
//    public int numJewelsInStones(String J, String S) {
//        int ans=0;
//        if(S.length() == 0)return 0;
//        for(int i=0;i<J.length();i++){
//            char val=J.charAt(i);
//            for(int j=0;j<S.length();j++){
//                if(val == S.charAt(j)){
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix==null || matrix.length==0 ||matrix[0].length==0)return false;
//        int row=matrix.length-1;
//        int col=0;
//        int n=matrix[0].length;
//        while (row >=0 && col<n){
//            if(matrix[row][col]<target){
//                col++;
//            }else if(matrix[row][col]>target){
//                row--;
//            }else {
//                return true;
//            }
//        }
//        return false;
//
//    }
//
//    public boolean search(int[] nums, int target){
//        int i=0,j=nums.length-1;
//        while (i<=j){
//            //int mid=i+(j-i)/2;
//            int mid=(i+j)/2;
//            //if(mid >=nums.length || mid <0)return false;
//            if(nums[mid] >target){
//                j=mid-1;
//            }else if(nums[mid]< target){
//                i=mid+1;
//            }else {
//                return true;
//            }
//        }
//        return false;
//    }






}
