package fantasy.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * 
 * Karakter generáláshoz szükséges osztály
 *
 */
@XmlRootElement
public class Character {
	
	/**
	 *  Faj.
	 */
	String race;
	/**
	 *  Életerő.
	 */
	int healPoints;
	/**
	 * Erő.
	 */
	int str;
	/**
	 * Ügyesség.
	 */
	double dex;
	/**
	 * Támadó érték.
	 */
	int attackPoints;
	/**
	 * Védő érték.
	 */
	double defensePoints;
	/**
	 * Mozgáspont.
	 */
	double movingPoints;

	/**
	 * Paraméter nélküli konstruktor.
	 */
	public Character() {
	}

	/**
	 * Paraméteres kontruktor.
	 * 
	 * @param race - faj
	 * @param healPoints - életerő
	 * @param str - erő
	 * @param dex - ügyesség
	 * @param attackPoints - támadópont
	 * @param defensePoints - védekezőpont
	 * @param movingPoints - mozgáspont
	 */
	public Character(String race, int healPoints, int str, double dex, int attackPoints, double defensePoints,
			double movingPoints) {
		this.race = race;
		this.healPoints = healPoints;
		this.str = str;
		this.dex = dex;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.movingPoints = movingPoints;
	}

	/**
	 * Visszaadja a karater faját.
	 * 
	 * @return faj
	 */
	public String getRace() {
		return race;
	}
	
	/**
	 * Beállítja a karakter faját.
	 * 
	 * @param race - faj
	 */
	@XmlElement
	public void setRace(String race) {
		this.race = race;
	}
	
	/**
	 * Visszaadja a karater életerejét.
	 * 
	 * @return életerő pont
	 */
	public int getHealPoints() {
		return healPoints;
	}

	/**
	 * Beállítja a karakter életerejét.
	 * 
	 * @param healPoints - életerőpont
	 */
	@XmlElement
	public void setHealPoints(int healPoints) {
		this.healPoints = healPoints;
	}

	/**
	 * Visszaadja a karater támadó értékét.
	 * 
	 * @return támadóérték
	 */
	public int getAttackPoints() {
		return attackPoints;
	}

	/**
	 * Beállítja a karakter támadó értékét.
	 * 
	 * @param attackPoints - támadó érték
	 */
	@XmlElement
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	/**
	 * Visszaadja a karater védő értékét.
	 * 
	 * @return védőérték
	 */
	public double getDefensePoints() {
		return defensePoints;
	}

	/**
	 * Beállítja a karakter védő értékét.
	 * 
	 * @param defensePoints - védőérték
	 */
	@XmlElement
	public void setDefensePoints(double defensePoints) {
		this.defensePoints = defensePoints;
	}

	/**
	 * Visszaadja a karater mozgáspontját.
	 * 
	 * @return mozgáspont
	 */
	public double getMovingPoints() {
		return movingPoints;
	}

	/**
	 * Beállítja a karakter mozgáspontját.
	 * 
	 * @param movingPoints - mozgáspont
	 */
	@XmlElement
	public void setMovingPoints(double movingPoints) {
		this.movingPoints = movingPoints;
	}

	/**
	 * Visszaadja a karater erejét.
	 * 
	 * @return erő
	 */
	public int getStr() {
		return str;
	}
	
	/**
	 * Beállítja a karakter erejét.
	 * 
	 * @param str - erő
	 */
	@XmlElement
	public void setStr(int str) {
		this.str = str;
	}
	
	/**
	 * Visszaadja a karater ügyességét.
	 * 
	 * @return ügyesség
	 */
	public double getDex() {
		return dex;
	}
	
	/**
	 * Beállítja a karakter ügyességét.
	 * 
	 * @param dex - ügyesség
	 */
	@XmlElement
	public void setDex(double dex) {
		this.dex = dex;
	}

	@Override
	public String toString() {
		return "Character [race=" + race + ", healPoints=" + healPoints + ", str=" + str + ", dex=" + dex
				+ ", attackPoints=" + attackPoints + ", defensePoints=" + defensePoints + ", movingPoints="
				+ movingPoints + "]";
	}
}
