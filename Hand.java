import java.util.ArrayList;
/**
 * Implementation for a hand for the game of Sevens
 * Contest link here: http://news.dice.com/2013/12/18/coding-challenge-best-card-sleave/
 * Game Description here: http://en.wikipedia.org/wiki/Sevens_%28card_game%29
 * 
 * A Hand is a data structure for a set of cards with additional functionality used for helping
 * strategy development.
 * 
 * @author Olin Gallet
 * @website http://www.olingallet.com
 */  

public class Hand{
  private Card[] cards;
  private int[] weight;

  
  /**
   * Constructs a new Hand.
   * @param cards an array of the cards for the hand.
   */
  public Hand(Card[] cards){
    this.cards  = cards;
    this.weight = new int[this.cards.length]; 
    
    int i = 0;
    while (i < cards.length){
      this.weight[i] = getWeight(this.cards[i].getValue());
      i = i + 1;
    }
  }
  
  private int getWeight(char value){
    int weight = 0;
    if (value == 'A' || value == 'K'){
      weight = 6;
    } else if (value == '2' || value == 'Q'){
      weight = 5;
    } else if (value == '3' || value == 'J'){
      weight = 4;
    } else if (value == '4' || value == 'T'){
      weight = 3;
    } else if (value == '5' || value == '9'){
      weight = 2;
    } else if (value == '6' || value == '8'){
      weight = 1;
    }
    return weight;
  }
 
  /**
   * Gets the count of a specific suit.
   * @param suit the suit to count.
   */
  public int getSuitCount(char suit){
    int i     = 0;
    int count = 0;
    while (i < this.cards.length){
      if (suit == this.cards[i].getSuit()){
        count = count + 1;
      }
      i = i + 1;
    }
    return count;
  }
  
  /**
   * Gets all the cards with the specified weight/suit
   * @param weight the weight of the cards to get
   * @param suit the suit of the cards to get
   */
  public Card[] getCardsWithWeight(int weight, char suit){
    ArrayList<Card> list = new ArrayList<Card>();
    int i = 0;
    
    while (i < this.cards.length){
      if (suit == this.cards[i].getSuit() && weight == getWeight(this.cards[i].getValue())){
        list.add(this.cards[i]);
      }
      i = i + 1;
    }
    
    Card[] response = new Card[list.size()];
    return list.toArray(response);
  }
  
  /**
   * Gets all the cards with the specified weight
   * @param weight the weight of the cards to get
   */
  public Card[] getCardsWithWeight(int weight){
    ArrayList<Card> list = new ArrayList<Card>();
    int i = 0;
    
    while (i < this.cards.length){
      if (weight == getWeight(this.cards[i].getValue())){
        list.add(this.cards[i]);
      }
      i = i + 1;
    }
    
    Card[] response = new Card[list.size()];
    return list.toArray(response);
  }
  
  /**
   * Does this hand have the seven of diamonds?
   */
  public boolean hasSevenOfDiamonds(){
    int i = 0;
    boolean hasSeven = false;
    while (i < this.cards.length && !hasSeven){
      hasSeven = this.cards[i].getSuit() == Card.DIAMOND_SUIT && this.cards[i].getValue() == '7';
      i = i + 1;
    }
    return hasSeven;
  }
  
  public String toString(){
    int i = 0;
    String response = "";
    while (i < cards.length){
      response = response + cards[i].toString() + "\n";
      i = i + 1;
    }
    return response;
  }
}