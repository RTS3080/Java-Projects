import com.sun.security.jgss.GSSUtil;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        new Main().run();

    }

    void run() {
//        Scanner f= new Scanner(System.in);
//        f.useRadix(8);
//        System.out.println(f.hasNextInt());
//        Stack<Integer> stack = new Stack<>();
//        String s = "test";
//        TreeSet<Integer> set = new TreeSet<>();
//        int[] arr = Arrays.stream("7 9 5 0 2 4".split(" ")).mapToInt(Integer::parseInt).toArray();
//        for(int i : arr){
//            set.add(i);
//        }
//        System.out.println(set.floor(3));
//        System.out.println(set.ceiling(10));
//
//        var test = new HashMap<String, String>();
//        for (int i = 0; i < 10; i++) {
//            test.put(Character.toString(((char)(i + 'A' ))),Character.toString(((char)(i + 'A' ))));
//        }
//
//        record Point(int x, int y){
//            static int a;
//            public Point(int x, int y) {
//                this.x = x;
//                this.y = y;
//                a = x*y;
//            }
//
//            int test(){
//                return 1;
//            }
//        }
//
//        Point p = new Point(1, 3);
//        Point p2 = new Point(2, 2);
//
//        System.out.println(p.getClass());
//        System.out.println(p2.getClass());
//        byte a = 3;
//        byte b = 8;

//        Integer[] a = new Integer[5];
//        System.out.println(a instanceof Object);
//        System.out.println(a[0] instanceof Integer);
//        String s= "ddddd";
//        System.out.println(s.split("d", 0).length);
//
//        puzzler p = null;
//        System.out.println(p.answer());
//        String s= "testing";
//        s=String.copyValueOf(new char[] {'a'});
//        System.out.println(s);
//        try {
//            String[] a = new String[2];
//            Object[] b = a;
//            b[0] = 2.34;
//            System.out.println(1);
//        }
//        catch(ArrayStoreException e) {
//            System.out.println(2);
//        }
//        finally{
//            System.out.println(3);
//        }
        String s= null;
        s+=1;
        System.out.println(s);


    }
    //(A!B + C)^(A + !D)*C

    class puzzler{
        static int answer(){
            return 42;
        }
    }

    class T {
        int x;
        int y;

        T(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static class test {
            public test() {

            }
        }
    }

    abstract class A {
        abstract int call();
    }

    interface C {
        int call();
    }

    class B extends A {
        public B() {

        }

        protected int call() {
            return 1;
        }
    }

    class D extends B {
        public D() {

        }

        public int call() {
            return 2;
        }
    }
}
abstract class G {
    private int g;

    public G(int g) {
        this.g = g;
    }

    abstract String fun();

    protected int getG() {
        return g;
    }
}



class H extends G {
    public H() {
        super(8);
    }

    String fun() {
        return "Hello";
    }

    public int getH() {
        return getG();
    }
}
