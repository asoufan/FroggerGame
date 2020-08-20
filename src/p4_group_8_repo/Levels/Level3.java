package p4_group_8_repo.Levels;

import p4_group_8_repo.Actor;
import p4_group_8_repo.MyStage;
import p4_group_8_repo.Obstacles.ObstacleFactory;

public class Level3 implements Level {
	
	MyStage background = MyStage.getInstance();
	ObstacleFactory factory = new ObstacleFactory();

	@Override
	public void instantiateObstacles() {
		
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png", 150, 0, 166, 0, 0, 0, 2)); 
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 220, 166, 0, 0, 0, 2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 440, 166, 0, 0, 0, 2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/logs.png",300, 0, 276, 0, 0, 0, 2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 50, 329, 0, 0, 0, 2));
		background.add((Actor) factory.getObstacle("LOG","file:src/misc/log3.png",150, 270, 329, 0, 0, 0, 2));
		
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck1"+"Right.png",0, 0, 649, 5, 120, 120, 0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck1"+"Right.png",0,300, 649, 5, 120, 120,0));

		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/truck2Right.png",0, 0, 540, 8, 200, 200,0));
		background.add((Actor) factory.getObstacle("VEHICLE","file:src/misc/car1Left.png",0, 500, 490, -5, 50, 50,0));
		
	}

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
