import java.util.*;
import java.io.*;

public class Jobs{

    ArrayList<String> vis;
    ArrayList<String> keys;
    ArrayList<String> valid;
    int best;
    String[] bes;
    HashMap<String,int[]> bob;


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Jobs".toLowerCase()+".dat"));
        int k = f.nextInt();
        f.nextLine();
        for (int djsfl = 0; djsfl < k; djsfl++) {
            int yup = f.nextInt();
            f.nextLine();
            int pos = 1;
            best = -1;
            bob= new HashMap<>();
            bes = new String[0];
            for (int sdhf = 0; sdhf < yup; sdhf++) {
                String in = f.next();
                int start = f.nextInt();
                int end = f.nextInt();
                int pay = f.nextInt();
                f.nextLine();
                bob.put(in, new int[]{start,end,pay,pos++});
            }

            vis = new ArrayList<>();
            keys = new ArrayList<>(bob.keySet()) ;
            valid = new ArrayList<>();
            for (int i = 0; i < keys.size(); i++) {
                recur(keys.get(i),bob.get(keys.get(i))[2]);
            }
            System.out.println(best);
            best = 0;
            bes = new String[0];
        }
        f.close();
    }

    public void recur (String name, int pay){
        for (int i = 0; i < keys.size()-1; i++) {
            if (!vis.contains(name)) {
                if (pay>=best){
                    if (pay==best){
                        String[] temp = name.split(" ");
                        if (bob.get(temp[0])[0]<bob.get(bes[0])[0]){
                            best = pay;
                            bes = name.split(" ");
                        }
                        else if (bob.get(temp[0])[0]==bob.get(bes[0])[0]){
                            if (bob.get(temp[0])[3]>bob.get(bes[0])[3]){
                                best = pay;
                                bes = name.split(" ");
                            }
                        }
                    }
                    else{
                        best = pay;
                        bes = name.split(" ");
                    }

                }
                vis.add(name+" "+keys.get(i));
                recur(name + " " + keys.get(i),bob.get(keys.get(i))[2]+ pay);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Jobs().run();
    }
}
