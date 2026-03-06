import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;

public class secure{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("secure".toLowerCase()+".dat"));
        int times=f.nextInt();
        int astro=f.nextInt();
        f.nextLine();
        Queue<ArrayList<String>> months = new LinkedList<>();
        while(times-->0){
            ArrayList<String> previous = new ArrayList<>();
            months.add(previous);
            for(int count  = 0; count < astro; count++){
                String s = f.nextLine().trim();
                boolean b = true;
                b&=s.length()>=10;
                b&=s.matches(".*[!@#$%^&*<?+_=>].*");
//                System.out.println(b);
                b&=s.matches(".*\\d.*");
//                System.out.println(b);
                b&=s.matches(".*[A-Z]*");
//                System.out.println(b);
                b&=s.matches(".*[a-z]*");
//                System.out.println(b);
//                for (int i = 0; i < s.length()-1; i++) {
//                    if(s.charAt(i)==s.charAt(i+1)){
//                        b = false;
//                    }
//                }
//                System.out.println(b);
                b&=s.matches(".*\\w.*");
//                System.out.println(b);
                if(!s.matches(".*(.)(\\1).*")){
                    b=false;
                    System.out.println(s);
                }
//                System.out.println(previous);
                if(b) {
                    previous.add(s);
                }
//                System.out.println(previous);

//                System.out.println(previous);
                System.out.println(b?"I am feeling much better now":"This mission is too important for me to allow you to jeopardize it");
            }

            if (months.size() == 4) months.poll();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new secure().run();
    }
}
