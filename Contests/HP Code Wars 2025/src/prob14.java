import java.util.*;
import java.io.*;

public class prob14{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int lenSq = f.nextInt();
        if(lenSq<25){
            System.out.println("That diagonal does not lead to integer sides!");
            return;
        }
//        if(lenSq==25){
//            System.out.println("3 4");
//            return;
//        }
        int s1 = lenSq-1;
        int side1 = -1, side2 = -1;
        boolean solved = false;
        int maxArea = 0;
        while(s1-->=0){
            if(isSquare(s1) && isSquare(lenSq-s1)){
                int a  = (int) Math.sqrt(s1);
                int b= (int) Math.sqrt(lenSq-s1);
                int area = a*b;
                if(area > maxArea){
                    maxArea = area;
                    side1 = a;
                    side2 = b;
                }
                solved = true;
            }
        }
        int tmp = Math.min(side1, side2);
        side2 = Math.max(side1, side2);
        side1 = tmp;
        if(!solved){
            System.out.println("That diagonal does not lead to integer sides!");
        }
        else {
            System.out.println(side1 + " " + side2);
        }


        f.close();
    }

    boolean isSquare(int d) {
        return (Math.sqrt(d) % 1) == 0;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new prob14().run();
    }
}
