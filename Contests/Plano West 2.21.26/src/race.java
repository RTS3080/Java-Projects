import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class race{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("race".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        int maxInd = -1;
        int maxVal = -1;
        for(int i = 1; i<=times;i++){
            int speed = f.nextInt();
            int agility = f.nextInt();
            int stamina = f.nextInt();
            int total = speed + agility + stamina;
            if(total > maxVal){
                maxVal = total;
                maxInd = i;
            }
            int above50 = 0;
            if(speed >=50){
                above50++;
            }
            if(agility >= 50){
                above50++;
            }
            if(stamina >= 50){
                above50++;
            }
            if(speed >= 80 && agility >= 70 && stamina >= 60){
                System.out.println("Champion");
            } else if (speed >= 70 && agility >= 60 && stamina >= 50) {
                System.out.println("Runner-Up");
            }
            else if(above50>=2){
                System.out.println("Average");
            }
            else{
                System.out.println("Beginner");
            }
        }
        System.out.println(maxInd);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new race().run();
    }
}
