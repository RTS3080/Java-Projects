import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class angryBirds{

    char[][] mat;
    TreeMap<Integer, Integer> birds;
    int totPigs;
    int pigsKilled;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("angryBirsd".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
//        int times = 0;
//        f.nextInt();
        while(times-->0){
            int rows=f.nextInt(); int cols=f.nextInt(); f.nextLine();
            mat = new char[rows][cols];
            birds = new TreeMap<>();
            totPigs=0;
            pigsKilled=0;
            for (int i = 0; i < rows; i++) {
                String[] ln = f.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = ln[j].charAt(0);
                    if(mat[i][j] == 'o' && !birds.containsKey(i)){
                        birds.put(i,j);
                    }
                    if(mat[i][j] == 'x'){
                        totPigs++;
                    }
                }
            }
            for(Entry e : birds.entrySet()){
                mat[(int)e.getKey()][(int)e.getValue()]='-';
                recur((int)e.getKey(),(int)e.getValue()+1,false,false);
            }
            System.out.println("Number of Pigs = "+totPigs);
            System.out.println("Number of Pigs Killed = "+pigsKilled);
            for(char[] chs :mat){
                String str = "";
                for(char ch : chs){
                    str+=ch+" ";
                }
                System.out.println(str.trim());
            }
            System.out.println();
        }

        f.close();
    }


    void recur(int r, int c, boolean angry,boolean killer){
        if(r<0 || c<0 || r>mat.length-1 || c>mat[0].length-1){
            return;
        }
        boolean ang = angry;
        boolean kill =killer;
        if (mat[r][c] == 'x') {
            kill = true;
            pigsKilled++;
            if(!angry){
                mat[r][c] = 'o';
                return;
            }
        }
        else if(mat[r][c] == 'o'){
            ang = true;
        }
        if(c==mat[0].length-1){
            mat[r][c] = 'o';
            return;
        }
        else {
            mat[r][c] = '-';
            recur(r, c + 1, ang,kill);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new angryBirds().run();
    }
}
