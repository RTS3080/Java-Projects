import java.util.*;

class Player
{
	private ArrayList<Card> hand;
	private int wins;
	private String name;
   
   //DO NOT add an instance variables for a DECK
   
	
/* Implement a constructor that takes a players name */
   public Player(){
       hand= new ArrayList<>();
       wins=0;
       name="Billy Bob Joe";
   }
   public Player(String n){
       hand=new ArrayList<>();
       wins=0;
       name=n;
   }
   
/* Implement accessor methods for each of the instance variables */

    public int getWins() {
        return wins;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }


    /* Implement the addCard method that takes a card and
 * adds the card to the players hand 
 */
   public void addCard( Card c){
      hand.add(c);
   }

/* Implement the playCard method that returns the top card in the players hand
 *  and also removes the card from the hand.
 * Hint: you have to check if the player has a card to play! Use the hasCards method.
 */
   public Card playCard(){
      if(hasCards()){
          return hand.remove(0);
      }
      else return null;
   }

   public void setName(String name){
       this.name=name;
   }
 
 /* Implement the win method that adds one to the players wins */
   public void win(){
       wins++;
   }
   
 /* Implement the hasCards method that will return true
  * if the player has cards in its hand 
  */
  public boolean hasCards(){
      return hand.size()>0;
  }
  public int numCards(){
      return hand.size();
  }
      
 /*Override the toString method to return a string formatted like this:
 * Name: Kyle
 * Wins: 13
 * Hand: {TWO of HEARTS(point value = 2), ACE of SPADES (point value = 14), KING of DIAMONDS (point value = 13)}
 */
    public String toString(){
        return "Name: "+name+"\nWins: "+wins+"\nHand :{"+hand.toString()+"}";
    }
	
}