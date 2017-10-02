package com.java.models;

/**
 * Created by alexis on 10/1/17.
 */
public class Card {
    private Suit suit;
    private FaceValue value;

    public Card(FaceValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getCardName() {
        return String.format("%s-%s", value.toString(), suit.toString());
    }
}
