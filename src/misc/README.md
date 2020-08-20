Note: genrating javadocs created a large number of files that cannot be deleted otherwise the javadocs will not work properly, and so to run the game please look into the src folder

Tested on: Lab Machine
Build script: None


The following changes have been made to make the Frogger game more maintainable and extendable:


1. The Main class has been split up and reduced to maintain single-responsibility:

Initializing the background, stage, end elements, and timer has been put into a setup method setup(), grouping related pieces of code into methods to avoid repetitive code
The background image has been fixed to use the proper image provided and resized to fit the window
Adding obstacles (log, vehicles,…) and animals (turtle, wet turtle) was split into two methods instantiateObstacles() and instantiateAnimals()
The methods were then moved into the created interface Level that is implemented through the LevelFactory factory that creates levels from classes Level1, Level2, and Level3 that contain the different implementations for the abstract methods 
This provides more organized code as levels are now set up using their own system without any dependencies, and this also provides the ability to extend to future levels easily without changing existing code
	


2. The Writer class is used to write the highscore achieved at the end of the game to a score.txt file:

It contains methods that read the scores already on the text file, write the highscore to the ArrayList created, and then to the text file
This was used to implement the leaderboard system which is called in the Main class at the end of the game and saves the score to the leaderboard which can be viewed on opening the game through the Controller


	
3. The Controller class is used to link the FXML files to the code for the start screen, leaderboard screen, and information page:
 
It contains methods that are referenced in SceneBuilder for each button to implement on click
This class also contains the implementation for the different levels since the level factory is instantiated and all the obstacles and animals are set up through the setLevel() method depending on which level button is clicked



4. An obstacle factory ObstacleFactory() was also implemented to provide a more organized method of instantiating obstacles(log, vehicles) and animals(turtle, wet turtle):

This also provides room for extension by allowing the ability to integrate new obstacles that can be easily added to the factory by implementing the Obstacle class to later be created by the factory
This is used in the level classes (Level1, Level2, Level3) where the obstacle factory is created and used to add the obstacles and animals to the background




5. The Animal class:

Was split into Score, Death, and Movement classes that each take care of the properties of handling score, frog movement/game ending, and frog movement respectively
This was done to maintain single-class responsibility of Animal class and provide clearer, more readable code that can be extended later on while improving internal structure
The roundEnd() method is implemented in score and uses an alert system to show to rank the players scores at the end of each round



6. Minor additions:

MyStage was made into a singleton because only one instance is required, provided through encapsulation
The classes were organized into different packages depending on what “system” they implement (obstacle creation system, level system, movement system, and general packages), making the overall code more readable
References to images were updated in the code and the images were placed in a separate package “misc” alongside other media
The game now accounts for frogs that enter already filled end “boxes” by deducting points and resetting the frog

