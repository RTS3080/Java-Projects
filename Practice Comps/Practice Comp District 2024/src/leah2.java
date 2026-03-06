import java.util.*;
import java.io.*;

public class leah2{
   ArrayList<String>binary;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("leah".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int w = f.nextInt();
            binary = new ArrayList<>();
            int maxNum = (2<<w-1);
            for(int i=0;i<(2<<w-1);i++){
                binary.add(String.format("%"+(w)+"s",Integer.toBinaryString(i)).replaceAll(" ","0"));
            }
            ArrayList<Integer> nums = new ArrayList<>();

            System.out.println(binary);
            nums.add(0);
            while(nums.size()<maxNum){
//                ArrayList<Integer> temp = new ArrayList<>();
                for (int i =0;i<maxNum;i++) {
                    if(getDiff(binary.get(nums.getLast()),binary.get(i))<=1 && !nums.contains(i)) {
                        nums.add(i);
                        break;
                    }
                }
                if(nums.size()>=maxNum)
                    break;
//                System.out.println(nums);
            }
            for(int i :nums)
                System.out.print(i+" ");
            System.out.println();
        }
        f.close();
    }
    public int getDiff(String s1, String s2){
        int cnt=0;
        for (int i = 0; i < s1.length() && i<s2.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i))
                cnt++;
        }
        return cnt;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new leah2().run();
    }
}
