import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt("03");
        System.out.println(a);
        System.out.println("Hello world!");
        Scanner f = new Scanner("1 2 3 4 5 6 7");
//        for (int i = 0; i < f.nextInt(); i++) {
//            System.out.print(i);
//        }
        List<? extends  Comparable> al = new ArrayList<>();
        int i = 23;
        i+=i--;
        i=-i+i++;
        System.out.println(i);

//        Math.pow();
    }
    class b <T extends Comparable<T>>{

    }
}