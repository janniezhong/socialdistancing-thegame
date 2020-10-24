# FinalProjectShelby2017
README
5/4/17

Creators: Helen Wang, Arleen Liu, Jannie Zhong
Java, Period 2

Introduction:
This program is a accuracy game, with both a singleplayer and multiplayer function. In the single player option, the player attempts to launch a projectile onto a target, with a timer deciding the numbers of points they get. In multiplayer option, two people compete to see who can launch a projectile onto a target in a lesser amount of time than the other. There will be different levels of difficulty the players can select to play in, and the program will match people to others who would like to play the same level. If one player hits the target and the other does not, the former automatically wins. If both players fail to hit the target, they must repeat the same level.

In each level, there will be obstacles preventing the players from shooting the projectile directly on the target. However, there will be items available to build a support structure system to help the projectile maneuver around the obstacles to successfully make it to the target. Players are only allowed to modify their custom courses before they launch the projectile. The timer takes into account both the time it takes to build the course, along with the time it takes to hit the target.

Instructions: Select the mode, character, and difficulty level you would like to play in. During the game, click on a piece to pick it up, and click on a separate location to set it down. Set a course using the available pieces to launch your projectile past the obstacles and onto the target. Launch your projectile by clicking and dragging your character back your desired angle and distance, and release to launch.

Game Mechanics:

Title screen:
Click MULTIPLAYER to play in multiplayer.
Click SINGLE PLAYER to play in singleplayer.
Click HOW TO PLAY to see controls and instructions on how to play.
Click SETTINGS to select your scenery or adjust your SFX and BGM settings.

Single player screen:
Click CHOOSE DIFFICULTY to decide which level you would like to play on.
Click CHOOSE CHARACTER to select your projectile.
Click START to begin the game.
Click BACK to return to the title screen.

Multiplayer screen: 
Click CHOOSE DIFFICULTY to decide which level you would like to play on.
Click CHOOSE CHARACTER to select your projectile.
Click START to select the difficulty level and begin the game.
Click BACK to return to the title screen.

Difficulty screen (singleplayer version):
Click on any difficulty level to progress to the game.
Click BACK to return to the single player screen.

Difficulty screen (multiplayer version):
Click on any difficulty level to progress to the FIND PLAYERS screen.
Click BACK to return to the multiplayer screen.


Game screen:
Click START BUILDING to begin building your support system.
Click on any items in the side menu or already in the window. Click on another location to move them to that location
Click READY to continue to the launching stage.
Click and hold onto the projectile and drag it backwards to generate energy and an angle for the launch.
Release the projectile to make it fly. 
Click the pause button to pause the game.

Pause screen:
Click the retry button to start that level over.
Click the go button to continue the level.
Click QUIT to go back to the title screen.


Results screen (single player ver.):
Click RETURN TO MAIN to go back to the title screen.
Click RETRY if you fail a launch or would like to play a level over again.
Click GO to progress to the next level after a successful launch.

Results screen (multiplayer ver.):
Click QUIT to go back to the title screen.
Click RETURN TO MAIN to go back to the title screen.
Click PLAY AGAIN to find a new partner (same level).
Click DIFFERENT LEVEL to choose a new level and a new partner.

Quit screen:
Click YES to return to main menu.
Click NO to stay on current page.




Class List: 
(nameOfGame): JFrame, main method
ControlPanel - game elements in screen (i.e. knows what to do by which button activates
Screen (will have Graphics) - represents/animates type of screen user is currently on
TitleScreen
DifficultyScreen
GameScreen
PauseScreen
ResultsScreen (w/ boolean is multi or single)
Character Screen
ObjectMenu - screen for holding objects (could extend Screen)
Character - image, properties of the character (like path motion)
Obstacles - preset obstacle blocks
HelperObjects - blocks user can move around
Button - holds Pause, Retry, Settings, Quit
Target
TimeTracker
ScoreTracker

Extensions from JButton
Pause button
Retry button
Settings button
Return to main screen

Target
Timer
Score
