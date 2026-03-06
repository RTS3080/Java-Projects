import java.util.*;
import java.io.*;

public class girish{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("girish".toLowerCase()+".dat"));
        ArrayList<String> lines = new ArrayList<>();
        while(f.hasNext()){
            String s = f.nextLine();
            if(!s.trim().matches("----------")){
                lines.add(s);
            }
        }
        int[][] mat = new int[lines.size()][lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            mat[i] = Arrays.stream(lines.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        double[] means = new double[lines.size()];
        int[] sum = new int[lines.size()];
        HashMap<Integer,Integer> modes = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> occur = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            means[i] = (double) Arrays.stream(mat[i]).sum()/mat[i].length;
            sum[i] = Arrays.stream(mat[i]).sum();
            for (int j = 0; j < mat[i].length; j++) {
                modes.putIfAbsent(mat[i][j], 0);
                occur.putIfAbsent(mat[i][j], new HashSet<>());
                occur.get(mat[i][j]).add(i);
                modes.put(mat[i][j], modes.get(mat[i][j]) + 1);
            }
        }
        Arrays.sort(means);
        double medMean;
        if(means.length%2 == 1){
            medMean = means[(means.length/2)];
        }
        else{
            double a = means[means.length/2];
            double b = means[means.length/2+1];
            medMean = (a+b)/2;
        }
        double meanSum = Arrays.stream(sum).sum()/((double)sum.length);
        int mode = -1;
        int maxCnt = 0;
        for(Map.Entry<Integer,Integer> e: modes.entrySet()){
            int num = e.getKey();
            int count = e.getValue();

            boolean hit = true;
            Set<Integer> cnts = occur.get(num);
            for (int i = 0; i < mat.length; i++) {
                if(!cnts.contains(i)){
                    hit = false;
                }
            }
            if(!hit){
                if(count>maxCnt){
                    maxCnt = count;
                    mode = num;
                }
            }
        }

//        System.out.println(Arrays.toString(means));
//        System.out.println(modes);
//        System.out.println(occur);
//        System.out.println(lines);
//        System.out.println(Arrays.toString(sum));
        System.out.printf("Median Mean: %.2f\n", medMean);
        System.out.printf("Mean Sum: %.2f\n", meanSum);
        System.out.printf("Mode Kinda: %d\n", mode);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new girish().run();
    }
}
