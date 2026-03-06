import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class brady{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("brady".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int N = f.nextInt(); int Q = f.nextInt();
            f.nextLine();
            String[] words = f.nextLine().toLowerCase().trim().split("\\s+");

            for (int z = 0; z < Q; z++) {
                String[] context = f.nextLine().toLowerCase().trim().split(" +");

                TreeMap<String, Integer> map = new TreeMap<String, Integer>();

                outer:
                for (int i = 0; i < words.length - N + 1; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (!words[i + j].equals(context[j])) {
                            continue outer;
                        }
                    }

                    String word = words[i + N - 1];
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }

                String res = "unknown";
                for (String word : map.keySet()) {
                    if (map.get(word) > map.getOrDefault(res, 0)) {
                        res = word;
                    }
                }
                System.out.println(res);
            }
        }
        f.close();

//        Scanner f = new Scanner(new File("brady.dat"));
//        int cases = f.nextInt();
//        while (cases-- > 0) {
//            int N = f.nextInt();
//            int Q = f.nextInt();
//            f.nextLine();
//
//            String[] data = f.nextLine().toLowerCase().trim().split("\\s+");
//
//            while (Q-- > 0){
//                String[] query = f.nextLine().toLowerCase().trim().split("\\s+");
//
////                System.out.println(Arrays.toString(query));
//
//                TreeMap<String, Integer> map = new TreeMap<>();
//
//                loop:
//                for (int i = N-1; i < data.length; i++){
//                    for (int j = 1; j <= N-1; j++){
//                        String dataCheck = data[i-j];
//                        String queryCheck = query[query.length-j];
//
////                        System.out.println(dataCheck+" "+queryCheck);
//                        if (!dataCheck.equals(queryCheck)) continue loop;
//                    }
//
//                    if (!map.containsKey(data[i])) map.put(data[i], 0);
//                    map.put(data[i], map.get(data[i]) + 1);
//                }
//
//                if (map.isEmpty()) System.out.println("unknown");
//                else{
//                    String result = "";
//                    for (String each : map.keySet()){
//                        if (map.get(each) > map.getOrDefault(result, 0)) result = each;
//                    }
//                    System.out.println(result);
//                }
//            }
//        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new brady().run();
    }
}
