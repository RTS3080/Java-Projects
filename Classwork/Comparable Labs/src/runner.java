import java.util.*;
import java.io.*;

public class runner{

    public void run() throws FileNotFoundException{
        TreeSet<len> lens = new TreeSet<>();
        String strs = "HI HIS sndif sdjflsdjfsj";
        for(String s : strs.split(" ")){
            lens.add(new len(s));
        }
        System.out.println(lens);

        TreeSet<vows> vowss = new TreeSet<>();
        strs = "a sdfdsf saaaaeriu aeiuo kajflhk";
        for(String s : strs.split(" ")){
            vowss.add(new vows(s));
        }
        System.out.println(vowss);

        TreeSet<odds> oddss = new TreeSet<>();
        String ints = "1 2423 545647 6786854";
        for(String s : ints.split(" ")){
            oddss.add(new odds(Integer.parseInt(s)));
        }
        System.out.println(oddss);

        TreeSet<sum> sums = new TreeSet<>();
        for(String s : ints.split(" ")){
            sums.add(new sum(Integer.parseInt(s)));
        }
        System.out.println(sums);

        String as = "1 1 17 63 63";
        String ws = "23 205 255 229 229";
        String hs = "2.2 5.6 5.4 6.2 9.6";
        int[] ages = Arrays.stream(as.split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] weights = Arrays.stream(ws.split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] heights = Arrays.stream(hs.split(" ")).mapToDouble(Double::parseDouble).toArray();
        TreeSet<Person> people = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(ages[i], weights[i], heights[i]));
        }
        System.out.println(people);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new runner().run();
    }
}
