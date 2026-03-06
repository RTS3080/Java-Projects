import java.util.*;
import java.io.*;
import java.awt.*;

public class vows{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vows".toLowerCase()+".dat"));
        ArrayList<String> strs = new ArrayList<>();
        while(f.hasNext()){
            strs.add(f.nextLine().trim());
        }
        String rep = strs.get(strs.size()-1);
        for(int i = 0; i< strs.size(); i++){
            strs.set(i, strs.get(i).replaceAll("BLANK", rep));
        }
        for (int i = 0; i < strs.size()-1; i++) {
            System.out.println(strs.get(i));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vows().run();
    }
}
