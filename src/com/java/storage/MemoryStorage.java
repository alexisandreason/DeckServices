package com.java.storage;

import com.java.models.Deck;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by alexis on 10/1/17.
 */
public class MemoryStorage implements Storage {
    private Map<String, Deck> cardDecks;
    private String shuffleType;
    private static MemoryStorage instance;

    public static MemoryStorage getInstance() {
        if ( instance == null ) {
            instance = new MemoryStorage();
            instance.shuffleType = "Simulated";
        }
        return instance;
    }

    private MemoryStorage() {
        cardDecks = new HashMap<>();
    }

    @Override
    public Map<String, Deck> fetchAllDecks() {
        return cardDecks;
    }

    @Override
    public Deck createDeck(String deckName) {
        if ( cardDecks.containsKey(deckName) ) {
            throw new RuntimeException("That deck name has already been taken");
        }
        Deck newDeck = new Deck();
        cardDecks.put(deckName, newDeck);
        return newDeck;
    }

    @Override
    public Deck fetchDeck(String deckName) {
        return cardDecks.get(deckName);
    }

    @Override
    public boolean shuffleDeck(String deckName, int shuffleAmount) {
        Deck deck = cardDecks.get(deckName);
        if ( deck == null ) {
            return false;
        }
        if ( shuffleType.equalsIgnoreCase("Simulate") ) {
            deck.shuffleCardsByHand(shuffleAmount);
        } else {
            for ( int i = 0; i < shuffleAmount; i++ ) {
                deck.shuffleCardsRandomly();
            }
        }
        return true;
    }

    @Override
    public boolean deleteDeck(String deckName) {
        Deck deck = cardDecks.get(deckName);
        if ( deck == null ) {
            return false;
        }
        cardDecks.remove(deckName);
        return true;
    }
}
