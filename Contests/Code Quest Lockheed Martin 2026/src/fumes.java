import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class fumes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("fumes".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        double[][] gallons = new double[3][3];
        String[] gals = "28,35,20|22,28,15|18,22,12".split("\\|");
        for (int i = 0; i < 3; i++) {
            String[] g = gals[i].split(",");
            for (int j = 0; j < 3; j++) {
                gallons[i][j] = Double.parseDouble(g[j]);
            }
        }
        for(int times = 0; times < numTimes; times++){
            int cylinders = f.nextInt();
            cylinders = (cylinders-4)/2;
            double gas = f.nextDouble();
            int gasCapacity = f.nextInt();
            int segments = f.nextInt();
            for (int i = 0; i < segments; i++) {
                char type = f.next().charAt(0);
                int length = f.nextInt();
                int index = switch(type){
                    case 'C' -> 0;
                    case 'H' -> 1;
                    case 'O' -> 2;
                    default -> -1;
                };
                double baseMpg = gallons[cylinders][index];
                double effectiveMpg = baseMpg - (.25 * (gasCapacity - gas));
//                System.out.println(length/effectiveMpg);
                gas-=length/effectiveMpg;
            }
//            System.out.println(gas);
            if(gas <= 0){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fumes().run();
    }
}
