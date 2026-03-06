import java.util.*;
import java.io.*;

public class Ghoa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        double bal = f.nextLong();
        int children = f.nextInt();
        ArrayList<Double> price = new ArrayList<>();
        f.nextLine();
        while(children-->0){
            price.add(f.nextDouble());
        }
        Collections.sort(price);
        Collections.reverse(price);
        int cnt = 0;
        for (int i = 0; i < price.size(); i++) {
            double div=  bal/price.get(i);
            cnt+=(int)div;
            bal -= (int)(div*price.get(i));
            if (bal==0){
                break;
            }
        }
        System.out.print((int)bal+" ");
        System.out.println(cnt);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ghoa().run();
    }
}
