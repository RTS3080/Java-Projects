import java.util.*;
import java.io.*;

public class trick{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("trick".toLowerCase()+".dat"));
        while(f.hasNext()) {
            String line = f.nextLine();
            if(line.contains("OR")) {
                String[] parts = line.split(" OR ");
                if(parts[0].startsWith("not")) {
                    parts[0] = parts[0].replaceFirst("not ", "");
                } else {
                    parts[0] = "not " + parts[0];
                }
                if(parts[1].startsWith("not")) {
                    parts[1] = parts[1].replaceFirst("not ", "");
                } else {
                    parts[1] = "not " + parts[1];
                }
                System.out.println("not (" + parts[0] + " AND " + parts[1] + ")");
            } else if(line.contains("AND")) {
                String[] parts = line.split(" AND ");
                if(parts[0].startsWith("not")) {
                    parts[0] = parts[0].replaceFirst("not ", "");
                } else {
                    parts[0] = "not " + parts[0];
                }
                if(parts[1].startsWith("not")) {
                    parts[1] = parts[1].replaceFirst("not ", "");
                } else {
                    parts[1] = "not " + parts[1];
                }
                System.out.println("not (" + parts[0] + " OR " + parts[1] + ")");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new trick().run();
    }
}
