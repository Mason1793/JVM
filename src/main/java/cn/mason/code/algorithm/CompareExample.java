package cn.mason.code.algorithm;
import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 快速排序
 * @Author zz
 * @Date
 **/
public class CompareExample  {
    public static void main(String[] args){
    }

    public void quickSort(Comparable[] nums,int low,int high){
        if(low>=high)return;
        int j=partition(nums,low,high);
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }

    public int partition(Comparable[] nums,int low,int high){
        int i=low,j=high+1;
        Comparable v=nums[low];
        while (true){
            while (less(nums[++i],v))if(i==high)break;
            while (less(v,nums[--j]))if(j==low)break;
            if(i>=j)break;
            swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }

    public void swap(Comparable[] nums,int i,int j){
        Comparable temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public boolean less(Comparable a,Comparable b){
        return (a.compareTo(b) == 1?false:true);
    }
}

class MyData implements Comparable<MyData>{
    int pos;
    int money;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int compareTo(MyData o) {
        if(this.money>o.money){
            return 1;
        }else {
            return -1;
        }
    }
}
