import java.util.*;
import java.io.*;

public class missions{

    HashMap<String, HashSet<String>> map;
    LinkedList<String> res;

    public void dfs(String[] abilities, int ability, LinkedList<String> vis) {
        if (ability >= abilities.length) {
            String s = "";
            for (String str : vis) {
                s += str + " ";
            }
            res.add(s.trim());
            return;
        }

        for (String user : map.get(abilities[ability])) {
            if (vis.contains(user)) continue;
            vis.add(user);
            dfs(abilities, ability + 1, vis);
            vis.remove(user);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("missions".toLowerCase()+".dat"));

        map = new HashMap<>();
        map.put("Strength", new HashSet<>());
        map.put("Invulnerability", new HashSet<>());
        map.put("Hand-to-Hand", new HashSet<>());
        map.put("Teleportation", new HashSet<>());
        map.put("Swords", new HashSet<>());
        map.put("Agility", new HashSet<>());
        map.put("Flight", new HashSet<>());
        map.put("Electric", new HashSet<>());
        map.put("Cold", new HashSet<>());
        map.put("Energy-Blasts", new HashSet<>());
        map.put("Telekinesis", new HashSet<>());
        map.put("Telepathy", new HashSet<>());

        map.get("Strength").add("Colossus");
        map.get("Invulnerability").add("Colossus");
        map.get("Hand-to-Hand").add("Wolverine");
        map.get("Invulnerability").add("Wolverine");
        map.get("Teleportation").add("Nightcrawler");
        map.get("Swords").add("Nightcrawler");
        map.get("Hand-to-Hand").add("Nightcrawler");
        map.get("Agility").add("Nightcrawler");
        map.get("Flight").add("Storm");
        map.get("Electric").add("Storm");
        map.get("Cold").add("Storm");
        map.get("Flight").add("Banshee");
        map.get("Energy-Blasts").add("Banshee");
        map.get("Hand-to-Hand").add("Cyclops");
        map.get("Energy-Blasts").add("Cyclops");
        map.get("Flight").add("Phoenix");
        map.get("Telekinesis").add("Phoenix");
        map.get("Telepathy").add("Phoenix");
        map.get("Energy-Blasts").add("Phoenix");
        map.get("Cold").add("Iceman");
        map.get("Invulnerability").add("Iceman");
        map.get("Strength").add("Beast");
        map.get("Agility").add("Beast");
        map.get("Flight").add("Angel");
        map.get("Swords").add("Angel");

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] abilities = f.nextLine().trim().split("\\s+");
            res = new LinkedList<>();
            if (abilities.length == 0) {
                System.out.println(0);
                System.out.println();
                continue;
            }
            dfs(abilities, 0, new LinkedList<>());
            if (res.isEmpty()) {
                System.out.println(0);
                System.out.println();
            } else {
                Collections.sort(res);
                System.out.println(res.size());
                System.out.println(res.getFirst());
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new missions().run();
    }
}
