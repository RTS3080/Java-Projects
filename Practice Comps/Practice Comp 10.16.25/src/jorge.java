import java.util.*;
import java.io.*;
import java.awt.*;

public class jorge{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jorge".toLowerCase()+".dat"));
        loop:
        while(f.hasNext()){
            int[] cards = new int[13];
            int[] suites = new int[4];
            int[] hand = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i : hand){
                cards[(i-1)%13]++;
                suites[(i-1)/13]++;
            }
            for(int i : cards){
                if(i==4) {
                    System.out.println("FOUR OF A KIND");
                    continue loop;
                }
            }
            boolean three = false;
            boolean two = false;
            for (int i = 0; i < cards.length; i++) {
                if(cards[i]==3){
                    three = true;
                }
                if(cards[i]==2){
                    two = true;
                }
            }
            if(three && two){
                System.out.println("FULL HOUSE");
                continue loop;
            }
            for(int i : suites){
                if(i==5){
                    System.out.println("FLUSH");
                    continue loop;
                }
            }
            loop2:
            for (int i = 0; i < cards.length; i++) {
                for(int j = i; j< i+5 && j< cards.length;j++){
                    if(cards[j]==0){
                        continue loop2;
                    }
                }
                System.out.println("STRAIGHT");
                continue loop;
            }
            //low straight
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                if(cards[i]>0){
                    cnt++;
                }
            }
            if(cnt==4 && cards[12]==1){
                System.out.println("STRAIGHT");
                continue loop;
            }
            for(int i : cards){
                if(i==3){
                    System.out.println("THREE OF A KIND");
                    continue loop;
                }
            }
            int ind = -1;
            boolean pair1 = false;
            boolean pair2 = false;
            for (int i = 0; i < 13; i++) {
                if(cards[i] == 2){
                    pair1 = true;
                    ind = i;
                }
            }
            for (int i = 0; i < 13; i++) {
                if(cards[i] == 2 && i != ind){
                    pair2 = true;
                }
            }
            if(pair1 && pair2){
                System.out.println("TWO PAIRS");
                continue loop;
            }

            for(int i : cards){
                if(i==2){
                    System.out.println("PAIR");
                    continue loop;
                }
            }
            System.out.println("NONE");

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jorge().run();
    }
}
