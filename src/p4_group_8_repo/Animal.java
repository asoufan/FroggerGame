package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Collections;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Movement.Death;
import p4_group_8_repo.Movement.Movement;
import p4_group_8_repo.Obstacles.End;
import p4_group_8_repo.Obstacles.Log;
import p4_group_8_repo.Obstacles.Turtle;
import p4_group_8_repo.Obstacles.Vehicle;
import p4_group_8_repo.Obstacles.WetTurtle;

/**
 * Animal class to instantiate the frog in all its states and handle movement 
 */

public class Animal extends Actor {
	
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	int imgSize = 40;
	Movement move = new Movement(13.3333333*2, 10.666666*2, 800, false, false);
	Score score = new Score(0, new ArrayList<Integer>(6), false);
	Death intersect = new Death(0, 0, false, false, false, new ArrayList<End>());

/**
 * 
 * @param imageLink: constructor to input the relevant picture of the frog 
 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+move.movement);
		
		imgW1 = new Image("file:src/misc/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/misc/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/misc/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/misc/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/misc/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/misc/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/misc/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/misc/froggerRightJump.png", imgSize, imgSize, true, true);
		
		/**
		 * handle movement using W,A,S,D
		 */
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (move.noMove) {
					
				}
				else {
				if (move.second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -move.movement);
		                score.changeScore = false;
		                setImage(imgW1);
		                move.second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-move.movementX, 0);
		            	 setImage(imgA1);
		            	 move.second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, move.movement);
		            	 setImage(imgS1);
		            	 move.second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(move.movementX, 0);
		            	 setImage(imgD1);
		            	 move.second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -move.movement);
	                setImage(imgW2);
	                move.second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-move.movementX, 0);
	            	 setImage(imgA2);
	            	 move.second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, move.movement);
	            	 setImage(imgS2);
	            	 move.second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(move.movementX, 0);
	            	 setImage(imgD2);
	            	 move.second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (move.noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < move.w) {
						score.changeScore = true;
						move.w = getY();
						score.points+=10;
					}
	                move(0, -move.movement);
	                setImage(imgW1);
	                move.second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-move.movementX, 0);
	            	 setImage(imgA1);
	            	 move.second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, move.movement);
	            	 setImage(imgS1);
	            	 move.second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(move.movementX, 0);
	            	 setImage(imgD1);
	            	 move.second = false;
	            }
	        }
			}
			
		});
	}
	
	/**
	 * handle the death of the frog on intersection with car or water or activated end slot
	 */
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+move.movement);
		}
		if (getX()<0) {
			move(move.movement*2, 0);
		}
		if (intersect.carDeath) {
			move.noMove = true;
			if ((now)% 11 ==0) {
				intersect.carD++;
			}
			if (intersect.carD==1) {
				setImage(new Image("file:src/misc/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (intersect.carD==2) {
				setImage(new Image("file:src/misc/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (intersect.carD==3) {
				setImage(new Image("file:src/misc/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (intersect.carD == 4) {
				setX(300);
				setY(679.8+move.movement);
				intersect.carDeath = false;
				intersect.carD = 0;
				setImage(new Image("file:src/misc/froggerUp.png", imgSize, imgSize, true, true));
				move.noMove = false;
				if (score.points>50) {
					score.points-=50;
					score.changeScore = true;
				}
			}
			
		}
		if (intersect.waterDeath) {
			move.noMove = true;
			if ((now)% 11 ==0) {
				intersect.carD++;
			}
			if (intersect.carD==1) {
				setImage(new Image("file:src/misc/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (intersect.carD==2) {
				setImage(new Image("file:src/misc/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (intersect.carD==3) {
				setImage(new Image("file:src/misc/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (intersect.carD == 4) {
				setImage(new Image("file:src/misc/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (intersect.carD == 5) {
				setX(300);
				setY(679.8+move.movement);
				intersect.waterDeath = false;
				intersect.carD = 0;
				setImage(new Image("file:src/misc/froggerUp.png", imgSize, imgSize, true, true));
				move.noMove = false;
				if (score.points>50) {
					score.points-=50;
					score.changeScore = true;
				}
			}
			
		}
		
		if (getX()>600) {
			move(-move.movement*2, 0);
		}
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			intersect.carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			intersect.stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !move.noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !move.noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				intersect.waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		/**
		 *  implemented the ability for the frog to respawn after going into a box with a frog already there and a round end score system that displays the scores of each round (the method roundEnd is implemented in the Score class)
		 */
		else if (getIntersectingObjects(End.class).size() >= 1) {
			intersect.inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				//intersect.end--; //when intersecting with a box that already has a frog in it, show alert and dont decrement intersect since game can only end if 5 boxes are full
				score.points-=60;
			}
			else{ //added else statement to fix the score system so that points are only incremented when intersecting with empty box and game only ends when all 5 boxes are full (happens in Main)
				intersect.end++; //used in the getStop method if intersect is 5 to end
				score.points+=50;
				score.changeScore = true;
				getIntersectingObjects(End.class).get(0).setEnd();
				score.roundEnd();
			}
			score.points = this.score.getPoints();
			System.out.println(intersect.end);
			move.w=800;
			setX(300);
			setY(679.8+move.movement);
			
		}
		else if (getY()<413){
			intersect.waterDeath = true;

		}
	}
	public boolean getStop() { //referenced in Main, if intersect == 5 then returns true and game stops
		return intersect.end==5;
	}
	
	
}
