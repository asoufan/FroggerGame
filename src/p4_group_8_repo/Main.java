package p4_group_8_repo;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import p4_group_8_repo.Levels.Digit;
import p4_group_8_repo.Obstacles.End;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background = MyStage.getInstance() ; //made into singleton since only need one instance
	static Stage primaryStage; //made static so can access from controller class
	static Animal animal; //made static so that the same instance can be used upon instantiation across all classes
	Writer writer;



	
	public static void main(String[] args) {
		launch(args);
	}
/**
 * start method calls the start screen and sets it to the primary stage, the Controller class takes care of the transition to the actual game
 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		
		writer = new Writer();
		Main.primaryStage = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml")); //use the start screen as the initial scene and use a controller class to switch to the main game
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
		
		animal = new Animal("file:src/misc/froggerUp.png");
		setUp();

		
	}
	
/**
 * method used to set the end boxes where the frogs are captured
 */
	public void setEnd() {
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		background.add(new Digit(0, 30, 570, 25)); //fixed score to be on side
		
	}
	
	/**
	 * method used to start the background/appplication, set the background image, and begin the game and timer after setup
	 */
	public void setUp() {
		background.start();
		BackgroundImage froggerback = new BackgroundImage("file:src/misc/iKogsKW.png");
		background.add(froggerback);
		setEnd();
		start();
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.score.changeScore()) { //change score is now in score class
            		setNumber(animal.score.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		int test =animal.score.getPoints();
            		writer.highscore = test;
            		writer.writeToArrayList();
            		alert.setHeaderText("Your High Score: "+test+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            		
            	}
            }
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 570 - shift, 25)); //fixed score to be on side
    		  shift+=30;
    		}
    }
}
