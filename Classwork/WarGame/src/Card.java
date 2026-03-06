
class Card implements Comparable{

	
	private String suit; /** Suit of the card (clubs, hearts, spades, diamonds - potentially )*/
	private String face; /** Face of the card (e.g., TWO, JACK, ACE, KING, QUEEN - potentially )*/
	private int pointValue; /** The point value - what is the card worth in the current game */


   /** Creates a new Card instance. */
   public Card(){
	   suit="Spades";
	   face="Ace";
	   pointValue=14;
   }
	public Card(String sut, String fac, int val )
   {
	   suit=sut;
	   face=fac;
	   pointValue=val;
   }


	/** Implement accessor (get) methods for each of the instance variables */
   //make get methods for suit, face, and pointValue
   	public String getSuit(){
		   return suit;
	}
	public String getFace(){
		   return face;
	}
	public int getPointValue(){
		   return pointValue;
	}

	
	/* This method returns the difference in the pointValues of each card */
   /* Only compare the point values of each card. */
   /* Return 1 if this card's point value is larger than otherCard's point value. */
   /* Return -1 if this card's point value is less than otherCard's point value. */
   /* Return 0 if this card's point value is the same as the otherCard's point value. */
	public int compareTo( Object anotherCard )
   {
      // type casting so we can use the Card accessor methods.
      Card otherCard = (Card) anotherCard;
	  if(this.pointValue>otherCard.pointValue)
		  return 1;
	  else if(this.pointValue< otherCard.pointValue)
		  return -1;
      return 0;
	}
		
	/** Override Object's toString
       Format like this: "face of suit (point value = pointValue)".*/
	public String toString() {
		return(face+" of "+suit+" (point value = "+pointValue+")");
	}
}
