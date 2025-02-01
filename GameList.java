import java.util.List;
import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement(name="GameList")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameList {
    @XmlElement
    private List<Game> games = null;
    
    public GameList() {
        games = new ArrayList<Game>();
    }
    
    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    
    public int getSize() {
        return games.size();
    }
    
    public void addGame(Game game) {
        games.add(game);
    }
    public void updateGame(Integer index, Game game) {
        games.set(index, game);
    }
    public String[][] toTable() {
        return games.stream().map(Game::toStringArray).toArray(String[][]::new);
    }
    public Game getGameByName(String name) {
        return games.stream().filter(game -> game.getName().equals(name)).findAny().orElse(null);
    }
}
