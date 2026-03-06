import java.util.*;
import java.io.*;
import java.awt.*;

public class BestCustomer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("BestCustomer".toLowerCase()+".dat"));
        ArrayList<Customer> customers = new ArrayList<>();
        while(f.hasNext()){
            String name = f.nextLine().trim();
            int[] days = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double spent = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).sum();
            customers.add(new Customer(name, days.length, spent));
        }
        Collections.sort(customers, Collections.reverseOrder());
        System.out.println(customers.get(0));
        f.close();
    }
    

    
    public static void main(String[] args) throws FileNotFoundException{
        new BestCustomer().run();
    }
}
class Customer implements Comparable<Customer>{
    String name;
    int amtDays;
    double totSpent;
    public Customer(String name, int amtDays, double totSpent){
        this.name = name;
        this.amtDays = amtDays;
        this.totSpent = totSpent;
    }
    public int compareTo(Customer c){
        if(this.amtDays != c.amtDays){
            return this.amtDays - c.amtDays;
        }
        return Double.compare(this.totSpent, c.totSpent);
    }
    public String toString(){
        return name;
    }
}