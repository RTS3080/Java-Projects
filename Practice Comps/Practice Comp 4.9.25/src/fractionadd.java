import java.util.*;
import java.io.*;

public class fractionadd{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fractionadd".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+\\?\\s+");
            List<Long> a  = new ArrayList<>(), b = new ArrayList<>();
            long[] left = new long[]{0,1};
            long[] right = new long[]{0,1};
            String[] one = ln[0].split("\\s+\\+\\s+");
            String[] two = ln[1].split("\\s+\\+\\s+");
            for (int i = 0; i < one.length; i++) {
                String[] fact = one[i].split("\\s+/\\s+");
                a.add(Long.parseLong(fact[0]));
                left[1] *= Long.parseLong(fact[1]);
            }
            for (int i = 0; i < two.length; i++) {
                String[] fact = two[i].split("\\s+/\\s+");
                b.add(Long.parseLong(fact[0]));
                right[1] *= Long.parseLong(fact[1]);
            }
            for (int i = 0; i < a.size(); i++) {
                String[] fact = one[i].split("\\s+/\\s+");
                left[0] += a.get(i) * (left[1] / Long.parseLong(fact[1]));
            }
            for (int i = 0; i < b.size(); i++) {
                String[] fact = two[i].split("\\s+/\\s+");
                right[0] += b.get(i) * (right[1] / Long.parseLong(fact[1]));
            }
            long GCF = gcf(left[0], left[1]);
            left[0] /=GCF;
            left[1] /=GCF;
            GCF = gcf(right[0], right[1]);
            right[0] /=GCF;
            right[1] /=GCF;
            long num1 = left[0] * right[1];
            long num2 = right[0] * left[1];
            System.out.print(left[0]+"/"+left[1]);
            if(num1 == num2){
                System.out.print(" = ");
            }
            else if(num1 > num2){
                System.out.print(" > ");
            }
            else System.out.print(" < ");
            System.out.println(right[0] + "/" + right[1]);
        }

        f.close();
    }
//    public String reduce(double d){
//        double denom = Math.pow(10,d+"".length());
//        double num = d  * denom;
//    }
    public long gcf(long a, long b){
        if(b==0) return a;
        return gcf(b, a %b);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new fractionadd().run();
    }
}
