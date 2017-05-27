package fantasy.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TATITOLI
 * 
 *	Egy játékost reprezentáló osztály.
 */
@XmlRootElement(name="palyer")
public class Player {
	/**
	 * Játékos egyedi azonosítója.
	 */
	String id;
	/**
	 * Játékos neve.
	 */
	String name;
	/**
	 * Játékos karaktere.
	 */
	Character character;
	
	/**
	 * Paraméter nélküli konstruktor.
	 */
	public Player(){
	}
	
	/**
	 * Paraméteres konstruktor.
	 * 
	 * @param id - egyedi azonosító
	 * @param name - név
	 * @param character - karakter
	 */
	public Player(String id, String name, Character character) {
		this.id = id;
		this.name = name;
		this.character = character;
	}
	
	/**
	 * Visszadja a játékos egyedi azonosítóját.
	 * 
	 * @return egyedi azonosító
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Beállítja a játékos egyedi azonosítóját.
	 * 
	 * @param id - egyedi azonosító
	 */
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Visszadja a játékos nevét.
	 * 
	 * @return játékos neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a játékos nevét.
	 * 
	 * @param name - játékos neve
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszadja a játékos karakterét.
	 * 
	 * @return játékos karaktere
	 */
	public Character getCharacter() {
		return character;
	}
	
	/**
	 * Beállítja a játékos karakterét.
	 * 
	 * @param character - játékos karaktere
	 */
	@XmlElement
	public void setCharacter(Character character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "Player [Id=" + id + ", name=" + name + ", character=" + character + "]";
	}
	
	
}
