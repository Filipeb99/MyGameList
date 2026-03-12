package com.mygamelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameListTest {
    private GameList gameList;

    @BeforeEach
    public void setUp() {
        gameList = new GameList();
    }

    @Test
    @DisplayName("Adding a game should increase the list size")
    public void addGameTest() {
        assertEquals(0, gameList.getSize(), "Game list should start empty");
        Game game = new Game();
        gameList.addGame(game);
        assertEquals(1, gameList.getSize(), "Game list should have one element");
    }

    @Test
    @DisplayName("Getting a game by name should only return if matching game is found")
    public void getGameByNameOnEmptyListTest() {
        assertNull(gameList.getGameByName(null), "No game should be found on empty game list");
        Game game = new Game();
        gameList.addGame(game);
        assertNull(gameList.getGameByName(null), "No game should be found if names do not match");
        assertNotNull(
            gameList.getGameByName(game.getName()), "Game should be found if names match");
    }
}
