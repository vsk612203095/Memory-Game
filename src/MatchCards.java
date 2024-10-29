import  java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import javax.swing.*;


public class MatchCards {

    class Card {
        String cardName;
        ImageIcon cardImageIcon;

        Card(String cardName , ImageIcon cardImageIcon){
            this.cardName = cardName ;
            this.cardImageIcon = cardImageIcon ;
        }

        public String toString(){
            return cardName;
        }
    }

    String[] cardList = {
            "darkness" ,
            "double" ,
            "fighting",
            "fire" ,
            "grass",
            "lightning" ,
            "metal" ,
            "psychic" ,
            "water"
    };

    int rows = 4;
    int columns = 5 ;
    int cardWidth = 90 ;
    int cardHeight = 128 ;

    ArrayList<Card> cardSet;
    ImageIcon cardbackImageIcon ;

    int boardWidth = columns * cardWidth ;
    int boardHeight = rows * cardHeight;

    JFrame frame = new JFrame("Pokemon Match Cards");


    MatchCards() {
        setupCards();
        shuffleCards();

        frame.setVisible(true);
        frame.setSize(boardWidth , boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    void setupCards() {
        cardSet = new ArrayList<Card>();
        for(String cardName : cardList) {
            //load each card image
            Image cardImg = new ImageIcon(getClass().getResource("./" + cardName + ".jpj")).getImage();
            ImageIcon cardImageIcon = new ImageIcon(cardImg.getScaledInstance(cardWidth , cardHeight , Image.SCALE_SMOOTH));

            //create card object and add to cardSet
            Card card = new Card(cardName , cardbackImageIcon);
            cardSet.add(card);
        }
        cardSet.addAll(cardSet);

        //load the back card image
        Image cardbackImg = new ImageIcon(getClass().getResource("./back.jpj")).getImage();
        cardbackImageIcon = new ImageIcon(cardbackImg.getScaledInstance(cardWidth , cardHeight , Image.SCALE_SMOOTH));

    }

    void shuffleCards() {
        System.out.println(cardSet);

        //shuffle
        for( int  i = 0 ; i < cardSet.size() ; i++){
            int j = (int) (Math.random() * cardSet.size()); //get random index

            //swap
            Card temp = cardSet.get(i);
            cardSet.set(i , cardSet.get(j));
            cardSet.set(j , temp);
        }
        System.out.println(cardSet);
    }
}

