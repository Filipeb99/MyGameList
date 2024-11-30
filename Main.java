import java.io.File;
import jakarta.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws JAXBException {
        File file = new File("gameList.xml");
        ManagerUI managerUI = new ManagerUI(file);
        managerUI.start();
    }
}
