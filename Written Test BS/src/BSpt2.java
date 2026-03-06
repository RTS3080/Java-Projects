public class BSpt2 extends a {

    String noise() {
        return "" + speed;
    }

    public int ret() {
        return 0;
    }
}

interface b {
      int f = 5;
     int ret();
}

abstract class a implements b {
    protected int speed;
    abstract String noise();
    public String toString(){
        return noise() + " "+speed + " " + ret();
    }
}
