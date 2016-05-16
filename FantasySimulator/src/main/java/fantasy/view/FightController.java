package fantasy.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.pmw.tinylog.Logger;

import fantasy.daoimp.GameDaoImp;
import fantasy.daoimp.PlayerDaoImp;
import fantasy.pojo.Game;
import fantasy.pojo.Games;
import fantasy.pojo.Player;
import fantasy.pojo.Players;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FightController {
	private LocalDateTime localDateTime;
	private Game game = new Game();
	private Games gamesList = new Games();
	private Players playerList = new Players();
	private int i = 0;
	private int rolledNumber = 0;
	boolean gameEnd = false;
	private PlayerDaoImp playerDao = new PlayerDaoImp();
	private GameDaoImp gameDao = new GameDaoImp();
	private List<Player> turnByPlayers;
	private Player playerOne;
	private Player playerTwo;
	private Stage stage;
	private MainForm mainForm;

	@FXML
	private Label messageOne;

	@FXML
	private Label messageTwo;

	@FXML
	private Button rollOne;

	@FXML
	private Button rollTwo;

	@FXML
	private Label message;

	@FXML
	private Label rollNumber;

	@FXML
	private Label hitTargetOne;

	@FXML
	private Label hitTargetTwo;

	@FXML
	private Label hitCriticTargetOne;

	@FXML
	private Label hitCriticTargetTwo;

	@FXML
	private Label nameOne;

	@FXML
	private Label nameTwo;

	@FXML
	private Label hpOne;

	@FXML
	private Label hpTwo;

	@FXML
	private Label mpOne;

	@FXML
	private Label mpTwo;

	@FXML
	private Label attackOne;

	@FXML
	private Label attackTwo;

	@FXML
	private Label defenseOne;

	@FXML
	private Label defenseTwo;

	@FXML
	private Button startButton;
	
	private String makeid(){
		String id = ""+localDateTime.now();
		id=id.replace("-", "").replace(":", "").replace(".", "");
		return id;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public int randomRoll() {
		Random random = new Random();
		int hit = random.nextInt(100) + 1;
		rollNumber.setText(String.valueOf(hit));
		return hit;
	}

	@FXML
	public void midButton(){
		if("Start".equals(startButton.getText())){
			startButton.setText("Ment�s");
			startGame();
		}else if("Ment�s".equals(startButton.getText())){
			saveGame();
		}else if("Bez�r".equals(startButton.getText())){
			Stage actualStage = (Stage) startButton.getScene().getWindow();
			actualStage.close();
		}
	}

	private void saveGame() {
		gamesList = new Games();
		game =  new Game();
		game.setId(makeid());
		game.setPlayers(playerList);
		game.setWhoWin(null);
		gamesList.add(game);
		gameDao.saveMatch(gamesList,"actualGame.xml");
		Stage actualStage = (Stage) startButton.getScene().getWindow();
		actualStage.close();
	}

	@FXML
	public void rollOne() {
		rolledNumber = randomRoll();
		if (rolledNumber <= Integer.parseInt(hitTargetOne.getText())) {
			hit();
			hpTwo.setText(String.valueOf((Integer.parseInt(hpTwo.getText()) - Integer.parseInt(attackOne.getText()))));
		}
		if (rolledNumber <= Integer.parseInt(hitCriticTargetOne.getText())) {
			dialogCriticalHit();
			hpTwo.setText(String.valueOf((Integer.parseInt(hpTwo.getText()) - Integer.parseInt(attackOne.getText()))));
		}
		if (Integer.parseInt(hpTwo.getText()) <= 0) {
			hpTwo.setText("0");
			playerDao.updatePlayer(playerTwo, hpTwo.getText());
			try {
				endGame(playerOne);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				Logger.error(e.getMessage());
			}
		}else{
			playerDao.updatePlayer(playerTwo, hpTwo.getText());
			whosNext();
		}
	}

	public void endGame(Player player) throws JAXBException {
		rollOne.setVisible(false);
		rollTwo.setVisible(false);
		message.setText("");
		messageOne.setText("");
		messageTwo.setText("");
		rollNumber.setText("");
		startButton.setText("Bez�r");
		game.setId(makeid());
		game.setPlayers(playerList);
		game.setWhoWin(player.getName());
		
		gamesList=gameDao.getAllGame("game.xml");
		gamesList.add(game);
		gameDao.saveGames(gamesList,"game.xml");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("V�ge a harcnak");
		alert.setHeaderText(null);
		alert.setContentText("Gratul�lok, " + player.getName()+ " j�tt ki gy�ztesen a k�zdelemb�l!");
		alert.showAndWait();
	}

	public void dialogCriticalHit() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Sz�p munka");
		alert.setHeaderText(null);
		alert.setContentText("Kritikus tal�lat");
		alert.showAndWait();
	}

	public void hit() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Sz�p munka");
		alert.setHeaderText(null);
		alert.setContentText("Tal�lat");
		alert.showAndWait();
	}

	@FXML
	public void rollTwo() {
		rolledNumber = randomRoll();
		if (rolledNumber <= Integer.parseInt(hitTargetTwo.getText())) {
			hit();
			hpOne.setText(String.valueOf((Integer.parseInt(hpOne.getText()) - Integer.parseInt(attackTwo.getText()))));
		}
		if (rolledNumber <= Integer.parseInt(hitCriticTargetTwo.getText())) {
			dialogCriticalHit();
			hpOne.setText(String.valueOf((Integer.parseInt(hpOne.getText()) - Integer.parseInt(attackTwo.getText()))));
		}
		if (Integer.parseInt(hpOne.getText()) <= 0) {
			hpOne.setText("0");
			playerDao.updatePlayer(playerOne, hpOne.getText());
			try {
				endGame(playerTwo);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			playerDao.updatePlayer(playerOne, hpOne.getText());
			whosNext();
		}
	}

	public void setInitPlayerOne(Player player, double playerTwoDefense) {
		this.playerOne = player;
		nameOne.setText(playerOne.getName());
		hpOne.setText(String.valueOf(playerOne.getCharacter().getHealPoints()));
		mpOne.setText(String.valueOf(playerOne.getCharacter().getMovingPoints()));
		attackOne.setText(String.valueOf(playerOne.getCharacter().getAttackPoints()));
		defenseOne.setText(String.valueOf((int)playerOne.getCharacter().getDefensePoints()));
		hitTargetOne.setText(String.valueOf(gameDao.getTargetHit(playerOne.getCharacter().getStr(), playerTwoDefense)));
		hitCriticTargetOne.setText(String.valueOf(gameDao.getCriticTargetHit(Integer.parseInt(hitTargetOne.getText()))));
		playerList.add(player);
	}

	public void setInitPlayerTwo(Player player, double playerOneDefense) {
		this.playerTwo = player;
		nameTwo.setText(playerTwo.getName());
		hpTwo.setText(String.valueOf(playerTwo.getCharacter().getHealPoints()));
		mpTwo.setText(String.valueOf(playerTwo.getCharacter().getMovingPoints()));
		attackTwo.setText(String.valueOf(playerTwo.getCharacter().getAttackPoints()));
		defenseTwo.setText(String.valueOf((int)playerTwo.getCharacter().getDefensePoints()));
		hitTargetTwo.setText(String.valueOf(gameDao.getTargetHit(playerTwo.getCharacter().getStr(), playerOneDefense)));
		hitCriticTargetTwo.setText(String.valueOf(gameDao.getCriticTargetHit(Integer.parseInt(hitTargetTwo.getText()))));
		rollOne.setVisible(false);
		rollTwo.setVisible(false);
		playerList.add(player);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setTurnsList(List<Player> turnByPlayers) {
		this.turnByPlayers = turnByPlayers;
	}

	public void startGame() {
		if (nameOne.getText().equals(turnByPlayers.get(0).getName())) {
			message.setText(nameOne.getText() + " kezdi a játékot");
			rollOne.setVisible(true);
		} else {
			message.setText(nameTwo.getText() + " kezdi a játékot");
			rollTwo.setVisible(true);
		}
	}

	public void whosNext() {
		i++;
		if (nameOne.getText().equals(turnByPlayers.get(i).getName())) {
			message.setText(nameOne.getText() + " következik!");
			rollOne.setVisible(true);
			rollTwo.setVisible(false);
			messageOne.setText("K�rlek dobj!");
			messageTwo.setText("");

		} else {
			message.setText(nameTwo.getText() + " következik!");
			rollTwo.setVisible(true);
			rollOne.setVisible(false);
			messageTwo.setText("Kérlek dobj!");
			messageOne.setText("");
		}
	}

}
