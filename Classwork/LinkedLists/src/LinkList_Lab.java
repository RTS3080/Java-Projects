import java.util.*;

public class LinkList_Lab <E>
{
   private Node<E> front;
   //add a constructor

   public LinkList_Lab(){
       front = null;
   }
   public LinkList_Lab(Node<E> n ){
      front = n;
   }

   
   //add method
    //add a new node containing val to the front of the list
   public void add(E val){
       Node<E> curr;
       for(curr = front; curr != null; curr = curr.next){}
      front = new Node<>(val, front,curr);
   }
   	

   	
   	
   //add last method
    //make an addLast method to add to the end of the list

   public void addLast( E val ){
      Node<E> curr = front;
      if(front == null){
          front = new Node<>(val, null,front);
          return;
      }
      while(curr.next != null){
         curr = curr.next;
      }
      curr.next = new Node<>(val, null,curr);
   }

   //delete method
    //deletes first occurence of val
   	
   	public boolean delete( E val ){
       Node<E> curr;
       if(front.value.equals(val)){
           front = front.next;
           return true;
       }
       for(curr = front; curr != null; curr = curr.next){
           if(curr.next.value.equals(val)){
               curr.next = curr.next.next;
               return true;
           }
       }
       return false;
   }


   
   //delete all method
    //deletes all occurences of val
   	
   	public boolean deleteAll( E val ){
       boolean removed = false;
       Node<E> curr;

        for(curr = front; curr != null; curr = curr.next){
            while(curr.next!= null && curr.next.value.equals(val)){
                curr.next = curr.next.next;
                removed = true;
            }
        }
        if(front.value.equals(val)){
            removed = true;
            front = front.next;
        }
//        if(curr.value.equals(val)){
//            curr = null;
//        }
        return removed;
    }
   
 
   //find method
    //return the index of a specified value in the list 
    //return -1 if not found
   
    public int find( E val ){
      int idx = 0;
      Node curr = front;
      while(curr.next != null){
         if(curr.value.equals(val)){
            return idx;
         }
         idx++;
         curr = curr.next;
      }
      return -1;
    }
   
   

   
   //doubleFirst
     //add a new node to the front of the list with the same value of the first node
     //[ 3, 4, 6]  would become  [3, 3, 4, 6]
     
     public void doubleFirst(){
      front = new Node<>(front.value, front,null);
     }
   
   

   
   //doubleLast
     //same as doubleFirst except you are doubling the last node 
     //[ 3, 4, 6]  would become  [3, 4, 6, 6]
   public void doubleLast(){
      Node<E> curr = front;
      while(curr.next != null){
         curr = curr.next;
      }
      curr.next = new Node<>(curr.value, null,curr);
   }

   public boolean contains( E val ) {
       for (Node<E> curr = front; curr != null; curr = curr.next) {
           if (curr.value.equals(val)) {
               return true;
           }
       }
       return false;
   }
    //print / toString method
    //print / return all values in the list
    
    //void print()
    public String toString(){
        String s ="";
        for(Node<E> curr = front; curr != null; curr = curr.next){
            s += curr.value + " ";
        }
        return s;
    }
   
   
}
