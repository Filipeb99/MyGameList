import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Main {
    public static void main (String[] args) {
        try {
            Game game = new Game("Persona 5 Royal", "Atlus");
            File file = new File("gameList.xml");
            
            JAXBContext ctxt = JAXBContext.newInstance(Game.class);
            Marshaller mrsh = ctxt.createMarshaller();
            mrsh.marshal(game, file);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
