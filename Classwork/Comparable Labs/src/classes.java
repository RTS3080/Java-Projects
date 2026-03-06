public class classes {
}
class len implements Comparable<len>{
    String s;
    public len(String s){
        this.s = s;
    }
    public int compareTo(len o) {
        return s.length()-o.s.length();
    }
    public String toString(){
        return s;
    }
}

class vows implements Comparable<vows>{
    String s;
    int numVows;
    public vows(String s){
        this.s = s;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i,i+1).matches("[aeiou]"))
                numVows++;
        }
    }
    public int compareTo(vows o) {
        return numVows-o.numVows;
    }
    public String toString(){
        return s;
    }
}

class odds implements Comparable<odds>{
    int n;
    int numOdds;
    public odds(int n){
        this.n = n;
        int i = n;
        while(i>0){
            if(i%2 == 0){
                numOdds++;
            }
            i/=10;
        }
    }
    public int compareTo(odds o) {
        return numOdds-o.numOdds;
    }
    public String toString(){
        return n+"";
    }
}

class sum implements Comparable<sum>{
    int n;
    int sum;
    public sum(int n){
        this.n = n;
        int i = n;
        while(i>0){
            sum+=i%10;
            i/=10;
        }
    }
    public int compareTo(sum o) {
        return sum-o.sum;
    }
    public String toString(){
        return n+"";
    }
}

class Person implements Comparable<Person>{
    int age;
    double weight;
    double height;
    public Person(int age, double weight, double height){
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    public int compareTo(Person o) {
        if(age!=o.age)
            return age-o.age;
        if(weight > o.weight){
            return 1;
        }
        if(weight < o.weight){
            return -1;
        }
        if(height > o.height){
            return 1;
        }
        if(height < o.height){
            return -1;
        }
        return 0;
    }
    public String toString(){
        return "("+age+", "+weight+", "+height+")";
    }
}