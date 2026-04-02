interface W{
    int z = 2;
    private int go(int b){
        return z+b;
    }
    static int why(){
        return 3;
    }
    default int k (int r){
        return go(r) + why();
    }
}
class A implements W{
    public int x;
    public A(int q){
        x = q;
    }
    public int fun(){
        return go(x) + W.why();
    }
    public int go(int w){
        return k(w) + x + this.z;
    }
}
class B extends A{
    private int h;
    public B(int p, int z){
        super(p);
        h = z;
    }
    public int fun(){
        return super.k(3) + super.go(h);
    }
}