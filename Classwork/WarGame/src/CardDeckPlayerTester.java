 
class CardDeckPlayerTester 
{
	public static void main(String[] args) 
	{
		//Test Each of the Methods and Constructors as you type them
      
      //Make 3 more Cards (1 w/ higher pointValue, 1 w/ same pointValue, 1 w/ lower pointValue)
      Card jackOfHearts = new Card( "HEARTS", "JACK", 11);
      
      //Output the 4 cards
      
      //test the 3 card accessor methods
      
      //Output the Card.compareTo methods  
      // compare the jackOfHearts to the other 3 cards
      
      
            
      //Use the following arrays to construct a new Deck of Cards
      String[] suitsDemo = new String[]{"BLUE","GREEN"};
      String[] facesDemo = "DOG CAT FROG CHICKEN".split(" ");
      int[] pvDemo = new int[]{20,40,60,80};
      //Instantiate a new Deck using the arrays above      
      
      
      //Use the following arrays to construct a new Deck of Cards
      String[] suits = new String[]{"HEARTS","DIAMONDS","SPADES","CLUBS"};
      String[] faces = "TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE".split(" ");
      int[] pv = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14};
      
      
      //Instantiate a new Deck using the arrays provided above      
      Deck deck= new Deck(faces,suits,pv);
      deck.shuffle();
      // print the deck
        System.out.println("Printing deck\n"+deck);
      // deal 5 cards
        System.out.println("\nDealing 5 Cards");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.getNextCard());
        }
      // print the deck again
        System.out.println("\nPrinting deck again\n"+deck);
        System.out.println(deck);
      // Create a new Player
        Player test= new Player("Ryder");
        test.addCard(deck.getNextCard());
        test.addCard(deck.getNextCard());
      // print the player
        System.out.println("\n"+test);
      // deal a card from the deck to the player
        test.addCard(deck.getNextCard());
      // play a card (print this card)
        System.out.println(test.playCard());
      // test any other methods that you need to in here before you start programming the card game!
	}
}
