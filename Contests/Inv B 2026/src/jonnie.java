import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jonnie{
    HashMap<Character, Integer> letterScores= new HashMap<>();
    ArrayList<Integer> possiblePreviousCharacters;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jonnie".toLowerCase()+".dat"));
        String[] vals = "1 3 3 2 1 4 2 4 1 8 5 1 3 1 1 3 10 1 1 1 1 4 4 8 4 10".split(" ");
        for (int i = 0; i < 26; i++) {
            letterScores.put((char)('A'+i),Integer.parseInt(vals[i]));
        }
        int n = f.nextInt();
        int players = f.nextInt();
        int numWords = f.nextInt();
        String[] words  = new String[numWords];
        int[][] wordCharCounts = new int[numWords][26];
        int[] wordValues = new int[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = f.next().toUpperCase();
            wordCharCounts[i] = calculateCharCounts(words[i]);
            wordValues[i] = calculateScore(words[i]);
        }
        boolean[] prevPlayed = new boolean[26];
        int[] playerScores = new int[players];

        boolean firstPlayer = true;
        for(int times = 0; times < n;times++){
//            System.out.println(Arrays.toString(prevPlayed));
            String availableLetters = f.next();
            int[] letterCounts = calculateCharCounts(availableLetters);

            int maxScore = -1;
            String bestWord = "";
            for (int i = 0; i < words.length; i++) {
                if(possibleWord(wordCharCounts[i], letterCounts, prevPlayed, firstPlayer)){
                    int score = wordValues[i];
                    if(score > maxScore){
                        maxScore = score;
                        bestWord = words[i];
                    }
                }
            }
//            System.out.println(possiblePreviousCharacters);
            if(maxScore == -1){
                System.out.println("NO POSSIBLE WORDS");
            }
            else {
                playerScores[times % players] += maxScore;
                System.out.println(bestWord + " " + maxScore);
                for(char c : bestWord.toCharArray()){
                    prevPlayed[c-'A']=true;
                }

                firstPlayer = false;
            }
//            System.out.println(Arrays.toString(prevPlayed));

        }
        int maxScore = Integer.MIN_VALUE;
        int bestPlayer = -1;
        for (int i = 0; i < playerScores.length; i++) {
            if(playerScores[i] > maxScore){
                maxScore = playerScores[i];
                bestPlayer = i;
            }
        }
        System.out.println("Player "+(bestPlayer+1)+" won with a score of "+maxScore);
        f.close();
    }

    int[] calculateCharCounts(String word){
        int[] counts = new int[26];
        for(char c : word.toCharArray()){
            counts[c-'A']++;
        }
        return counts;
    }
    boolean possibleWord(int[] wordCharCounts, int[] myLetters, boolean[] prevLetters, boolean first){
        possiblePreviousCharacters = new ArrayList<>();
        if(first){
            for (int i = 0; i < 26; i++) {
                if(wordCharCounts[i] > myLetters[i]){
                    return false;
                }
            }
            return true;
        }
        ArrayList<Character> lettersNeeded = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if(wordCharCounts[i] > myLetters[i]){
                int diff = wordCharCounts[i] - myLetters[i];
                if(diff >=2) return false;
                if(prevLetters[i] && wordCharCounts[i]>0){
                    lettersNeeded.add((char)(i+'A'));
                }
                else{
                    return false;
                }
            }
        }
        if(lettersNeeded.isEmpty()){
            boolean ok = false;
            for (int i = 0; i < 26; i++) {
                if(prevLetters[i] && wordCharCounts[i]>0){
                    possiblePreviousCharacters.add(i);
                    ok= true;
                }
            }
            return ok;
        }
        if(lettersNeeded.size() == 1){
            possiblePreviousCharacters.add(Integer.valueOf(lettersNeeded.get(0)));
            return true;
        }
        return false;
    }

    int calculateScore(String word){
        int score = 0;
        for(char c : word.toCharArray()){
            score += letterScores.get(c);
        }
        return score;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new jonnie().run();
    }
}
