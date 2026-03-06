import java.util.*;
import java.io.*;
public class dryRun{
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int x = scan.nextInt();
        scan.nextLine();
        for(;x>0;x--){
            System.out.println(scan.nextLine()+ " hates Disney.");
        }
    }
}
