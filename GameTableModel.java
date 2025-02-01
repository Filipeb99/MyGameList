import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel {
    private GameList gameList = null;
    private String[] columnNames = null;
    
    public GameTableModel(GameList gameList) {
        this.gameList = gameList;
        this.columnNames = Game.getElementNames();
    }
    
    public int getRowCount() {
        return gameList.getSize();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public Object getValueAt(int row, int column) {
        return gameList.toTable()[row][column];
    }
    public void setValueAt(Object value, int row, int column) {
        gameList.toTable()[row][column] = (String) value;
    }
}
