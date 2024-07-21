import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Game {
	private String name = null;
    private String developer = null;
    private String currStatus = null;
    
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
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDeveloper() {
        return this.developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getStatus () {
        return this.currStatus;
    }
    public void setStatus (String newStatus) {
        this.currStatus = newStatus;
    }
}
