import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class emergency{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("emergency".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int numPatients = f.nextInt();
            int target = f.nextInt();
            f.nextLine();

            ArrayList<Patient> beforePatients = new ArrayList<>();

            for (int i = 0; i < numPatients; i++){
                Scanner inF = new Scanner(f.nextLine());

                int time = convert(inF.next());
                beforePatients.add(new Patient(inF.nextInt(), time));
            }

            int totalDoctors = 3;

            ArrayList<Integer> doctors = new ArrayList<>();


            for (int i = 0; i < 50*60; i++){

                boolean loop = false;
                do {
                    for (int j = doctors.size() - 1; j >= 0; j--) {
                        if (doctors.get(j) == i) doctors.remove(j);
                    }

                    int availableDoctors = totalDoctors - doctors.size();

                    PriorityQueue<Patient> waitingPatients = new PriorityQueue<>();
                    for (Patient p : beforePatients) {
                        if (p.enterTime <= i) {
                            p.filled = p.severity < 8 || (p.enterTime + 5) <= i;

                            if (p.filled) waitingPatients.add(p);
                        }
                    }

                    while (!waitingPatients.isEmpty() && availableDoctors > 0) {
                        Patient cur = waitingPatients.poll();
                        doctors.add(cur.severity * 8);
                        beforePatients.remove(cur);
                        availableDoctors--;
                    }


                    for (Patient p : waitingPatients) {
                        if (i - p.enterTime > target){
                            totalDoctors++;
                            loop = true;
                            break;
                        }
                    }
                } while (loop);

                System.out.println(totalDoctors);

                System.out.println(i);
                System.out.println(doctors);
                System.out.println(beforePatients);
//                while (!waitingPatients.isEmpty()){}

            }

            System.out.println(beforePatients);
        }

        f.close();
    }

    public int convert(String input){
        String[] split = input.split(":");
        return Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
    }

    int timer;

    class Patient implements Comparable<Patient>{
        int severity;
        int enterTime;

        boolean filled;

        public Patient(int severity, int enterTime){
            this.severity = severity;
            this.enterTime = enterTime;
            this.filled = false;
        }

        public int compareTo(Patient p){
            if (p.filled != p.filled){
                if (p.filled) return -1;
                else return 1;
            }

            if (p.severity != this.severity) return this.severity - p.severity;
            return enterTime - p.enterTime;
        }

        public String toString(){
            return severity + ":" + enterTime;
        }

        public boolean equals(Object o){
            return severity == ((Patient)o).severity && enterTime == ((Patient)o).enterTime && filled == ((Patient)o).filled;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new emergency().run();
    }
}
