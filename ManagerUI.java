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
        
        ActionListener newFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameListUI.refreshTableData();
                gameUI = new GameUI(gameList);
                gameUI.start();
            }
        };
        ActionListener saveFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameListUI.refreshTableData();
                try {
                    GameListFileHandler.getInstance().marshal(gameList, gameListFile);
                } catch(JAXBException jaxbException) {}
            }
        };
        
        gameListUI.setNewFunc(newFunc);
        gameListUI.setSaveFunc(saveFunc);
    }
    
    public void start() {
        gameListUI.start();
    }
}
