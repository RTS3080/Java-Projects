import java.util.*;
import java.io.*;
import java.awt.*;

public class grocery{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("grocery".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] groceries = f.nextLine().split(" ");
            int times2=f.nextInt(); f.nextLine();
            Store[] stores = new Store[times2];
            int[] storeScores = new int[times2];
            for (int i = 0; i < times2; i++) {
                String storeName = f.next();
                int times3=f.nextInt(); f.nextLine();
                ArrayList<Item> items = new ArrayList<>();
                while(times3-->0){
                    String itemName = f.next();
                    double price = f.nextDouble(); f.nextLine();
                    for(String s : groceries){
                        if(s.equals(itemName)){
                            items.add(new Item(s, price));
                        }
                    }
                }
                stores[i] = new Store(storeName, items, i);
            }
            for(String s : groceries){
                double bestPrice = Double.MAX_VALUE;
                int bestInd = -1;
                for (int i = 0; i < stores.length; i++) {
                    for(Item it : stores[i].items){
                        if(s.equals(it.name)){
                            if(it.cost < bestPrice){
                                bestPrice = it.cost;
                                bestInd = i;
                            }
                        }
                    }
                }
                storeScores[bestInd]++;
            }
            int bestInd = -1;
            int bestScore = -1;
            for (int i = 0; i < storeScores.length; i++) {
                if(storeScores[i] > bestScore){
                    bestScore = storeScores[i];
                    bestInd = i;
                }
            }
            Store bestStore = stores[bestInd];

            System.out.println(bestStore.name+"'s prices are top G!!!");

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new grocery().run();
    }
}
class Store{
    String name;
    ArrayList<Item> items;
    int ind;
    public Store(String name, ArrayList<Item> items, int ind){
        this.name=name;
        this.items=items;
        this.ind=ind;
    }
}
class Item{
    double cost;
    String name;
    public Item(String name, double cost){
        this.cost=cost;
        this.name=name;
    }
    public String toString(){
        return name+" "+cost;
    }
}