import java.util.*;
import java.io.*;

public class khushi{
    int[] memo;
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("khushi".toLowerCase()+".dat"));
        int[] coins = new int[]{1, 5, 10, 25, 100, 500, 1000, 2000};
        String[] name = new String[]{"Pennies", "Nickels", "Dimes", "Quarters", "$1", "$5", "$10", "$20"};
        int times = in.nextInt();
        for (int i = 0; i < times; i++) {
            int due = (int) (in.nextDouble()*100);
            int paid = (int) (in.nextDouble()*100);
            int change = paid-due;
            if(change==0){
                System.out.print("No Change Owed");
            }
            else{
                 memo = new int[coins.length];
                 int pos = coins.length-1;
                 while(change>0){
                     if(change<coins[pos]){
                         pos--;
                     }
                     else{
                         while(change>=coins[pos]){
                             memo[pos]++;
                             change-=coins[pos];
                         }
                     }
                 }
//                System.out.println(Arrays.toString(memo));
                for (int j = memo.length-1; j >=0; j--) {
                    int count = memo[j];
                    if(count!=0){
                        if(count==1){
                            if(name[j].equals("Pennies")){
                                System.out.print(count+"-"+"Penny ");
                            }
                            else if(name[j].equals("Quarters")){
                                System.out.print(count+"-"+"Quarter ");
                            }
                            else if(name[j].equals("Dimes")){
                                System.out.print(count+"-"+"Dime ");
                            }
                            else if(name[j].equals("Nickels")){
                                System.out.print(count+"-"+"Nickel ");
                            }
                            else{
                                System.out.print(count+"-"+name[j]+" ");
                            }
                        }
                        else{
                            System.out.print(count+"-"+name[j]+" ");
                        }
                    }


                }

            }
            System.out.println();

        }

//        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new khushi().run();
    }
}

