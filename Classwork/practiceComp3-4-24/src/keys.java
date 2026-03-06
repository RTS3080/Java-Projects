import java.util.*;
import java.io.*;

public class keys{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("keys".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double percent=100.0/f.nextDouble();
            System.out.printf("%.2f%%\n",percent);
        }
        f.close();
    }
}
