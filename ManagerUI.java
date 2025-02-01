import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.xml.bind.JAXBException;

public class ManagerUI {
    private GameList gameList = null;
    private GameTableModel tableModel = null;
    private GenericListUI gameListUI = null;
    private GameUI gameUI = null;
    
    public ManagerUI(File gameListFile) throws JAXBException {
        gameList = GameListFileHandler.getInstance().unmarshal(gameListFile);
        tableModel = new GameTableModel(gameList);
        gameListUI = new GenericListUI(tableModel, "MyGameList");
        gameUI = new GameUI();
        
        /* GameUI ActionListeners */
        ActionListener cancelFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.stop();
            }
        };
        ActionListener addFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = gameUI.getName();
                String developer = gameUI.getDeveloper();
                String status = gameUI.getStatus();
                
                Game game = new Game(name, developer, status);
                gameList.addGame(game);
                
                gameUI.stop();
                gameListUI.refreshTableData();
            }
        };
        ActionListener updateFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = gameUI.getName();
                String developer = gameUI.getDeveloper();
                String status = gameUI.getStatus();
                
                Game gameToUpdate = gameList.getGameByName(name);
                Integer gameToUpdateIndex = gameList.getGames().indexOf(gameToUpdate);
                
                Game game = new Game(name, developer, status);
                gameList.updateGame(gameToUpdateIndex, game);
                
                gameUI.stop();
                gameListUI.refreshTableData();
            }
        };
        
        /* GameListUI ActionListeners */
        ActionListener editFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = gameListUI.getSelectedRow();
                String name = (String) tableModel.getValueAt(row, 0);
                String developer = (String) tableModel.getValueAt(row, 1);
                String status = (String) tableModel.getValueAt(row, 2);
                
                gameUI = new GameUI(name, developer, status);
                gameUI.setCancelFunc(cancelFunc);
                gameUI.setConfirmFunc(updateFunc);
                gameUI.activateButtons();
                gameUI.start();
            }
        };
        ActionListener newFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI = new GameUI();
                gameUI.setCancelFunc(cancelFunc);
                gameUI.setConfirmFunc(addFunc);
                gameUI.activateButtons();
                gameUI.start();
            }
        };
        ActionListener saveFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameListFileHandler.getInstance().marshal(gameList, gameListFile);
                } catch(JAXBException jaxbException) {}
            }
        };
        
        gameListUI.setEditFunc(editFunc);
        gameListUI.setNewFunc(newFunc);
        gameListUI.setSaveFunc(saveFunc);
    }
    
    public void start() {
        gameListUI.start();
    }
}
