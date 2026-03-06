import java.util.*;
import java.io.*;
import java.awt.*;

public class Liza{
    class Student {
        String first;
        String last;
        int grade;

        public Student(String[] data) {
            first = data[1].trim();
            last = data[0].trim();
            grade = Integer.parseInt(data[2].trim());
        }
        public String toString() {
            return first + " " + last + ": " + grade;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Liza".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine());
            Student[] students = new Student[f.nextInt()];
            f.nextLine();
            for (int i = 0; i < students.length; i++) {
                students[i] = new Student(f.nextLine().trim().split(","));
            }

            Arrays.sort(students, (a, b) -> {
                if (a.grade != b.grade) {
                    return b.grade - a.grade;
                }

                if (a.last.compareTo(b.last) != 0) {
                    return a.last.compareTo(b.last);
                }

                return a.first.compareTo(b.first);
            });

            double avg = 0;
            for (Student student : students) {
                avg += student.grade;
            }

            avg /= students.length;
            double med = students[students.length / 2].grade;
            if (students.length % 2 == 0) {
                med = (med + students[students.length / 2 - 1].grade) / 2;
            }

            System.out.println(students[0]);
            System.out.println(students[1]);
            System.out.println(students[2]);
            System.out.printf("MEAN SCORE: %.2f%nMEDIAN SCORE: %.1f%n", avg, med);
            if(times!=0) {
                System.out.println();
            }
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Liza().run();
    }
}
