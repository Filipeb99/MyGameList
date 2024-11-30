import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {
	private String name = null;
    private String developer = null;
    private String status = null;
    
    public static String[] getElementNames() {
        return new String[]{"Name", "Developer", "Status"};
    }
    
    public Game() {
        this("", "", "Playing");
    }
    public Game(String name, String developer, String status) {
        this.name = name;
        this.developer = developer;
        this.status = status;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] toStringArray() {
        return new String[]{name, developer, status};
    }
}
