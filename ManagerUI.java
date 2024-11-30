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
        
        ActionListener newFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.start();
            }
        };
        ActionListener saveFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameListFileHandler.getInstance().marshal(gameList, gameListFile);
                } catch(JAXBException jaxbException) {}
                
                gameListUI.refreshTableData();
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
            }
        };
        ActionListener cancelFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.stop();
            }
        };
        
        gameListUI.setNewFunc(newFunc);
        gameListUI.setSaveFunc(saveFunc);
        gameUI.setAddFunc(addFunc);
        gameUI.setCancelFunc(cancelFunc);
    }
    
    public void start() {
        gameListUI.start();
    }
}
