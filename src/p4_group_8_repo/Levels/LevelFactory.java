package p4_group_8_repo.Levels;
/**
 * 
 * LevelFactory that gets the relevant level and returns an instance of it
 *
 */
public class LevelFactory {
	/**
	 * 
	 * @param level, the number of the level to be returned
	 * @return, returns an instance of the relevant level
	 */
	public Level getLevel(int level) {
		
		if (level == 0) {
			return null;
		}
		
		if (level == 1) {
			return new Level1();
		}
		
		if (level == 2) {
			return new Level2();
		}
		
		if (level ==3) {
			return new Level3();
		}
		
		return null;
		
	}

}
