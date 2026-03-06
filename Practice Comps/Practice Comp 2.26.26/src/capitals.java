import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class capitals{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("capital".toLowerCase()+".in"));
        String[] countries = "Ireland Portugal Andorra Switzerland Belgium Austria Malta Sweden Vatican Greece Monaco UK Spain France Liechtenstein Germany Italy Norway Denmark Hungary Finland Bosnia_Herzegovina".split(" ");
        String[] capitals = "Dublin Lisbon Andorra Bern Brussels Vienna Valletta Stockholm Vatican_City Athens Monaco London Madrid Paris Vaduz Berlin Rome Oslo Copenhagen Budapest Helsinki Sarajevo".split(" ");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < countries.length; i++) {
            String country = countries[i].replaceAll("_", " ");
            String capital = capitals[i].replaceAll("_", " ");
            map.put(country, capital);
            map.put(capital, country);
        }
        while(f.hasNext()){
            String ln = f.nextLine().trim();
            ln = ln.substring(20, ln.length()-1);
            String[] places = ln.split(" is ");
            String country = places[0].trim();
            String capital = places[1].trim();
            if(country.contains("_")){
                country = map.get(capital);
            }
            if(capital.contains("_")){
                capital = map.get(country);
            }
            System.out.printf("The capital city of %s is %s.\n",country,capital);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new capitals().run();
    }
}
