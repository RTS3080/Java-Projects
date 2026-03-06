import java.util.*;
import java.io.*;

//Ryder Sanchez
public class DecodeString{

    public static String decodeString(String s) {
        Stack<String> letters = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        String[] ln = s.split("[\\[\\]]");
        for(String str : ln){
            if(str.matches("[0-9]")){
                nums.push(Integer.parseInt(str));
            }
            else{
                letters.push(str);
            }
        }
        System.out.println(letters);
        System.out.println(nums);
        while(!letters.isEmpty() && !nums.isEmpty()){
            letters.add(letters.pop().repeat(nums.pop()));
        }
        for(String str : letters){
            System.out.print(str);
        }
        System.out.println();
        return null;
    }
    public static void main(String[] args){
        decodeString("3[a]2[bc]");
    }
    
    

}
