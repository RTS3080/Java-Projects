import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class mathabet{

    public class N implements  Comparable<N>{
        String name;
        BigInteger n ;
        public N(String name ){
            this.name = name;
            n = convert(name);
        }
        public String toString(){
            return this.name;
        }
        public BigInteger convert(String name){
            BigInteger num;
            String str ="";
            String[] ar = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
            Map<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < ar.length; i++) {
                hm.put(ar[i], i+1);
            }
            for (int i = 0; i < name.length(); i++) {
                str+=hm.get(name.substring(i,i+1));
            }
            num = new BigInteger(str);
            return num;
        }
        @Override
        public int compareTo(N o) {
            if(this.n.isProbablePrime(10) && !o.n.isProbablePrime(10)){
                return 1;
            } else if ( !this.n.isProbablePrime(10) && o.n.isProbablePrime(10)) {
                return -1;
            }
            else {
                if(this.n.mod(new BigInteger("2")).equals(new BigInteger("0")) && !o.n.mod(new BigInteger("2")).equals(new BigInteger("0"))){
                    return 1;
                } else if (!this.n.mod(new BigInteger("2")).equals(new BigInteger("0")) && o.n.mod(new BigInteger("2")).equals(new BigInteger("0"))) {
                    return -1;
                }
                else {
                    if (this.n.compareTo(o.n) < 0) {return -1;}
                    else if (this.n.compareTo(o.n)>0) {return 1;}
                    else if (this.n.compareTo(o.n)==0) {return 0;}
                }
            }

            return 0;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mathabet".toLowerCase()+".dat"));
        int t = f.nextInt();
        f.nextLine();
        ArrayList<N> al = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            al.add(new N(f.nextLine()));

        }
        Collections.sort(al);
        for (N n : al) {
            System.out.println(n.name);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mathabet().run();
    }
}
