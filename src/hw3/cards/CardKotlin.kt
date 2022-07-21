package hw3.cards

class CardKotlin ( _suit : Suit, _rank: Int) : Comparable<CardKotlin>{

    constructor(suit: Suit) : this(suit, getMaxRankToSuit(suit))

    var rank : Int
    var suit : Suit
    init {
        suit = _suit
        setMaxRankToSuit(suit,_rank)
        rank =_rank
    }

    companion object{
        private var maxRankDiamonds : Int = 2
        private var maxRankClubs : Int = 2
        private var maxRankHearts : Int = 2
        private var maxRankSpades : Int = 2

        fun setMaxRankToSuit(suit: Suit, rank: Int){
            if (suit == Suit.clubs){
                if (rank > maxRankClubs) {
                    maxRankClubs = rank +1
                }
            }else if (suit== Suit.diamonds){
                if (rank > maxRankDiamonds) {
                     maxRankDiamonds = rank +1
                }
            }else if (suit == Suit.spades) {
                if (rank > maxRankSpades) {
                    maxRankSpades = rank +1
                }
            } else if (suit == Suit.hearts) {
                if (rank > maxRankHearts) {
                    maxRankHearts = rank  +1
                }
            }
        }

        fun getMaxRankToSuit(suit: Suit): Int {
            var rankRet = 0
            when (suit) {
                Suit.clubs -> { rankRet = maxRankClubs
                    maxRankClubs++
                }
                Suit.diamonds -> { rankRet = maxRankDiamonds
                    maxRankDiamonds++
                }
                Suit.spades -> { rankRet = maxRankSpades
                    maxRankSpades++
                }
                Suit.hearts -> { rankRet = maxRankHearts
                    maxRankHearts++
                }
                else -> {}
            }
            return rankRet
        }

        private fun chekRank(rank :Int): Boolean {
            if (rank in 2..15)
                return true
            println("incorrect rank")
            return false
        }

        fun isStandatrDeck(card : CardKotlin): Boolean {
            return card.suit != Suit.another || chekRank(card.rank)
        }

    }

    private fun getNameSuit(): String {
        return suit.toString()
    }

    override fun toString(): String {
        val sb = StringBuffer()
        when (rank){
            11 -> sb.append("Jack")
            12 -> sb.append("Queen")
            13 -> sb.append("King")
            14 -> sb.append("Ace")
            else -> sb.append(rank)
        }
        sb.append(" of ")
        sb.append(getNameSuit())
        return sb.toString()
   }

    override fun equals(card: Any?): Boolean {
        if (card is CardKotlin) {
            if (rank == card.rank && suit == card.suit)
                return true
        }
        return false
    }

    override fun hashCode(): Int {
        var result : Int = getNameSuit().hashCode()
        result *= 31 + rank
        return result
    }

    private fun getNumberSuit(): Int {
        return when (suit){
            Suit.clubs ->  1
            Suit.diamonds -> 2
            Suit.spades -> 3
            Suit.hearts -> 4
            Suit.blackJoker -> 5
            Suit.redJoker -> 5
            Suit.another ->0
        }
    }

    override fun compareTo(o: CardKotlin): Int {
        if (getNumberSuit() > o.getNumberSuit()) {
            return -1
        } else if (getNumberSuit() < o.getNumberSuit()) {
            return 1
        } else {
            if (rank > o.rank) {
                return 1
            } else if (rank < o.rank) {
                return -1
            }
        }
        return 0
    }



}

