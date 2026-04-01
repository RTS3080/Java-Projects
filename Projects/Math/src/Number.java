import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.stream.IntStream;

import static java.lang.Math.*;




public class Number{
    
    String num; // base 16 num
    int size;
    public Number(long n){
        num = Long.toHexString(n).toLowerCase();
        size = num.length();
    }
    public Number(String s){
        num = s;
    }
    public Number(int n){
        num = Integer.toHexString(n).toLowerCase();
    }
    public String toString(){
        return ""+Integer.parseInt(num, 16);
    }
    void updateSize(){
        this.size = num.length();
    }
//    im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it

    void add(Number n){
        this.num = base2toBase16(add(this, n));
        updateSize();
    }

    static String add(Number a, Number b){
        String minLen = a.size <= b.size ? a.getBase2() : b.getBase2();
        String maxLen = a.size > b.size ? a.getBase2() : b.getBase2();
        minLen = "0".repeat(maxLen.length()-minLen.length())+minLen;

        int[] min = minLen.chars().asLongStream().mapToInt(i -> (int)i-'0').toArray();
        int[] max = maxLen.chars().asLongStream().mapToInt(i -> (int)i-'0').toArray();
        int[] out = new int[max.length];
        boolean addplace = false;
        for(int i = max.length-1; i >= 0; i--){
            int val = min[i] + max[i];
            if(val>1){
                if(i==0) addplace = true;
                else{
                    max[i-1]++;
                }
            }
            out[i] = val%2;
        }
        String res = "";
        if(addplace){
            res="1";
        }
        for (int i = 0; i < out.length; i++) {
            res+=out[i];
        }
        return res;
    }
    static String add(String a, String b){
        String minLen = a.length() <= b.length() ? base16toBase2(a) : base16toBase2(b);
        String maxLen = a.length() > b.length() ? base16toBase2(a) : base16toBase2(b);
        minLen = "0".repeat(maxLen.length()-minLen.length())+minLen;

        int[] min = minLen.chars().asLongStream().mapToInt(i -> (int)i-'0').toArray();
        int[] max = maxLen.chars().asLongStream().mapToInt(i -> (int)i-'0').toArray();
        int[] out = new int[max.length];
        boolean addplace = false;
        for(int i = max.length-1; i >= 0; i--){
            int val = min[i] + max[i];
            if(val>1){
                if(i==0) addplace = true;
                else{
                    max[i-1]++;
                }
            }
            out[i] = val%2;
        }
        String res = "";
        if(addplace){
            res="1";
        }
        for (int i = 0; i < out.length; i++) {
            res+=out[i];
        }
        return res;
    }
    String getBase2(){
        return base16toBase2(num);
    }


    static String base16toBase2(String s){
        String out = "";
        for(int i = s.length()-1; i >= 0; i--){
            out = base16BitToBase2(s.substring(i,i+1))+out;
        }
        return out;
    }
    static String base2toBase16(String s){
        int numZerosNeeded = (4-s.length()%4)%4;
        s = "0".repeat(numZerosNeeded) + s;
        String out = "";
        for (int i = s.length(); i >=4; i-=4) {
            int n = Integer.parseInt(s.substring(i-4,i),2);
            if(n<10){
                out=n+out;
            }
            else{
                out=('a'+n%10) + out;
            }
        }
        return out;
    }
    static String base16BitToBase2(String s){
        if(s.length() != 1){
            throw new IllegalArgumentException("Invalid hex Number: length must be 1");
        }
        char ch = s.charAt(0);
        int n = -1;
        if(Character.isDigit(ch)){
            n = ch-'0';
        }
        else if(Character.isAlphabetic(ch)){
            n = ch-'a' + 10;
        }
        if(n > 15 || n < 0){
            throw new IllegalArgumentException("Invalid hex Number: must be between 0 and f");
        }
        return "0".repeat(Integer.numberOfLeadingZeros(n)-28)+Integer.toBinaryString(n);
    }


}

//    im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it im numbering it im numberin it im numbering it
