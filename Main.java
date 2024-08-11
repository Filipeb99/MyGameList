import java.io.File;
import jakarta.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws JAXBException {
        File file = new File("gameList.xml");
        
        GameList gameList = GameListFileHandler.getInstance().unmarshal(file);
        
        GameListMainUI mainUI = new GameListMainUI(gameList);
        mainUI.run();
        
        GameListFileHandler.getInstance().marshal(gameList, file);
    }
}
