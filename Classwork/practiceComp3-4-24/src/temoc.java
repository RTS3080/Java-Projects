import java.util.*;
import java.io.*;

public class temoc {
    int[][] store1;
    int[][] store2;

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("temoc".toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);

        int dimension = f.nextInt();
        store1 = new int[dimension][dimension];
        store2 = new int[dimension][dimension];

        for (int i = 0; i < dimension;i ++){
            Arrays.fill(store1[i], Integer.MAX_VALUE);
            Arrays.fill(store2[i], Integer.MAX_VALUE);
        }

        int X1 = f.nextInt()-1;
        int Y1 = f.nextInt()-1;

        int X2 = f.nextInt()-1;
        int Y2 = f.nextInt()-1;

        int goalX = f.nextInt()-1;
        int goalY = f.nextInt()-1;

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(X1); queue1.offer(Y1); queue1.offer(0);

        while(!queue1.isEmpty()){
            int checkX = queue1.poll();
            int checkY = queue1.poll();
            int step = queue1.poll();

            if (checkX >= dimension || checkX < 0 ||
                    checkY >= dimension || checkY < 0||
                    store1[checkX][checkY] <= step)
            {
                continue;
            }
            store1[checkX][checkY] = step;

            queue1.offer(checkX-1); queue1.offer(checkY+2); queue1.offer(step+1);
            queue1.offer(checkX-1); queue1.offer(checkY-2); queue1.offer(step+1);

            queue1.offer(checkX+1); queue1.offer(checkY+2); queue1.offer(step+1);
            queue1.offer(checkX+1); queue1.offer(checkY-2); queue1.offer(step+1);

            queue1.offer(checkX+2); queue1.offer(checkY+1); queue1.offer(step+1);
            queue1.offer(checkX+2); queue1.offer(checkY-1); queue1.offer(step+1);

            queue1.offer(checkX-2); queue1.offer(checkY+1); queue1.offer(step+1);
            queue1.offer(checkX-2); queue1.offer(checkY-1); queue1.offer(step+1);
        }

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(X2); queue2.offer(Y2); queue2.offer(0);

        while(!queue2.isEmpty()){
            int checkX = queue2.poll();
            int checkY = queue2.poll();
            int step = queue2.poll();

            if (checkX >= dimension || checkX < 0 ||
                    checkY >= dimension || checkY < 0||
                    store2[checkX][checkY] <= step)
            {
                continue;
            }
            store2[checkX][checkY] = step;

            queue2.offer(checkX-1); queue2.offer(checkY+2); queue2.offer(step+1);
            queue2.offer(checkX-1); queue2.offer(checkY-2); queue2.offer(step+1);

            queue2.offer(checkX+1); queue2.offer(checkY+2); queue2.offer(step+1);
            queue2.offer(checkX+1); queue2.offer(checkY-2); queue2.offer(step+1);

            queue2.offer(checkX+2); queue2.offer(checkY+1); queue2.offer(step+1);
            queue2.offer(checkX+2); queue2.offer(checkY-1); queue2.offer(step+1);

            queue2.offer(checkX-2); queue2.offer(checkY+1); queue2.offer(step+1);
            queue2.offer(checkX-2); queue2.offer(checkY-1); queue2.offer(step+1);
        }

        int dis1 = store1[goalX][goalY];
        int dis2 = store2[goalX][goalY];

        if (dis1 < dis2){
            System.out.println("1");
        }
        else if (dis1 > dis2){
            System.out.println("2");
        }
        else{
            System.out.println("0");
        }
    }

    public static void main(String[] args) throws Exception {
        new temoc().run();
    }
}