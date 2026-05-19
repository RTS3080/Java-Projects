enum Test{
    ONE(1), TWO(2), THREE(3);
    int a;
    private Test(int a){
        this.a = a;
    }

    public void testing(){
        for(Test t : values()){}
    }
}