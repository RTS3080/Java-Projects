import java.util.*;
import java.io.*;

public class signs{
    int num;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("signs".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            num = f.nextInt();
            boolean neg = false;
            if(num<0){
                neg = true;
                num = -num;
            }
            System.out.println("recur: "+recur(1,0));
        }
        f.close();
    }
    int recur(int n, int i){
        if(n>=num || i>=num){
//            System.out.println("broken");
            return 1;
        }
        System.out.print(n+" ");
        int sub;
        if(n-i>0){
            sub = recur(n-i,i+1)+1;
        }
        else sub = Integer.MAX_VALUE;
        int add = recur(n+i,i+1)+1;
//        int sub = recur(n-i,i+1)+1;
//        System.out.println(Math.min(sub,add));
        return Math.min(sub,add);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new signs().run();
    }
}
