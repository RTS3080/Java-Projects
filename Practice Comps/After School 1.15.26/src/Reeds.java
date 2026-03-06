import java.util.*;
import java.io.*;
import java.awt.*;

public class Reeds{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Reeds".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<Reed> reeds = new ArrayList<>();
        while(times-->0){
            int id = f.nextInt();
            boolean married = f.next().equals("true");
            int phds = f.nextInt();
            int height = f.nextInt();
            int kids = f.nextInt();
            boolean stretch = f.next().equals("true");
            int members = f.nextInt();
            reeds.add(new Reed(id, married, phds, height, kids, stretch, members));
        }
        Collections.sort(reeds);
        String out = "";
        for(Reed r : reeds){
            out+=r.id+" ";
        }
        System.out.println(out.trim());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Reeds().run();
    }
}

class Reed implements Comparable<Reed>{
    int id;
    boolean married;
    int phds;
    int height;
    int kids;
    boolean stretch;
    int members;
    public Reed(int id, boolean married, int phds, int height, int kids, boolean stretch, int members){
        this.id = id;
        this.married = married;
        this.phds = phds;
        this.height = height;
        this.kids = kids;
        this.stretch = stretch;
        this.members = members;
    }
    public int compareTo(Reed o){
        if(married != o.married){
            return married ? -1 : 1;
        }
        if(kids != o.kids){
            if(kids == 2) return -1;
            if(o.kids ==2) return 1;
            return kids > o.kids ? -1 : 1;
        }
        if(members != o.members){
            if(members == 4) return -1;
            if(o.members == 4) return 1;
            if(members == 5) return -1;
            if(o.members == 5) return 1;
            return members < o.members ? -1 : 1;
        }
        if(stretch != o.stretch){
            return stretch ? -1 : 1;
        }
        if(phds != o.phds){
            return phds < o.phds ? -1 : 1;
        }
        return Integer.compare(height, o.height);
    }
}