import java.util.*;
import java.io.*;
import java.awt.*;

public class dealer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dealer".toLowerCase()+".dat"));

        boolean go = true;

        while(go){
            if (f.next().equals("ENDOFINPUT")){
                go = false;
                break;
            }

            int h = f.nextInt();
            System.out.println("HAND " + h );
            f.nextLine();
            int cur = toInt(f.next()) + toInt(f.next());
            f.nextLine();
            ArrayList<Integer> hands = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                hands.add(toInt(f.next())+255);
            }
            f.nextLine();
            Queue<Integer> byt = new LinkedList<>();
            Queue<Integer> nib  = new LinkedList<>();
            for (int i = 0; i < 4  ; i++) {
                byt.add(toInt(f.next()));
            }
            f.nextLine();
            for (int i = 0; i < 4   ; i++) {
                nib.add(toInt(f.next()));

            }
            f.nextLine();
            f.nextLine();
            String res = "";
            int hit = 0;
            while (true){

                for (int i = hands.size()-1; i >=0 ; i--) {
                    if (cur>=hands.get(i)){
                        hands.remove(i);
                    }
                }
                if (hands.isEmpty()){
                    res = "Win!";
                    break;
                }
                if (cur>510){
                    System.out.println("HELLO");
                    res = "Bust!";
                    break;
                }
                if (cur<382&&!byt.isEmpty()){
                    if (hit==4){
                        res = "Lose!";
                        break;
                    }
                    System.out.println("Byte me!");
                    cur+= byt.poll();
                    hit++;
                }else if (cur<=500&&!nib.isEmpty()){
                    if (hit==4){
                        res = "Lose!";
                        break;
                    }
                    System.out.println("Nibble me!");
                    cur+= nib.poll();
                    hit++;
                }else{
                    res = "Lose!";
                    break;
                }
            }
            System.out.println(res);
        }


        f.close();
    }

    public int toInt (String in){
        int t = 1;
        int out = 0;
        for (int i = in.length()-1; i >=0 ; i--) {
            if (in.charAt(i)=='1'){
                out+=t;
            }
            t*=2;
        }
        return out;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new dealer().run();
    }
}
