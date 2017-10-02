package com.java.storage;

import com.java.models.Deck;

import java.util.Map;

/**
 * Created by alexis on 10/1/17.
 */
public interface Storage {
    Map<String, Deck> fetchAllDecks();
    Deck createDeck(String deckName);
    Deck fetchDeck(String deckName);
    boolean shuffleDeck(String deckName, int shuffleAmount);
    boolean deleteDeck(String deckName);
}
