import java.util.*;
import java.io.*;
import java.awt.*;

public class pratik{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pratik".toLowerCase()+".dat"));
        Scanner scan = new Scanner(new File("nums.dat"));
        char[][][] nums = new char[10][5][5];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                char[] s = scan.nextLine().toCharArray();
                nums[i][j] = s;
            }
        }


        HashMap<String, Integer> shifts = new HashMap<>();
        shifts.put("Aunt Tapasi", -5 * 60 - 30);
        shifts.put("Grandpa Aadi", -5 * 60 - 45);
        shifts.put("Second Cousin Bongi", -2 * 60);
        shifts.put("Cousin Gulasyl", -5 * 60);
        shifts.put("Uncle Ardam", -2 * 60);
        shifts.put("Mom", -6 * 60);
//        shifts.put("")
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] temp = f.next().split(":");
            int hour = Integer.parseInt(temp[0]) % 12;
            int min = Integer.parseInt(temp[1]);
            boolean isPM = f.next().equals("pm"); f.nextLine();
            if (isPM) {
                hour += 12;
            }
            System.out.println(hour+" "+min);
            min += hour * 60;
            String name = f.nextLine().trim();
            min += shifts.get(name);
//            min += 6 * 60;
            System.out.println(min);
            int hours = min/60;
            int mins = min%60;
            System.out.println(hours+" "+mins);
            char[][] out = new char[5][25];
            for (int i = 0; i < 5; i++) {
                Arrays.fill(out[i], ' ');
            }
            int[] digits = new int[4];
            System.out.println(hours);
            digits[0]= (hours)%12;
            digits[1]= (hours)%12%10;
            digits[2] = mins/10;
            digits[3]= mins%10;
            System.out.println(digits[0]+" "+digits[1]+" : "+digits[2]+" "+digits[3]);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    out[i][j] = nums[digits[0]][i][j];
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 6; j < 11; j++) {
                    out[i][j] = nums[digits[1]][i][j-6];
                }
            }
            out[1][12] = '.';
            out[3][12] = '.';
            for (int i = 0; i < 5; i++) {
                System.out.println(out[i]);
            }
            System.out.println(nums[digits[2]].length);
            for (int i = 0; i < 5; i++) {
                for(int j = 14;j<19;j++){
                    out[i][j] = nums[digits[2]][i][j-14];
                }
            }
            for (int i = 0; i < 5; i++) {
                for(int j = 20;j<25;j++){
                    out[i][j] = nums[digits[3]][i][j-20];
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(out[i]);
            }




        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pratik().run();
    }
}
