import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Bohr{
    class Soldier{
        int r, c, targetR, targetC;
        public Soldier(int r, int c){
            this.r = r;
            this.c = c;
            this.targetR = -1;
            this.targetC = -1;
        }
    }

    public int[][] copy(int[][] a){
        int[][] b = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                b[i][j] = a[i][j];
            }
        } return b;
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bohr".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int r= f.nextInt(), c = f.nextInt(), time = f.nextInt();
        Random rCombat = new Random(f.nextInt());
        Random rSpawn = new Random(f.nextInt());
        Random bCombat = new Random(f.nextInt());
        Random bSpawn = new Random(f.nextInt());
        int numSoldiers = f.nextInt();
        char[][] mat = new char[r][c];
        int[][] redSoldiers = new int[r][c];
        int[][] blueSoldiers = new int[r][c];
        int[][][] redSoldierTargets = new int[r][c][2];
        int[][][] blueSoldierTargets = new int[r][c][2];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
               blueSoldierTargets[i][j] = new int[] {-1, -1};
                blueSoldierTargets[i][j] = new int[] {-1, -1};
            }
        }
        ArrayList<int[]> rBases = new ArrayList<>();
        ArrayList<int[]> bBases = new ArrayList<>();
        ArrayList<int[]> controlPoints = new ArrayList<>(); //r c val team
        for (int i = 0; i < r; i++) {
            mat[i] = f.next().toCharArray();
            for (int j = 0; j < c; j++) {
                char cur = mat[i][j];
                if(cur == 'R'){
                    rBases.add(new int[]{i, j});
                }
                if(cur == 'B'){
                    bBases.add(new int[]{i, j});
                }
                if(Character.isDigit(cur)){
                    controlPoints.add(new int[]{i, j, cur-'0', 0});
                }
            }
        }

        for (int i = 0; i < numSoldiers; i++) {
            redSoldiers[rBases.get(i)[0]][rBases.get(i)[1]]++;
            blueSoldiers[bBases.get(i)[0]][bBases.get(i)[1]]++;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int soldiers = redSoldiers[i][j];
                int[] curTarget = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
                double curDist = Integer.MAX_VALUE;
                for (int k = 0; k < controlPoints.size(); k++) {
                    int[] curPoint = controlPoints.get(k);
                    double dist = Math.hypot(curPoint[0]-i, curPoint[1]-j);
                    if(dist > curDist){
                        continue;
                    }
                    if(dist < curDist){
                        curDist = dist;
                        curTarget = new int[]{controlPoints.get(k)[0], controlPoints.get(k)[1], controlPoints.get(k)[2]};
                        break;
                    }
                    if(curPoint[2] < curTarget[2]) continue;
                    if(curPoint[2] > curTarget[2]){
                        curTarget = curPoint;
                        curDist = dist;
                        break;
                    }
                    if(curPoint[0] > curTarget[0]) continue;
                    if(curPoint[0] < curTarget[0]){
                        curTarget = curPoint;
                        curDist = dist;
                        break;
                    }
                    if(curPoint[1] > curTarget[1]) continue;
                    if(curPoint[1] < curTarget[1]){
                        curTarget = curPoint;
                        break;
                    }
                }
                redSoldierTargets[i][j][0] = curTarget[0];
                redSoldierTargets[i][j][1] = curTarget[1];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int soldiers = redSoldiers[i][j];
                int[] curTarget = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
                double curDist = Integer.MAX_VALUE;
                for (int k = 0; k < controlPoints.size(); k++) {
                    int[] curPoint = controlPoints.get(j);
                    double dist = Math.hypot(curPoint[0]-i, curPoint[1]-j);
                    if(dist > curDist){
                        continue;
                    }
                    if(dist < curDist){
                        curDist = dist;
                        curTarget = new int[]{controlPoints.get(k)[0], controlPoints.get(k)[1], controlPoints.get(k)[2]};
                        break;
                    }
                    if(curPoint[2] < curTarget[2]) continue;
                    if(curPoint[2] > curTarget[2]){
                        curTarget = curPoint;
                        curDist = dist;
                        break;
                    }
                    if(curPoint[0] > curTarget[0]) continue;
                    if(curPoint[0] < curTarget[0]){
                        curTarget = curPoint;
                        curDist = dist;
                        break;
                    }
                    if(curPoint[1] > curTarget[1]) continue;
                    if(curPoint[1] < curTarget[1]){
                        curTarget = curPoint;
                        break;
                    }
                }

                blueSoldierTargets[i][j][0] = curTarget[0];
                blueSoldierTargets[i][j][1] = curTarget[1];
            }
        }

        for (int zz = 0; zz < time; zz++) {

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bohr().run();
    }
}
