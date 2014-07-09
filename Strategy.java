import java.util.ArrayList;
/**
 * Implementation for a strategy for the game of Sevens
 * Contest link here: http://news.dice.com/2013/12/18/coding-challenge-best-card-sleave/
 * Game Description here: http://en.wikipedia.org/wiki/Sevens_%28card_game%29
 * 
 * Represents a strategy for the game of Sevens.
 * 
 * Strategy:
 * If you have the seven of diamonds, play the seven of diamonds
 * else starting with max weight of the cards (cards have greatest weight near the ends, less weight as it goes to 7)
 * see if they're playable.  Priority is given to cards that are most common in hand.
 * Then just go down in weight until a playable card is found.
 * 
 * @author Olin Gallet
 * @website http://www.olingallet.com
 */

public class Strategy{
    private Hand hand;
    private GameState state;
    public final static int GREATEST_WEIGHT = 7;
    
    public Strategy(Hand hand, GameState state){
      this.hand = hand;
      this.state = state;
    }
    
    /**
     * Gets the move.
     * @param weight the weight of the card to play.
     */
    public String getMove(int weight){
      String move = "";
      if (weight >= 0){
        if (hand.hasSevenOfDiamonds()){
          move = "7D";
        } else{
          Card[] cards = this.hand.getCardsWithWeight(weight);
          int i = 0;
          ArrayList<Card> playableCards = new ArrayList<Card>();
          
          while (i < cards.length){
            if (state.isCardPlayable(cards[i])){
              playableCards.add(cards[i]);
            }
            i = i + 1;
          }
          
          if (playableCards.size() == 0){
            move = getMove (weight - 1);
          } else if (playableCards.size() == 1){
            move = new StringBuilder().append(playableCards.get(0).getValue()).append(playableCards.get(0).getSuit()).toString();
          } else {
            Card playedCard = playableCards.get(0);
            int j = 1;
            while (j < playableCards.size()){                            
              if (hand.getSuitCount(playedCard.getSuit()) < hand.getSuitCount(playableCards.get(j).getSuit())){
                playedCard = playableCards.get(j);
              }
              j = j + 1;
            }
            move = new StringBuilder().append(playedCard.getValue()).append(playedCard.getSuit()).toString();
          }
        }
      }
      return move;
    }
}