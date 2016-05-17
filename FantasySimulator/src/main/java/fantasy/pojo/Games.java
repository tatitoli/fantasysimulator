package fantasy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 *Az összes lejátszott játék reprezentáló osztály
 */
@XmlRootElement(name = "games")
public class Games {
	/**
	 * Játékok egy listája
	 */
	List<Game> games;	

	/**
	 * Beállítja a játékok egy listáját
	 * 
	 * @param games
	 */
	@XmlElement(name="game")
	public void setGames(List<Game> games) {
		this.games = games;
	}

	/**
	 * Játékot ad az eddegi lejátszott játékok listájához
	 * 
	 * @param game - az adott játék
	 */
	public void add(Game game) {
		if (this.games == null) {
			this.games = new ArrayList<Game>();
		}
		this.games.add(game);
	}

	/**
	 * Játékok egy listájával tér vissza
	 * 
	 * @return játékok
	 */
	public List<Game> getGames() {
		return games;
	}

	@Override
	public String toString() {
		return "Games [games=" + games + "]";
	}
	
}
