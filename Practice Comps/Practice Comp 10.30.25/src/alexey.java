import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class alexey{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("alexey".toLowerCase()+".dat"));

        while (f.hasNext()){
            String op = f.next();
            int one = f.nextInt();

            int two = 0;

            if (!op.equals("N")){
                two = f.nextInt();
            }

            ArrayList<Character> charList;
            String bString;
            String resultStr;

            int result = -1;

            switch (op){
                case "N":
                    bString = Integer.toBinaryString(one);

                    resultStr = Integer.toBinaryString(~one);
                    resultStr = resultStr.substring(resultStr.length()-bString.length());

                    result = Integer.parseInt(resultStr, 2);
                    break;
                case "A":
                    result = one & two;
                    break;
                case "O":
                    result = one | two;
                    break;
                case "X":
                    result = one ^ two;
                    break;

                case "LS":
                    result = two << one;
                    break;
                case "RS":
                    result = two >> one;
                    break;

                case "RC":
                    charList = new ArrayList<>();
                    bString = Integer.toBinaryString(two);
                    for (char each : bString.toCharArray()){
                        charList.add(each);
                    }

                    Collections.rotate(charList, one);

                    resultStr = "";
                    for (char each : charList){
                        resultStr += each;
                    }

                    result = Integer.parseInt(resultStr, 2);
                    break;

                case "LC":
                    charList = new ArrayList<>();
                    bString = Integer.toBinaryString(two);
                    for (char each : bString.toCharArray()){
                        charList.add(each);
                    }

                    Collections.rotate(charList, -one);

                    resultStr = "";
                    for (char each : charList){
                        resultStr += each;
                    }

                    result = Integer.parseInt(resultStr, 2);
                    break;
            }

            System.out.println(result);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new alexey().run();
    }
}
