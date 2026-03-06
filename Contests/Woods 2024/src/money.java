import java.io.File;
import java.util.Scanner;

public class money {
    public void run () throws Exception {
        Scanner f = new Scanner(new File("money.dat"));
        int x = Integer.parseInt(f.nextLine().trim());
        String name = "";
        int max = 0;
        int amt = 0;
        String suspect = "";

        for(int i=0; i<x; i++){
            String s = f.nextLine();
            String[] suspects = s.split(",");

            if(suspects.length == 2) {
                suspect = suspects[0];
                amt = Integer.parseInt(suspects[1].trim());
            }

            if(amt > max){
                max = amt;
                name = suspect;
            }
        }

        if(!name.isEmpty() && max > 0){
            System.out.println(name + " has stolen the most money!");
        } else{
            System.out.println("No valid suspects were listed.");
        }
    }
    public static void main(String[] args) throws Exception {
        new money().run();
    }
}