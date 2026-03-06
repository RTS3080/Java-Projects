import java.util.*;
import java.io.*;
import java.awt.*;

public class krishna{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("krishna".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        long[] gifts = new long[101];
//        gifts[1]=1;
        for (int i = 1; i < 101; i++) {
//            gifts[i] = gifts[i-1] + i*(i-1)/2;
            int sum = 0;
            for (int j = 0; j <=i; j++) {
                sum+=j*(j+1)/2;
            }
            gifts[i]=sum;
        }
        while(times-->0){
            int a = f.nextInt();
            int b= f.nextInt();
            System.out.println(gifts[b]-gifts[a-1]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new krishna().run();
    }
}
