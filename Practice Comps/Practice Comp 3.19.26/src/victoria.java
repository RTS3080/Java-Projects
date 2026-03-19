import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class victoria{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("victoria".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        while (f.hasNext()){
            String line = f.nextLine();
            String[] words = line.trim().split(" +");

            int wordCount = 0;
            int specials = 0;
            int caps = 0;

            for (String w : words) {
                if (w.length() >= 4) {
                    wordCount++;
                }

                if (w.matches(".*[\\W_].*")) {
                    specials++;
                }
                if (w.matches(".*[\\d].*")) {
                    specials++;
                }

                if (w.equals(w.toUpperCase()) && w.matches(".*[A-Z].*")) {
                    caps++;
                }
            }

            if (wordCount < 4 || line.length() < 20) {
                System.out.println("0:Unacceptable");
                continue;
            }

            int finalScore = 100;

            finalScore += (words.length - 4) * 10;
            finalScore += specials * 5;
            if (caps < words.length / 2.0) {
                finalScore += caps * 10;
            }

            if (line.equals(line.toUpperCase()) && line.matches(".*[A-Z].*[A-Z].*") || line.equals(line.toLowerCase()) && line.matches(".*[a-z].*[a-z].*")) {
                finalScore -= 10;
            }

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j) continue;

                    if (words[i].length() > 2) {
                        if (words[j].startsWith(words[i])) {
                            finalScore -= 10;
                        }
                        if (words[j].endsWith(words[i])) {
                            finalScore -= 10;
                        }

                        if (words[i].equals(words[j])) {
                            finalScore -= 10;
                        }
                    }
                }
            }

            String modifier = "";
            if(finalScore >= 150){
                modifier = "Excellent";

            }
            else if(finalScore >= 125){
                modifier = "Strong";
            }
            else if(finalScore >= 100){
                modifier = "Adequate";
            }
            else if(finalScore >= 75){
                modifier = "Weak";
            }
            else if(finalScore >= 50){
                modifier = "Poor";
            }
            else{
                modifier = "Unacceptable";
            }
            System.out.println(finalScore+":"+modifier);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new victoria().run();
    }
}
