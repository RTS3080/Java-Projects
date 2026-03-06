import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class blackhole{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        BigInteger startFuel = f.nextBigInteger();
        BigInteger startDistance = f.nextBigInteger(); f.nextLine();
        String good = null;
        timeloop:
        while(f.hasNext()){
            BigInteger fuel = new BigInteger(startFuel.toString());
            BigInteger distance = new BigInteger(startDistance.toString());
            String c = f.next().trim();
            String plan = f.nextLine().trim();
            boolean cool = true;
            for (int i = 0; i < plan.length(); i+=3) {
                for (int j = i; j < i+3 && j<plan.length(); j++) {
                    if(plan.charAt(j) == 'r'){
                        fuel = fuel.add(BigInteger.valueOf(3));
                    }
                    else{
                        fuel = fuel.subtract(new BigInteger(plan.substring(j,j+1)).multiply(BigInteger.valueOf(2)));
                        distance =distance.add(new BigInteger(plan.substring(j,j+1)));
                    }
                    distance = distance.subtract(BigInteger.valueOf(4));
                }
                if(distance.compareTo(BigInteger.ZERO)<0 || fuel.compareTo(BigInteger.ZERO)<0){
                    cool = false;
                }
            }
            if(cool) good = c;
        }
        System.out.println(good!=null?good:"none");

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new blackhole().run();
    }
}
