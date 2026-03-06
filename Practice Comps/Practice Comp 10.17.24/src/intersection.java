import java.util.*;
import java.io.*;

public class intersection{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("intersection".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            List<ArrayList<String>> sets = new ArrayList<>();
            int n=f.nextInt(); f.nextLine();
            for (int i = 0; i < n; i++) {
                sets.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split(" ");
                for(String s : ln){
                    sets.get(i).add(s);
                }
            }
            Set<Integer> allIn = new TreeSet<>();
            for(ArrayList<String> set : sets){
                for(String s : set){
                    boolean canAdd = true;
                    for(ArrayList<String> al : sets){
                        if(!al.contains(s)){
                            canAdd = false;
                        }
                    }
                    if(canAdd){
                        allIn.add(Integer.parseInt(s));
                    }
                }
            }
//            System.out.println(allIn);
            if(allIn.isEmpty()){
                System.out.println("NO COMMON ELEMENT FOUND");
            }
            else {
                for(Integer s : allIn){
                    System.out.print(s+" ");
                }
                System.out.println();
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new intersection().run();
    }
}
