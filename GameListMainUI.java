import java.io.File;
import jakarta.xml.bind.JAXBException;

public class GameListMainUI extends MainUI {
    public GameListMainUI(File gameListFile) throws JAXBException {
        GameList gameList = GameListFileHandler.getInstance().unmarshal(gameListFile);
        super(gameList.toTable(), Game.getElementNames(), "MyGameList");
    }
}
