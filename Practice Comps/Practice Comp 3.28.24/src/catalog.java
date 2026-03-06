import java.util.*;
import java.io.*;

public class catalog{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("catalog".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<person> peeps=new ArrayList<>();
        while(times-->0){
            String str=f.nextLine();
            int s=0;
            for(char c:str.toCharArray()){
                if(c>=48 && c<=57){
                    s+=c-48;
                }
            }
            person p=new person(str,s);
            peeps.add(p);
        }
        Collections.sort(peeps);
        for(person p:peeps){
            System.out.println(p);
        }
        f.close();
    }

}
class person implements Comparable<person>{
    public int sum;
    public String id;
    public person(String s, int n){
        id=s;
        sum=n;

    }
    public int compareTo(person c){
        if(sum>c.sum){
            return 1;
        }
        else if(sum<c.sum){
            return -1;
        }
        return id.compareTo(c.id);
    }

    public String toString(){
        return id+" "+sum;
    }
}