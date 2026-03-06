import java.util.*;
import java.io.*;

public class ScammersTroy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Scammers".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<String> lns = new ArrayList<>();
        while(f.hasNext()){
            lns.add(f.nextLine());
        }
        String[] split = new String[lns.size()];
        split = lns.toArray(split);
        ArrayList<String> statements = new ArrayList<>();
        String currLine = "";
        for(int i = 0; i < split.length; i++){
            if(split[i].isEmpty()){
                statements.add(currLine);
                currLine = "";
            }
            else{
                currLine += split[i]+" ";
            }
        }
        statements.add(currLine);
        for(String s : statements){
            String[] spl = s.split(":");
            String name = spl[0];
            boolean scam = spl[1].matches(".*s.*c.*a.*m.*");
            System.out.println(name+" "+(scam?"is a scammer!":"is safe to text."));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ScammersTroy().run();
    }
}
