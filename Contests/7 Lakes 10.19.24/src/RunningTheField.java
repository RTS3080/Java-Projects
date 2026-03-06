import java.util.*;
import java.io.*;

public class RunningTheField{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("RunningTheField".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len = f.nextInt();
            int numDef = f.nextInt();
            int energy = f.nextInt(); f.nextLine();
            char[] field = f.nextLine().trim().toCharArray();
            String[] strs = f.nextLine().trim().split(" ");
            Stack<Integer> strengths = new Stack<>();
            for(String str : strs){
                strengths.push(Integer.parseInt(str));
            }
            boolean broken = false;
            int[] sUsed = new int[len];
            for(int i = field.length-1; i >= 0; i--){

                if(field[i] != 'D'){
                    sUsed[i]= 1;
                }
                else{
                    sUsed[i] = strengths.pop();
                }

            }
            int totUsed = 0;
            for(int i = field.length-1; i >= 0; i--){
                if(totUsed>energy){
                    broken = true;
                    System.out.println(i+2);
                    break;
                }
                totUsed+=sUsed[i];
            }
            if(!broken){
                System.out.println(0);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new RunningTheField().run();
    }
}
