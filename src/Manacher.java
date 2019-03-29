/**
 * @Author zz
 * @Date
 **/
public class Manacher {
    public String ManacherFun(String s){
        String str="$#";
        for(int i=0;i<s.length();i++){
            str+=s.charAt(i);
            str+="#";
        }
        int max=0;
        int id=0;
        int sum=0;
        int center=0;
        int[] len=new int[str.length()];
        for(int i=1;i<str.length();i++){
            len[i]=i<max?Math.min(len[2*id-i],max-i):1;

            while (i+len[i]<str.length() && i-len[i] >=0 && str.charAt(i+len[i])==str.charAt(i-len[i])){
                len[i]++;
            }
            if(len[i]+i>max){
                max=len[i]+i;
                id=i;
            }
            if(sum < len[i]){
                sum = len[i];
                center = i;
            }
        }
        return s.substring((center-sum)/2, (center-sum)/2+sum-1);
    }
    public static void main(String[] args){
        System.out.println(new Manacher().ManacherFun("babad"));
    }
}
