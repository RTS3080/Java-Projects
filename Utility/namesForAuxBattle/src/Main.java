public class Main {
    public static void main(String[] args) {
        String names="Ryder, Zach, Justus, Garrett, Matt, Jackson, Ava, Wyatt?, Lily?, Liz?, Caleb?, Sol?, Emily? Laney?, Kelsey?";
        names=names.replaceAll("[,\\?]","");
        for (int i = 0; i < names.split(" ").length; i++) {
            System.out.println(names.split(" ")[i]);
        }
    }
}