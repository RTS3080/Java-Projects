import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class randy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("randy".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String ln = f.nextLine();
            int val = 0;
            int[] vals = new int[12];
            int[] types = new int[12];
            int[] shots = new int[ln.length()];
            HashMap<Integer, Integer> indicies = new HashMap<>();
            for (int i = 0; i < ln.length(); i++) {
                char c = ln.charAt(i);
                if(c=='X'){
                    shots[i]=10;
                }
                else if (c=='/'){
                    shots[i]=10-shots[i-1];
                }
                else{
                    shots[i]=c-'0';
                }
            }
            int p = 0;
            int ind = 0;
            while(p < ln.length() && ind<12){
                int score;
                int change = 1;
                if(ln.charAt(p) == 'X'){
                    score=10;
                    types[ind] = 2;
                }
                else if(p == ln.length()-1){
                    break;
                }
                else{
                    score = ln.charAt(p)-'0';
                    if(ln.charAt(p+1)=='/'){
                        score=10;
                        types[ind] = 1;
                    }
                    else{
                        score += ln.charAt(p+1)-'0';
                    }
                    vals[ind]=score;
                    change++;
                }
                vals[ind] =score;
                indicies.put(ind, p);
                ind++;
                p+=change;
//                System.out.println(p+" "+ind+" "+score);
            }
            int score = 0;
            for (int i = 0; i < 10; i++) {
                if(types[i] >0) {
                    int shift = types[i];
                    int si = indicies.get(i);
                    if(shift == 2){
                        for (int j = si+1; j < si+3 && j<shots.length; j++) {
                            vals[i]+=shots[j];
                        }
                    }
                    else{
                        vals[i] += shots[si+2];
                    }

                }
                score += vals[i];
            }
//            System.out.println(Arrays.toString(vals));
            System.out.println(score);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new randy().run();
    }
}
