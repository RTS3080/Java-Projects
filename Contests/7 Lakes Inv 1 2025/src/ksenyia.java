import java.util.*;
import java.io.*;

public class ksenyia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ksenyia".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> passes = new ArrayList<>();
        timeloop:
        while(times-->0){
            String user =  f.nextLine();
            String pass =  f.nextLine();

            boolean userT = true;
            boolean passT = true;

            if(!user.matches("[A-Za-z0-9]+"))
                userT = false;
            if(!user.matches("[A-Z].*"))
                userT = false;
            if(user.length()<8 || user.length()>20)
                userT = false;
            if(users.contains(user))
                userT = false;

           if(!pass.matches(".*[A-Z].*"))
               passT = false;
           if(!pass.matches(".*[a-z].*"))
               passT = false;
           if(!pass.matches(".*[0-9].*"))
               passT = false;
           if(!pass.matches(".*[!@#\\$%\\^&\\*\\?\\+].*")) {
               passT = false;
//               System.out.println(pass);
           }

            if(pass.contains(" "))
                passT = false;
            for (int i = 0; i < pass.length()-3; i++) {
                if(pass.substring(i,i+3).matches(pass.substring(i,i+1).repeat(3))){
                    passT = false;
                }
            }
            if(pass.length()<10 || pass.length()>30)
                passT = false;

            if(passes.contains(pass))
                passT = false;

            if(passT && userT){
                users.add(user);
                passes.add(pass);
                System.out.println("Valid");
            }
            else if (passT && !userT){
                System.out.println("Username Invalid");
            }
            else if (!passT && userT){
                System.out.println("Password Invalid");
            }
            else System.out.println("Both Invalid");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ksenyia().run();
    }
}
