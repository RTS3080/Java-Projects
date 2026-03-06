public class Monster {
    private int age;
    private Double height;
    private int weight;
    private String name;
    public Monster(){
        age=10;
        height=6.9;
        weight=300;
        name="Billy";
    }
    public Monster(int a, double h, int w, String n){
        age=a;
        height=h;
        weight=w;
        name=n;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public void getOlder(int a){
        age+=a;
    }
    public String toString(){
        return("Name: "+name+"\nAge: "+age+"\nHeight: "+height+"\nWeight: "+weight);
    }

}
