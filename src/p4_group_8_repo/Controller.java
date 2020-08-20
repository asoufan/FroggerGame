package p4_group_8_repo;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import p4_group_8_repo.Levels.Level;
import p4_group_8_repo.Levels.LevelFactory;
/**
 * 
 * @author Controller class is used to run the FXML files and link them to the code to start the game levels, go to the information screen, and display the leaderboard
 *
 */
public class Controller { //class to control FXML
	
	Writer writer;
	LevelFactory levelfactory;
	Animal animal;
	MyStage background;


	
	/**
	 * 
	 * method called when the start button is clicked to call on the FXML file Levels that gives the player options between different levels
	 */
	public void startButtonClick() throws IOException{
		
		changeScene("Levels.fxml");
		
	}
	/**
	 * 
	 * method called when the info button is clicked to display the info screen
	 */
	public void infoButtonClick() throws IOException {
		changeScene("InfoScreen.fxml");
	}
	
	/**
	 * 
	 * method called when the back button of the info screen is clicked to go back to the start screen
	 */
	public void backButtonClick() throws IOException {
		changeScene("StartScreen.fxml");
		
	}
	
	/**
	 * method called when the leader button is clicked to display a list of high scores using an alert with the help of the Writer instantiated that reads and writes from the score.txt file
	 */
	public void leaderButtonClick(){
		
		writer = new Writer();
		String list="";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Leaderboard");
		alert.setHeaderText("These are the highest all-time scores:");
		writer.readFromFile();
		for (int counter : writer.numb) {
			//System.out.println(counter);
			list = list + "\n" + counter;
			}
		alert.setContentText(list);
		alert.show();
		
	}
	/**
	 * 
	 * @param fxml contains the fxml to be changed to
	 * method used to transition display between fxml files 
	 */
	public void changeScene(String fxml) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		Main.primaryStage.getScene().setRoot(root);
		
	}
	
	/**
	 * method used to set the scene on the main stage and call set level to instantiate the obstacles
	 */
	public void Level1() {
		
		Scene scene  = new Scene(MyStage.getInstance(),600,800);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		setLevel(1);
		this.animal = Main.animal;
		background = MyStage.getInstance();
		background.add(animal);
	
		
	}
	
	public void Level2() {
		Scene scene  = new Scene(MyStage.getInstance(),600,800);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		setLevel(2);
		this.animal = Main.animal;
		background = MyStage.getInstance();
		background.add(animal);


	}
	public void Level3() {
		Scene scene  = new Scene(MyStage.getInstance(),600,800);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		setLevel(3);
		this.animal = Main.animal;
		background = MyStage.getInstance();
		background.add(animal);


	}
	/**
	 * 
	 * @param level to pick which level's obstacles are instantiated based on the level factory created
	 * method used to call on the level factory and set up the obstacles and turtles
	 */
	public void setLevel(int level) {
		
		levelfactory = new LevelFactory();
		Level levelCreated = levelfactory.getLevel(level);
		levelCreated.instantiateObstacles();
		levelCreated.instantiateAnimals();
		
	}
	


}