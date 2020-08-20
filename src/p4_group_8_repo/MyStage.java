package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
/**
 * 
 * singleton MyStage since only one instance of the stage is required
 *
 */
public class MyStage extends World{
	private static MyStage MyStage; //singleton pattern
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	private MyStage() {
	}
	/**
	 * 
	 * @return  MyStage which is the singleton instance of MyStage that can be accessed from any class (the same instance is accessed every time this method is called)
	 */
	public static MyStage getInstance() { //singleton pattern
		
		if (MyStage==null) 
            MyStage = new MyStage(); 
        return MyStage; 
	}
	
	public void playMusic() {
		String musicFile = "src/misc/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
