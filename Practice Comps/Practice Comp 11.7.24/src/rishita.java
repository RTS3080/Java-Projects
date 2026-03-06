import java.util.*;
import java.io.*;

public class rishita{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rishita".toLowerCase()+".dat"));
        TreeMap<String,ArrayList<Course>> unis = new TreeMap<>();
        while(f.hasNext()){
            String[] ln = f.nextLine().split(",");
            unis.putIfAbsent(ln[2], new ArrayList<>());
            unis.get(ln[2]).add(new Course(ln[1],ln[0]));
        }
        for(Map.Entry<String,ArrayList<Course>> e: unis.entrySet()){
            System.out.println(e.getKey());
            Collections.sort(e.getValue());
            for(Course c: e.getValue()){
                System.out.println(c);
            }
        }
        f.close();
    }

    class Course implements Comparable<Course>{
        String room;
        String clas;
        public Course(String room, String clas){
            this.room=room;
            this.clas=clas;
        }
        public int compareTo(Course c){
            return this.room.compareTo(c.room);
        }
        public String toString(){
            return "   "+room+"   "+clas;
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new rishita().run();
    }
}
