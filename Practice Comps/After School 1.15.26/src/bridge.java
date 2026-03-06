import java.util.*;
import java.io.*;
import java.awt.*;

public class bridge {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("bridge".toLowerCase() + ".dat"));

        long numEntries = f.nextLong();
        long numQueries = f.nextLong();

        HashMap<Long, ArrayList<Long>> survived = new HashMap<>();
        ArrayList<Long>[] superheroes = new ArrayList[2];
        ArrayList<Long>[] swans = new ArrayList[2];
        ArrayList<Long>[] mapmakers = new ArrayList[2];


        for (int i = 0; i < 2; i++) {
            superheroes[i] = new ArrayList<>();
            swans[i] = new ArrayList<>();
            mapmakers[i] = new ArrayList<>();
        }

        ArrayList<Long> total = new ArrayList<>();

        for (int i = 0; i < numEntries; i++) {
            long incursion = f.nextLong();
            long[] unis = new long[]{f.nextLong(), f.nextLong()};
            long winner = f.nextLong();
            boolean superhero = f.next().equals("true");
            boolean swan =  f.next().equals("true");
            boolean mapmaker =  f.next().equals("true");

            total.add(incursion);

            for (int j = 0; j < unis.length; j++) {
                if (winner == unis[j]) {
                    if (!survived.containsKey(unis[j])) survived.put(unis[j], new ArrayList<>());
                    survived.get(unis[j]).add(incursion);
                }
            }

            superheroes[superhero ? 1 : 0].add(incursion);
            swans[swan ? 1 : 0].add(incursion);
            mapmakers[mapmaker ? 1 : 0].add(incursion);
        }

        for (int i = 0; i < numQueries; i++) {
            String query_type = f.next().trim();

            f.next();

            String[] criterias = (f.nextLine().trim()).split(",?\\s+");
            ArrayList<Long> result = new ArrayList<>(total);
            for (String each : criterias) {
                String[] query = each.split("=");

                switch (query[0]) {
                    case "WINNER":
                        long survivor = Long.parseLong(query[1]);
                        result.retainAll(survived.get(survivor));
                        break;

                    case "SUPERHEROES":
                        boolean superhero = Boolean.parseBoolean(query[1]);
                        result.retainAll(superheroes[superhero ? 1 : 0]);
                        break;
                    case "SWANS":
                        boolean swan = Boolean.parseBoolean(query[1]);
                        result.retainAll(swans[swan ? 1 : 0]);
                        break;
                    case "MAPMAKERS":
                        boolean mapmaker = Boolean.parseBoolean(query[1]);
                        result.retainAll(mapmakers[mapmaker ? 1 : 0]);
                        break;
                }
            }

            if (result.isEmpty()) {
                System.out.println("Doom is upon us.");
            }

            else {
                switch (query_type) {
                    case "COUNT":
                        System.out.println(result.size());
                        break;

                    case "SELECT":
                        Collections.sort(result);
                        System.out.println(("" + result).replaceAll("[\\[\\],]", ""));
                }
            }
        }

        long max = 0;
        long result = 0;

        for (Long each : survived.keySet()){
            if (max < survived.get(each).size()){
                max = survived.get(each).size();
                result = each;
            }
        }

        System.out.println(result);

        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new bridge().run();
    }
}
