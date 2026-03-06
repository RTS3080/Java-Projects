import java.util.*;
import java.io.*;

public class marek{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("marek".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            Scanner l =  new Scanner(ln);
            int tot = 0;
            boolean go = true;
            if(!ln.contains("(")){
                tot+=l.nextInt();
                while(l.hasNext()){
                    String s = l.next();
//                    System.out.print(s+" ");
                    switch(s){
                        case "+" : tot+=l.nextInt(); break;
                        case "-": tot-=l.nextInt(); break;
                        case "*": tot*=l.nextInt(); break;
                        case "/": {
                            try{
                                tot/=l.nextInt();
                            }
                            catch(ArithmeticException e){
                                System.out.println("Infinity");
                                go = false;
                            }
                            break;
                        }
                    }

                }
                System.out.println(tot);
            }
            else System.out.println("parentheses");
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new marek().run();
    }
}
