import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Implementation for card selection for the game of Sevens
 * Contest link here: http://news.dice.com/2013/12/18/coding-challenge-best-card-sleave/
 * Game Description here: http://en.wikipedia.org/wiki/Sevens_%28card_game%29
 * 
 * Game Notes:
 * VS (Two characters (VS) are used to represent your cards: V is value (A,2,3,4,5,6,7,8,9,T,J,Q,or K) 
 * and S is suit (C,D,H or S). So 3D stands for the three of diamonds and TS stands for the 10 of spades.
 * 
 * 7 is the middle.  7 of diamonds must be played if had.  Other 7s can be strategically held.
 * 
 * Strategy:
 * Play cards as close to the edge (A or K) as possible to block other players.  Cards in hand at end of the game are
 * bad and count as one point lost.  Play cards as close to the edge as possible.  Then play 7s.  
 * Key is to get rid of cards while other players can't.
 * 
 * Weigh each value? ie:
 * A | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | T | J | Q | K
 * 6 | 5 | 4 | 3 | 2 | 1 | 0 | 1 | 2 | 3 | 4 | 5 | 6
 * 
 * So what if I hold multiple playable cards with the same weight?  Play cards that I have the most of.  That means
 * I hold more potentially playable cards than my opponent, thus forcing my opponent to skip turns.
 * 
 * @author Olin Gallet
 * @website http://www.olingallet.com
 */

public class SevensCardGame{
  private final static String INPUT_FILENAME  = "input.txt";
  private final static String OUTPUT_FILENAME = "move.txt";
  
  public static void main(String args[]){
    getCard();
  }
  
  public static void getCard(){
    try {
        BufferedReader br = new BufferedReader(new FileReader(SevensCardGame.INPUT_FILENAME));
        String[] stateLines = new String[4];
        String[] cardData = br.readLine().trim().split(" ");
        Card[] rawHand     = new Card[cardData.length];
        int i = 0;
        
        while (i < cardData.length){
          rawHand[i] = new Card(cardData[i].charAt(0), cardData[i].charAt(1));
          i = i + 1;
        }
        
        Hand hand = new Hand(rawHand);
        
        stateLines[0] = br.readLine().trim();
        stateLines[1] = br.readLine().trim();
        stateLines[2] = br.readLine().trim();
        stateLines[3] = br.readLine().trim();
        
        GameState state = new GameState(stateLines[0], stateLines[1], stateLines[2], stateLines[3]);
        Strategy strategy = new Strategy(hand, state);
        
        String move = strategy.getMove(Strategy.GREATEST_WEIGHT);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(SevensCardGame.OUTPUT_FILENAME));
        bw.write(move, 0, move.length());
        
        bw.close();
        br.close();
        
    } catch (IOException e){
      System.out.println("Bad Input/Output File");
    }
  }
}
