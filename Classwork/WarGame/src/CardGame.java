import com.sun.source.tree.Tree;

import java.util.*;

class CardGame {
    private Deck deck; // this is the deck that is being used to play the game

    //Use these variables for the 2 player version
    //Do the TWO PLAYER version FIRST
    private Player one;
    private Player two;

    //This ArrayList is for the multi-player version of the game
    private ArrayList<Player> players;  // this is the list of players for the multi player
    private ArrayList<Player> out;

    public CardGame() {
   		/* 
          * initialize all your instance variables
          * you will need arrays to create your deck and shuffle it after you make it.
            Look at the Tester for examples
          */
        String[] suits = new String[]{"HEARTS", "DIAMONDS", "SPADES", "CLUBS"};
        String[] faces = "TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE".split(" ");
        int[] pv = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
//        String[] faces = "TWO THREE FOUR FIVE".split(" ");
//        int[] pv=new int[]{2,3,4,5};

        deck = new Deck(faces, suits, pv);
        one = new Player("Ryder");
        two = new Player("John");
    }
    public CardGame(String n1, String n2){
        String[] suits = new String[]{"HEARTS","DIAMONDS","SPADES","CLUBS"};
        String[] faces = "TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE".split(" ");
        int[] pv = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14};
//        String[] faces = "TWO THREE FOUR FIVE".split(" ");
//        int[] pv=new int[]{2,3,4,5};
        deck= new Deck(faces,suits,pv);
        one=new Player(n1);
        two=new Player(n2);
    }
    public CardGame(String n1, String n2, String[] faces, String[] suits, int[] pv){
        deck=new Deck(faces,suits,pv);
        one=new Player(n1);
        two=new Player(n2);
    }



    /* Method to load the list of players */
    private void addPlayers() {

        //add in logic for a 2 player game FIRST
      Scanner kb= new Scanner(System.in);
//        System.out.print("What is player 1's name? ");
//        String n1=kb.next();
//        one.setName(n1);
//        System.out.print("What is player 2's name? ");
//        String n2=kb.next();
//        two.setName(n2);
//        System.out.println();


//      This section will be used for the multi-player version of the game
      
      Scanner keyboard = new Scanner( System.in );
		System.out.println("How many players are playing? "); //Get the 2 player version to work FIRST
        players=new ArrayList<>();
   	int numOfPlayers = keyboard.nextInt(); // gets an int
        if(numOfPlayers<=1){
            System.out.println("You must have at least 2 players");
            addPlayers();
        }
        else{
            for (int x = 1; x <= numOfPlayers; x++) {
                System.out.println("Type player #" + x + "'s name:: ");
                String name = keyboard.next();//gets a String
                // add each new player to the list
                players.add(new Player(name));
            }
        }
    }


    public void playGame() {
        addPlayers();
        /* All your game logic goes below here! */
        /* Make any necessary methods for your game to work */

        //Dealing to players//
        deck.shuffle();
        int leftOver= deck.size()-deck.size()% players.size();
        leftOver/=players.size();
        while(leftOver-->0){
            for (int i = 0; i < players.size(); i++) {
                players.get(i).addCard(deck.getNextCard());
            }
        }

        boolean arewegonnaplay=false;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).hasCards())
                arewegonnaplay=true;
        }
        while(arewegonnaplay){
            HashMap<Card,Player> who= new HashMap<>();
            ArrayList<Card> played= new ArrayList<>();
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).hasCards()){
                    Card a= players.get(i).playCard();
                    played.add(a);
                    who.put(a,players.get(i));
                }
            }
            play(played,who);
            out = new ArrayList<>();
            for (int i = players.size()-1; i>=0;i--) {
                if(!players.get(i).hasCards()){
                    out.add(players.remove(i));
                }
            }
                if(players.size()==0)
                    arewegonnaplay=false;
            System.out.println("================");
        }
        Player winner= out.get(0);
        for (int i = 0; i < out.size(); i++) {
            if(out.get(i).getWins()>winner.getWins())
                winner=out.get(i);
        }
//        for (Player p: out) {
//            System.out.println(p.getWins());
//        }
        System.out.println("GAME OVER!");
        System.out.println(winner.getName()+" is the winner with "+winner.getWins()+" wins!");
    }

    public void play(ArrayList<Card> played,HashMap<Card,Player> who){
            System.out.println((1+who.get(played.get(0)).numCards())+" cards left");
        for (int i = 0; i < played.size(); i++) {
            System.out.println(who.get(played.get(i)).getName()+" played the "+played.get(i));
        }
        Card best= played.get(0);
        for (int i = 0; i < played.size(); i++) {
            if(played.get(i).getPointValue()>best.getPointValue())
                best=played.get(i);
        }
        for (int i = 0; i < played.size(); i++) {
            if(played.get(i).getPointValue()==best.getPointValue()) {
                System.out.println(who.get(played.get(i)).getName() + " won");
                who.get(played.get(i)).win();
            }
        }


    }




    public static void main(String[] args)
    {
        CardGame game = new CardGame();
        game.playGame();
    }
}