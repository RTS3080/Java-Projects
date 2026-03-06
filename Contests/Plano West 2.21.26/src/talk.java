import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class talk{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("talk".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int sentenceLength = f.nextInt();
            int missing = f.nextInt();
            ArrayList<Integer> missingIndices = new ArrayList<>();
            ArrayList<String> possible = new ArrayList<>();
            for (int i = 0; i < missing; i++) {
                possible.add(f.next());
            }
            String[] english = f.nextLine().trim().split(" ");
            String[] duckish = f.nextLine().trim().split(" ");
            for (int i = 0; i < english.length; i++) {
                if(english[i].equals("_")){
                    for(String s : possible){
                        if(s.length() == duckish[i].length()){
                            english[i] = s;
                        }
                    }
                }
            }
            String out = "";
            for(String s : english){
                out+=s+" ";
            }
            System.out.println(out.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new talk().run();
    }
}
