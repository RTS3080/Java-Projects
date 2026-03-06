import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class botan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("botan".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        for(int abcd = 1;abcd<=times;abcd++){
            System.out.print("Case #"+abcd+": ");
            String n = f.nextLine().trim();


//                System.out.println(substrings);

            boolean allPrime = isBotanPrime(n);
            System.out.println(allPrime?"BOTAN-PRIME":"NOT BOTAN-PRIME");
        }
        f.close();
    }

    public boolean isBotanPrime(String n){
        if(n.length()==1){
            BigInteger a = new BigInteger(n);
            if(a.isProbablePrime(100)){
                return true;
            }
            return false;
        }

        Set<String> substrings = new TreeSet<>();
        for (int i = 0; i <= n.length(); i++) {
            for (int j = i + 1; j <= n.length(); j++) {
                substrings.add(n.substring(i, j));
            }
        }
        substrings.remove(n);
        boolean prime = true;
        for (String s : substrings) {
            prime &= isBotanPrime(s);
        }
        return prime;
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new botan().run();
    }
}
