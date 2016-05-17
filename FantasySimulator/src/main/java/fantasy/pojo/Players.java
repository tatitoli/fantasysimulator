package fantasy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * Játékban résztvevő játékosok egy listáját adja vissza
 */
@XmlRootElement(name = "players")
public class Players {
	/**
	 * Játékosok listája
	 */
	List<Player> players;	

	/**
	 * Beállítja a játékosok egy listáját
	 * 
	 * @param players - játékosok egy listája
	 */
	@XmlElement(name="player")
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Hozzáad egy játékost a játékosok egy listjához
	 * 
	 * @param player - játékos
	 */
	public void add(Player player) {
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		this.players.add(player);
	}

	/**
	 * Visszadja a játékosok egy listáját
	 * 
	 * @return játékosok egy listája
	 */
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		return "Players [players=" + players + "]";
	}
	
	
}
