package fantasy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * 
 * Az lejátszott játékokat,meccseket reprezentáló osztály.
 */
@XmlRootElement(name = "games")
public class Games {
	/**
	 * Játékok egy listájával tér vissza, ahol a {@link java.util.List} lista több {@link fantasy.pojo.Game} objektumot is tartalmazhat.
	 */
	List<Game> games;	

	/**
	 * Beállítja a játékok egy listáját.
	 * 
	 * @param games - játékok, ahol {@link fantasy.pojo.Game} objektumok egy {@link java.util.List} típusú objektumát állítja be
	 */
	@XmlElement(name="game")
	public void setGames(List<Game> games) {
		this.games = games;
	}

	/**
	 * Játék hozzáadása az eddegi lejátszott játékok listájához.
	 * 
	 * @param game - egy adott játék, ami egy {@link fantasy.pojo.Game} objektum
	 */
	public void add(Game game) {
		if (this.games == null) {
			this.games = new ArrayList<Game>();
		}
		this.games.add(game);
	}

	/**
	 * Játékok egy listájával tér vissza.
	 * 
	 * @return játékok, ahol a {@link java.util.List} lista több {@link fantasy.pojo.Game} objektumot is tartalmazhat
	 */
	public List<Game> getGames() {
		return games;
	}

	@Override
	public String toString() {
		return "Games [games=" + games + "]";
	}
	
}
