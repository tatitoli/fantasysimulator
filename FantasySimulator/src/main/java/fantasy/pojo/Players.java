package fantasy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * 
 *  Egy játékban résztvevő játékosok egy listáját adja vissza.
 */
@XmlRootElement(name = "players")
public class Players {
	/**
	 * Játékosok listája, amely egy {@link java.util.List} több {@link fantasy.pojo.Player} objektumot is tartalmazhat.
	 */
	List<Player> players;	

	/**
	 * Beállítja a játékosok egy listáját.
	 * 
	 * @param players - játékosok egy listája, ahol egy {@link java.util.List} objektem több {@link fantasy.pojo.Player} objektumot is tartalmazhat.
	 */
	@XmlElement(name="player")
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Hozzáad egy játékost a játékosok egy listjához.
	 * 
	 * @param player - játékos, amely egy {@link fantasy.pojo.Player} objektum
	 */
	public void add(Player player) {
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		this.players.add(player);
	}

	/**
	 * Visszadja a játékosok egy listáját.
	 * 
	 * @return játékosok egy listája, ahol a {@link java.util.List} objektum több {@link fantasy.pojo.Player} objektumot is tartalmazhat
	 */
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		return "Players [players=" + players + "]";
	}
	
	
}
