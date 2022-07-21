package hw2.cardsDeck;

import java.util.ArrayList;

public class Deck {

    public ArrayList<Card> getListCard() {
        return listCard;
    }

    ArrayList<Card> listCard = new ArrayList<>(54);

    private Deck(){
        fillDeck();
    }

    private void fillDeck(){
        int suit = 1;
        int rank = 2;
        while (suit<5){
            rank = 2;
            while (rank<15){
                listCard.add(new Card(rank,suit));
                rank++;
            }
            suit++;
        }

    }

    public boolean isDeckEmpty(){
        if (listCard.size()==0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (Card cardname : listCard){
            sb.append(cardname.toString());
            sb.append("; ");
        }
        return sb.toString();
    }






    public Card[] getSixCard(){
        Card[] arrayCard = new Card[6];
        for (int i = 0; i<6;i++){
            arrayCard[i] = getRandomCard();
        }
        return arrayCard;
    }


    public void putCardOfDeck(Card card){
        if (putCard(card)){
            System.out.println("карта добавленна в колоду");
        }else {
            System.out.println("такая карта уже есть в колоде");
        }
    }


    private boolean putCard(Card card){
        if (listCard.contains(card)){
            return false;
        }
        listCard.add(card);
        return true;
    }




    public static Deck getDeck(){
        return new Deck();
    }


    public Card getRandomCard(){
        int randomCard = (int) (Math.random() * listCard.size());
        Card card = listCard.get(randomCard);
        listCard.remove(randomCard);
        return card;
    }





    public void sortDeck(){

        ArrayList<Card> newList = new ArrayList<>(54);
        while(listCard.size()>0 ){
            newList.add(getRandomCard());
        }
        listCard = newList;
        //Collections.sort(listCard);
    }




}
