import static java.lang.Math.*;
import static java.lang.System.out;

public class Main {

    int a;

    public Main() {
//        this(5);
    }

    public Main(int a) {
//        this.a = a;
    }


    public static void main(String[] args) {

        new Main().run();

    }

    public void run(){
        new Test();
        Test single = Test.singleton;

    }

    class Test{

        int b;
        int a;
        int c;
        public static Test singleton;

        private Test(int c){
            this.c = c;
            b = 2;
            a = -1;
        }
        public Test(){
            if (singleton == null) singleton = new Test(1);
        }

        public Test getSingleton(){
            return singleton;
        }
        public Test yeahurstupid(){
            singleton.a = 1;
            return singleton;
        }

        public Test yeahurstupidthesequal(){
            singleton.a = 2;
            return singleton;
        }


        public String toString(){
            return ""+a;
        }
    }

}