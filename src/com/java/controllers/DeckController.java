package com.java.controllers;

import com.java.models.Deck;
import com.java.storage.MemoryStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by alexis on 10/1/17.
 */
@Path("/decks")
public class DeckController {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAll() {
        MemoryStorage storage = MemoryStorage.getInstance();
        Map<String, Deck> decks = storage.fetchAllDecks();
        return Response
                .ok(decks)
                .build();
    }

    @GET
    @Path("/name/{deckName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchByName(@PathParam("deckName")String deckName) {
        MemoryStorage storage = MemoryStorage.getInstance();
        Deck deck = storage.fetchDeck(deckName);
        if ( deck != null ) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok(deck)
                .build();
    }

    @POST
    @Path("/name/{deckName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewDeck(@PathParam("deckName")String deckName) {
        MemoryStorage storage = MemoryStorage.getInstance();
        Deck existingDeck = storage.fetchDeck(deckName);
        if ( existingDeck != null ) {
            return Response
                    .status(Response.Status.BAD_REQUEST.getStatusCode())
                    .build();
        }
        Deck newDeck = storage.createDeck(deckName);
        return Response
                .ok(newDeck)
                .build();
    }

    @PUT
    @Path("/name/{deckName}/shuffle/{shuffleTimes}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response shuffleDeck(@PathParam("deckName")String deckName, @PathParam("shuffleTimes")int numberOfShuffles) {
        MemoryStorage storage = MemoryStorage.getInstance();
        boolean shuffleSuccess = storage.shuffleDeck(deckName, numberOfShuffles);
        if ( !shuffleSuccess ) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        Deck deck = storage.fetchDeck(deckName);
        return Response
                .ok(deck)
                .build();
    }

    @DELETE
    @Path("/name/{deckName}")
    public Response deleteDeck(@PathParam("deckName")String deckName) {
        MemoryStorage storage = MemoryStorage.getInstance();
        boolean shuffleSuccess = storage.deleteDeck(deckName);
        if ( !shuffleSuccess ) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .ok()
                .build();
    }
}
