import java.util.*;
import java.io.*;

class darth {
    public static void main(String[] args) throws Exception {
        darth a = new darth();
        a.run();
    }

    public void run() throws Exception {
        System.out.println("                                +;;;++++++++++                                   \n" +
                "                        ;;+++++++xxxxxxxxxxxxxxxxx++++                           \n" +
                "                     +;+++++xxxxxxxxxxxXXXXXXXXXxxxxxxxx+                        \n" +
                "                   ;+++xxxxxxxxxxxxxxxxxxXXXXXXXXxXXXXXxx+++                     \n" +
                "                  ;++xxXXXXxXxxxx+;;+;;+xXxXXXXXXXXXXXXXXXx++                    \n" +
                "                ;xx++XXXXXXXXXxxx+;;+;;+xXxxxXXXXXXXXXXXXXXXx+;                  \n" +
                "                ;x+xXXXXXXXXXXxxx+;+x;;+xxxxxxXXXXXxXXXXXXXXXx;;                 \n" +
                "               ;;+xXXXXXXXXXXXxxxx++x;;;xXXxxxXXXXXXXXXXXXXXXXx;;                \n" +
                "              ;;+xXXXXXXXXXXXXXxx+++x;;;+xXXXXXXXXXXXXXXXXXXXXX+;                \n" +
                "             :;;+XXXXXXXXXXXXXXXx+++x+;+xxxxXXXXXXXXXXXXXXXXXXXx;                \n" +
                "            ;;;;xXXXXXXXXXXXXXXXxx+xxxxxxXxxxXXXXXXXXxXXXXXXXXXX+:               \n" +
                "            ;;;;+XXXXXXXXXXXXXXXxxxxXXXXXXXXXXXXXXXXXXXXXXXXXXXX+;               \n" +
                "           ;;;;++xXXXXXXXXXXxXXXXxxXXXXXXXXXXxx+xXXXXXXXXXXXXXXXx+;              \n" +
                "           ;;;;+++++xX+xxxxxxxxx;;+XXXXXXXXXXxxXXXXXxXXXxxXXXXXXx+;              \n" +
                "           :;;+++;;;x+xxxXxXxxx;;xxx;xx+;+;+xxxXXXXXXXXXXxx++xXXx+;              \n" +
                "           ;;;++;;;xxxxXXxxxxx+;;+xx+x+;+;;;;;;xxXxxxxxXXxxx++++x;;              \n" +
                "          ;;;;;;;+xXXXXX$$$$$$XXXXXXXx;;+xxxXXXXXXXXXXXXXXXXx++;;;;              \n" +
                "          :;;;;;+XXXX$$$$$$$$$$$$$$XX$XXXXXXXXXXXXXX$$$$XXXXXXx;;;;;             \n" +
                "          ;;;;+XX$$X$$$$$$$$$$$$$$$XXXXx+xXXXxxX$$$$$$$$$$XX$XXX+;;;             \n" +
                "          ;;;XXX$$$$$$$$$$$XXxxXXXXXXXXxxxXXXXXXXXXX$$$$$$$X$$$XXX;;;            \n" +
                "          ;;XX$$$X$$$$$$$$XXXXXXXXXXXXxxxxXXXXXxx++X$$$$$$$XX$$$XXX;;:           \n" +
                "         :;XX$$$$$$$$$$$XXXXXXXXXX$XXXXXxxXXXXXX+XXXXXX$$$$$x$$$$XXX;;           \n" +
                "        ;;XX$$$$$$X$$$$$XX$$XXXX$$XXXXXXxxXXXXXXxxxXXX$$$$$$X$$$$$XXX;:          \n" +
                "        :xXX$$$$$$$$$XXXXXXXxxxx++xXXXXXXxXXXx+x+;xXXXXXXXXXX$$$$$$XXx;:         \n" +
                "       ;xXX$$$$$$$XXXXXxx++;;;++xXXXXXXXXxXXXXXXXx++xXXXXXXXXX$$$$$$XXx;;        \n" +
                "      ;+XX$$$$$$$$XXXXXXxxxxxXXXXXXXXxxxxXXxx+x++xXXXXXXXXXXX$$$$$$$XXX+;        \n" +
                "      ;XXX$$$$$$$$XXXXXXXXXXXXXXXXXX+;;;;+xXxx+;;;;;;;;+xxxX$$$$$$$$$XXX;;       \n" +
                "     ;xXX$$$$$$$$$XXXXXXXXXXXXXXXXXx;;;;;;+XXXx;;;;;;;++++XX$$$$$$$$$$XXX;;      \n" +
                "    ;+XXX$$$$$$$$$XXXXXXXXXXXXXXXXXX+;;;;;XXxxXX+;;;;++++XXXXXXXXXXXXXXXXx;      \n" +
                "    +XXX$$$$$$$$$$XXXXXXXXXXXXXXXXXXX$XXX$$$XXxXXX+;;;+++XXXXXXXXXXXXX$XXX;;     \n" +
                "   ;xXXX$$$XX$X$$$XXXXXXXXXXXXXXXXXXXXXXXX$XXXXxXxXX+;++xXXXXXXXXXXXXXXXXXX;;    \n" +
                "   +XXXX$$$XXXX$$$$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxXXx+XXXX$XXXXXXXXXXXXXXx;;   \n" +
                "  ;xXXX$$$XXXXXX$$$XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX+xxxXXxXXXXX$$XXXXXXXXXXXXX+;   \n" +
                "  xXXXXXXXXXXXXX$$$XXXxxXXXXXXXXXXxXXXXXXXXXXXXXXXxXXXxxXXXXXXXXXXXXXXXXXXXXX;;  \n" +
                " +XXXXXXXXXXXXXXXXXXXXXxxxXXXXXXXXXXXXXXXXXXXXXXXXXxXxxxXXXXXXXXXXXXXXXXXXXXXx;; \n" +
                " XXXXXXXXXXXXXXXXXXXxXX;;;XXXXXXXXXXXXXXXXXXXXXXXxxX+x;;XXXXXXXXXXXXXXXXXXXXXX;; \n" +
                "XXXXXXXXXXXXXXXXXXXXXXXx+xXXXXXXXXXXXXXXXXXXXXXXXXXXX+;;xXXXXXXXXXXXXXXXXXXXxxxx+\n" +
                "XXXXXXXXXXXXXXXXXXXXXxx++xXXXXXXXXXXXXXXXXXXXXXxxxxXXxxXXXXXXXXXXXXXXXXXXXXXXxxxx\n" +
                "XXXXXXXXXXXXXXXXXXXXXx++++xXXXXXXXXxXXxxxxXXXXXXXXXxxxxxXXXXXXXXXXXXXXXXXXXXXX+xx\n" +
                "xXXXXXXXXXXXXXXXXXXXx+++++xxXXXXXXXXXXxxXXXXXXXXXXXXxxxXXXXXXXX$$$$$$$$$$XXXX+++ \n" +
                "++XXXXXXXXXXXXXXXXXX++x+xxxXXXXXXXXXXXXXXXxxXXXXXXXxxxxXXXXXXXXXxXXXXXX          \n" +
                "  ;;xX$$$$$X$X$$$$Xx++xxxxXXXXXXXXXXXXXXXxxXXXXXXXXXXXXXXXXXXX                   \n" +
                "                  +++xxxXXXXXXXXXXXXXXXXXXXXXXXXXXxXXXXXXXXXXX                   \n" +
                "                  x+xxxxXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxXXXxXXX                    \n" +
                "                   xxxxXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxxxxxx                       \n" +
                "                    xxxxXXXXXXXXXXXXXxxxxxxxxx++++xx++++x                        \n" +
                "                       xXXXXXXXXXXxXxxxxxxxxxx++;;;;:;                           \n" +
                "                          XXXXXXXxxXXXXXXxxxx+;;;;;;                             \n" +
                "                               Xxxxxxxxxxxx+++;;                                 ");
    }
}