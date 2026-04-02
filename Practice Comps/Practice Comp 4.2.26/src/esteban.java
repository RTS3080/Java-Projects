import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class esteban{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("esteban".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            char type = f.next().charAt(0);
            double t = f.nextDouble();
            double h = f.nextDouble();
            if(type == 'C'){
                t = 9./5 * t + 32;
            }
            double tFarenheit = t;
            double hi;
            hi = -42.379 + 2.04901523*t + 10.14333127 * h - 0.22475541 * t * h
                    - 0.00683783*t*t - 0.05481717*h*h + 0.00122874*t*t*h + 0.00085282*t*h*h
                    -0.00000199*t*t*h*h;
            String add = "";
//            System.out.println(hi+" "+t+" "+h);
            if(h < 13){
                hi -=((13-h)/4) * sqrt((17-abs(t-95.))/17);
            }
            if(h > 85){
                hi +=((h-85)/10)*((87-t)/5);
            }

            if(hi > 140 || (hi < tFarenheit && h>=40) || tFarenheit<80){
                add = " INVALID";
            }

            if(type == 'C'){
                hi = 5./9 * (hi - 32);
            }
            System.out.printf("#%d:%.1f%s\n",times+1,hi,type+add);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new esteban().run();
    }
}
