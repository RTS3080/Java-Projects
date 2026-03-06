import java.util.*;
import java.io.*;

public class Concordance{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Concordance".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();

        Map<String, ArrayList<Integer>> words = new TreeMap<>();
        for(int i = 1; i <= times; i++){
            String[] ln = f.nextLine().split(" ");
            for(String s : ln){
                if(!words.containsKey(s)){
                    words.put(s, new ArrayList<>());
                }
                words.get(s).add(i);
            }
        }
        for(Map.Entry<String, ArrayList<Integer>> e : words.entrySet()){
            System.out.printf("%-11s",e.getKey());
            for(Integer i : e.getValue()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Concordance().run();
    }
}
