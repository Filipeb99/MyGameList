public class GameListMainUI extends MainUI {
    public GameListMainUI(GameList gameList) {
        super(gameList.toTable(), Game.getElementNames(), "MyGameList");
    }
}
