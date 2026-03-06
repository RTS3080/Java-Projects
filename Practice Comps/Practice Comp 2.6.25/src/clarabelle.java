import java.util.*;
import java.io.*;

public class clarabelle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("clarabelle".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.nextLine().trim();
            ArrayList<String> pals = new ArrayList<>();
            for (int i = 0; i < s.length()-2; i++) {
                if(s.charAt(i)==s.charAt(i+2)){
                    if(!pals.contains(s.substring(i,i+3))) {
                        pals.add(s.substring(i, i + 3));
                    }
                }
            }
            Collections.sort(pals);
            if(pals.size()==0){
                System.out.println("NONE");
            }
            else{
                for(String str : pals){
                    System.out.print(str+" ");
                }
                System.out.println();
            }
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new clarabelle().run();
    }
}
