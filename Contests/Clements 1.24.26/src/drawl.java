import java.util.*;
import java.io.*;
import java.awt.*;

public class drawl{

    public void run() throws FileNotFoundException{
        System.out.println("                        ###\n" +
                "                      ##  ##\n" +
                "                    ###     ##\n" +
                "                   ##         ##\n" +
                " -+++           ###            ####            ++-\n" +
                " +   +##+#######      8888888      #######-##++  +\n" +
                "++     #          8888+     +8888         +#     +\n" +
                "+      ##       888             888       ##     ++\n" +
                "++      #      88                 88     +#      ++\n" +
                " +      ##    88                   88    #+      + \n" +
                " ++      #    8-       \\   /       88   ##      +\n" +
                "   +      #   -8   ####     ####   88   #      +\n" +
                " +       ##   8-  ######   ######  88   ##       +\n" +
                " +      +#    88   ####     ####  888    #       +\n" +
                " ++     ##     888               888     ##     ++\n" +
                "  ++   -#       8888           8888       #    ++\n" +
                "   ++  #          888         888         ##  ++\n" +
                "    ++####          +888888888          +###+++\n" +
                "      ##########               ###########\n" +
                "         ###########          ##########+\n" +
                "            ##########       #########+\n" +
                "                   ####    +####\n" +
                "                    ##### ####-\n" +
                "                      #######\n" +
                "                        ###");
    }



    public static void main(String[] args) throws FileNotFoundException{
        new drawl().run();
    }
}
