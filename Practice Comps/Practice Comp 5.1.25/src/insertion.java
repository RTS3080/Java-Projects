import java.util.*;
import java.io.*;
import java.awt.*;

public class insertion{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("insertion".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        String face = "TJQKA";
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            int[] arr = new int[ln.length];
            for(int i=0;i<ln.length;i++){
                String s  = ln[i];
                if(face.contains(s)){
                    arr[i] = face.indexOf(s)+10;
                }
                else{
                    arr[i] = Integer.parseInt(s);
                }
            }
            for(int i = 1; i< arr.length; i++){
                int j = i;
                while(j >0 && arr[j] < arr[j-1]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    j--;
                }
                String s = "";
                for(int a : arr){
                    if(a>=10){
                        s+=face.charAt(a-10);
                    }
                    else{
                        s+=a;
                    }
                    s+=" ";
                }
                System.out.println(s.trim());
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new insertion().run();
    }
}
