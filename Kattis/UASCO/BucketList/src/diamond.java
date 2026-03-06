import java.util.*;
import java.io.*;

public class diamond{
    int diff;
    ArrayList<Integer> dias;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diamond".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("diamond".toLowerCase()+".out"));
        int times=f.nextInt();
        diff = f.nextInt(); f.nextLine();
        dias = new ArrayList<>();
        while(times-->0){
            dias.add(f.nextInt());
        }
        Collections.reverse(dias);
        int cnt = 0;
        for (int k = 0; k < dias.size(); k++) {
            int tmp = dias.get(k);
            int amt=0;
            for (int i = dias.size() - 1; i >= 0; i--) {
                if (dias.get(i)>=tmp && dias.get(i)<=tmp+diff) {
                    amt++;
//                    dias.remove(i);
                }
            }
            if(amt>cnt)
                cnt = amt;
        }

//        System.out.println(cnt);
        pw.println(cnt);
        pw.close();
        f.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new diamond().run();
    }
}
