package com.java.models;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexis on 10/1/17.
 */
public class Deck {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Deck() {
        cards = new ArrayList<>();
        List<Suit> suits = Arrays.asList(Suit.values());
        List<FaceValue> faceValues = Arrays.asList(FaceValue.values());
        suits.forEach(suit -> {
            faceValues.forEach(faceValue -> cards.add(new Card(faceValue, suit)));
        });
    }

    /**
     * This method uses java's shuffle method to randomize the card order
     */
    public void shuffleCardsRandomly() {
        Collections.shuffle(cards);
    }

    /**
     * This method will simulate shuffling a deck of cards by hand
     * @param numberOfShuffles - The number of times that the deck should be shuffled
     */
    public void shuffleCardsByHand(int numberOfShuffles) {
        for (int i = 0; i < numberOfShuffles; i++) {
            List<List<Card>> splitCards = Lists.partition(cards, 2); //splitting the deck in half
            List<Card> firstHalf = splitCards.get(0);
            List<Card> secondHalf = splitCards.get(1);
            cards = new ArrayList<>();
            //adding cards from either half until all cards are back in a single deck
            for ( int j = 0; j < firstHalf.size(); j++ ) {
                cards.add(firstHalf.get(j));
                cards.add(secondHalf.get(j));
            }
        }
    }
}
