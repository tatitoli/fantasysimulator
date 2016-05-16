package fantasy.dao;

import fantasy.pojo.Player;
import fantasy.pojo.Players;

/**
 * @author TATITOLI
 *	A karakterek generálásához szükséges metódusokat deklarálja.
 */
public interface PlayerDao {
	/**
	 * Egy players osztályból visszaadja az Id parametérrel megegyező 
	 * player osztályt.
	 * @param players - Players osztály
	 * @param Id - 
	 * @return paraméterül megkapott megegyező id-jú Player osztállyal tér vissza
	 */
	public Player getPlayer(Players players, String id);

	/**
	 * Kiszámolja az adott fajhoz tartozó mozgáspontot.
	 * @param race - az adott faj
	 * @param dex - ügyesség
	 * @return kalkulált mozgáspont
	 */
	public double getCalculateMovingPoints(String race, double dex);

	/**
	 * Kiszámolja az adott fajhoz tartozó életerőt.
	 * @param race - az adott faj
	 * @param str - erő
	 * @return kiszámolt életerő pont 
	 */
	public int getHealthPoints(String race, int str);

	/**
	 * Frissíti a paraméterül kapott játékos életerejét.
	 * @param player - az adott játékos
	 * @param hp - életerő String formában
	 */
	public void updatePlayer(Player player, String hp);
}
