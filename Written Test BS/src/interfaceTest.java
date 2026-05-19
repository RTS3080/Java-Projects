public class interfaceTest {
    interface A{
        int a = 1;
        default int go(){
            return 1;
        }
    }
    abstract class B{
        public int go(){
            return 2;
        };
    }
    class C extends B implements A{
        public int go(){
            return 3;
        }
    }
    interface D extends A{
        default int go(){
            return 1;
        }
    }
    class Lambdas{
        private interface FI {
            public int go(int i);
        }
    }
    public static void main(String[] args) {
        Lambdas.FI lambda = i -> i%10 + i/10;
        System.out.println(lambda.go(12345));
    }
}


