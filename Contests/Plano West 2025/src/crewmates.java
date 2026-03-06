import java.util.*;
import java.io.*;

public class crewmates{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        ArrayList<String> ppl = new ArrayList<>();
        while(times-->0){
            ppl.add(f.nextLine());
        }
        int times2=f.nextInt(); f.nextLine();
        while(times2-->0){
            ppl.remove(f.nextLine());
        }
        for(String s : ppl){
            System.out.println(s);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new crewmates().run();
    }
}
