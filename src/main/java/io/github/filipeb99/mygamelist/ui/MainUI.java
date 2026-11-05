package io.github.filipeb99.mygamelist.ui;

import io.github.filipeb99.mygamelist.GameListFileHandler;
import io.github.filipeb99.mygamelist.GameTableModel;
import io.github.filipeb99.mygamelist.model.Game;
import io.github.filipeb99.mygamelist.model.GameList;
import jakarta.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainUI {
  private GameList gameList = null;
  private GameTableModel tableModel = null;
  private GenericListUI gameListUI = null;
  private GameUI gameUI = null;

  public MainUI(File gameListFile) throws JAXBException {
    gameList = GameListFileHandler.getInstance().unmarshal(gameListFile);
    tableModel = new GameTableModel(gameList);
    gameListUI = new GenericListUI(tableModel, "MyGameList");
    gameUI = new GameUI();

    /* GameListUI ActionListeners */
    ActionListener editFunc =
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            int row = gameListUI.getSelectedRow();
            String name = (String) tableModel.getValueAt(row, 0);
            String developer = (String) tableModel.getValueAt(row, 1);
            String status = (String) tableModel.getValueAt(row, 2);

            gameUI = new GameUI(name, developer, status);
            gameUI.setCancelFunc(ae -> cancelFunc(ae));
            gameUI.setConfirmFunc(ae -> updateFunc(ae));
            gameUI.activateButtons();
            gameUI.start();
          }
        };

    ActionListener newFunc =
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            gameUI = new GameUI();
            gameUI.setCancelFunc(ae -> cancelFunc(ae));
            gameUI.setConfirmFunc(ae -> addFunc(ae));
            gameUI.activateButtons();
            gameUI.start();
          }
        };

    ActionListener saveFunc =
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              GameListFileHandler.getInstance().marshal(gameList, gameListFile);
            } catch (JAXBException jaxbException) {
            }
          }
        };

    gameListUI.setEditFunc(editFunc);
    gameListUI.setNewFunc(newFunc);
    gameListUI.setSaveFunc(saveFunc);
  }

  public void start() {
    gameListUI.start();
  }

  /** GameUI ActionListeners */
  private void cancelFunc(ActionEvent e) {
    gameUI.stop();
  }

  private void addFunc(ActionEvent e) {
    String name = gameUI.getName();
    String developer = gameUI.getDeveloper();
    String status = gameUI.getStatus();

    Game game = new Game(name, developer, status);
    gameList.addGame(game);

    gameUI.stop();
    gameListUI.refreshTableData();
  }

  private void updateFunc(ActionEvent e) {
    String name = gameUI.getName();
    String developer = gameUI.getDeveloper();
    String status = gameUI.getStatus();

    Game gameToUpdate = gameList.getGameByName(name);
    int gameToUpdateIndex = gameList.getGames().indexOf(gameToUpdate);

    Game game = new Game(name, developer, status);
    gameList.updateGame(gameToUpdateIndex, game);

    gameUI.stop();
    gameListUI.refreshTableData();
  }
}
