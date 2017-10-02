import com.java.models.Card;
import com.java.models.Deck;
import com.java.models.FaceValue;
import com.java.models.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alexis on 9/30/17.
 */
public class DeckTest {
    @Test
    public void testDeckInstantiation() {
        Deck myDeck = new Deck();
        Assert.assertTrue("Deck has incorrect number of cards",
                myDeck.getCards() != null && myDeck.getCards().size() == 52);
    }

    @Test
    public void testCardOrder() {
        Deck myDeck = new Deck();
        List<String> cardNames = myDeck.getCards().stream()
                .map(Card::getCardName)
                .collect(Collectors.toList());
        int cardCounter = 0;
        for ( Suit suit : Arrays.asList(Suit.values()) ) {
            for ( FaceValue faceValue : Arrays.asList(FaceValue.values()) ) {
                String currentCardName = cardNames.get(cardCounter);
                String expectedCardName = faceValue.toString() + "-" + suit.toString();
                Assert.assertEquals("Deck is ordered incorrectly", expectedCardName, currentCardName);
                cardCounter++;
            }
        }
    }

    @Test
    public void testShuffle() {
        Deck myDeck = new Deck();
        String cardNames = myDeck.getCards().stream()
                .map(Card::getCardName)
                .collect(Collectors.joining(","));

        myDeck.shuffleCardsRandomly();
        String shuffledNames = myDeck.getCards().stream()
                .map(Card::getCardName)
                .collect(Collectors.joining(","));

        Assert.assertTrue("Cards were not shuffled", !cardNames.equals(shuffledNames));

        myDeck = new Deck();
        myDeck.shuffleCardsByHand(2);
        shuffledNames = myDeck.getCards().stream()
                .map(Card::getCardName)
                .collect(Collectors.joining(","));

        Assert.assertTrue("Cards were not shuffled", !cardNames.equals(shuffledNames));
    }
}
