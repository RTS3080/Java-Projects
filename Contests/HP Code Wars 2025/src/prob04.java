import java.util.*;
import java.io.*;

public class prob04{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        String name = f.next();
        int times=f.nextInt(); f.nextLine();
        int shirts = 0, hats = 0, stickers = 0;
        while(times-->0){
            shirts += f.nextInt();
            hats += f.nextInt();
            stickers += f.nextInt();
        }
        int tot = shirts*13
                + hats*9 + stickers*2;
        String sh = shirts == 1 ? "shirt" : "shirts";
        String h = hats == 1 ? "hat" : "hats";
        String st = stickers == 1 ? "sticker" : "stickers";
        System.out.printf("%s spent $%d on %d %s, %d %s, and %d %s.\n", name,tot,  shirts, sh, hats, h, stickers, st);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob04().run();
    }
}
