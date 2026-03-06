import java.util.*;
import java.io.*;
import java.awt.*;

public class ren{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ren".toLowerCase()+".dat"));
        ArrayList<person> people = new ArrayList<>();
        while(f.hasNext()){
            String firstName= f.next();
            String lastName= f.next();
            int correct = f.nextInt();
            int wrong = f.nextInt();
            int score = correct * 6 - wrong * 2;
            people.add(new person(firstName, lastName, score));
        }
        Collections.sort(people);
        System.out.println("-".repeat(30));
        System.out.println("   Name" + " ".repeat(18)+"Score");
        for (int i = 0; i < 6; i++) {
            person p = people.get(i);
            System.out.printf("%d. %-22s%5d\n", i+1, p.toString(), p.score);
        }
        System.out.println("-".repeat(30));


        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ren().run();
    }
}
class person implements Comparable<person>{
    String firstName;
    String lastName;
    int score;
    public person(String firstName, String lastName, int score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }
    public int compareTo(person p){
        if(this.score != p.score){
            return p.score - this.score;
        }
        return lastName.compareTo(p.lastName);
    }

    public String toString(){
        return lastName + ", " + firstName;
    }
}