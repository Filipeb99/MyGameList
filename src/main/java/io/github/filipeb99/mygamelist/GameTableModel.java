package io.github.filipeb99.mygamelist;

import io.github.filipeb99.mygamelist.model.Game;
import io.github.filipeb99.mygamelist.model.GameList;
import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel {
  private GameList gameList;
  private String[] columnNames;

  public GameTableModel(GameList gameList) {
    this.gameList = gameList;
    this.columnNames = Game.getElementNames();
  }

  @Override
  public int getRowCount() {
    return gameList.getSize();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public Object getValueAt(int row, int column) {
    return gameList.toTable()[row][column];
  }

  @Override
  public void setValueAt(Object value, int row, int column) {
    gameList.toTable()[row][column] = (String) value;
  }
}
