import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.xml.bind.JAXBException;

public class GameListMainUI extends MainUI {
    public GameListMainUI(File gameListFile) throws JAXBException {
        GameList gameList = GameListFileHandler.getInstance().unmarshal(gameListFile);
        super(gameList.toTable(), Game.getElementNames(), "MyGameList");
        
        ActionListener addFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement add functionality
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
        
        setAddFunc(addFunc);
        setSaveFunc(saveFunc);
    }
}
