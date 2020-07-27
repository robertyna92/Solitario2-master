import java.util.LinkedList;
public class Deck{
    private LinkedList<Card> cardDeck ;

    public Deck(){
        this.cardDeck= new LinkedList<>();
        createDeck();
    }

    //Create a simple deck
    public void createDeck(){
        Card.Color color;
        for (Card.Seed seed : Card.Seed.values()) {
            int realValue=0;
            for (Card.Value value : Card.Value.values()) {
                if (seed == Card.Seed.CUORI || seed == Card.Seed.QUADR ) {
                    color = Card.Color.ROSSO;
                }else color = Card.Color.NERO;
                realValue++;
                Card c = new Card(seed, value, realValue, color);
                this.cardDeck.push(c);
            }
        }
    }
    public LinkedList getDeck(){
        return this.cardDeck;
    }

}
