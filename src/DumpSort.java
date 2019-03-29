/**
 * @Author zz
 * @Date
 **/
public class DumpSort {
    public static void main(String[] args){
        int a[]={4,6,8,5,9};

        new DumpSort().sort(a);
    }

    public void sort(int[] a){
        int N=a.length;
        for(int k=N/2-1;k>=0;k--)sink(a,k,N);

        for(int j=a.length-1;j>0;j--){
            int temp=a[0];
            a[0]=a[j];
            a[j]=temp;
            sink(a,0,j);
        }

    }

    public void sink(int[] a,int k,int n){
        while(2*k+1<n){
            int j = 2*k+1;
            if(j+1 < n && a[j]<a[j+1])j++;
            if(a[k] >= a[j])break;
            int temp=a[k];
            a[k]=a[j];
            a[j] = temp;
            k=j;
        }
    }
}
