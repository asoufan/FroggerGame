package p4_group_8_repo.Movement;

import java.util.ArrayList;

import p4_group_8_repo.Obstacles.End;
/**
 * 
 * Death class that contains all the relevant properties for the death of the frog, initially found in the Animal class but split up for organization purposes
 *
 */
public class Death {
	public int end;
	public int carD;
	public boolean carDeath;
	public boolean waterDeath;
	public boolean stop;
	public ArrayList<End> inter;

	public Death(int end, int carD, boolean carDeath, boolean waterDeath, boolean stop, ArrayList<End> inter) {
		this.end = end;
		this.carD = carD;
		this.carDeath = carDeath;
		this.waterDeath = waterDeath;
		this.stop = stop;
		this.inter = inter;
		
		
	}
	
}