import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class nemo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("nemo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        while (f.hasNext()){
            f.next();
            L = f.nextInt();
//            System.out.println(L);
            W = f.nextInt();
            D = f.nextInt();
            f.nextLine();

//            System.out.println(L+" "+W+" "+D);

            boolean[][][] fishes = new boolean[L+1][W+1][D+1];
            ArrayList<ArrayList<Integer>> dList = new ArrayList<>();
            String[] line = f.nextLine().trim().split("\\s+");


            for (String each : line){
                String[] inEach = each.trim().split(",");
                ArrayList<Integer> temp = new ArrayList<>();
                for (String inInEach : inEach) {
                    temp.add(Integer.parseInt(inInEach));
                }
                dList.add(temp);
            }


            line = f.nextLine().trim().split("\\s+");
            for (String each : line){
                String[] inEach = each.trim().split(",");
                int x = Integer.parseInt(inEach[0]);
                int y = Integer.parseInt(inEach[1]);
                int z = Integer.parseInt(inEach[2]);

                fishes[x][y][z] = true;
            }

//            System.out.println(Arrays.toString(line));

            int result = 0;

            for (ArrayList<Integer> each : dList){
                int z = Math.min(D, each.get(2));
                int x = each.get(0);
                int y = each.get(1);
                int res = 0;
                for (int inX = x-1; inX <= x+1; inX++){
                    for (int inY = y-1; inY <= y+1; inY++){
                        for (int inZ = z-1; inZ <= z+1; inZ++){
                            if (inBounds(inX, inY, inZ) && fishes[inX][inY][inZ] && Math.sqrt(Math.pow(inX-x, 2) + Math.pow(inY-y, 2) + Math.pow(inZ-z, 2)) <= 1){
                                res++;
                                fishes[inX][inY][inZ] = false;
                            }
                        }
                    }
                }
                result += res;
//                System.out.println(res);
            }

            if (result == 0){
                System.out.println("None of dem fish blowed up!");
            }
            else System.out.println("AIEE, I got "+result+" fish, me!");
            f.next();

        }

        f.close();
    }

    int L, W, D;

    public boolean inBounds(int x, int y, int z){
        return x >= 0 && x <= L && y >= 0 && y <= W && z >= 0 && z <= D;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new nemo().run();
    }
}
