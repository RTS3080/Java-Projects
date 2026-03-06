import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class ballistic{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        final double g = -9.8;
        //Scanner f = new Scanner(new File("ballistic".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double x0Def = f.nextDouble();
            double y0Def = f.nextDouble();
            double v0Def = f.nextDouble();
            double thetaDef = toRadians(f.nextDouble());
            double x0Thr = f.nextDouble();
            double y0Thr = f.nextDouble();
            double v0Thr = f.nextDouble();
            double thetaThr = toRadians(f.nextDouble());

            double determinantDef = sqrt(pow(v0Def*sin(thetaDef), 2) - 2 * g * y0Def);
            double a1Def = (v0Def + determinantDef)/g;
            double a2Def = (v0Def - determinantDef)/g;
            double xT1Def = v0Def*cos(thetaDef)*a1Def + x0Def;
            double xT2Def = v0Def*cos(thetaDef)*a2Def + x0Def;
            double yT1Def = .5 * g * pow(a1Def, 2) + v0Def * sin(thetaDef)*a1Def + y0Def;
            double yT2Def = .5 * g * pow(a2Def, 2) + v0Def * sin(thetaDef)*a2Def + y0Def;

//            double determinantThr = sqrt(pow(v0Thr*sin(thetaThr), 2) - 2 * g * y0Thr);
//            double a1Thr = (v0Thr + determinantThr)/g;
//            double a2Thr = (v0Thr - determinantThr)/g;
//            double xT1Thr = v0Thr*cos(thetaThr)*a1Thr + x0Thr;
//            double xT2Thr = v0Thr*cos(thetaThr)*a2Thr + x0Thr;
//            double yT1Thr = .5 * g * pow(a1Thr, 2) + v0Thr * sin(thetaThr) * a1Thr + y0Thr;
//            double yT2Thr = .5 * g * pow(a2Thr, 2) + v0Thr * sin(thetaThr) * a2Thr + y0Thr;
            double xt = g * (pow(x0Thr, 2) -pow(x0Def, 2)) - tan(thetaThr)*x0Thr + tan(thetaDef)*x0Def - y0Thr + y0Def;
            xt/=tan(thetaDef)-tan(thetaThr)-2 *g * (x0Thr-x0Def);
            double t = (xt - x0Def) / (v0Def * cos(thetaDef));
            double y = .5 * g *pow(t,2) + v0Def * sin(thetaDef)*t + y0Def;
            boolean ok = true;
            if(!((xt <=x0Def && xt >= x0Thr) || (xt <=x0Thr && xt >= x0Def))){
                ok = false;
            }
            if(y < 0){
                ok = false;
            }
            System.out.println(t);
            System.out.println(ok);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ballistic().run();
    }
}
