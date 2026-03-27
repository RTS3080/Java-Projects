import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jared{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jared".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int maxLen = 0;
            String[] ln = f.nextLine().split(",");
            Map<String, HashSet<String>> graph = new TreeMap<>();
            graph.put(" ", new HashSet<>());
            for (int i = 0; i < ln.length; i++) {
                maxLen = max(maxLen, ln[i].length());
                char[] ch = ln[i].toCharArray();
                graph.get(" ").add(ch[0]+"");
                graph.putIfAbsent(ch[0]+"", new HashSet<>());
                String s = ""+ch[0];
                for (int j = 1; j < ch.length; j++) {
                    s+=ch[j];
                    graph.putIfAbsent(s, new HashSet<>());
                    graph.get(s.substring(0, s.length()-1)).add(s);
                }
                graph.get(s).add(""+(char)('a'+i));
            }
            int numWrong = 0;
            TreeMap<String, Integer> wrongCounts = new TreeMap<>();
            for(int i = maxLen;i>0;i--){
                for(Map.Entry<String, HashSet<String>> e : graph.entrySet()){
                    if(e.getKey().length()==i){
                        int numStat = 0;
                        boolean hasDir = false;
                        for(String s : e.getValue()){
                            if(s.equals(s.toLowerCase())){
                                numStat++;
                            }
                            else{
                                hasDir = true;
                            }
                        }
                            wrongCounts.put(e.getKey(), numStat);
                    }

                }
            }
            System.out.println("Graph: "+graph);
            System.out.println("Wrong Counts: "+wrongCounts);
            if(numWrong == 0){
                System.out.println("Democracy Prevails!");
            }
            else{
                System.out.printf("There are %d misinputs...\n", numWrong);
            }
        }
        f.close();
    }




    public static void main(String[] args) throws FileNotFoundException{
        new jared().run();
    }
}
