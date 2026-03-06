import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class postOffice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("postOffice".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            double sum = 0.4;
            for(String s : ln){
                sum+=Double.parseDouble(s);
            }
            System.out.println(sum<5?"OK" : "OVERWEIGHT");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new postOffice().run();
    }
}
