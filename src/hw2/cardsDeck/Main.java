package hw2.cardsDeck;

import hw2.cardsDeck.Card;
import hw2.cardsDeck.Deck;
import hw2.fileSystemNode.FileSystem;
import hw2.fileSystemNode.FileSystemNode;
import hw3.cards.CardKotlin;
import hw3.cards.Suit;

public class Main {

    public static void main(String[] args) {

        /* проверка дз2 №2  */
        Card card = new Card(5,2);
        Card card4 = new Card(2);
        Card card3 = new Card(2);
        System.out.println(card3.getRank());
        Card card2 = new Card(12,2);
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        System.out.println(card.hashCode());


        /* проверка дз2 №4  */
        Deck deck = Deck.getDeck();
        System.out.println(deck.toString());
        Card[] arrayCard = deck.getSixCard();
        for (Card cardname : arrayCard){
            System.out.println(cardname.toString());
        }
        deck.putCardOfDeck(arrayCard[2]);
        deck.putCardOfDeck(arrayCard[3]);
        deck.putCardOfDeck(arrayCard[3]);
        deck.sortDeck();
        System.out.println(deck.toString());
        while (deck.getListCard().size()>0){
            System.out.println(deck.getRandomCard().toString());
        }


    }
}
