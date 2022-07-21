package hw3.cards;


public class CardJava implements Comparable<CardJava>{

    private static int maxRankDiamonds = 2;
    private static int maxRankClubs = 2;
    private static int maxRankHearts = 2;
    private static int maxRankSpades = 2;

    private int rank;
    private Suit suit;

    public CardJava(int rank, Suit suit) {
        if(chekRank(rank)){
            setMaxRank(rank,suit);
        }else{
            System.out.println("incorrect rank");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public CardJava(Suit suit) {
        if (suit == Suit.clubs){
            this.rank = maxRankClubs;
        }else if (suit == Suit.diamonds){
            this.rank = maxRankDiamonds;
        }else if(suit == Suit.spades){
            this.rank = maxRankSpades;
        }else if(suit == Suit.hearts){
            this.rank = maxRankHearts;
        }else if(suit == Suit.redJoker){
            this.rank = 15;
        }else if(suit == Suit.blackJoker){
            this.rank = 15;
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
        return suit.toString();
    }

    public Suit getSuit() {
        return suit;
    }

    private void setMaxRank(int rank, Suit suit){
        if (suit ==Suit.clubs){
            if (rank > maxRankClubs){
                maxRankClubs = ++rank;
            }
        }else if(suit == Suit.diamonds){
            if (rank > maxRankDiamonds){
                maxRankDiamonds = ++rank;
            }
        }else if(suit ==Suit.spades){
            if (rank > maxRankSpades){
                maxRankSpades = ++rank;
            }
        }else if(suit ==Suit.hearts){
            if (rank > maxRankHearts){
                maxRankHearts = ++rank;
            }
        }
    }

    private static boolean chekRank(int rank){
        if (rank<=15 && rank>=2){
            return true;
        }else{
            System.out.println("incorrect rank");
            return false;
        }
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    private int getNumberSuit(){
        if (suit == Suit.clubs){
            return 1;
        }else if (suit == Suit.diamonds){
            return 2;
        }else if (suit == Suit.spades){
            return 3;
        }else if (suit == Suit.hearts){
            return 4;
        }else if (suit == Suit.blackJoker || suit==Suit.redJoker){
            return 5;
        }else
            return 0;

    }


    @Override
    public String toString(){
        if (suit!= Suit.redJoker && suit!= Suit.blackJoker){
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
        }else
            return getNameSuit();
    }

    @Override
    public boolean equals(Object card){
        if (card instanceof CardJava){
            CardJava newCard = (CardJava) card;
            if (getRank()==newCard.getRank() && getSuit()==((CardJava) card).getSuit()){
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
    public int compareTo(CardJava o) {
        if (getNumberSuit()>o.getNumberSuit()){
            return -1;
        }else if(getNumberSuit()<o.getNumberSuit()){
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

    public static boolean isStandatrDeck(CardJava card){
        if (card.getSuit()!= Suit.another || chekRank(card.getRank())){
            return true;
        }
        return false;
    }

}
