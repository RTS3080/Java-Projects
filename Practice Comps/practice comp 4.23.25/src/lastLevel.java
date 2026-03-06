import java.util.*;
import java.io.*;

public class lastLevel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lastLevel".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int members = f.nextInt();
            if(members==1){
                System.out.println("1");
                continue;
            }
            boolean[][] connections = new boolean[members][members];
            for (int i = 0; i < members-1; i++) {
                int parent = f.nextInt()-1;
                int child = f.nextInt()-1;
                connections[parent][child] = true;
            }
            ArrayList<Integer> leafs = new ArrayList<>();
            for (int i = 0; i < members; i++) {
                boolean b = false;
                for(int j = 0; j < members; j++){
                    b|=connections[i][j];
                }
                if(!b) leafs.add(i);
            }
            for(int i : leafs){
                System.out.print(i+1+" ");
            }
            System.out.println();

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lastLevel().run();
    }
}
