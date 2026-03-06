import java.util.*;
import java.io.*;

public class XML{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("xml".toLowerCase()+".dat"));

        int k = f.nextInt();
        f.nextLine();
        Stack<String> use = new Stack<>();
        boolean valid = true;
        for (int l = 0; l < k; l++) {
            int ke = f.nextInt();
            f.nextLine();
            for (int x = 0; x < ke; x++) {
                String in  =f.nextLine().trim();
                if (in.substring(1,2).equals("/")) {
                    String t = use.pop();
                    if (!in.substring(2).equals(t.substring(1))) {
                        valid = false;
                    }
                    continue;
                }
                if (in.startsWith("<")&&!in.substring(1,2).equals("/")){
                    use.push(in);
                }
            }

            if (valid){
                System.out.println("valid");
            }else {
                System.out.println("invalid");
            }
            valid = true;

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new XML().run();
    }
}
