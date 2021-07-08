import java.util.Date;

public class BitDance_SumOfMultiplesOf3And5_003 {
    private  long sum=0;
    public long sumOfMultiplesOf3And51(long s){
        for(int i=1;i<=s;i++)
        {
            if(i%3==0) sum+=i;
        }
        for(int j=1;j<=s;j++)
        {
            if(j%5==0) sum+=j;
        }
        for(int k=1;k<=s;k++)
        {
            if(k%15==0) sum-=k;
        }
        return sum;
    }

    public long sumOfMultiplesOf3And5(long s){
        long one = method(s, 3);
        long two = method(s, 5);
        long three = method(s, 15);
        return one+two-three;
    }
    public long method(long n, long m){
        long two = 0;
        if(n<m){
            two = 0;
        }else if(n<(2*m)){
            two = m;
        } else{
            long v1 = n/m;
            long v2 = n%m;
            long v3 = n-v2;
            two = ((m+v3)*v1)/2;
        }
        return two;
    }
    public static void main(String[] args) {
        BitDance_SumOfMultiplesOf3And5_003 mSum=new BitDance_SumOfMultiplesOf3And5_003();

        Date date1 = new Date();
        System.out.println("data="+date1+"-----");
        System.out.println(mSum.sumOfMultiplesOf3And51(1000));
        Date date2 = new Date();
        System.out.println("data="+date2+"-----");


        Date date3 = new Date();
        System.out.println("data="+date3+"-----");
        System.out.println(mSum.sumOfMultiplesOf3And5(1000));
        Date date4 = new Date();
        System.out.println("data="+date4+"-----");

    }

}
