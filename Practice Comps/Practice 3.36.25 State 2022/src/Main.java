public class Main {
    public static void main(String[] args) {
        int a = 16;
        System.out.println(Integer.toBinaryString(2<<a));
        System.out.println(Integer.toBinaryString(Integer.reverseBytes(2<<a)));
        System.out.println(Integer.toBinaryString(Integer.reverse(2<<a)));
        String s= new String("1");
    }
}