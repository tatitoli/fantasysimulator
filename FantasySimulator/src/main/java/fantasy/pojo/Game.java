package fantasy.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * 
 * Egy játékmenethez szükséges osztály.
 *
 */
@XmlRootElement(name="game")
public class Game {
	
	/**
	 * Játék egyedi azonosítója.
	 */
	String id;
	
	/**
	 * Játékban részvevő játékosok.
	 */
	Players players;
	
	/**
	 * Játék győztese.
	 */
	String whoWin;

	/**
	 *  Paraméter nélküli konstruktor.
	 */
	public Game() {
	}

	/**
	 * Paraméteres konstruktor.
	 * 
	 * @param id - egyedi azonosító
	 * @param players - játékosok, amely egy {@link fantasy.pojo.Players} objektum
	 * @param whoWin - győztes
	 */
	public Game(String id, Players players, String whoWin) {
		super();
		this.id = id;
		this.players = players;
		this.whoWin = whoWin;
	}
	
	/**
	 * Visszadja a játék egyedi azonosítóját.
	 * 
	 * @return - egyedi azonosító
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Beállítja a játék egyedi azonosítóját.
	 * 
	 * @param id - egyedi azonosító
	 */
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Visszaadja a játékban résztvevő játékosokat, amely egy {@link fantasy.pojo.Players} objektum.
	 * 
	 * @return játékosok
	 */
	public Players getPlayers() {
		return players;
	}
	
	/**
	 * Beállítja a játékban résztvető játékosokat.
	 * 
	 * @param players - játékosok, amely egy {@link fantasy.pojo.Players} objektum
	 */
	@XmlElement
	public void setPlayers(Players players) {
		this.players = players;
	}
	
	/**
	 * Visszaadja a játék győztesét.
	 * 
	 * @return játék győztesét adja vissza
	 */
	public String getWhoWin() {
		return whoWin;
	}

	/**
	 * Beállítja a játék győztesét.
	 * 
	 * @param whoWin - játék győztese
	 */
	@XmlElement
	public void setWhoWin(String whoWin) {
		this.whoWin = whoWin;
	}

	@Override
	public String toString() {
		return "Game [Id=" + id + ", players=" + players + ", whoWin=" + whoWin + "]";
	}
}
