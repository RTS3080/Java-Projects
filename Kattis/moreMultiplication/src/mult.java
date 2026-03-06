import java.util.*;
import java.io.*;

public class mult{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("multiply".toLowerCase()+".in"));
        while(f.hasNext()){
            int t=f.nextInt();
            int s=f.nextInt();
            int tot=t*s;
            if(t ==0 && s ==0){
                break;
            }

            ArrayList<Integer> top=new ArrayList<>();
            while(t>0){
                top.add(t%10);
                t/=10;
            }
            ArrayList<Integer> side=new ArrayList<>();
            while(s>0){
                side.add(s%10);
                s/=10;
            }
            int digits=Math.max(top.size(),side.size());

        }
        f.close();
    }
}
