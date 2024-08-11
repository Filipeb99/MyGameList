import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class GameListFileHandler {
    private static GameListFileHandler instance = null;

    private JAXBContext ctxt = null;
    private Marshaller mrsh = null;
    private Unmarshaller unmrsh = null;

    private GameListFileHandler() throws JAXBException {
        ctxt = JAXBContext.newInstance(GameList.class);
        mrsh = ctxt.createMarshaller();
        mrsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        unmrsh = ctxt.createUnmarshaller();
    }

    public static GameListFileHandler getInstance() throws JAXBException {
        if (instance == null) {
            instance = new GameListFileHandler();
        }
        return instance;
    }

    public void marshal(GameList gameList, File file) throws JAXBException {
        mrsh.marshal(gameList, file);
    }
    public GameList unmarshal(File file) throws JAXBException {
        return (GameList) unmrsh.unmarshal(file);
    }
}
