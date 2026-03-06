import java.util.*;
import java.io.*;

public class magic{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("magic".toLowerCase()+".dat"));
        Map<String, String> viruses = new HashMap<>();
        viruses.put("RPM", "ED AB EE DB");
        viruses.put("EXE", "4D 5A");
        viruses.put("PDF", "25 50 44 46 2D");
        viruses.put("VBS", "23 40 7E 5E");
        viruses.put("CLASS", "CA FE BA BE");
        viruses.put("ELF", "7F 45 4C 46");
        viruses.put("BC", "42 43");
        viruses.put("MSI", "D0 CF 11 E0 A1 B1 1A E1");
        while(f.hasNext()){
            String line=f.nextLine();
            boolean hasVirus = false;
            for(String virus : viruses.keySet()){
                if(line.startsWith(viruses.get(virus))){
                    hasVirus = true;
                    System.out.println("BAD_" + name(line.substring(viruses.get(virus).length()+1)) + "." + virus.toLowerCase());
                    break;
                }
            }
            if(!hasVirus) {
                System.out.println(name(line));
            }
        }
        f.close();
    }

    public String name(String line){
        String x = "";
        String[] arr = line.split(" ");
        for(String s : arr){
            int a = Integer.parseInt(s, 16);
            x+= (char)a;
        }
        return x;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new magic().run();
    }
}
