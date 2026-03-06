import java.util.*;

class Structure{
    final int SIZE;
    ArrayList<String>[] storage;

    public Structure(int size){
        SIZE = size;
        storage = new ArrayList[size];
        for (int i = 0; i < size; i++){
            storage[i] = new ArrayList<>();
        }
    }

    public int encode(String str){
        int result = 0;

        for (int i=0; i<str.length(); i++){
            char each = str.charAt(i);
            int temp =  each * (int)Math.pow(31, str.length()-i-1);

            result += temp;
        }
        return result%SIZE;
    }

    public void method1(String str){
        int ind = encode(str);
        storage[ind].add(str);
    }

    public boolean method2(String str){
        int ind = encode(str);
        return storage[ind].contains(str);
    }


}


