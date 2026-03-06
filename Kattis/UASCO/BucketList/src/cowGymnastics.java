import java.util.*;
import java.io.*;

public class cowGymnastics{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Gymnastics".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("Gymnastics".toLowerCase()+".out"));
        int times=f.nextInt();
        int c = f.nextInt();
        ArrayList<Integer>[] places = new ArrayList[c+1];
//        Arrays.fill(places,new ArrayList<Integer>());
        for(int i=1;i<=c;i++)
            places[i]=new ArrayList<>();
        while(times-->0){
//            int[] ranks = new int[c];

            for (int i = 0; i < c; i++) {
//                System.out.println(Arrays.toString(places));
                int spot = f.nextInt();
                places[spot].add(i);
//                System.out.println(places[spot]);
//                System.out.println(spot+" "+i);
            }
        }
        int cnt=0;
        for (int i = 1; i < places.length; i++) {

            for(int j = i+1;j<places.length;j++){
                boolean greater = true;
                boolean smaller = true;
                for (int k = 1; k < places[i].size(); k++) {
                    if(!(places[i].get(k)>places[j].get(k)
                            && places[i].get(k-1)>places[j].get(k-1))){
                        greater = false;
//                        System.out.println("greater "+i+" "+j+" "+k);
                    }
                    if(!(places[i].get(k)<places[j].get(k)
                            && places[i].get(k-1)<places[j].get(k-1))) {
                        smaller = false;
//                        System.out.println("smaller "+i+" "+j+" "+k);
                    }
                }
                if(greater || smaller)
                    cnt++;
            }
        }
        pw.println(cnt);

        pw.close();
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new cowGymnastics().run();
    }
}
