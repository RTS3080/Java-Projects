public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Alaqmar(2);
    }

    static class Terrorist{
        int numBombs;
        double KDR;

        public Terrorist(int age){
            numBombs = age / 10 + 5;
            KDR = 0.0;
        }

        public void kill(){
            KDR++;
        }

        public void die(){
            System.out.println("you lose");
        }
    }

    static class Alaqmar extends Terrorist{
        String weapon;
        public Alaqmar(int age){
            super(18);
            weapon = "airplane";
            System.out.println("I am the capitan now");
        }
    }
}