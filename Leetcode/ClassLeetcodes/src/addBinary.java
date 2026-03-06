import java.math.BigInteger;

public class addBinary {
    public static void main(String[] args) throws Exception{
        new addBinary().run();
    }
    void run()throws Exception{
        BigInteger a = new BigInteger("1");
        System.out.println(a.shiftLeft(1));
        System.out.println(parse("101101"));
    }

    BigInteger parse(String s){
        BigInteger sum = BigInteger.ZERO;
        int p = 0;
        BigInteger one = BigInteger.ONE;
        while(p < s.length()){
            if(s.charAt(s.length()-p-1) == '1'){
                sum = sum.add(one.shiftLeft(p));
            }
            p++;
            System.out.println(sum+" "+p);
        }
        System.out.println(sum);
        return sum;
    }
}
//class Solution {
//    public String addBinary(String a, String b) {
//        BigInteger sum = parse(a).add(parse(b));
//        return sum.toString(2);
//
//    }
//    BigInteger parse(String s){
//        BigInteger sum = BigInteger.ZERO;
//        int p = 0;
//        while(p < s.length()){
//            if(s.charAt(s.length()-p-1) == '1'){
//                sum.add(BigInteger.ONE.shiftLeft(p));
//            }
//            p++;
//        }
//        return sum;
//    }
//}
