import java.util.*;
import java.io.*;

public class Sunny{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Sunny".toLowerCase()+".dat"));
        ArrayList<Course> courses = new ArrayList<Course>();
        while(f.hasNext()){
            String room = f.next();
            String courseName = f.nextLine().substring(1);
            courses.add(new Course(courseName, room));
        }
        Collections.sort(courses);
        for(Course c: courses){
            System.out.println(c);
        }
        f.close();
    }
    class Course implements Comparable<Course>{
        String clas;
        String room;
        public Course(String clas, String room){
            this.clas = clas;
            this.room = room;
        }
        public String toString(){
            return clas + " ("+room+")";
        }
        public int compareTo(Course c){
            return this.clas.compareTo(c.clas);
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Sunny().run();
    }
}
