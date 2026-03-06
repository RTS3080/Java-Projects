import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class recount{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("recount".toLowerCase()+".dat"));
        while(f.hasNext()){
            int n = f.nextInt();
            HashMap<Character, Integer> suitIntex = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                suitIntex.put("SHDC".charAt(i), i);
            }
            int[][] cards = new int[4][15];
            String[][] holder = new String[4][15];
            for (int i = 0; i < 4; i++) {
                for (int j = 2; j < 15; j++) {
                    char[] above = "TJQKA".toCharArray();
                    String s ="";
                    if(j >=10){
                        s+=above[j%10];
                    }
                    else{
                        s+=j;
                    }
                    s+="SHDC".charAt(i);
                    holder[i][j] = s;
                }
            }
            for (int i = 0; i < n; i++) {
                int ind = -1;
                String s = f.next();
                char[] card = s.toCharArray();
                if(Character.isLetter(card[0])){
                    ind = switch(card[0]){
                        case 'T' ->10;
                        case 'J' ->11;
                        case 'Q' -> 12;
                        case 'K' -> 13;
                        case 'A' -> 14;
                        default -> -1;
                    };
                }
                else{
                    ind = card[0] -'0';
                }
                int suitInd = suitIntex.get(card[1]);
                cards[suitInd][ind]++;
            }
            String missing = "";
            String dupe = "";
            for (int i = 0; i < 4; i++) {
                for (int j = 2; j < 15; j++) {
                    if(cards[i][j] == 0){
                        missing += holder[i][j]+" ";
                    }
                    else if(cards[i][j] > 1){
                        dupe += holder[i][j]+" ";
                    }
                }
            }
            System.out.println("Missing: "+(missing.isEmpty()?"None" : missing.trim()));
            System.out.println("Duplicates: "+(dupe.isEmpty()?"None" : dupe.trim()));
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new recount().run();
    }
}
