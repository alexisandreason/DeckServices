import com.java.models.Card;
import com.java.models.FaceValue;
import com.java.models.Suit;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexis on 9/30/17.
 */
public class CardTest {
    @Test
    public void CardNameTest() {
        Card testCard = new Card(FaceValue.Ace, Suit.Club);
        String expectedName = "Ace-Club";
        Assert.assertEquals("Card name was generated improperly", expectedName, testCard.getCardName());
    }
}
