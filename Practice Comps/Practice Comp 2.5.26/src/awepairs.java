import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class awepairs{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("awepairs".toLowerCase()+".dat"));

        while (f.hasNext()){
            String check = f.next();
            DSU dsu = new DSU();
            for (int i = 0; i < check.length(); i+=2){
                dsu.merge(check.charAt(i), check.charAt(i+1));
            }

            ArrayList<ArrayList<Character>> result = new ArrayList<>();
            result.add(new ArrayList<>());

            HashMap<Character, ArrayList<Character>> map = dsu.map;

            for (char each : map.keySet()){
                if (result.get(0).size() <= 1 + map.get(each).size()){
                    ArrayList<Character> temp = new ArrayList<>(map.get(each));
                    temp.add(0, each);

                    if (result.get(0).size() < 1 + map.get(each).size()){
                        result = new ArrayList<>();
                    }

                    result.add(temp);
                }
            }

            StringBuilder str = new StringBuilder();

            for (ArrayList<Character> each : result){
                str.append(each.toString().replaceAll("\\W", "")).append(" ");
//                System.out.println(each.toString().replaceAll("\\W", ""));
            }

            System.out.println(str.toString().trim());

        }

        f.close();
    }

    class DSU{
        int[] store;
        HashMap<Character, ArrayList<Character>> map;

        public DSU(){
            store = new int[26];
            Arrays.fill(store, -1);

            map = new HashMap<>();
            for (char i = 'A'; i <= 'Z'; i++) map.put(i, new ArrayList<>());
        }

        public int find(int ind){
            if (store[ind] == -1) return ind;
            return store[ind] = find(store[ind]);
        }

        public void merge(char parent, char child){
            int pParent = find(parent-'A');
            int pChild = find(child-'A');

            if (pParent != pChild){
                map.get((char) (pParent+'A')).add((char) (pChild+'A'));
                map.get((char) (pParent+'A')).addAll(map.get((char) (pChild+'A')));
                map.put((char) (pChild+'A'), new ArrayList<>());

                store[pChild] = pParent;
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new awepairs().run();
    }
}
