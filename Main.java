import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {
    public static void main (String[] args) throws JAXBException {
        Game game = null;
        File file = new File("gameList.xml");
        
        JAXBContext ctxt = JAXBContext.newInstance(Game.class);
        
        Marshaller mrsh = ctxt.createMarshaller();
        mrsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        Unmarshaller unmrsh = ctxt.createUnmarshaller();
        
        game = (Game) unmrsh.unmarshal(file);
        game.setStatus("Playing");
        mrsh.marshal(game, file);
    }
}
