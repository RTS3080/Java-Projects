import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class LLama{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("LLama".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            boolean validFirst = true;
            boolean validLast = true;
            String first = f.next().toLowerCase();
            String last = f.next().toLowerCase();
            HashMap<Character, Integer> firstVowelCounts = new HashMap<>();
            HashMap<Character, Integer> firstLetterCounts = new HashMap<>();
            int firstUniqueVowels = 0;
            int firstUniqueLetters = 0;
            for(Character c: first.toCharArray()){
                if ("aeiouAEIOU".indexOf(c)!=-1)
                {
                    if (!firstVowelCounts.containsKey(c)) {
                        firstVowelCounts.put(c, 0);
                        firstUniqueVowels++;
                    }
                    firstVowelCounts.put(c, firstVowelCounts.get(c) + 1);
                }
                if(!firstLetterCounts.containsKey(c)){
                    firstLetterCounts.put(c, 0);
                    firstUniqueLetters++;
                }
                firstLetterCounts.put(c, firstLetterCounts.get(c) + 1);
            }
            int firstVowelsTwice = 0;
            for(Map.Entry<Character, Integer> entry: firstVowelCounts.entrySet()){
                if(entry.getValue() >= 2){
                    firstVowelsTwice++;
                }
            }
            if(firstVowelsTwice != 1){
                validFirst=false;
            }
            if(firstUniqueVowels >3){
                validFirst=false;
            }
            boolean firstIsDouble = false;
            for(Map.Entry<Character, Integer> entry: firstLetterCounts.entrySet()){
                if(entry.getValue() >= 2 && entry.getKey() != first.charAt(first.length()-1)){
                    firstIsDouble = true;
                }
            }
            if(!firstIsDouble){
                validFirst=false;
            }
            if(firstUniqueLetters <5 || firstUniqueLetters >8){
                validFirst=false;
            }






            HashMap<Character, Integer> lastVowelCounts = new HashMap<>();
            HashMap<Character, Integer> lastLetterCounts = new HashMap<>();
            HashMap<Character, Integer> lastConsonantCounts = new HashMap<>();
            int lastUniqueVowels = 0;
            int lastUniqueLetters = 0;
            int lastUniqueConsonants = 0;
            for(Character c: last.toCharArray()){
                if ("aeiouAEIOU".indexOf(c)!=-1)
                {
                    if (!lastVowelCounts.containsKey(c)) {
                        lastVowelCounts.put(c, 0);
                        lastUniqueVowels++;
                    }
                    lastVowelCounts.put(c, lastVowelCounts.get(c) + 1);
                }
                else{
                    if(!lastConsonantCounts.containsKey(c)){
                        lastConsonantCounts.put(c, 0);
                        lastUniqueConsonants++;
                    }
                    lastConsonantCounts.put(c, lastConsonantCounts.get(c) + 1);
                }
                if(!lastLetterCounts.containsKey(c)){
                    lastLetterCounts.put(c, 0);
                    lastUniqueLetters++;
                }
                lastLetterCounts.put(c, lastLetterCounts.get(c) + 1);
            }
            if(lastUniqueLetters <7) {
                validLast = false;
//                System.out.println("to few letters "+lastUniqueLetters);
            }
            int lastNumDouble = 0;
            for(Map.Entry<Character, Integer> entry: lastLetterCounts.entrySet()){
                if(entry.getValue() >= 2){
                    lastNumDouble++;
                }
            }
            if(lastNumDouble <2){
                validLast = false;
//                System.out.println("to few doubles "+lastNumDouble);
            }
            if(lastUniqueConsonants < 3){
                validLast = false;
//                System.out.println("not enough consonants "+lastUniqueConsonants);
            }
            if(lastUniqueVowels < 1 || lastUniqueVowels >2){
                validLast = false;
//                System.out.println("wrong number of vowels "+lastUniqueVowels);
            }

            System.out.println(validFirst+" "+validLast);
            if(validFirst && validLast){
                System.out.println("No trouble for llamas tonight.");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new LLama().run();
    }
}
