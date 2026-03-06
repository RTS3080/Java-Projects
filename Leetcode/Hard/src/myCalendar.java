import java.util.*;
import java.io.*;

class MyCalendar {
    public ArrayList<Integer[]> events;
    public ArrayList<Boolean> canAdd;

    public MyCalendar() {
        events = new ArrayList<>();
        canAdd = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Integer[] pairs : events) {
            if ((start >= pairs[0] && start < pairs[1]) || (end > pairs[0] && end <= pairs[1])) {
                return false;
            }
            if(pairs[0] >= start && pairs[0] <end || pairs[1] >= start && pairs[1] < end) {
                return false;
            }
        }
        Integer[] a = new Integer[] { start, end };
        events.add(a);
        return true;
    }
    public static void main(String[] args) {
        MyCalendar cal =new MyCalendar();
        String[] a = "97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37],[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15".split("[,\\[\\]]+");
        for (int i = 0; i < a.length; i+=2) {
            int start = Integer.parseInt(a[i]);
            int end = Integer.parseInt(a[i+1]);
            System.out.println(cal.book(start, end));
            System.out.println(start+" "+end);
            for(Integer[] ints : cal.events) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
        }

    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */