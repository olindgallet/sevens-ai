/**
 * Implementation for a card for the game of Sevens
 * Contest link here: http://news.dice.com/2013/12/18/coding-challenge-best-card-sleave/
 * Game Description here: http://en.wikipedia.org/wiki/Sevens_%28card_game%29
 * 
 * Represents a standard playing card.  Each card has a suit (diamond, heart, spade, and club) and a value(ten = 'T',
 * jack = 'J', queen = 'Q', king = 'K', ace = 'A').
 * 
 * @author Olin Gallet
 * @website http://www.olingallet.com
 */

public class Card{
    public final static char DIAMOND_SUIT = 'D';
    public final static char HEART_SUIT   = 'H';
    public final static char SPADE_SUIT   = 'S';
    public final static char CLUB_SUIT    = 'C';
  
    private char value;
    private char suit;
    private int numericalValue;
    
    public Card(char value, char suit){
      this.suit = suit;
      this.value = value;
      this.numericalValue = getNumericalValue(value);
    }
    
    private int getNumericalValue(char value){
      int numericalValue = 0;
      if (value == 'A'){
        numericalValue = 1;
      } else if (value == 'T'){
        numericalValue = 10;
      } else if (value == 'J'){
        numericalValue = 11;
      } else if (value == 'Q'){
        numericalValue = 12;
      } else if (value == 'K'){
        numericalValue = 13;
      } else {
        numericalValue = Character.getNumericValue(value);
      }
      return numericalValue;
    }
    
    public int getNumericalValue(){
      return this.numericalValue;
    }
    
    /**
     * Returns the value of this card.
     */
    public char getValue(){
      return this.value;
    }
    
    /**
     * Returns the suit of this card.
     */
    public char getSuit(){
      return this.suit;
    }
    
    /**
     * States if the object is equal to this.
     * For two Cards to be equal they have to have the same suit
     * and value.
     */
    public boolean isEqual(Object obj){
      boolean isEqual = false;
      if (obj instanceof Card){
        Card card = (Card)obj;
        isEqual = card.getValue() == this.value && card.getSuit() == this.suit;
      }
      return isEqual;
    }
    
    public String toString(){
      return "Suit: " + this.suit + " Value: " + this.value + " Numerical Value: " + this.numericalValue;
    }
  }