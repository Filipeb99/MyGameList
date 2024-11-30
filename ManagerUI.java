import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.xml.bind.JAXBException;

public class ManagerUI {
    private GameList gameList = null;
    private GameTableModel tableModel = null;
    private MainUI mainUI = null;
    
    public ManagerUI(File gameListFile) throws JAXBException {
        gameList = GameListFileHandler.getInstance().unmarshal(gameListFile);
        tableModel = new GameTableModel(gameList);
        mainUI = new MainUI(tableModel, "MyGameList");
        
        ActionListener newFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement add new functionality
                mainUI.refreshTableData();
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
        
        mainUI.setNewFunc(newFunc);
        mainUI.setSaveFunc(saveFunc);
    }
    
    public void start() {
        mainUI.start();
    }
}
