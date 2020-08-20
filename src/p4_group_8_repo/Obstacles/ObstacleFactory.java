package p4_group_8_repo.Obstacles;

/**
 * obstacle factory used to instantiate different obstacles such as Log, Turtle, Vehicle, Log
 *
 */
public class ObstacleFactory {
/**
 * 
 * @param obstacleType, for the type of the obstacle to be returned by the factory
 * @param imageLink, link to the image of the obstacle
 * @param size, size of the obstacle
 * @param xpos, x position
 * @param ypos. y position
 * @param s, speed (int)
 * @param w, width
 * @param h, height
 * @param s1, speed (double)
 * @return, returns the relevant obstacle
 */
	public Obstacle getObstacle(String obstacleType, String imageLink, int size, int xpos, int ypos, int s, int w, int h, double s1) {
		
		if (obstacleType == null) {
		return null;
	}
		if (obstacleType.equalsIgnoreCase("VEHICLE")) {
			return new Vehicle(imageLink, xpos, ypos, s , w , h);
		}
	
		if (obstacleType.equalsIgnoreCase("LOG")) {
			return new Log(imageLink, size, xpos, ypos, s1);
		}
		if (obstacleType.equalsIgnoreCase("TURTLE")) {
			return new Turtle(xpos, ypos, s, w, h);
		}
		if (obstacleType.equalsIgnoreCase("WETTURTLE")) {
			return new WetTurtle(xpos, ypos, s, w, h);
		}
		
		return null;
		
	}
}
