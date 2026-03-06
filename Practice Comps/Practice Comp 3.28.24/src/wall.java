import java.util.*;
import java.io.*;

public class wall{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("wall".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<Integer> fences=new ArrayList<>();
            int times2=f.nextInt();f.nextLine();
            while(times2-->0){
                int st=f.nextInt();
                int end=f.nextInt();
                fences.add(st);
                fences.add(end);
            }
            int times3=f.nextInt();f.nextLine();
            while(times3-->0){
                int s=f.nextInt();
                int start=fences.indexOf(s);
                int end=f.nextInt();
                boolean made=true;
                if(start%2==0){
                    start++;
                }
                for (int i = start; i < fences.indexOf(end); i+=2) {
                    if(!fences.get(i).equals(fences.get(i + 1))) {
                        made = false;
//                        System.out.println(fences.get(i)+" "+fences.get(i+1));
                    }
                }
                System.out.println(made?"MADE IT":"NOPE");
            }
        }
        f.close();
    }
}
