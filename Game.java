import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {
	private String name = null;
    private String developer = null;
    private String currStatus = null;
    
    public static String[] getElementNames() {
        return new String[]{"Name", "Developer", "Status"};
    }
    
    public Game() {
        this.name = new String();
        this.developer = new String();
        this.currStatus = new String("Playing");
    }
    public Game(String name, String developer) {
        this.name = name;
        this.developer = developer;
        this.currStatus = new String("Playing");
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getStatus () {
        return currStatus;
    }
    public void setStatus (String newStatus) {
        this.currStatus = newStatus;
    }
    
    public String[] toStringArray() {
        return new String[]{name, developer, currStatus};
    }
}
