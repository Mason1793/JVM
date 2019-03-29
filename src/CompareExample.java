
/**
 * 快速排序
 * @Author zz
 * @Date
 **/
public class CompareExample  {
    public static void main(String[] args){
        MyData[] myDatas=new MyData[5];
        MyData d1=new MyData();
        MyData d2=new MyData();
        MyData d3=new MyData();
        MyData d4=new MyData();
        MyData d5=new MyData();
        d1.setMoney(5);
        d1.setPos(1);

        d2.setPos(2);
        d2.setMoney(1);

        d3.setPos(3);
        d3.setMoney(7);

        d4.setPos(4);
        d4.setMoney(9);

        d5.setPos(5);
        d5.setMoney(-30);

        myDatas[0]=d1;
        myDatas[1]=d2;
        myDatas[2]=d3;
        myDatas[3]=d4;
        myDatas[4]=d5;

        new CompareExample().quickSort(myDatas,0,4);


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
