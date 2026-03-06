import java.util.*;
import java.io.*;
import java.awt.*;

public class hanzo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hanzo".toLowerCase()+".in"));
        double tax= f.nextDouble()+1;
        int times=f.nextInt(); f.nextLine();
        System.out.println("|"+repeat("-",87)+"|");
        System.out.println("|"+repeat(" ",87)+"|");
        System.out.println("|  NAME"+repeat(" ",10)+"UNIT COST"+repeat(" ",10)+"INDIVIDUAL TAX"+repeat(" ",10)+"AMOUNT"+repeat(" ",10)+"TOTAL COST"+"  |");
        System.out.println("|"+repeat(" ",87)+"|");
        double total = 0;
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            String name="";
            for(int i=0;i<ln.length-3;i++){
                name+=ln[i]+" ";
            }
            name = name.trim();
            double cost = Double.parseDouble(ln[ln.length-3]);
            double ind = Double.parseDouble(ln[ln.length-2]);
            double amt = Double.parseDouble(ln[ln.length-1]);
            double tot = cost*amt*(ind+1);
            total+=tot;
//            tot*=tax;
            System.out.printf("|  %-12S  $%-16.2f  %-22s  %-14s  $%-9.2f  |\n", name, cost, (String.format("%.2f",((ind)*100))+"%"), Math.round(amt)+" UNITS", tot);
        }
        System.out.println("|"+repeat(" ",87)+"|");
        System.out.printf("|  SUBTOTAL: $%-74.2f|\n",total );
        System.out.printf("|  SALES TAX: %-74s|\n",String.format("%.2f",((tax-1)*100))+"%" );
        System.out.println("|"+repeat(" ",87)+"|");
        total*=tax;
        System.out.printf("|  TOTAL: $%-77.2f|\n",total );
        System.out.println("|"+repeat(" ",87)+"|");
        System.out.println("|  HATORI HANZO CANDIES"+repeat(" ", 65)+"|");
        System.out.println("|"+repeat("-",87)+"|");

        f.close();
    }
    String repeat(String s, int i){
        String str = "";
        for (int j = 0; j < i; j++) {
            str+=s;
        }
        return str;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hanzo().run();
    }
}
