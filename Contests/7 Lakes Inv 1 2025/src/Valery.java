import java.util.*;
import java.io.*;

public class Valery{

    ArrayList<String> valid;
    HashSet<String> invalid;
    HashMap<String,ArrayList<String>> post;
    HashMap<String,ArrayList<String>> del;
    ArrayList<String> order;


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Valery".toLowerCase()+".dat"));

        int k = f.nextInt();
        f.nextLine();
        for (int x = 0; x < k; x++) {
            String ke = f.next();
            int p = f.nextInt();
            f.nextLine();
            valid.add(ke);
            for (int i = 0; i < p; i++) {
                String name = f.next();
                post.putIfAbsent(name, new ArrayList<>());
                invalid.add(name);
                post.get(name).add(ke);
                del.putIfAbsent(name, new ArrayList<>());
                del.get(ke).add(name);
            }
        }

        for (int i = 0; i < valid.size(); i++) {
            if (invalid.contains(valid.get(i))){
                valid.remove(i);
            }
        }
        Collections.sort(valid);
        while (!valid.isEmpty()){
            recur(valid.get(0));
            valid.remove(0);
        }
        for (int i = 0; i < order.size()-1; i++) {
            System.out.print(order.get(i)+"->");
        }
        System.out.println(order.get(order.size()-1));

        f.close();
    }

    public void recur (String cur){
        valid.remove(0);
        for (int i = 0; i < del.get(cur).size(); i++) {
            String tar = del.get(cur).get(i);
            post.get(tar).remove(cur);
            if (post.get(tar).isEmpty()){
                valid.add(tar);
                order.add(tar);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Valery().run();
    }
}
