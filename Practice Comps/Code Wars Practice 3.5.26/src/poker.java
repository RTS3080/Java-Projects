import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class poker{
    class Card implements Comparable<Card>{
        int rank;
        char suit;
        public Card(char[] card){
            suit = card[1];
            if(Character.isLetter(card[0])) {
                rank = switch (card[0]) {
                    case 'T' -> 10;
                    case 'J' -> 11;
                    case 'Q' -> 12;
                    case 'K' -> 13;
                    case 'A' -> 14;
                    default -> -1;
                };
            }
            else rank = card[0]-'0';
        }

        public int compareTo(Card o){
            return rank - o.rank;
        }
        public String toString(){
            char[] above = "TJQKA".toCharArray();
            String s ="";
            if(rank >=10){
                s+=above[rank%10];
            }
            else{
                s+=rank;
            }
            s+=suit;
            return s;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("poker".toLowerCase()+".dat"));
        while(f.hasNext()){
            String s = f.nextLine();
            String[] ln = s.trim().split(" ");
            Card[] hand = new Card[5];
            for (int i = 0; i < 5; i++) {
                hand[i] = new Card(ln[i].toCharArray());
            }

            Arrays.sort(hand);
            String type = getHandType(hand);
            System.out.println(s.trim()+" "+type);
        }
        f.close();
    }
    boolean isFlush(Card[] hand){
        HashSet<Character> suits = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            suits.add(hand[i].suit);
        }
        return suits.size()==1;
    }
    boolean isStraight(Card[] hand){
        for (int i = 0; i < 4; i++) {
            if(hand[i+1].rank-hand[i].rank!=1){
                return false;
            }
        }
        return true;
    }
    String getHandType(Card[] hand){
        HashMap<Integer,Integer> counts = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            counts.put(hand[i].rank, counts.getOrDefault(hand[i].rank, 0) + 1);
        }
        if(isStraight(hand) && isFlush(hand)){
            return ("Straight Flush");
        }
        if(isFlush(hand)){
            return ("Flush");
        }
        if(isStraight(hand)){
            return ("Straight");
        }
        boolean isQuad = false;
        boolean isTrip = false;
        int numPair = 0;
//        System.out.println(counts);
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()){
            if(entry.getValue()==2){
                numPair++;
            }
            else if(entry.getValue()==3){
                isTrip = true;
            }
            else if(entry.getValue()==4){
                isQuad = true;
            }
        }
        if(isQuad){
            return ("Four of a Kind");
        }
        if(isTrip && numPair > 0){
            return ("Full House");
        }
        if(isTrip){
            return ("Three of a Kind");
        }
        if(numPair == 2){
            return "Two Pair";
        }
        if(numPair == 1){
            return "One Pair";
        }
        return "High Card";

    }



    public static void main(String[] args) throws FileNotFoundException{
        new poker().run();
    }
}
