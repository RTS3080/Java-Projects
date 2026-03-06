import java.util.*;
import java.io.*;
class Solution {
    Set<String> airports;
    TreeMap<String, TreeSet<String>> destinations = new TreeMap<>();
    Set<String> answer;
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            for (String s : pair) {
                if (!destinations.containsKey(s)) {
                    destinations.put(s, new TreeSet<>());
                }
            }
            destinations.get(pair.get(0)).add(pair.get(1));
            destinations.get(pair.get(1)).add(pair.get(0));
        }
        System.out.println(destinations);
        airports = destinations.keySet();
        System.out.println(airports);
        TreeSet<String> starter = new TreeSet<>();
        starter.add("JFK");
        recur("JFK", starter);
        System.out.println(answer);
        return null;
    }

    public void recur(String here, TreeSet<String> visited){
        if(visited.contains(here)){
            return;
        }
        for(String s : airports){
            if(!visited.contains(s)){
                System.out.println(s);
                return;
            }
            answer = visited;
        }
        visited.add(here);
        for(String s : airports){
            recur(s,visited);
        }
    }
}
class itenerary{
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        new Solution().findItinerary(tickets);
    }
}