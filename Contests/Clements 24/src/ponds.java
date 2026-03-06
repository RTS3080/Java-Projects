import java.util.*;
import java.io.*;
public class ponds{
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("sixponds".toLowerCase()+".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(); f.nextLine();
        for(int abcd = 0;abcd<times;abcd++){
            int n = f.nextInt()-1;
            String ln = f.nextLine().substring(1);
            switch (n){
                case 0: {
                    System.out.println(ln.replaceAll("[aeiouAEIOU]","POND"));
                    break;
                }
                case 1: {

                    String a =(ln.replaceAll("[aeiuAEIU]","POND"));
                    a = a.replaceAll("[oO]","_");
                    System.out.println(a);
                    break;
                }
                case 2: {

                    StringBuilder arev = new StringBuilder(ln);
                    arev = arev.reverse();
                    String b = arev.toString();
                    String a ="";
//                    System.out.println(a);
                    for(char c : b.toCharArray()){
                        if((c+"").matches("[AEIOUaeiou]")){
                            a+=String.format("%.2f",Math.sqrt((int)c));
                        }
                        else a+=""+c;
                    }
                    System.out.println(a);
                    break;
                }
                case 5: {
                    String a = "";
                    for (int i = 0; i < ln.length(); i++) {
                        String let = ln.substring(i,i+1);
                        if(let.matches("[qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKLZXCVBNM]")){
                            if(let.toLowerCase().equals(let)) {
                                a += (char) ((let.charAt(0) + -1));
                            }
                            else{
                                a += (char) ((let.charAt(0) + -1));
                            }

                        }
                        else a +=let;
                    }
                    System.out.println(a);
                    break;
                }
                default:{
                    System.out.println(ln);
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new ponds().run();
    }
}