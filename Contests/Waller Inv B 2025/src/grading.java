import java.util.*;
import java.io.*;

public class grading{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("grading".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();

        HashMap<String, ArrayList<Double>> grades = new HashMap<>();
        while(times-->0){
            char[] key = f.next().toCharArray();
            int ppl = f.nextInt(); f.nextLine();

            for(int abcd = 0; abcd < ppl; abcd++){
                String name = f.next();
                char[] ans = f.next().toCharArray();
                double correct = 0;
                for (int i = 0; i < ans.length; i++) {
                    if(ans[i] == key[i]){
                        correct++;
                    }
                }
                grades.putIfAbsent(name, new ArrayList<>());
                grades.get(name).add(correct/ans.length);
            }
        }
        ArrayList<person>  people = new ArrayList<>();
        for(Map.Entry<String, ArrayList<Double>> e: grades.entrySet()){
            people.add(new person(e.getKey(), e.getValue()));
        }
        Collections.sort(people,Collections.reverseOrder());
        for (int i = 0; i < people.size(); i++) {
            System.out.print("#"+(i+1)+": "+people.get(i).name+", ");
            for(int j = 0; j < people.get(i).tests.size(); j++){
                System.out.printf("%.2f ",people.get(i).tests.get(j)*100);
            }
            System.out.println();
        }
        f.close();
    }
    class person implements Comparable<person>{
        String name;
        ArrayList<Double> tests;
        double grade;
        public person(String name, ArrayList<Double> tests){
            this.name = name;
            this.tests = tests;
            Collections.sort(tests,Collections.reverseOrder());
            for (int i = 0; i < tests.size(); i++) {
                grade+=tests.get(i);
            }
            grade/=tests.size();
        }
        public int compareTo(person p){
            if(grade > p.grade) return 1;
            else if(grade < p.grade) return -1;
            return name.compareTo(p.name);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new grading().run();
    }
}
