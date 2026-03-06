import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class adding{
    class Printer{
        char id;
        double density;
        double mass;
        public Printer(char id, double density, double mass){
            this.id = id;
            this.density = density;
            this.mass = mass;
        }
    }
    class job implements Comparable<job>{
        Printer printer;
        double volume;
        double infill;
        double massUsed;
        public job(Printer printer, double volume, double infill){
            this.printer = printer;
            this.volume = volume;
            this.infill = infill;
            massUsed = volume * infill * printer.density;
        }
        public int compareTo(job o){
            return Double.compare(massUsed, o.massUsed);
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("adding".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numPrinters = f.nextInt();
            int numJobs = f.nextInt();
            Printer[] printers = new Printer[numPrinters];
            job[] jobs = new job[numJobs];
            for (int i = 0; i < numPrinters; i++) {
                char id = f.next().charAt(0);
                double density = f.nextDouble();
                double mass = f.nextDouble();
                printers[i] = new Printer(id,density,mass);
            }
            for (int i = 0; i < numJobs; i++) {
                char printerId = f.next().charAt(0);
                double volume = f.nextDouble();
                double infill = f.nextDouble();
                Printer printer=null;
                for(Printer p : printers){
                    if(p.id == printerId){
                        printer = p;
                    }
                }
                jobs[i] = new job(printer,volume,infill);
            }
            int count = 0;
            for (int i = 0; i < jobs.length; i++) {
                job j = jobs[i];
//                System.out.println(j.massUsed);
                count = (int)(j.printer.mass/j.massUsed);
                System.out.println(count);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new adding().run();
    }
}
