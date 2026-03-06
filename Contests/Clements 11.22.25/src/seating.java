import java.util.*;
import java.io.*;
import java.awt.*;

public class seating{
    ArrayList<int[]> perms;
    int size;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("seating".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            size=f.nextInt();
            perms =new ArrayList<>();
            int[][] adj =  new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    adj[i][j] = f.nextInt();
                }
            }
            permute("0", 1);
            int max = Integer.MIN_VALUE;
            int[] costs = new int[perms.size()];
            for(int j = 0; j< perms.size();j++){
                int[] arr = perms.get(j);
                int cost = 0;
                for (int i = 0; i < arr.length-1; i++) {
                    cost+=adj[arr[i]][arr[i+1]];
                    cost+=adj[arr[i+1]][arr[i]];
                }
                cost+=adj[arr[arr.length-1]][arr[0]];
                cost+=adj[arr[0]][arr[arr.length-1]];
                max = Math.max(max, cost);
                costs[j] =cost;
            }
            int countMax = 0;
            for(int i : costs){
                if(i==max){
                    countMax++;
                }
            }

            System.out.println(max+" "+countMax);
        }
        f.close();
    }
    void permute(String s, int i){
        int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        if(i==size){
            perms.add(arr);
            return;
        }
        loop:
        for(int j=1;j<size;j++){
            for(int a : arr){
                if(j==a) continue loop;
            }
            permute(s+j, i+1);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new seating().run();
    }
}
