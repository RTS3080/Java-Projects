import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class shopping{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("shopping".toLowerCase()+".in"));
        int times=f.nextInt(); double duckVolume = f.nextDouble();
        ArrayList<Double> volumes =  new ArrayList<>();
        while(times-->0){
            String type=f.next();
            double l = f.nextDouble();
            double w=f.nextDouble();
            double h=f.nextDouble();
            double vol = switch(type){
                case "TRIANGLE" ->{
                    yield .5 * l * h * w;
                }
                case "SEMICIRCLE" -> {
                    yield .5 * PI * l * l * h;
                }
                case "RECTANGLE" ->{
                    yield l * h * w;
                }
                default -> 0;
            };
            volumes.add(vol);
        }
        Collections.sort(volumes, Collections.reverseOrder());
        double vol = 0;
        for (int i = 0; i < volumes.size() && i<2; i++) {
            vol+=volumes.get(i);
        }
        System.out.print((int)(vol/duckVolume));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shopping().run();
    }
}
