import java.util.*;
import java.io.*;
import java.awt.*;

public class legion{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("legion".toLowerCase()+".dat"));

        HashMap<String, ArrayList<Legion>> map= new HashMap<>();

        int N = f.nextInt();
        int M = f.nextInt();

        f.nextLine();

        for (int i = 0; i < N; i++) {
            String[] line = f.nextLine().trim().split("\\s+");
            Legion temp = new Legion(line[0], line[1], line[2]);

            for (int j = 3; j < line.length; j++) {
                if (!map.containsKey(line[j])) map.put(line[j], new ArrayList<>());
                map.get(line[j]).add(temp);
            }
        }

        for (int i = 0; i < M; i++) {
            String[] line = f.nextLine().trim().split("\\s+");
            TreeSet<Legion> founders = new TreeSet<>();
            TreeSet<Legion> nonfounders = new TreeSet<>();

            for (String each:line){
                for (Legion legion:map.get(each)){
                    if (legion.founder) founders.add(legion);
                    else nonfounders.add(legion);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Legion each:founders){
                sb.append(each.name).append(" ");
            }
            for (Legion each:nonfounders){
                sb.append(each.name).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

        f.close();
    }

    class Legion implements Comparable<Legion>{
        String name;
        GregorianCalendar date;
        boolean founder;

        public Legion(String name, String date, String founder){
            this.name = name;

            String[] split = date.split("-");
            this.date = new GregorianCalendar();
            this.date.set(Integer.parseInt(split[2]), Integer.parseInt(split[0])-1, Integer.parseInt(split[1]));

            this.founder = Boolean.parseBoolean(founder);
        }

        public int compareTo(Legion o){
            if (founder != o.founder) return founder ? -1 : 1;
            if (date.compareTo(o.date) != 0) return date.compareTo(o.date);
            return name.compareTo(o.name);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new legion().run();
    }
}
