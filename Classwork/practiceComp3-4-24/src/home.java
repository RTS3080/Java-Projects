import java.util.*;
import java.io.*;

public class home{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("home".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            f.nextLine();
            String[] ln=f.nextLine().split(" ");
            for (int i = 0; i < ln.length; i++) {
                if(ln[i].equals("right")){
                    ln[i]="left";
                }
                else{
                    ln[i]="right";
                }
            }
            for(String s:ln){
                System.out.print(s+" ");
            }
            System.out.println();
        }
        f.close();
    }
}
