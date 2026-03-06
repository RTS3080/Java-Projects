import java.util.*;
import java.io.*;
import java.awt.*;

public class TestCasesCreator{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("base3".toLowerCase()+".dat"));
        int count = 0;
        File folder = new File("input");
        if (!folder.exists()) {
            folder.mkdir(); // create the folder if it doesn’t exist
        }
        while(f.hasNext()){
            File file = new File(folder,"input"+String.format("%02d", count++)+".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            PrintWriter pw = new PrintWriter(file);
            String s = f.nextLine();
            pw.write(s);
            pw.close();
        }
        f.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        new TestCasesCreator().run();
    }
}
