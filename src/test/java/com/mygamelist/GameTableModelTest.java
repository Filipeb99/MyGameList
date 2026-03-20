package com.mygamelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mygamelist.model.GameList;

public class GameTableModelTest {
    private GameList gameList;
    private GameTableModel gameTableModel;

    @BeforeEach
    public void setUp() {
        gameList = new GameList();
        gameTableModel = new GameTableModel(gameList);
    }

    @Test
    @DisplayName("Initialises with correct rows and columns")
    public void initialisationTest() {
        assertEquals(0, gameTableModel.getRowCount(), "Game table should start without any rows");
        assertEquals(
            3, gameTableModel.getColumnCount(), "Game table should start with all columns");
    }
}
