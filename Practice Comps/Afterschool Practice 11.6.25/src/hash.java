import java.util.*;
import java.io.*;
import java.awt.*;

public class hash{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hash".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int cnt = 0;
            int size = f.nextInt();
            boolean[] table = new boolean[size];
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                long sum =0;
                char[] str = f.next().toCharArray();
                for (int i = 0; i < str.length; i++) {
                    sum+=(str[i] - 'a') <<i;
                }
                sum%=size;
                if(table[(int)sum]){
                    boolean insert = false;
                    for(int i = Math.max(0, (int)sum-1); i< size && i<=sum+1;i++){
                        if(!table[i]){
                            insert = true;
                            table[i] = true;
                            break;
                        }
                    }
                    if(!insert){
                        cnt++;
                    }
                }
                else{
                    table[(int)sum] = true;
                }
//                System.out.println(Arrays.toString(table));
            }
            System.out.println(cnt);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hash().run();
    }
}
