package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * 
 * the score class contains all score-related methods that were initially in the Animal class, as well as the roundEnd method to deal with round scores
 *
 */
public class Score {
	public int points;
	public ArrayList<Integer> rounds;
	public boolean changeScore;

	public Score(int points, ArrayList<Integer> rounds, boolean changeScore) {
		this.points = points;
		this.rounds = rounds;
		this.changeScore = changeScore;
	}
	
	public boolean changeScore() { //added to score class from animal class
		if (this.changeScore) {
			this.changeScore = false;
			return true;
		}
		return false;
		
	}
	/**
	 * the roundEnd method adds the score of the round to an array and sorts the scores of each round and displays it in an array
	 */
	public void roundEnd() { //round end routine to print high score list per round
		
		//System.out.println(this.points); //test for points
		this.rounds.add(this.points);
		Collections.sort(this.rounds);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Highscore List");
		alert.setHeaderText("Your highscores per round:");
		String list = "";
		for (int counter : this.rounds) {
			//System.out.println(counter);
			list = list + "\n" + counter;
		}
		alert.setContentText(list);
		alert.show();
		
	}
	
	public int getPoints() {
		return this.points;
	}
}