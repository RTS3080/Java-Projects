import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Hannah{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Hannah".toLowerCase()+".dat"));


         int k = f.nextInt();
         f.nextLine();
        for (int x = 0; x < k; x++) {
            int ke = f.nextInt();
            f.nextLine();
            HashMap<String,Integer> bob = new HashMap<>();
            HashMap<String,String> c = new HashMap<>();
            for (int y = 0; y < ke; y++) {
                String name = f.next();
                String clas = f.next();
                int tot = 0;
                for (int i = 0; i < 12; i++) {
                    tot+=f.nextInt();
                }
                f.nextLine();
                c.put(name, clas);
                bob.put(name,tot);
            }
            for (int y = 0; y < ke; y++) {
                String name = f.next();
                int tot = 0;
                for (int i = 0; i < 3; i++) {
                    tot += f.nextInt();
                }
                bob.put(name,bob.get(name)+tot);
                f.nextLine();
            }
            LinkedList<String> key = new LinkedList<>(bob.keySet());
            TreeMap<Integer,String> A1 = new TreeMap<>();
            TreeMap<Integer,String> A2 = new TreeMap<>();
            TreeMap<Integer,String> A3 = new TreeMap<>();
            TreeMap<Integer,String> A4 = new TreeMap<>();
            TreeMap<Integer,String> A5 = new TreeMap<>();
            TreeMap<Integer,String> A6 = new TreeMap<>();

            for (int i = 0; i < key.size(); i++) {
                switch (c.get( key.get(i))) {
                    case "1A":
                        A1.put(bob.get(key.get(i)), key.get(i)); break;
                    case "2A":
                        A2.put(bob.get(key.get(i)), key.get(i));break;
                    case "3A":
                        A3.put(bob.get(key.get(i)), key.get(i));break;
                    case "4A":
                        A4.put(bob.get(key.get(i)), key.get(i));break;
                    case "5A":
                        A5.put(bob.get(key.get(i)), key.get(i));break;
                    case "6A":
                        A6.put(bob.get(key.get(i)), key.get(i));break;
                }
            }

            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        System.out.println("Classification 1A Results");
                        LinkedList<Integer> ky = new LinkedList<>(A1.keySet());
                        for (int j = ky.size()-1; j >=0; j--) {
                            System.out.println(A1.get(ky.get(j))+" "+ky.get(j));
                        };
                        break;
                    case 1:
                        System.out.println("Classification 2A Results");
                        LinkedList<Integer> ky2 = new LinkedList<>(A2.keySet());
                        for (int j = ky2.size()-1; j >=0; j--) {
                            System.out.println(A2.get(ky2.get(j))+" "+ky2.get(j));
                        }break;
                    case 2:
                        System.out.println("Classification 3A Results");
                        LinkedList<Integer> ky3 = new LinkedList<>(A3.keySet());
                        for (int j = ky3.size()-1; j >=0; j--) {
                            System.out.println(A3.get(ky3.get(j))+" "+ky3.get(j));
                        }break;
                    case 3:
                        System.out.println("Classification 4A Results");
                        LinkedList<Integer> ky4 = new LinkedList<>(A4.keySet());
                        for (int j = ky4.size()-1; j >=0; j--) {
                            System.out.println(A4.get(ky4.get(j))+" "+ky4.get(j));
                        }break;
                   case 4:
                       System.out.println("Classification 5A Results");
                       LinkedList<Integer> ky5 = new LinkedList<>(A5.keySet());
                       for (int j = ky5.size()-1; j >=0; j--) {
                           System.out.println(A5.get(ky5.get(j))+" "+ky5.get(j));
                       }break;
                   case 5:
                       System.out.println("Classification 6A Results");
                       LinkedList<Integer> ky6 = new LinkedList<>(A6.keySet());
                       for (int j = ky6.size()-1; j >=0; j--) {
                           System.out.println(A6.get(ky6.get(j))+" "+ky6.get(j));
                       }break;
                }

            }
            System.out.println("=".repeat(25));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Hannah().run();
    }
}
