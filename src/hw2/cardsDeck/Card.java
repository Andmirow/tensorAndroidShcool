package hw2.cardsDeck;


public class Card implements Comparable<Card>{

    private static int maxRankDiamonds = 2;
    private static int maxRankClubs = 2;
    private static int maxRankHearts = 2;
    private static int maxRankSpades = 2;

    private int rank;
    private int suit;

    public Card() {}

    public Card(int rank, int suit) {
        if (chekSuit(suit)){
            if(chekRank(rank)){
                setMaxRank(rank,suit);
            }else{
                System.out.println("incorrect rank");
            }
        }
        this.suit = suit;
        this.rank = rank;

    }

    public Card(int suit) {
        if (suit ==1){
            this.rank = maxRankClubs;
            maxRankClubs++;
        }else if (suit ==2){
            this.rank = maxRankDiamonds;
            maxRankDiamonds++;
        }else if(suit ==3){
            this.rank = maxRankSpades;
            maxRankSpades++;
        }else if(suit ==4){
            this.rank = maxRankHearts;
            maxRankHearts++;
        }else
            System.out.println("incorrect suit");
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (chekRank(rank)){
            setMaxRank(rank, suit);
        }else{
            System.out.println("incorrect rank");
        }
        this.rank = rank;
    }

    public String getNameSuit() {
        if (suit ==1){
            return "clubs";
        }else if (suit ==2){
            return "diamonds";
        }else if(suit ==3){
            return "hearts";
        }else if (suit ==4){
            return "spades";
        }
        return "no name";
    }

    public int getSuit() {
        return suit;
    }



    private void setMaxRank(int rank, int suit){
        if (suit ==1){
            if (rank > maxRankClubs){
                maxRankClubs = ++rank;
            }
        }else if(suit ==2){
            if (rank > maxRankDiamonds){
                maxRankDiamonds = ++rank;
            }
        }else if(suit ==3){
            if (rank > maxRankSpades){
                maxRankSpades = ++rank;
            }
        }else if(suit ==4){
            if (rank > maxRankHearts){
                maxRankHearts = ++rank;
            }
        }
    }

    private static boolean chekRank(int rank){
        if (rank<=14 && rank>=2){
            return true;
        }else{
            System.out.println("incorrect rank");
            return false;
        }
    }

    private static boolean chekSuit(int suit){
        if (suit<=4 && suit>=1){
            return true;
        }else{
            System.out.println("incorrect suit");
            return false;
        }
    }

    public void setSuit(int suit) {
        if (chekSuit(suit)){
            this.suit = suit;
        }
    }


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        if (rank == 11){
            sb.append("Jack");
        }else if (rank == 12){
            sb.append("Queen");
        }else if (rank == 13){
            sb.append("King");
        }else if (rank == 14){
            sb.append("Ace");
        }else {
            sb.append(rank);
        }
        sb.append(" of ");
        sb.append(getNameSuit());
        return sb.toString();
    }

    @Override
    public boolean equals(Object card){
        if (card instanceof Card){
            Card newCard = (Card) card;
            if (getRank()==newCard.getRank() && getNameSuit().equals(newCard.getNameSuit())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        if (this != null){
            result = getNameSuit().hashCode();
            result *= 31 + rank;
        }
        return result;
    }

    @Override
    public int compareTo(Card o) {
        if (getSuit()>o.getSuit()){
            return -1;
        }else if(getSuit()<o.getSuit()){
            return 1;
        }else {
            if (getRank()>o.getRank()){
                return 1;
            }else if (getRank()<o.getRank()){
                return -1;
            }
        }
        return 0;
    }

    public static boolean isStandatrDeck(Card card){
        if (chekSuit(card.getSuit()) || chekRank(card.getRank())){
            return true;
        }
        return false;
    }



}
