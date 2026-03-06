import java.util.*;
import java.io.*;

public class Harmony{
String rank1;
String rank2;
HashSet<String> invalid;
HashSet<String> spec;


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Harmony".toLowerCase()+".dat"));
        String in = f.nextLine();
        rank1=in.substring(0,in.length()/2);
        rank2=in.substring(in.length()/2);
        String[] lob = f.nextLine().split("");
        invalid = new HashSet<>();
        spec = new HashSet<>();
        spec.addAll(Arrays.asList(lob));
        for (int i = 0; i < 10; i++) {
            String[] bob = f.nextLine().split("");
            invalid.addAll(Arrays.asList(bob));
        }
        while(f.hasNext()){
            String pass = f.nextLine().trim();
            System.out.println(isValid(pass));
        }


        f.close();
    }

    public String isValid(String in){
        int score = 0;
        if (in.length()>=8&&!invalid.contains(in)){
            int c = 0;
            if (in.matches(".*\\d.*")){c++;}
            if (in.matches(".*[a-z].*")){c++;}
            if (in.matches(".*[A-Z].*")){c++;}
            for (int i = 0; i < in.length(); i++) {
                String a = in.charAt(i)+"";
                if (spec.contains(a)){
                    c++;
                    break;
                }
            }
            if (c==4){
                score+=5;
            }
            if (c>=3){
                if (in.length()>10){
                    score+= (in.length()-10)*3;
                }
                for (int i = 0; i < in.length(); i++) {
                    String a = ""+in.charAt(i);
                    if (rank1.toUpperCase().contains(a.toUpperCase())){
                        score+=1;
                    }
                    else if (rank2.toUpperCase() .contains(a.toUpperCase())){
//                        System.out.println(rank2);
//                        System.out.println("r2");
                        score+=3;
                    }
                    else if (a.matches("[0-9]")){
                        score+=3;
                    }
                    else if (spec.contains(a)){
                        score+=5;
                    }
                }
                for (int i = 1; i < in.length(); i++) {
                    char a= in.charAt(i);
                    char b = in.charAt(i-1);
                    if (a==b){
                        score-=2;
                    }
                }
                String cat = "";
                String x = in.substring(0,1);
                if (x.matches("\\d")){cat= "d";}
                else if (x.matches("[a-z]")){cat= "l";}
                else if (x.matches("[A-Z]")){cat= "u";}
                else if (spec.contains(x)){cat= "s";}
                for (int i = 1; i < in.length(); i++) {
                    String n = in.charAt(i) + "";
                    if (n.matches("\\d")){
                        if(!cat.equals("d")){
                            score+=3;
                            cat = "d";
                        }
                    }
                    if (n.matches("[a-z]")){
                        if (!cat.equals("l")){
                            score+=3;
                            cat = "l";
                        }
                    }
                    if (n.matches("[A-Z]")){
                        if (!cat.equals("u")){
                            score+=3;
                            cat = "u";
                        }
                    }
                    if (spec.contains(n)){
                        if (!cat.equals("s")){
                            score+=3;
                            cat = "s";
                        }
                    }
                }
            }

        }

        System.out.print(in+":"+score + ":");
        return score==0?"UNACCEPTABLE":score>=1&&score<=20?"WEAK":score>=21&&score<=35?"FAIR":score>=36&&score<=50?"GOOD":score>=51?"STRONG":"UNACCEPTABLE";
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Harmony().run();
    }
}
