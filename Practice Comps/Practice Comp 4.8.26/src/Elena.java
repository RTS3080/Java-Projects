import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Elena{
    int[] tree;
    int target;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Elena".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            target = f.nextInt();
            String[] ln = f.next().split(",");
            tree= new int[ln.length];
            for (int i = 0; i < tree.length; i++) {
                if(ln[i].equals("null")){
                    tree[i]=Integer.MIN_VALUE;
                }
                else{
                    tree[i]=Integer.parseInt(ln[i]);
                }
            }
            System.out.println(sum(0, 0));

        }
        f.close();
    }
    boolean sum(int node, int sum){
        if(node >=tree.length || tree[node] == Integer.MIN_VALUE) return false;
        if(sum + tree[node] == target) return true;
        return sum(node*2+1, sum+tree[node]) | sum(node*2+2, sum+tree[node]);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Elena().run();
    }
}
