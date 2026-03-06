import java.util.ArrayList;

public class Main {
    abstract class A {
        public A(){

        }
        abstract int func();
    }

    class B extends A {
        public B(){

        }

        @Override
        int func() {
            System.out.println("bruh");
            return 1;
        }
        void bruh(){
            System.out.println("bruh2");
        }
    }
    public void run() throws Exception {
        A a = new B();
        a.func();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
//        System.out.println("what???? ever!!!!!");
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <2; k++) {
                    for (int l = 0; l < 2; l++) {
                        boolean a = i%2==0;
                        boolean b = j%2==0;
                        boolean c = k%2==0;
                        boolean d = l%2==0;
                        res += (a ^ b && !c || d && c ^ !a || !b && !d ^ a) ? 1 : 0;
                        System.out.println((i+1)%2+" "+(j+1)%2+" "+(k+1)%2+" "+(l+1)%2+" "+(a ^ b && !c || d && c ^ !a || !b && !d ^ a));
                    }
                }
            }
        }
        System.out.println(res);
    }

}