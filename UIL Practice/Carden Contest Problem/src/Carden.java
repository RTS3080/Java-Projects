import java.util.*;
import java.io.*;

public class Carden{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Carden".toUpperCase().toLowerCase()+".dAt".toUpperCase().toLowerCase()));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            TreeMap<String,String> replacements = new TreeMap<>();
            replacements.put("o", "()");
            replacements.put("O", "()");
            replacements.put("l", "|");
            replacements.put("G", "6");
            replacements.put("V", "\\/");
            replacements.put("v", "\\/");
            int newWords = f.nextInt(); f.nextLine();
            for (int i = 0; i < newWords; i++) {
                String word = f.next();
                String replacement = f.next();
                replacements.put(word, replacement);
            }
            int vowelMult = f.nextInt();
            f.nextLine();
            String[] ln = f.nextLine().split("");
            ArrayList<String> sentence = new ArrayList<>(Arrays.asList(ln));
            for(String str : sentence){
                System.out.print(str);
            }
            System.out.println();
            ArrayList<Integer> spots = new ArrayList<>();
            for (int i = 0; i < sentence.size(); i++) {
                for(String e : replacements.keySet()){
                    if(sentence.get(i).matches(e) && !spots.contains(i)) {
                        String a = replacements.get(e);
                        sentence.set(i, a);
                        spots.add(i);
                    }
                }
                if(sentence.get(i).matches("[aeiouAEIOU]")&& !spots.contains(i)){
                    sentence.set(i,sentence.get(i).repeat(vowelMult));
                    spots.add(i);
                }
                if(sentence.get(i).matches("\\p{Punct}")&& !spots.contains(i)){
                        sentence.set(i,"");
                }
            }
            for (int i = 0; i < sentence.size(); i++) {
                if(i%4 == 0 && !spots.contains(i)){
                    sentence.set(i,sentence.get(i).toUpperCase());
                }
            }
            for(String let : sentence){
                System.out.print(let);
            }
            System.out.println();

//            System.out.println(sentence);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Carden().run();
    }
}
