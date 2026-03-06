import java.util.*;
import java.io.*;

public class boxes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("boxes".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int boxNum = f.nextInt(); f.nextLine();
            long[][] boxes = new long[boxNum][3];
            String[] ln = f.nextLine().split(" ");
            for (int i = 0; i < boxNum; i++) {
                String[] box = ln[i].split("x");
//                System.out.println(Arrays.toString(box));
                for (int j = 0; j < 3; j++) {
                    boxes[i][j] = Long.parseLong(box[j]);
                }
            }

            for (int i = 0; i < boxNum; i++) {
                Arrays.sort(boxes[i]);
            }
            int fitBoxes = 0;
            for (int i = 0; i < boxNum-1; i++) {
                if(boxes[i][0] < boxes[i+1][0] && boxes[i][1] < boxes[i+1][1]&&
                        boxes[i][2] < boxes[i+1][2]){
                    fitBoxes++;
                }
                else break;
            }
            System.out.println(fitBoxes);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new boxes().run();
    }
}
