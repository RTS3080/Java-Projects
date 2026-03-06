import java.util.*;
import java.io.*;
import java.awt.*;

public class torchtrouble{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("torchtrouble".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int dis = f.nextInt();
            f.nextLine();

            int lastLit = -1;
            String road = f.nextLine().trim();

            int numLit = 0;

            boolean possible = true;

            for (int i = 0; i < road.length(); i++){
                if (i - lastLit - 1 == dis){
                    int checkInd = i;
                    while (checkInd > lastLit && road.charAt(checkInd) == '~') checkInd--;

                    if (checkInd == lastLit){
                        possible = false;
                        break;
                    }
                    else{
                        numLit++;
                        lastLit = checkInd + dis;
                        i = lastLit;
                    }
                }
            }

            if (lastLit < road.length()-1){
                int ind = road.length()-1;
                while (ind > lastLit && road.charAt(ind) == '~') ind--;
                if (ind == lastLit) possible = false;
                else{
                    numLit++;
                }
            }

            if (possible){
                System.out.println(numLit);
            }
            else{
                System.out.println("Don't mine at night");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new torchtrouble().run();
    }
}
