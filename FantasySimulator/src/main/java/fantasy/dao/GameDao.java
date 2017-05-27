package fantasy.dao;

import java.util.List;

import fantasy.pojo.Game;
import fantasy.pojo.Games;
import fantasy.pojo.Player;

/**
 * @author TATITOLI
 * 
 * Az alkalmazás működéséhez szükséges metódusokat leíró interfész.
 *
 */
public interface GameDao {
	
	/** Visszaadja az összes eddig lejátszott játék/meccs eredményét.
	 * 
	 * @return egy {@link fantasy.pojo.Games} objektum
	 */
	public Games getAllGame();
	
	/**
	 * Egy {@link fantasy.pojo.Games} objektum tartalmából visszaadja a paraméterként kapott id-hoz tartozó {@link fantasy.pojo.Game} objektumot.
	 * 
	 * @param id - a meccs/játék egyedi azonosítója
	 * 
	 * @param games - a {@link fantasy.pojo.Games} objektum, mely a lejátszott meccseket tartalmazza
	 * 
	 * @return visszatér az id-val megegyező {@link fantasy.pojo.Game} objektummal
	 */
	public Game getGameById(String id, Games games);

	/**
	 * Mentésre kerülnek a korábbi és az aktuális játékok eredményei.
	 * 
	 * @param games - a {@link fantasy.pojo.Games} objektum, mely a lejátszott meccseket tartalmazza
	 */
	public void saveGames(Games games);

	/** Mentésre kerülnek a az eddigi és az aktuális játékok eredményei.
	 * 
	 * @param games - a {@link fantasy.pojo.Games} objektum, mely a lejátszott meccseket tartalmazza
	 * 
	 * @param fileName - file név
	 */
	public void saveMatch(Games games,String fileName);
	
	/** Betöltésre kerül az utolsó mentett állás.
	 * 
	 * @return games - a {@link fantasy.pojo.Games} objektum, mely a lejátszott meccseket tartalmazza
	 */
	public Games loadMatch();

	/**
	 * A játékosok mozgáspontjai alapján kiszámításra kerül, hogy ki mikor fog következni.
	 * 
	 * @param playerOne - Első játékost reprezentáló {@link fantasy.pojo.Player} objektum
	 * 
	 * @param playerTwo - Második játékost reprezentáló {@link fantasy.pojo.Player} objektum
	 * 
	 * @return Játékosok listájával tér vissza, hogy ki mikor következik
	 */
	public List<Player> makeTurnPlayers(Player playerOne, Player playerTwo);

	/**
	 * Az adott játékos találati értékét számítja ki, hogy mekkora esélye van eltalálni az ellenfelét.
	 * 
	 * @param attack - játékos támadó értéke
	 * 
	 * @param defense - az ellenfél védő értéke
	 * 
	 * @return kiszámolt találati értékkel tér vissza.
	 */
	public int getTargetHit(int attack, double defense);

	/**
	 * Az adott játékos találati értékét számítja ki, hogy mekkora esélye van eltalálni az ellenfelét kritikus találattal.
	 * 
	 * @param hitTarget - a játékos találati esélye
	 * 
	 * @return a paraméterül kapott érték egy százalékos szorzatával tér vissza
	 */
	public int getCriticTargetHit(int hitTarget);

	/**
	 * Paraméterül kapott fájlból betöltésre kerül az utolsó mentett állás.
	 * 
	 * @param fileName - fájlnév
	 * 
	 * @return egy {@link fantasy.pojo.Games} objektummal tér vissza
	 */
	Games loadMatch(String fileName);

	/**Mentésre kerül a paraméterül megkapott játék.
	 * 
	 * @param games - egy {@link fantasy.pojo.Games} objektum
	 */
	void saveMatch(Games games);

	/**Mentésre kerül a paraméterül megkapott játék.
	 * 
	 * @param games - az adott játék, amely egy {@link fantasy.pojo.Games} objektum
	 * 
	 * @param fileName - fájlnév
	 */
	void saveGames(Games games, String fileName);

	/**Betöltésre kerül az eddig összes lejátszott meccs eredménye.
	 * 
	 * @param fileName - fájlnév
	 * 
	 * @return egy {@link fantasy.pojo.Games} objektummal tér vissza
	 */
	Games getAllGame(String fileName);
}
