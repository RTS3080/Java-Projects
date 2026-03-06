import java.util.*;
import java.io.*;

public class kanYuSpell{
    public int getChanges(char[] a, char[] b) {
        int changes = 0;

        for (int i = 0; i < a.length; i++) {
            if (b[i] < a[i]) {
                return -1;
            } changes += b[i] - a[i];
        } return changes;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("kanYuSpell".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String origA = f.next();
            String origB = f.next();
            char[] sortedA = origA.toCharArray();
            char[] sortedB = origB.toCharArray();

            Arrays.sort(sortedA);
            Arrays.sort(sortedB);

            char[] a = origA.toCharArray();
            char[] b = origB.toCharArray();

            int sortedChanges = getChanges(sortedA,sortedB);

            int changes = getChanges(a,b);

            if (sortedChanges < 0) {
                System.out.println(-1);
                continue;
            }

            if (sortedChanges == changes) {
                System.out.println(sortedChanges);
            } else {
                System.out.println(sortedChanges + 1);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kanYuSpell().run();
    }
}
