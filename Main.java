import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {
    public static void main (String[] args) throws JAXBException {
        GameList gameList = null;
        File file = new File("gameList.xml");
        
        JAXBContext ctxt = JAXBContext.newInstance(GameList.class);
        
        Marshaller mrsh = ctxt.createMarshaller();
        mrsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        Unmarshaller unmrsh = ctxt.createUnmarshaller();
        
        gameList = (GameList) unmrsh.unmarshal(file);
        System.out.println(gameList.getGames().size());
        gameList.getGames().get(0).setStatus("Completed");
        mrsh.marshal(gameList, file);
    }
}
