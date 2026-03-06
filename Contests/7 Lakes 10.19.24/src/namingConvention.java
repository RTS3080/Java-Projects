import java.util.*;
import java.io.*;

public class namingConvention{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("namingConvention".toLowerCase()+".in"));
        int times=f.nextInt();
        int maxName = f.nextInt();
        f.nextLine();
        ArrayList<String> validNames = new ArrayList<>();
        while(times-->0){
            boolean valid = true;
            String a=f.nextLine();
            String[] ln = a.split(" ");

            if(!ln[0].substring(0,1).matches(("[A-Z]")))
                valid = false;
            for(String s : ln) {
                if (s.matches("[A-Z]{2,}"))
                    valid = false;
                if(s.contains("johnson"))
                    valid = false;
                int vowels = 0;
                int consonants = 0;
                for (int i = 0; i < s.length(); i++) {
                    if(s.substring(i,i+1).matches("[aeiouAEIOU]"))
                        vowels++;
                    if(s.substring(i,i+1).matches("[qwrtyplkjhgfdszxcvbnmQWTRYPSDFGHJKLZXCVBNM]"))
                        consonants++;
                }
                if(vowels>consonants)
                    valid = false;
            }

//            System.out.println(validNames);
            int countdupes=0;
            for(String s : validNames) {
                if(ln[0].equals(s))
                    countdupes++;
            }
            if(countdupes>=maxName)
                valid = false;
            if(valid) {
                System.out.println(a + " is a valid name");
                validNames.add(ln[0]);
            }

            else System.out.println(a+" has to change his/her name");

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new namingConvention().run();
    }
}
