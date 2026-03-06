package Solutions;

import java.util.*;
import java.io.*;

public class Hank {
    public static void main(String[] args) throws Exception {
        new Hank().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("hank.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            String url = f.nextLine();
            System.out.println(url.matches("^(?:https?://)?(?:www\\.)?([a-zA-Z0-9]{2,}\\.)?[a-zA-Z0-9]{2,}\\.(?!www$)[a-zA-Z0-9]{2,}$")
                    ? "Validated":"Hmm... can't reach this page");
        }
        f.close();
    }
}