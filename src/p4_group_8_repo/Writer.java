package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * the Writer class contains methods to read and write from the score.txt file to implement a leaderboard for high scores
 *
 */
public class Writer {
	
	File fileName = new File("src/misc/score.txt");
	int highscore;
	ArrayList<Integer> numb;

	/**
	 * constructor to instantiate an arraylist of size 11
	 */
	public Writer(){
		 numb = new ArrayList<Integer>(11);
	}
	/**
	 * method that writes to the ArrayList by reading the existing elements first, then adding to the list, sorting it, and writing it back to the file
	 */
	public void writeToArrayList() {
		
		readFromFile();
		numb.add(highscore);
		Collections.sort(numb, Collections.reverseOrder());
		numb.remove(numb.size()-1); //used to make sure that only top 10 scores will be displayed
		writeToFile();
	}
	
	/**
	 * method that writes to the file by iteration
	 */
	public void writeToFile() {
		
		try {
			FileWriter fw = new FileWriter(fileName, false);
			BufferedWriter bw = new BufferedWriter(fw);
			String list = "";
			
			for (int counter : numb) {
			//System.out.println(counter);
			list = list + "\n" + counter;
			}
			list = list.trim();
			bw.write(list);
			//fw.flush();
			bw.close();
			fw.close();
			System.out.println(list);
			
		} catch (IOException e) {
			 System.out.println("exception occoured" + e);
		}
		
		
	}
	/**
	 * method that reads from the file by going through each line with built in error handling for missing files
	 */
	public void readFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       numb.add(Integer.parseInt(line));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


