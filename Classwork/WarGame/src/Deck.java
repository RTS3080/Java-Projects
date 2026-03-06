
import java.util.*;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
class Deck {

	/** cards contains all the cards in the deck.*/
	private ArrayList<Card> cards;

	/** pointer to the current card to be dealt*/
	private int top;


	/**
	 * Creates a new Deck instance.
	 * It pairs each element of faces with each element of suits,
	 * and produces one of the corresponding card.
	 * @param faces is an array containing all of the card faces - JACKS, KING, TWO, FIVE, etc.
	 * @param suits is an array containing all of the card suits - CLUBS, DIAMONDS, etc.
	 * @param values is an array containing all of the card point values.
	 *	Precondition: faces.length == values.length
	 *	Precondition: faces.length > 0, suits.length > 0, values.length > 0
	 */
	public Deck(String[] faces, String[] suits, int[] values) 
   {
		/*	Hint: Do not make the arrays in this constructor! 
		 *	You have to use the arrays given in the Tester / Game to make a Card to add to cards.
       * Look at the code in the CardDeckPlayerTester.java file
       * top needs to be set to the top of the Deck
		 */
	   cards=new ArrayList<Card>();
	   for (int i = 0; i < suits.length; i++) {
		   for (int j = 0; j < faces.length; j++) {
			   cards.add(new Card(suits[i],faces[j],values[j]));
		   }
	   }
	   top= cards.size()-1;
	}


	/**
	 * Determines if this deck is empty - where is the top card pointing
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return top<0;
	}


	/**
	 * getNextCard ( deal ) returns the top card from the Deck.  
      Cards are dealt from the last card in the deck(highest index).
      top will point at the current card
      decrement top to move down to the next card 
	 * @return the card just dealt,or null if the deck is empty */
	public Card getNextCard() 
	{		
      // Hint: DO NOT REMOVE CARDS FROM THE LIST!!!
		return cards.get(top--);
	}
	
	/**
	 * shuffle will pick up all the cards and mix them randomly.
    * reset top to the top of the deck
    * DO NOT USE Collections.shuffle(), Use Math.random() and a swap algorithm.
	 */
	public void shuffle() {
//		Random r= new Random();
//		for (int i = 0; i < cards.size(); i++) {
//			int swap1 = r.nextInt(0,cards.size());
//			int swap2 = r.nextInt(0,cards.size());
//			Card tmp=cards.get(swap1);
//			cards.set(swap1,cards.get(swap2));
//			cards.set(swap2,tmp);
//		}
		Collections.shuffle(cards);
	}
   
   
	/**
	 * returns the number of cards in the deck
      it would return 52 for a standard deck of cards
      it might return a different value as well
	 */
	public int size() {		
		return cards.size();
	}   
	
	
	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	public String toString() {
		String rtn = "";
      //add all cards to rtn
		for (int i = 0; i < size(); i++) {
			Card tmp=cards.get(i);
			rtn+=tmp.toString()+"\n";
		}
      //add the value of top at the end of the string
		rtn+="top = "+cards.get(top).toString();

		return rtn;
	}
}
