package fantasy.pojo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author TATITOLI
 * Az eddig lejátszott játékok egy megjelenítését reprezentáló osztály
 *
 */
public class GameTable {
	
	/**
	 * Egyedi azonosító
	 */
	private String id;
	/**
	 * Első játékos
	 */
	private StringProperty playerOne;
	/**
	 * Második játékos
	 */
	private StringProperty playerTwo;
	/**
	 * Játék győztese
	 */
	private StringProperty who;

	/**
	 * Paraméteres konstruktor
	 * 
	 * @param id -egyedi azonosító
	 * @param playerOne - első játékos
	 * @param playerTwo - második játékos
	 * @param who - játék győztese
	 */
	public GameTable(String id, String playerOne, String playerTwo, String who) {
		this.id= id;
		this.playerOne = new SimpleStringProperty(playerOne);
		this.playerTwo = new SimpleStringProperty(playerTwo);
		this.who = new SimpleStringProperty(who);
	}
	
	/**
	 * Visszadja a első játékost
	 * 
	 * @return játékos
	 */
	public String getPlayerOne() {
		return playerOne.get();
	}

	/**
	 * 
	 * Beállítja az első játékos
	 * 
	 * @param playerOne - játékos
	 */
	public void setPlayerOne(String playerOne) {
		this.playerOne.set(playerOne);
	}
	
	/**
	 * Visszadja a első játékost
	 * 
	 * @return játékos
	 */
	public StringProperty getPlayerOneProperty() {
		return playerOne;
	}

	/**
	 * Visszadja a második játékost
	 * 
	 * @return játékos
	 */
	public String getPlayerTwo() {
		return playerTwo.get();
	}

	/**
	 * Beállítja a második játékost
	 * 
	 * @param playerTwo - játékos
	 */
	public void setPlayerTwo(String playerTwo) {
		this.playerTwo.set(playerTwo);
	}
	
	/**
	 * Visszadja a második játékost
	 * 
	 * @return játékos
	 */
	public StringProperty getPlayerTwoProperty() {
		return playerTwo;
	}

	/**
	 * Visszadja a játék győztesét
	 * 
	 * @return - győztes
	 */
	public String getWho() {
		return who.get();
	}

	/**
	 * Beállítja a játék győztesét
	 * 
	 * @param who - győztes
	 */
	public void setWho(String who) {
		this.who.set(who);
	}
	
	/**
	 * Visszadja a játék győztesét
	 * 
	 * @return győztes
	 */
	public StringProperty getWhoProperty() {
		return who;
	}

	/**
	 * Beállítja az első játékos
	 * 
	 * @param playerOne - játékos
	 */
	public void setPlayerOne(StringProperty playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * Beállítja a második játékost
	 * 
	 * @param playerTwo - játékos
	 */
	public void setPlayerTwo(StringProperty playerTwo) {
		this.playerTwo = playerTwo;
	}

	/**
	 * Visszadja a játék győztesét
	 * 
	 * @return győztes
	 */
	public void setWho(StringProperty who) {
		this.who = who;
	}

	/**
	 * Visszaadja az a játék egyedi azonosítóját
	 * 
	 * @return egyedi azonosító
	 */
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a játék egyedi azonosítóját
	 * 
	 * @param id - egyedi azonosító
	 */
	public void setId(String id) {
		this.id = id;
	}
}
