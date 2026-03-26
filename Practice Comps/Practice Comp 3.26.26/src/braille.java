//import java.util.*;
//import java.io.*;
//import java.awt.*;
//import static java.lang.Math.*;
//
//
//public class braille{
//HashMap<Integer,Integer> map;
//    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("braille".toLowerCase()+".dat"));
//        //Scanner f = new Scanner(new File("input.txt"));
//        int numTimes=f.nextInt();f.nextLine();
//        for(int times = 0; times < numTimes; times++){
//            int[][] parse = new int[3][];
//            for (int i = 0; i < 3; i++) {
//                parse[i] = Arrays.stream(f.next().split("")).mapToInt(Integer::parseInt).toArray();
//            }
//            int[][][] cells = new int[parse[0].length/2][3][2];
//            map = new HashMap<>();
//
//            map.put(1, 1);
//            map.put(3, 2);
//            map.put(5, 3);
//            map.put(10, 4);
//            map.put(7, 6);
//            map.put(6, 5);
//            map.put(12, 7);
//            map.put(8, 8);
//            map.put(11, 10);
//            map.put(9, 9);
//            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//                map.put(entry.getKey()+3, entry.getValue()+10);
//                map.put(entry.getKey()+9, entry.getValue()+20);
//            }
//        }
//        f.close();
//    }
//
//    char parseBraille(int[][] mat){
//
//    }
//
//
//
//    public static void main(String[] args) throws FileNotFoundException{
//        new braille().run();
//    }
//}
