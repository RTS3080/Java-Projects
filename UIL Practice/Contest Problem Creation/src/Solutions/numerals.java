
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class numerals {
    static public void run() throws FileNotFoundException {
        Scanner file=new Scanner(new File("numerals.dat"));
        int times=file.nextInt();

        //Roman Number setup
        ArrayList<Integer> num= new ArrayList<>(Arrays.asList(1296,648,216,108,36,18,6,3,1));
        ArrayList<String> conv= new ArrayList<>(Arrays.asList("F","V","B","G","Z","J","Q","K","Y"));

        while(times-->0){
            int target=file.nextInt();
            //base case
            if(target==0){
                System.out.println("0 turns into A");
                continue;
            }
            int or=target;
            String goal="";
            //Roman Number result making
            while(target>0){
                for (int i = 0; i < num.size(); i++) {
                    if (target>=num.get(i)){
                        target-=num.get(i);
                        goal+=conv.get(i);
                        break;
                    }
                }
            }
            System.out.println(or+" turns into " + goal);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        numerals.run();
    }
}