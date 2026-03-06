import java.util.*;
import java.io.*;
import java.awt.*;

public class jediTesting{

    public void run() throws FileNotFoundException{
        Temple jediTemple = new ObiWanThing();
        Jedi padawan = jediTemple.trainJedi();
        jediTemple = new AnakinThing();
        Jedi youngling = jediTemple.trainJedi();
        padawan.force();
        youngling.force();
    }
    interface Jedi {
        void force();
    }
    class ObiWan implements Jedi {
        public void force() {
            System.out.println("Hello there");
        }
    }
    class Anakin implements Jedi {
        public void force() {
            System.out.println("I never liked sand");
        }
    }
    abstract class Temple {
        public abstract Jedi trainJedi();
    }
    class ObiWanThing extends Temple {
        public Jedi trainJedi() {
            return new ObiWan();
        }
    }
    class AnakinThing extends Temple {
        public Jedi trainJedi() {
            return new Anakin();
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        new jediTesting().run();
    }
}