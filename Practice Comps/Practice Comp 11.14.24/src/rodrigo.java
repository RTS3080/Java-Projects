import java.util.*;
import java.io.*;

public class rodrigo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rodrigo".toLowerCase()+".dat"));

        int numCities = f.nextInt();
        int numFlights = f.nextInt();
        int totalMoney = f.nextInt();

        HashMap<String, City> map = new HashMap<String, City>();
        ArrayList<String> cities = new ArrayList<>();

        cities.add("Dallas");

        for (int i = 0; i < numCities; i++){
            String city = f.next();
            double touristRate = f.nextDouble();
            double price = f.nextDouble();
            double attractions = f.nextDouble();
            double culiRate = f.nextDouble();
            cities.add(city);
            map.putIfAbsent(city, new City(city, touristRate, price, attractions, culiRate));
        }

        int[][] adjMatrix = new int[cities.size()][cities.size()];
        for (int[] each:adjMatrix) Arrays.fill(each, -1);

        for (int i = 0; i < numFlights; i++){
            String city1 = f.next();
            String city2 = f.next();
            int cost = f.nextInt();
            adjMatrix[cities.indexOf(city1)][cities.indexOf(city2)] = cost;
            adjMatrix[cities.indexOf(city2)][cities.indexOf(city1)] = cost;
        }

        int[] visited = new int[cities.size()];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[cities.indexOf("Dallas")] = 0;

        TreeSet<City> result = new TreeSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(cities.indexOf("Dallas")); q.offer(0);

        while(!q.isEmpty()){
            int ind = q.poll();
            int cost = q.poll();

            for (int i = 0; i < cities.size(); i++){
                if (adjMatrix[ind][i] != -1 && cost+adjMatrix[ind][i] <= totalMoney && cost+adjMatrix[ind][i] < visited[i]){
                    visited[i] = cost+adjMatrix[ind][i];
                    result.add(map.get(cities.get(i)));
                    q.offer(i); q.offer(cost+adjMatrix[ind][i]);
                }
            }
        }
        int ind = 1;
        for (City each:result){
            System.out.println(ind+": "+each);
            ind++;
        }
        f.close();
    }

    class City implements Comparable<City>{
        String name;
        double touristRate, price, attractions, culiRate;
        public City(String name, double touristRate, double price, double attractions, double culiRate){
            this.name = name;
            this.touristRate = touristRate;
            this.price = price;
            this.attractions = attractions;
            this.culiRate = culiRate;
        }

        public int compareTo(City other){
            if (attractions == other.attractions){
                if (culiRate == other.culiRate){
                    if (price == other.price){
                        if (touristRate == other.touristRate){
                            return name.compareTo(other.name);
                        }
                        return Double.compare(other.touristRate, touristRate);
                    }
                    return Double.compare(price, other.price);
                }
                return Double.compare(other.culiRate, culiRate);
            }
            return Double.compare(other.attractions, attractions);
        }

        public String toString(){
            return name;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rodrigo().run();
    }
}
