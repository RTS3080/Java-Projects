import java.util.*;
import java.io.*;

public class Leah{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Leah".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int size = f.nextInt();
            Stack<Integer> master = new Stack<>();
            master.push(0);
            master.push(1);
            for (int abc = 1; abc< size; abc++) {
                Stack<Integer> prev = new Stack<>();
                Queue<Integer> curr= new LinkedList<>();
//                System.out.println("master: "+master);
                while(!master.isEmpty()) {
                    int a = master.pop();
                    prev.push(a);
                    curr.offer(a+(2<<abc-1));
                }
//                System.out.println("prev: "+prev);
//                System.out.println("curr: "+curr);
                while(!prev.isEmpty()) {
                    master.push(prev.pop());
                }

                while(!curr.isEmpty()) {
                    master.push(curr.poll());
                }
//                System.out.println(master);
            }
            ArrayList<Integer> list = new ArrayList<>();
            while(!master.isEmpty()) {
                list.add(master.pop());
            }
            Collections.reverse(list);
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Leah().run();
    }
}
