import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class theHumanTrapezoid{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("theHumanTrapezoid".toLowerCase()+".in"));
        long times=f.nextLong();
        while(times-->0) {
            BigDecimal bottom=BigDecimal.valueOf(f.nextLong());
            BigDecimal top=BigDecimal.valueOf(f.nextLong());
            BigDecimal players = BigDecimal.valueOf(f.nextLong());
            BigDecimal x=bottom.add(top);
//            System.out.println(bottom +" "+top);
//            System.out.println(x);
            BigDecimal n = bottom.subtract(top).add(BigDecimal.ONE);
            x = x.multiply(n);
//            System.out.println(n+" "+x);
            x = x.divide(BigDecimal.valueOf(2));
            x = x.subtract(players);
            if(x.compareTo(BigDecimal.ZERO)<0){
                System.out.println(0);
            }
            else {
                System.out.println(x);
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new theHumanTrapezoid().run();
    }
}
