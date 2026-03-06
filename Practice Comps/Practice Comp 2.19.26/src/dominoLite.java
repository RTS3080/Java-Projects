import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;

class domino{
    int[] nums;
    domino[] doms;
    boolean connected;
    public domino(int left, int right){
        nums = new int[2];
        doms = new domino[2];
        nums[0] = left;
        nums[1] = right;
    }
    void reverse(){
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;

        domino tmp = doms[0];
        doms[0] = doms[1];
        doms[1] = tmp;
    }
    int connection(domino d){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(nums[i] == d.nums[j]){
                    return i * 2 + j;
                }
            }
        }
        return -1;
    }
}
public class dominoLite{
    int[] parent;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("domino".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            domino[] dominoes = new domino[n];
            for (int i = 0; i < n; i++) {
                int a = f.nextInt();
                int b = f.nextInt();
                dominoes[i] = new domino(a,b);
            }
            domino rside = dominoes[0];
            domino lside = dominoes[0];
            int right = dominoes[0].nums[1];
            int left = dominoes[0].nums[0];
            dominoes[0].connected = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dominoes[j].connected){
                        continue;
                    }

                }
            }





        }
        f.close();
    }
    int find(int a){
        if(parent[a] ==a) return a;
        return find(parent[a]);
    }
    void union(int a, int b){
        parent[find(a)] = find(b);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new dominoLite().run();
    }
}
