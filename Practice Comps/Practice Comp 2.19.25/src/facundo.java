import java.util.*;
import java.io.*;

public class facundo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("facundo".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] str = f.next().split("");
            int shuffles = f.nextInt(); f.nextLine();
            while(shuffles-->0){
                int frontlen = str.length/2;
//                System.out.println(Arrays.toString(str));
//                System.out.println(frontlen);
                if(str.length%2==1){
                    frontlen++;
                }
                String[] front  = new String[frontlen];
                String[] back = new String[str.length-frontlen];
                for (int i = 0; i < frontlen; i++) {
                    front[i] = str[i];
                }
                System.out.println(Arrays.toString(front));
                for (int i =frontlen+1; i < str.length; i++) {
                    back[i-frontlen-1] = str[i];
                }
                for (int i = 0; i < Math.min(frontlen, str.length/2)-1; i++) {
                    str[i*2] = front[i];
                    str[i*2+1] = back[i];
                }
                if(str.length%2==1){
                    str[str.length-1] = front[frontlen-1];
                }
            }
            String s ="";
            for(String strs : str){
                s+=strs;
            }
            System.out.println(s);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new facundo().run();
    }
}
