import java.util.*;
import java.io.*;
import java.awt.*;

public class Bizarro{
    HashMap<String, String> replacements;
    HashMap<String, String> replacements1;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bizarro".toLowerCase()+".dat"));
        Scanner dat =new Scanner(new File("bizarroHelper.dat"));
        int times=f.nextInt(), words = f.nextInt();f.nextLine();
        replacements = new HashMap<>();
        replacements1 = new HashMap<>();
        while(dat.hasNext()){
            String[] ln = dat.nextLine().split("\\|");
            replacements.put(ln[0], ln[1]);
        }

        while(words-->0){
            String start = f.next();
            String end = f.next();
            String copyStart = new String(start);
            String copyEnd = new String(end);
            if(start.endsWith("ed")){
                end = end.substring(0, end.length()-2)+"ing";
            }
            else if (start.endsWith("ing")){
                end = end.substring(0, end.length()-3)+"ed";
            }
            replacements1.put(start, end);
            start = copyStart;
            end = copyEnd;
            if(end.endsWith("ed")){
                start = start.substring(0, start.length()-2)+"ing";
            }
            else if (end.endsWith("ing")){
                start = start.substring(0, start.length()-3)+"ed";
            }
            replacements1.put(end, start);
        }
//        System.out.println(replacements1);
//        System.out.println(replacements);
        f.nextLine();
        while(times-->0) {
            String[] ln = f.nextLine().trim().split(" +");
            String out = "";
            for (String s : ln) {
                String a = replaceWord(s);
                out+=replaceWord1(a)+" ";
            }
            out=out.substring(0, out.length()-1);
            System.out.println(out);
        }
        f.close();
    }
    String replaceWord(String str){
        String punct = "";
        if((str.charAt(str.length()-1)+"").matches("\\p{Punct}")){
            punct = str.substring(str.length()-1);
            str = str.substring(0, str.length()-1);
        }
        String out = replacements.get(str.toLowerCase());
        if(out == null){return str+punct;}
        if(Character.isUpperCase(str.charAt(0))){
            out=(out.charAt(0)+"").toUpperCase()+out.substring(1);
        }
        return out+punct;
    }
    String replaceWord1(String str){
        String punct = "";
        if((str.charAt(str.length()-1)+"").matches("\\p{Punct}")){
            punct = str.substring(str.length()-1);
            str = str.substring(0, str.length()-1);
        }
        String out = replacements1.get(str.toLowerCase());
        if(out == null){return str+punct;}
        if(Character.isUpperCase(str.charAt(0))){
            out=(out.charAt(0)+"").toUpperCase()+out.substring(1);
        }
        return out+punct;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bizarro().run();
    }
}
