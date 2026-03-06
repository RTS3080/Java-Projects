import java.util.*;
import java.io.*;

public class cyclops{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cyclops".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<Integer> strengths = new ArrayList<>();
            int n=f.nextInt();
            f.nextInt();
            int pow = f.nextInt();
            for (int i = 0; i < n; i++) {
                char[] chs = f.next().toCharArray();
                for (char c : chs) {
                    strengths.add(c - '0');
                }
            }

            Collections.sort(strengths);
//            System.out.println(strengths);
            int spot = strengths.size()/2;
            if(strengths.size()%2==1){
                spot++;
            }

            for(int i=0; i<spot; i++){
                pow-=strengths.get(i);
            }
            System.out.println(pow<0 ? "Better Call Iceman." : "Made it with "+pow+" power to spare.");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cyclops().run();
    }
}
