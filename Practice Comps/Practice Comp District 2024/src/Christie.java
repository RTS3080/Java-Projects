import java.util.*;
import java.io.*;

public class Christie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Christie".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int start=f.nextInt(); int end=f.nextInt();
            ArrayList<Integer> christies=new ArrayList<>();
            for (int i = start; i <=end ; i++) {
                int squares = 0;
                int num = i;
                while(num>0){
                    squares+=(int)Math.pow(num%10,2);
                    num/=10;
                }
                if(Math.sqrt(squares)%1==0){
                    christies.add(i);
                }
            }
            if(christies.isEmpty()){
                System.out.println("NONE");
            }
            else{
                for(int i : christies){
                    System.out.print(i+" ");
                }
                System.out.println();
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Christie().run();
    }
}
