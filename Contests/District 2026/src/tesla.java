import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class tesla{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tesla".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int commands = f.nextInt();

        HashMap<String, ArrayList<String>> catToItems = new HashMap<>();
        HashMap<String, Integer> itemToCount = new HashMap<>();

        while (commands-- > 0){

            String command = f.next();
            String category, item;
            int quantity;
//
            System.out.println(command);
            System.out.println(catToItems);
            System.out.println(itemToCount);

            System.out.println("-".repeat(10));

            switch (command){
                case "ADD":
                    category = f.next();
                    item = f.next();
                    quantity = f.nextInt();

                    if (!catToItems.containsKey(category)) catToItems.put(category, new ArrayList<>());
                    if (!catToItems.get(category).contains(item)) catToItems.get(category).add(item);

                    if (!itemToCount.containsKey(item)) itemToCount.put(item, 0);
                    itemToCount.put(item, itemToCount.get(item) + quantity);
                    break;

                case "REMOVE":
                    item = f.next();
                    quantity = f.nextInt();
                    if (itemToCount.containsKey(item)) {
                        itemToCount.put(item, Math.max(0, itemToCount.get(item) - quantity));
                    }
                    break;

                case "QUERY":
                    item = f.next();
                    System.out.println(itemToCount.getOrDefault(item, 0));
                    break;

                case "CATEGORY":
                    category = f.next();
                    ArrayList<String> items = new ArrayList<>(catToItems.getOrDefault(category, new ArrayList<>()));
                    Collections.sort(items);

                    for (int i = items.size()-1; i >= 0; i--){
                        String checkItem = items.get(i);
                        if (itemToCount.getOrDefault(checkItem, 0) == 0) items.remove(i);
                    }

                    int total = 0;
                    for (String each : items) total += itemToCount.getOrDefault(each, 0);
                    System.out.println(total);

                    if (items.isEmpty()) {
                        System.out.println("EMPTY");
                        break;
                    }

                    for (String each : items){
                        int count = itemToCount.getOrDefault(each, 0);
                        System.out.println(each+" "+count);
                    }

                    break;

                case "TOTAL":
                    int count = 0;
                    for (String each : itemToCount.keySet()){
                        if (itemToCount.get(each) > 0) count++;
                    }
                    System.out.println(count);
                    break;

                case "LIST":
                    ArrayList<String> categories = new ArrayList<>();
                    for (String each : catToItems.keySet()) categories.add(each);
                    Collections.sort(categories);

                    ArrayList<String> allItems = new ArrayList<>();

                    for (String each : categories){
                        ArrayList<String> itemList = new ArrayList<>(catToItems.getOrDefault(each, new ArrayList<>()));
                        Collections.sort(itemList);

                        for (int i = itemList.size() - 1; i >= 0; i--){
                            String checkItem = itemList.get(i);
                            if (itemToCount.getOrDefault(checkItem, 0) == 0){
                                itemList.remove(i);
                            }
                        }

                        for (String inEach:itemList){
                            System.out.println(each+" "+inEach+" "+itemToCount.get(inEach));
                        }

                        allItems.addAll(itemList);
                    }

                    if (allItems.isEmpty()){
                        System.out.println("EMPTY");
                        break;
                    }

//                    for (String each : allItems){
//                        System.out.println(each+" "+itemToCount.getOrDefault(each, 0));
//                    }

            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tesla().run();
    }
}
