import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class maximo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("maximo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String lnA = f.next().substring(3);
            String lnB = f.next().substring(3);
            lnA = lnA.substring(0, lnA.length()-1);
            lnB = lnB.substring(0, lnB.length()-1);
            HashSet<Integer> a = new HashSet<>();
            HashSet<Integer> aCopy = new HashSet<>();
            for(String s : lnA.split(",")){
                a.add(Integer.parseInt(s));
                aCopy.add(Integer.parseInt(s));
            }
            HashSet<Integer> b = new HashSet<>();
            HashSet<Integer> bCopy = new HashSet<>();

            for(String s : lnB.split(",")){
                b.add(Integer.parseInt(s));
                bCopy.add(Integer.parseInt(s));
            }
            aCopy.retainAll(b);
            if(a.equals(b)){
                System.out.println("Set A is equal to Set B");
            }
            else if(aCopy.equals(b)){
                System.out.println("Set B is a subset of Set A");
            }
            else if(aCopy.equals(a)){
                System.out.println("Set A is a subset of Set B");
            }
            else{
                System.out.print("Neither set is a subset of the other. Their intersection is: ");
                System.out.println(aCopy.toString().replaceAll("\\[", "{").replaceAll("\\]", "}").replaceAll(" ",""));
            }


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new maximo().run();
    }
}
