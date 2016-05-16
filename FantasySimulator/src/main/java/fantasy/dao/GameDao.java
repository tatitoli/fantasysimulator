package fantasy.dao;

import java.util.List;

import javax.xml.bind.JAXBException;

import fantasy.pojo.Game;
import fantasy.pojo.Games;
import fantasy.pojo.Player;

/**
 * @author TATITOLI
 * A játék menetéhez szükséges metódusokat deklarálja
 *
 */
public interface GameDao {
	
	/** Visszaadja az összes eddig lejátszott játékot.
	 * @return
	 */
	public Games getAllGame();
	
	/**
	 * Egy Games osztályból visszaadja az id parametérrel megegyező 
	 * game osztályt.
	 * @param id - egyedi azonosító
	 * @param games - Games osztály
	 * @return paraméterül megkapott megegyező id-jú Game osztállyal tér vissza.
	 */
	public Game getGameById(String id, Games games);

	/**
	 * Mentésre kerülnek a az eddigi és az aktuális játékok eredményei
	 * @param games - Games osztály
	 */
	public void saveGames(Games games);

	/**Mentésre kerülnek a az eddigi és az aktuális játékok eredményei.
	 * @param games - Games osztály
	 * @param fileName - file név
	 */
	public void saveMatch(Games games,String fileName);
	
	/**Betöltésre kerül az utolsó mentett állás.
	 * @return utolsó játékkal tér vissza.
	 */
	public Games loadMatch();

	/**
	 * A játékosok mozgáspontjai alapján kiszámításra kerül, hogy ki melyik körben fog következni.
	 * @param playerOne - Első játékos
	 * @param playerTwo - Második játékos
	 * @return Játékosok listájával tér vissza, hogy ki mikor következik
	 */
	public List<Player> makeTurnPlayers(Player playerOne, Player playerTwo);

	/**
	 * Az adott játékos találati értékét számítja ki, hogy 
	 * mekkora esélye van eltalálni az ellenfelét
	 * @param attack - játékos támadó értéke
	 * @param defense - az ellenfél védő értéke
	 * @return kiszámolt találati értékkel tér vissza.
	 */
	public int getTargetHit(int attack, double defense);

	/**
	 * Az adott játékos találati értékét számítja ki, hogy 
	 * mekkora esélye van eltalálni az ellenfelét kritikus találattal
	 * @param hitTarget - kiszámolt getTargetHit értéke
	 * @return hitTarget 15%-át adja vissza.
	 */
	public int getCriticTargetHit(int hitTarget);

	/**
	 * Paraméterül kapott fájlból betöltésre kerül az utolsó mentett állás
	 * @param fileName - fájl náv
	 * @return az adott játék
	 */
	Games loadMatch(String fileName);

	/**Mentésre kerül a paraméterül megkapott játék.
	 * @param games - az adott játék
	 */
	void saveMatch(Games games);

	/**Mentésre kerül a paraméterül megkapott játék.
	 * @param games - az adott játék
	 * @param fileName - fájl név
	 */
	void saveGames(Games games, String fileName);

	/**Betöltésre kerül az eddig összes lejátszott meccs eredménye.
	 * @param fileName - fájlnév
	 * @return Games osztály
	 */
	Games getAllGame(String fileName);
}
