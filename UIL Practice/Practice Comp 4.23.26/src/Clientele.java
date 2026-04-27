import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Clientele{
    class Person implements Comparable<Person>{
        String name;
        double companyWorth;
        int positionIndex;
        int height;
        public Person(String name, double companyWorth, int positionIndex, int height){
            this.name = name;
            this.companyWorth = companyWorth;
            this.positionIndex = positionIndex;
            this.height = height;
        }
        public int compareTo(Person p){
            if(this.companyWorth != p.companyWorth){
                return -Double.compare(this.companyWorth, p.companyWorth);
            }
            if(this.positionIndex != p.positionIndex){
                return Integer.compare(this.positionIndex, p.positionIndex);
            }
            if(this.height != p.height){
                return Integer.compare(this.height, p.height);
            }
            return name.compareTo(p.name);
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Clientele".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();
        int numCompanies = f.nextInt();
        HashMap<String, Double> companies = new HashMap<>();
        f.nextLine();
        while(numCompanies-->0){
            String[] ln = f.next().split(":");
            companies.put(ln[0], Double.parseDouble(ln[1]));
        }
        ArrayList<String> positions = new ArrayList(Arrays.asList("CEO CFO CTO VP Manager".split(" ")));
        for(int times = 0; times < numTimes; times++){
            int times2=f.nextInt(); f.nextLine();
            ArrayList<Person> ppl = new ArrayList<>();
            while(times2-->0){
                String[] ln = f.nextLine().split(" ");
                String name = ln[0]+" "+ln[1];
                String position = ln[2];
                String company = ln[3];
                if(position.equals("COO")) position="CFO";
                if(position.equals("CPO")) position="CTO";
                int positionInd = positions.indexOf(position);
                double companyWorth = companies.get(company);
                int height = Integer.parseInt(ln[4]);
                ppl.add(new Person(name, companyWorth, positionInd, height));
            }
            Collections.sort(ppl);
            String res = "";
            for(Person p: ppl){
                res += p.name + ", ";
            }
            System.out.println(res.substring(0, res.length()-2));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Clientele().run();
    }
}
