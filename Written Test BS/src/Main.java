import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Scanner f= new Scanner(System.in);
//        f.useRadix(8);
//        System.out.println(f.hasNextInt());
//        Stack<Integer> stack = new Stack<>();
//        String s = "test";
        TreeSet<Integer> set = new TreeSet<>();
        int[] arr = Arrays.stream("7 9 5 0 2 4".split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i : arr){
            set.add(i);
        }
        System.out.println(set.floor(3));
        System.out.println(set.ceiling(10));

        var test = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            test.put(Character.toString(((char)(i + 'A' ))),Character.toString(((char)(i + 'A' ))));
        }
    }


}
