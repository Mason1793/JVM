package cn.mason.code.algorithm;
import java.util.Scanner;

/**
 * @Author zz
 * @Date
 **/
public class TestAllocation {
    private static final int _1MB=1024*1024;
    public static void quickSort(int[] nums,int low,int high){
        if(low>=high)return;
        int j=partition(nums,low,high);
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }

    public static int partition(int[] nums,int low,int high){
        int i=low,j=high+1;
        int v=nums[low];
        while (true){
            while (nums[++i]<v)if(i==high)break;
            while ((v<nums[--j]))if(j==low)break;
            if(i>=j)break;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        int temp=nums[low];
        nums[low]=nums[j];
        nums[j]=temp;
        return j;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        String str=in.next();

        int i=0,j=1;
        int cnt=str.length();
        char[] str1=str.toCharArray();
        while (i<j&&j<n){
            if((str1[i] == '0' && str1[j]=='1') || (str1[i] == '1' && str1[j]=='0')){
                str1[i]='2';
                str1[j]='2';
                cnt-=2;

                for(int k=0;k<n;k++){
                    if(str1[k]!='2'){
                        i=k;
                        for(int h=k+1;h<n;h++){
                            if(str1[h]!='2'){
                                j=h;
                                break;
                            }
                        }
                        break;
                    }
                }
            }else {
                i++;
                j++;
            }



        }

        System.out.println(cnt);
//        int m=in.nextInt();
//        int n=in.nextInt();
//        int[] price=new int[n];
//        int cnt=0;
//
//
//        for(int i=0;i<n;i++){
//            price[i] = in.nextInt();
//        }
//
//        quickSort(price,0,price.length-1);
//
//        //没有一块钱肯定无解
//        if(price[0]!=1){
//            System.out.println(-1);
//            return;
//        }
//
//        int left=m;
//        int pos=n-1;
//        while (price[pos]>=m){
//            pos--;
//        }
//        for(int i=pos;i>0;i--){
//
//            int temp=left%price[i];
//            if( temp == 0){
//                cnt+=left/price[i]-1;
//                temp=price[i];
//            }else {
//                cnt+=left/price[i];
//            }
//            left=temp;
//        }
//
//
//        System.out.println(cnt+left);


//        int i=n-1;
//        while (i>0 && left !=0){
//            if(left > price[i]){
//                left-=price[i];
//                cnt+=1;
//            }else {
//                i--;
//            }
//        }
//
//        System.out.println(cnt+left);
    }
}
