public class classes {
    class A {
        {
            System.out.println("A");
        }
        static{
            System.out.println("B");
        }
        public A(){
            System.out.println("C");
        }

    }


    public void run(){
        new A();
        new A();

    }
    public static void main(String[] args) {
        new classes().run();

    }
}
