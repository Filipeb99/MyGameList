import java.util.List;
import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GameList {
    @XmlElement
    private List<Game> games = null;
    
    public GameList() {
        this.games = new ArrayList<Game>();
    }
    
    public List<Game> getGames() {
        return this.games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    
    public void addGame(Game game) {
        this.games.add(game);
    }
    
    public String[][] toTable() {
        return games.stream().map(Game::toStringArray).toArray(String[][]::new);
    }
}
