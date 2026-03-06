package student_datasets;

import java.util.*;
import java.io.*;

public class holder {
    HashSet<String> visited;
    TreeMap<String, Double> map = new TreeMap<>();
    int[] ints = Arrays.stream("-1234567890 82 62 80 57 72 73".split(" ")).mapToInt(Integer::parseInt).toArray();
    public void run() throws FileNotFoundException{
        String str = "123456";
        visited = new HashSet<>();
        int[] pointers = {1,2,3,4};
        combos(pointers);
        for(Map.Entry<String, Double> entry : map.entrySet()){
            System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue(), str);
        }
        DoubleSummaryStatistics d = map.values().stream().mapToDouble(Double::doubleValue).summaryStatistics();
        double average = d.getAverage();
        System.out.println("mean: "+average);


    }
    public void combos(int[] pointers){
        String s ="";
        for (int i = 0; i < 4; i++) {
            s+=pointers[i];
        }
        for (int i = 0; i < 4; i++) {
            if(pointers[i]>=ints.length) {
                return;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.lastIndexOf(s.charAt(i)) != s.indexOf(s.charAt(i))){
                return;
            }
        }
        double avg = 0;
        for (int i = 0; i < 4; i++) {
            avg+=ints[pointers[i]];
        }
        avg/=4;
        map.put(s,avg);
        for (int i = 0; i < 4; i++) {
            pointers[i] ++;
            combos(pointers);
            pointers[i]--;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new holder().run();
    }
}
