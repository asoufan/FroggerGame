package p4_group_8_repo.Levels;

import p4_group_8_repo.Actor;
import p4_group_8_repo.MyStage;
import p4_group_8_repo.Obstacles.ObstacleFactory;
/**
 * 
 * class for Level1 that contains the implementation for instantiating the different obstacles/turtles using the Obstaclefactory and adding them to the background
 *
 */
public class Level1 implements Level {

	MyStage background = MyStage.getInstance();
	ObstacleFactory factory = new ObstacleFactory();

	/**
	 * method to instantiate the obstacles using obstacle factory
	 */
	@Override
	public void instantiateObstacles() {
		
		
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png", 150, 0, 166, 0, 0, 0, 0.75)); 
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 220, 166, 0, 0, 0, 0.75));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 440, 166, 0, 0, 0, 0.75));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/logs.png",300, 0, 276, 0, 0, 0, -2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/logs.png",300, 400, 276, 0, 0, 0, -2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 50, 329, 0, 0, 0, 0.75));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 270, 329, 0, 0, 0, 0.75));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 490, 329, 0, 0, 0, 0.75));
		
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck1"+"Right.png",0, 0, 649, 1, 120, 120, 0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck1"+"Right.png",0,300, 649, 1, 120, 120,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck1"+"Right.png",0, 600, 649, 1, 120, 120,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 100, 597, -1, 50, 50,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 250, 597, -1, 50, 50,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 400, 597, -1, 50, 50,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 550, 597, -1, 50, 50,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck2Right.png",0, 0, 540, 1, 200, 200,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck2Right.png",0, 500, 540, 1, 200, 200,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 500, 490, -5, 50, 50,0));
		
	}
/**
 * method to instantiate the turtles using obstacle factory
 */
	@Override
	public void instantiateAnimals() {
		
		background.add((Actor) factory.getObstacle("TURTLE",null, 0, 500, 376, -1, 130, 130, 0));
		background.add((Actor) factory.getObstacle("TURTLE",null, 0, 300, 376, -1, 130, 130, 0));
		background.add((Actor) factory.getObstacle("WETTURTLE",null, 0, 700, 376, -1, 130, 130, 0));
		background.add((Actor) factory.getObstacle("WETTURTLE",null, 0, 600, 217, -1, 130, 130, 0));
		background.add((Actor) factory.getObstacle("WETTURTLE",null, 0, 400, 217, -1, 130, 130, 0));
		background.add((Actor) factory.getObstacle("WETTURTLE",null, 0, 200, 217, -1, 130, 130, 0));
		
	}

}
