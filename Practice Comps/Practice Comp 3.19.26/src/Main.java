import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public boolean canAliceWin(int[] nums) {
        int sumOne = Arrays.stream(nums).filter(a -> a/10==0).sum();
        int sumTwo = Arrays.stream(nums).filter(a -> a/100==0 && a/10>0).sum();
        int sum = Arrays.stream(nums).sum();
        int sumNotOne = sum-sumOne;
        int sumNotTwo = sum-sumTwo;
        System.out.println(sumNotOne+" "+sumNotTwo);
        System.out.println(sumOne+" "+sumTwo);
        return (sumOne > sumNotOne || sumTwo > sumNotTwo);
    }
    
}