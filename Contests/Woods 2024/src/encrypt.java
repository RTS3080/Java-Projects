import java.util.*;
import java.io.*;
public class encrypt {
    public static void main(String[] args)throws Exception{
        new encrypt().run();
    }
    public String encrypt(String s, String key){
        ArrayList<String> al  = new ArrayList<>(Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split("\\s+")));
        String encryptStr = "";
        for (int i = 0; i < s.length(); i++) {
            int passAlphaPos = al.indexOf(s.charAt(i)+""), keyAlphaPos = al.indexOf(key.charAt(i)+"");

            int resultXOR = passAlphaPos^keyAlphaPos;

            if(resultXOR>=26){
                resultXOR%=26;
            }
            else if(resultXOR<=-1 && Math.abs(resultXOR)>26){
                resultXOR=Math.abs(resultXOR)%26;
            }
            else if(resultXOR<=-1){
                resultXOR*=-1;
            }
            encryptStr+=al.get(resultXOR);
        }
        return encryptStr;
    }
    public void run() throws Exception{
        Scanner f = new Scanner(new File("encrypt.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while(t-->0){
            String key = f.nextLine();
            String[] pass = f.nextLine().split("\\s+");
            ArrayList<String> al = new ArrayList<>();
            for (String string : pass) {
                al.add(encrypt(string, key));
            }
            Collections.sort(al);
            String str = "";
            for (String s :
                    al) {
                str+=s+" ";
            }
            System.out.println(str.trim());

        }
        f.close();

    }
}