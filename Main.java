import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static void main (String[] args) {
        try {
            Game game = null;
            File file = new File("gameList.xml");
            
            JAXBContext ctxt = JAXBContext.newInstance(Game.class);
            
            Marshaller mrsh = ctxt.createMarshaller();
            Unmarshaller unmrsh = ctxt.createUnmarshaller();
            
            game = (Game) unmrsh.unmarshal(file);
            game.setStatus("Completed");
            mrsh.marshal(game, file);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
