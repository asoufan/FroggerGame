package p4_group_8_repo.Obstacles;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/misc/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/misc/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
