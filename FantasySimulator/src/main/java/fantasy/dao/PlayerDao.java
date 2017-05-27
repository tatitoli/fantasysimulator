package fantasy.dao;

import fantasy.pojo.Player;
import fantasy.pojo.Players;

/**
 * @author TATITOLI
 * 
 *	A karakterek generálásához szükséges metódusokat deklarálja.
 */
public interface PlayerDao {
	/**
	 * Paraméterül kapott {@link fantasy.pojo.Players} objektumból visszaadja az id parametérrel megegyező {@link fantasy.pojo.Player} objektumot.
	 * 
	 * @param players - egy {@link fantasy.pojo.Players} objektum
	 * 
	 * @param id - egy {@link fantasy.pojo.Player} objektumot azonosító paraméter 
	 * 
	 * @return paraméterül megkapott megegyező id-jú {@link fantasy.pojo.Player} objektummal tér vissza
	 */
	public Player getPlayer(Players players, String id);

	/**
	 * Kiszámolja az adott fajhoz tartozó mozgáspontot.
	 * 
	 * @param race - az adott faj
	 * 
	 * @param dex - ügyesség
	 * 
	 * @return kalkulált mozgáspont
	 */
	public double getCalculateMovingPoints(String race, double dex);

	/**
	 * Kiszámolja az adott fajhoz tartozó életerőt.
	 * 
	 * @param race - az adott faj
	 * 
	 * @param str - erő
	 * 
	 * @return kiszámolt életerő pont 
	 */
	public int getHealthPoints(String race, int str);

	/**
	 * Frissíti a paraméterül kapott játékos életerejét.
	 * 
	 * @param player - az adott játékos
	 * 
	 * @param hp - életerő String formában
	 */
	public void updatePlayer(Player player, String hp);
}
