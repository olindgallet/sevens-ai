/**
 * Implementation for a game state for the game of Sevens
 * Contest link here: http://news.dice.com/2013/12/18/coding-challenge-best-card-sleave/
 * Game Description here: http://en.wikipedia.org/wiki/Sevens_%28card_game%29
 * 
 * Represents the game state 
 * 
 * @author Olin Gallet
 * @website http://www.olingallet.com
 */

public class GameState{
  
    private Card lesserClubCard;
    private Card greaterClubCard;
    private Card lesserDiamondCard;
    private Card greaterDiamondCard;
    private Card lesserHeartCard;
    private Card greaterHeartCard;
    private Card lesserSpadeCard;
    private Card greaterSpadeCard;
    
    /**
     * Constructs a new GameState representing the state of the game.
     * @param line1 a input line containing information about a suit
     * @param line2 a input line containing information about a suit
     * @param line3 a input line containing information about a suit
     * @param line4 a input line containing information about a suit
     */
    public GameState(String line1, String line2, String line3, String line4){
      processLine(line1);
      processLine(line2);
      processLine(line3);
      processLine(line4);
    }
    
    private void processLine(String line){
      switch (line.charAt(0)){
        case Card.CLUB_SUIT:
          if (line.length() == 1){
            lesserClubCard  = null;
            greaterClubCard = null;
          } else if (line.length() == 2){
            lesserClubCard  = new Card(line.charAt(1), Card.CLUB_SUIT);
            greaterClubCard = new Card(line.charAt(1), Card.CLUB_SUIT);
          } else if (line.length() == 3){
            lesserClubCard  = new Card(line.charAt(1), Card.CLUB_SUIT);
            greaterClubCard = new Card(line.charAt(2), Card.CLUB_SUIT);
          }
          break;
        
        case Card.DIAMOND_SUIT:
          if (line.length() == 1){
            lesserDiamondCard  = null;
            greaterDiamondCard = null;
          } else if (line.length() == 2){
            lesserDiamondCard  = new Card(line.charAt(1), Card.DIAMOND_SUIT);
            greaterDiamondCard = new Card(line.charAt(1), Card.DIAMOND_SUIT);
          } else if (line.length() == 3){
            lesserDiamondCard  = new Card(line.charAt(1), Card.DIAMOND_SUIT);
            greaterDiamondCard = new Card(line.charAt(2), Card.DIAMOND_SUIT);
          }
          break;
          
        case Card.HEART_SUIT:      
          if (line.length() == 1){
            lesserHeartCard  = null;
            greaterHeartCard = null;
          } else if (line.length() == 2){
            lesserHeartCard  = new Card(line.charAt(1), Card.HEART_SUIT);
            greaterHeartCard = new Card(line.charAt(1), Card.HEART_SUIT);
          } else if (line.length() == 3){
            lesserHeartCard  = new Card( line.charAt(1), Card.HEART_SUIT);
            greaterHeartCard = new Card(line.charAt(2), Card.HEART_SUIT);
          }
          break;
          
        case Card.SPADE_SUIT:       
          if (line.length() == 1){
            lesserSpadeCard  = null;
            greaterSpadeCard = null;
          } else if (line.length() == 2){
            lesserSpadeCard  = new Card(line.charAt(1), Card.SPADE_SUIT);
            greaterSpadeCard = new Card(line.charAt(1), Card.SPADE_SUIT);
          } else if (line.length() == 3){
            lesserSpadeCard  = new Card(line.charAt(1) , Card.SPADE_SUIT);
            greaterSpadeCard = new Card(line.charAt(2), Card.SPADE_SUIT);
          }
          break;
          
        default:
          //bad input file.
          break;
      }
    }
    
    /**
     * States if the given card is playable.
     * @param card the card to check if is playable.
     */
    public boolean isCardPlayable(Card card){
      boolean isPlayable = false;
      
      switch(card.getSuit()){
        case Card.DIAMOND_SUIT:
          if (lesserDiamondCard == null && greaterDiamondCard == null){
            isPlayable = card.getValue() == '7';
          } else {
            isPlayable = (card.getNumericalValue() == lesserDiamondCard.getNumericalValue() - 1) ||
                         (card.getNumericalValue() == greaterDiamondCard.getNumericalValue() + 1);
          }
          break;
          
        case Card.HEART_SUIT:
          if (lesserHeartCard == null && greaterHeartCard == null){
            isPlayable = card.getValue() == '7';
        } else {
          isPlayable = (card.getNumericalValue() == lesserHeartCard.getNumericalValue() - 1) ||
                       (card.getNumericalValue() == greaterHeartCard.getNumericalValue() + 1);
        } 
          break;
          
        case Card.SPADE_SUIT:
          if (lesserSpadeCard == null && greaterSpadeCard == null){
            isPlayable = card.getValue() == '7';
        } else {
          isPlayable = (card.getNumericalValue() == lesserSpadeCard.getNumericalValue() - 1) ||
                         (card.getNumericalValue() == greaterSpadeCard.getNumericalValue() + 1);
        }
          break;
          
        case Card.CLUB_SUIT:
          if (lesserClubCard == null && greaterClubCard == null){
            isPlayable = card.getValue() == '7';
        } else {
          isPlayable = (card.getNumericalValue() == lesserClubCard.getNumericalValue() - 1) ||
                         (card.getNumericalValue() == greaterClubCard.getNumericalValue() + 1);
        }
          break;
          
        default:
          break;
      }
      return isPlayable;
    }
    
    public String toString(){
      return "Lesser Club Card: " + lesserClubCard.toString() + '\n' + 
             "Greater Club Card: " + greaterClubCard.toString() + '\n' +
             "Lesser Diamond Card: " + lesserDiamondCard.toString() + '\n' + 
             "Greater Diamond Card: " + greaterDiamondCard.toString() + '\n' + 
             "Lesser Heart Card: " + lesserHeartCard.toString() + '\n' + 
             "Greater Heart Card: " + greaterHeartCard.toString() + '\n' + 
             "Lesser Spade Card: " + lesserSpadeCard.toString() + '\n' +
             "Greater Spade Card: " + greaterSpadeCard.toString() + '\n';
    }
  }