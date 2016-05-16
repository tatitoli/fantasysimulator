package fantasy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fantasy.daoimp.GameDaoImp;
import fantasy.daoimp.PlayerDaoImp;
import fantasy.pojo.Character;
import fantasy.pojo.Game;
import fantasy.pojo.Games;
import fantasy.pojo.Player;
import fantasy.pojo.Players;

public class GameDaoTest {

	List<Player> turnPlayers;
	Games games = new Games();
	Game game = new Game();
	Players players = new Players();
	Player player;
	Player playerTwo;
	Character character;
	Character characterTwo;
	PlayerDaoImp playerDaoImp = new PlayerDaoImp();
	GameDaoImp gameDaoImp = new GameDaoImp();
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
		playerTwo = new Player();
		characterTwo = new Character();
		characterTwo.setRace("Ember");
		character = new Character();
		character.setRace("Elf");
		character.setStr(8);
		character.setDex(6.0);
		character.setAttackPoints(8);
		character.setDefensePoints(6);
		character.setMovingPoints(playerDaoImp.getCalculateMovingPoints("Elf", 6.0));
		character.setHealPoints(playerDaoImp.getHealthPoints("Elf", 8));
		characterTwo.setStr(7);
		characterTwo.setDex(7.0);
		characterTwo.setAttackPoints(7);
		characterTwo.setDefensePoints(7);
		characterTwo.setMovingPoints(playerDaoImp.getCalculateMovingPoints("Ember", 7.0));
		characterTwo.setHealPoints(playerDaoImp.getHealthPoints("Ember", 7));
		player.setCharacter(character);
		player.setId("0");
		playerTwo.setCharacter(characterTwo);
		player.setId("1");
		players.add(player);
		players.add(playerTwo);
		game.setPlayers(players);
		game.setId("0");
		game.setWhoWin("NoOne");
		games.add(game);
	}
	
	@Test
	public void testGetTargetHit() {
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0)==100, false);
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0)==99, true);
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0)==98, false);
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0)==84, false);
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0)==85, true);
		assertEquals(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0)==86, false);
	}
	
	@Test
	public void testGetCriticTargetHit() {
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0))==13, false);
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0))==14, true);
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 1.0))==15, false);
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0))==11, false);
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0))==12, true);
		assertEquals(gameDaoImp.getCriticTargetHit(gameDaoImp.getTargetHit(player.getCharacter().getStr(), 5.0))==13, false);
	}
	
//	@Before
//	public void testSaveGame() throws JAXBException{
//		gameDaoImp.saveGames(games,"testGame.xml");
//	}
//	
//	@Test
//	public void testGetAllGame() throws JAXBException{
//		games = gameDaoImp.getAllGame("testGame.xml");
//	}
//	
//	
//	@Before
//	public void testSaveMatch() throws JAXBException{
//		gameDaoImp.saveMatch(games,"testActualGame.xml");
//	}
//	
//	@Test
//	public void testLoadMatch() throws JAXBException{
//		games = gameDaoImp.loadMatch("testActualGame.xml");
//	}
	
	@Test
	public void testGameById(){
		assertEquals(gameDaoImp.getGameById("0", games).equals(game), true);
		assertEquals(gameDaoImp.getGameById("1", games).equals(game), false);
	}
	
	@Test
	public void testTurnPlayers(){
		turnPlayers = gameDaoImp.makeTurnPlayers(player, playerTwo);
		assertEquals(turnPlayers.get(0).equals(player), true);
		assertEquals(turnPlayers.get(0).equals(playerTwo), false);
	}
}
