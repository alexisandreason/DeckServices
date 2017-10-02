import com.java.models.Deck;
import com.java.storage.MemoryStorage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexis on 10/1/17.
 */
public class StorageTest {
    @Test
    public void testStorage() {
        MemoryStorage storage = MemoryStorage.getInstance();
        String deckName = "My Deck";
        Deck myDeck = storage.createDeck(deckName);
        Assert.assertTrue("Deck was not created", myDeck != null);
        Assert.assertTrue("Deck cards were not created correctly",
                myDeck.getCards() != null && myDeck.getCards().size() == 52);
    }
}
