import java.sql.Time;
import java.util.*;
import java.io.*;

public class classes{
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("classes".toLowerCase()+".dat"));
        List<String> subjectList = new ArrayList<>(Arrays.asList("Writing","Lighting","Sound-Design","Casting","Set-Design"));
        Time[][] timeList = {{new Time(11),new Time(15)},{new Time(15), new Time(18)},{new Time(9),new Time(11)}, {new Time(18),new Time(20)},{new Time(7),new Time(9)}};

        int times=f.nextInt(); f.nextLine();
        String taken = f.nextLine();
        ArrayList<course> courseSet = new ArrayList<>();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().trim().split("\\|");
            String code = ln[0];
            String name = ln[1];
            int hours = Integer.parseInt(ln[2]);

            int subjectPos = subjectList.indexOf(ln[3]);
            double rating = Double.parseDouble(ln[4]);
            Time t = Time.valueOf(ln[5]+":0");
            int timeSpot = -1;
            for (int i = 0; i < timeList.length; i++) {
                Time[] ts = timeList[i];
                if(t.compareTo(ts[0])>0 && t.compareTo(ts[1])<0){
                    timeSpot = i;
                }
            }
            String[] prerequisites = ln[6].split(", ");
            for(String p : prerequisites){
                if(!taken.contains(p)){
                    continue timeloop;
                }
            }
            courseSet.add(new course(code, name, hours, subjectPos, rating, timeSpot));
        }

        Collections.sort(courseSet);
        int totHours = 0;
        for(course c : courseSet){

            if((totHours+=c.hours)>=21) break;
            System.out.println(c);

        }
        f.close();
    }

    class course implements Comparable<course>{
        String code;
        String name;
        int hours;
        int subjectPos;
        double profRating;
        int timePos;
        public course(String code, String name, int hours, int subjectPos, double profRating, int timePos){
            this.code = code;
            this.name = name;
            this.hours = hours;
            this.subjectPos = subjectPos;
            this.profRating = profRating;
            this.timePos = timePos;
        }
        public int compareTo(course o){
            if(subjectPos!=o.subjectPos) return subjectPos-o.subjectPos;
            if(profRating!=o.profRating){
                if(profRating>o.profRating) return -1;
                return 1;
            }
            if(timePos!=o.timePos) return o.timePos-timePos;
            if(hours!=o.hours) return hours-o.hours;
            return code.compareTo(o.code);
        }
        public String toString(){
//            System.out.println(code+" "+name+" "+hours+" "+subjectPos+" "+profRating+" "+timePos);
            return code+": "+name;
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new classes().run();
    }
}
