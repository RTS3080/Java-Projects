import java.util.*;
import java.io.*;

public class sveta{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sveta".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int bits =Integer.parseInt(f.nextLine().split("=")[1]);
            String ln1 = f.nextLine();
            String ln2 = f.nextLine();
            String ln3 = f.nextLine();
            f.nextLine();

            String op = "";
            if(!ln1.contains("n/a") && ln2.contains("n/a") && ln3.contains("n/a")){
                op = "|";
            }
            else if (ln1.contains("n/a") && !ln2.contains("n/a") && ln3.contains("n/a")){
                op = "&";
            }
            else if (ln1.contains("n/a") && ln2.contains("n/a") && !ln3.contains("n/a")){
                op = "^";
            }
            else op = "X";

            int spots[];
            int a;
            if(op.equals("|")){
                String[] nums = ln1.split(" ")[3].split(",");
                spots = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    spots[i] = Integer.parseInt(nums[i]);
                }

                int[] num = new int[bits];
                for(int n : spots){
                    num[n] = 1;
                }
                String s = "";
                for (int i = 0; i < num.length; i++) {
                    s+=num[i];
                }
                String n = convertToHex(s).toUpperCase().toUpperCase();
                System.out.println("opnd "+op+" "+n);
            }
            else if ( op.equals("&")){
                String[] nums = ln2.split(" ")[3].split(",");
                spots = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    spots[i] = Integer.parseInt(nums[i]);
                }

                int[] num = new int[bits];
                Arrays.fill(num,1);
                for(int n : spots){
                    num[n] = 0;
                }
                String s = "";
                for(int n : num){
                    s+=n;
                }
                String n = convertToHex(s).toUpperCase();

                System.out.println("opnd "+op+" "+n);

            }
            else if(op.equals("^")){

                String[] nums = ln3.split(" ")[1].split(",");
                spots = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    spots[i] = Integer.parseInt(nums[i]);
                }

                int[] num = new int[bits];
                for(int n : spots){
                    num[n] = 1;
                }
                String s = "";
                for (int i = 0; i < num.length; i++) {
                    s+=num[i];
                }
                String n = convertToHex(s).toUpperCase().toUpperCase();
                System.out.println("opnd "+op+" "+n);

            }

            else if(op.equals("X")){
                System.out.println("This can not be done with a single bitwise operator.");
            }
        }
        f.close();
    }
    public String convertToHex(String s){
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            a+=Integer.parseInt(s.charAt(i)+"")<<i;
        }
        return (Integer.toHexString(a));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sveta().run();
    }
}
