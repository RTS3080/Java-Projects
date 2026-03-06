import java.util.*;
import java.io.*;

public class confcostumes{
    ArrayList<ArrayList<String>> p;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("confcostumes".toLowerCase()+".dat"));
        int times=f.nextInt();
        f.nextLine();
       //System.out.println(times);
        while(times-->0) {
            p = new ArrayList<>();
            int times2 = f.nextInt();
            f.nextLine();

            while (times2-- > 0) {
                int times3 = f.nextInt();
                f.nextLine();
                p.add(new ArrayList<>());
                while (times3-- > 0) {
                    p.getLast().add(f.next());
                }
                if (f.hasNextLine()) {
                    f.nextLine();
                }
            }
            System.out.println((recur(0, new HashSet<>())) ? "Everyone's happy!" : "Someone's out of luck!");
        }
        f.close();
    }

   public boolean recur(int index,Set<String> pic){
        if(index>=p.size()) return true;
       for (int i = 0; i < p.get(index).size(); i++) {
           if(!pic.contains(p.get(index).get(i))){
               pic.add(p.get(index).get(i));
               if(recur(index+1,pic)){
                   return true;
               }
               pic.remove(p.get(index).get(i));
           }
       }
       return false;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new confcostumes().run();
    }
}
