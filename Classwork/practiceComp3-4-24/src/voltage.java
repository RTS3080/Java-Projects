import java.util.*;
import java.io.*;

public class voltage{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("voltage".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<Character,Double> vals=new HashMap<>();
            double I=0,V=0,R=0,P=0;
            String stuff = "VIRP";
            String here="";
            for (int j = 0; j < 2; j++) {
                String[] fir=f.nextLine().split(" ");
                for (int i = 0; i < stuff.length(); i++) {
                    if (fir[0].charAt(0) == stuff.charAt(i)) {
                        here += stuff.charAt(i);
                        vals.put(stuff.charAt(i), Double.parseDouble(fir[fir.length-1]));
//                        System.out.println(stuff.charAt(i)+" "+Double.parseDouble(fir[fir.length-1]) + "q");
                    }
                }
            }
            if(here.equals("IR") || here.equals("RI")){
                I=vals.get('I');
                R=vals.get('R');
                V=I*R;
                P=I*V;
            }
            else if(here.equals("IV") || here.equals("VI")){
                I=vals.get('I');
                V=vals.get('V');
                P=I*V;
                R=V/I;
            }
            else if (here.equals("IP") || here.equals("PI")){
                P=vals.get('P');
                I=vals.get('I');
                V = P / I;
                R = V / I;
            }
            else if (here.equals("RV")|| here.equals("VR")){
                R=vals.get('R');
                V=vals.get('V');
                I=V/R;
                P=I*V;
            }
            else if (here.equals("VP") || here.equals("PV")){
                V=vals.get('V');
                P=vals.get('P');
                I=P/V;
                R=V/I;
            }
            else{
                R=vals.get('R');
                P=vals.get('P');
                I=Math.sqrt(P/R);
                V=I*R;
            }

            System.out.printf("V = %.3f, I = %.3f, R = %.3f, P = %.3f\n",V,I,R,P);
        }
        f.close();
    }
}
