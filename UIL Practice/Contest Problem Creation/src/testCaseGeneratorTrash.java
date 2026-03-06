import java.util.*;
import java.io.*;

public class testCaseGeneratorTrash {

    public void run() throws Exception{
        new PrintWriter("trashTesting.dat").close();
        BufferedWriter out = new BufferedWriter(new FileWriter("trashTesting.dat"));
        Random rand = new Random();
        Scanner f = new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        out.write(times+"\n");
        System.out.println(times);

        while(times-->0){
            int bound = rand.nextInt(5,50);
            int t = rand.nextInt(1, bound*bound/2);
            out.write(bound + " " + t +"\n");
            System.out.println(bound+" "+t);
            char[][] mat = new char[bound][bound];
            for (int i = 0; i < bound; i++) {
                for (int j = 0; j < bound; j++) {
                    double prob = rand.nextDouble();
                    if(prob<=.7){
                        mat[i][j] = '.';
                    }
                    else if(prob<=.97){
                        mat[i][j] = '#';
                    }
                    else{
                        mat[i][j] = 'M';
                    }
                }
            }
            int[] starts = new int[2];
            int[] ends = new int[2];
            for (int i = 0; i < 2; i++) {
                starts[i] = rand.nextInt(0, bound);
                ends[i] = rand.nextInt(0, bound);
            }
            mat[starts[0]][starts[1]] = 'S';
            mat[ends[0]][ends[1]] = 'E';
            for(char[] ch : mat){
                out.write(new String(ch)+"\n");
                System.out.println(ch);
            }
        }

        // Added to ensure all data is written and resources are released
        out.flush();
        out.close();
        f.close();
    }

    public static void main(String[] args) throws Exception{
        new testCaseGeneratorTrash().run();
    }
}