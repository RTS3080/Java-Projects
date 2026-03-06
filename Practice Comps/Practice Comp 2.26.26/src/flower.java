import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class flower{
    class Flower{
        int x;
        int y;
        int roots;
        int above;
        public Flower(int x, int y, int roots, int above){
            this.x = x;
            this.y = y;
            this.roots = roots;
            this.above = above;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("flower".toLowerCase()+".in"));
        int numOk = 0;
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int numFlowers = f.nextInt();
            Flower[] flowers = new Flower[numFlowers];
            for (int i = 0; i < numFlowers; i++) {
                int roots = f.nextInt();
                int above = f.nextInt();
                int x = f.nextInt();
                int y = f.nextInt();
                flowers[i] = new Flower(x, y, roots, above);
            }
            boolean clean = true;
            for (int i = 0; i < numFlowers; i++) {
                for (int j = 0; j < numFlowers; j++) {
                    if(i==j) continue;
                    Flower a = flowers[i];
                    Flower b = flowers[j];
                    double dist = sqrt(pow(a.x-b.x,2) + pow(a.y-b.y,2));
                    double rootsDist = a.roots+b.roots;
                    double aboveDist = a.above+b.above;
                    if (dist < rootsDist || dist < aboveDist) {
                        clean = false;
                        break;
                    }
                }
            }
            if(clean){
                numOk++;
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        String binary = Integer.toString(numOk+'0', 2);
        while(binary.length()<8){
            binary = "0"+binary;
        }
        String flipped = "";
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i)=='1'){
                flipped +="0";
            }
            else{
                flipped +="1";
            }
        }
        int val = Integer.parseInt(flipped, 2);
        String out = Integer.toString(val, 16).toLowerCase();
        System.out.println(out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new flower().run();
    }
}
