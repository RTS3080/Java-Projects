import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class gpa{
    class course{
        int id;
        boolean honors;
        int credits;
        public course(int id, boolean honors, int credits){
            this.id = id;
            this.honors = honors;
            this.credits = credits;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gpa".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        HashMap<Integer, course> courses = new HashMap<>();
        while(times-->0){
            int id = f.nextInt();
            boolean honors = f.next().equals("YES");
            String courseLen = f.next();
            int credits = 0;
            if(courseLen.equals("YEAR")){
                credits = 4;
            }
            else if(courseLen.equals("SEMESTER")){
                credits = 2;
            }
            else if(courseLen.equals("QUARTER")){
                credits = 1;
            }
            courses.put(id, new course(id, honors, credits));
        }
        String best = "";
        double maxGPA = 0;
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            int numCredits = 0;
            double GPA = 0;
            String name = ln[0];
            for(int i=1;i<ln.length;i+=2){
                double grade = evaluateGrade(ln[i]);
                int id = Integer.parseInt(ln[i+1]);
                course c = courses.get(id);
                if(grade >= 2.25 && c.honors){
                    grade+=.5;
                }
                GPA += grade * c.credits;
                numCredits+=c.credits;
            }
            GPA /= numCredits;
            System.out.printf("%s %.3f\n", name, GPA);
            if(GPA > maxGPA){
                maxGPA = GPA;
                best = name;
            }
        }
        System.out.println(best);
        f.close();
    }

    double evaluateGrade(String grade){
        char[] ch = grade.toCharArray();
        double val=switch(ch[0]){
            case 'A' -> 4.5;
            case 'B' -> 3.5;
            case 'C' -> 2.5;
            case 'D' -> 1;
            default -> 0;
        };
        if(grade.matches(".[+\\-]")){
//            System.out.println("hello?");
            val += ch[1] == '+' ? .25 : -.25;
        }
        return val;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new gpa().run();
    }
}

