package p4_group_8_repo.Movement;
/**
 * 
 *  Movement class that contains all the relevant properties for the movement of the frog, initially found in the Animal class but split up for organization purposes
 *
 */
public class Movement {
	public double movement;
	public double movementX;
	public double w;
	public boolean second;
	public boolean noMove;

	public Movement(double movement, double movementX, double w, boolean second, boolean noMove) {
		this.movement = movement;
		this.movementX = movementX;
		this.w = w;
		this.second = second;
		this.noMove = noMove;
	}
}