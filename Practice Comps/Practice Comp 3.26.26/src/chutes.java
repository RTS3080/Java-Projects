import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class chutes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("chutes".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numPlayers = f.nextInt();
            long seed = f.nextLong();
            int numPortals = f.nextInt() + f.nextInt();

            HashMap<Integer, Integer> portals = new HashMap<>();
            Random gen = new Random(seed);

            for (int i = 0; i < numPortals; i++) {
                portals.put(f.nextInt(), f.nextInt());
            }

            int[] players = new int[numPlayers];
            Arrays.fill(players, 1);

            int rolls = 0;
            int player = 0;

            while (true) {
                int roll = gen.nextInt(1, 7);
                rolls++;

                players[player] += roll;

                while (portals.containsKey(players[player])) {
                    players[player] = portals.get(players[player]);
                }

                if (players[player] >= 64) {
                    break;
                }

                player = (player + 1) % numPlayers;
            }

            char winner = (char) ('A' + player);
            System.out.println("Player " + winner + " wins after " + rolls + " rolls!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new chutes().run();
    }
}
