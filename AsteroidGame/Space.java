import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Space
 * 
 * @author (Usman Khan) 
 * @version (March 3, 2017)
 */
public class Space extends World
{
    //Global Variables
    private int gameTime = 0;
    private double survivalTimer = 0;
    private int asteroidSpawnCounter = 0;
    private int asteroidCounter = 0;
    int highScore = 0;
    static int gameState;
    GreenfootSound bgm = new GreenfootSound("bgm.wav");
    int powerupChooser;
    static int counter = 0;
    static int counter2 = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
    }
    
    public void act() {
        
        switch (gameState) {
            case 0:                                              //Start Screen initialization
                    // if (bgm.isPlaying()) {  
                        // bgm.stop();
                    // }
                    addObject(new Button(false, "Start Game"), 400, 200);
                    addObject(new Button(false, "INSTRUCTIONS"), 400, 300);
                    addObject(new Button(true, "1. Use WASD keys to move"), 400, 340);
                    addObject(new Button(true, "2. Press Space to shoot"), 400, 380);
                    addObject(new Button(true, "3. Hold 'p' to pause"), 400, 420);
                    addObject(new Button(true, "4. Press 'b' to end game"), 400, 460);
                    addObject(new Button(true, "5. Press 't' to go back to start"), 400, 500);
                    addObject(new Button(true, "6. Touch colored circles for powerups"), 400, 540);
                    addObject(new LongerBullets(), 50, 100);
                    addObject(new Button(true, "= Longer Lasting Bullets"), 160, 100);
                    addObject(new ExtraLife(), 50, 150);
                    addObject(new Button(true, "= Extra Life"), 110, 150);
                    addObject(new LargerBullets(), 50, 200);
                    addObject(new Button(true, "= Larger Bullers"), 130, 200);
                    
                    gameState = 1;  //Changes game state
                    
            case 1:                                              //Start Screen Loop
                    //Detects if mouse clicks on button and moves onto next game state
                    MouseInfo mouse = Greenfoot.getMouseInfo();
                    if (mouse != null) {
                        Actor currentActor = mouse.getActor();
                        if (currentActor != null) {
                            if (currentActor.getClass() == Button.class) {
                                Button currentButton = (Button)currentActor;
                                int mouseButtonPressed = mouse.getButton();
                                int mouseClickCount = mouse.getClickCount();
                                System.out.println(mouseButtonPressed + " " + mouseClickCount);
                                if (mouseClickCount == 1) {
                                    gameState = 2;
                                    List allObjects = getObjects(null);
                                    removeObjects(allObjects);
                                }
                            }
                        }
                    }
                    break;
            case 2:                                               //Game initialization
                    addObject( new Rocket(), 100, 150);    //Spawns rocket at given coordinates
                    //Resetting all variables
                    Rocket.playerLives = 3; 
                    gameTime = 0;
                    survivalTimer = 0;
                    gameState = 3;   //Changes game state to the next one
            
            case 3:                                               //Start Gameplay
                    // bgm.playLoop();   //Starts playing background music loop--Puts pressure on the program so I turned this off for now
                    gameTime += 1;   //Increments gameTime by 1 each frame
                    survivalTimer += 0.01666666666;    //Increases timer by 1 sec per frame
                    String timer = Integer.toString((int) survivalTimer);
                    addObject(new Button(true, "Time Survived: " + timer + " s"), 700, 20);  //Displays survival timer
                    addObject(new Button(true, "LIVES LEFT: " + Integer.toString(Rocket.playerLives)), 80, 20);  //Displays player lives
                    
                    //Spawns asteroids after certain time intervals
                    if ((gameTime % 250) == 0) {
                        addObject( new Asteroid(), (int) (Math.random()*800), (int) (Math.random()*600));
                    }
                    
                    //Spawns aliens after certain time intervals
                    if (gameTime >= 1000) {
                        if ((gameTime % 400) == 0) {
                            addObject( new Alien(), (int) (Math.random()*800), (int) (Math.random()*600));
                        }
                    }
                    
                    //Spawns powerups after certain time intervals
                    if ((gameTime % 800) == 0) {
                        powerupChooser = (int) (Math.random()*3) + 1;
                        System.out.println(powerupChooser);
                    }
                    //First powerup code
                    if(powerupChooser == 1) {    //If the number 1 is chosen, the longer lasting bullets powerup is spawned
                        addObject( new LongerBullets(), ((int) (Math.random()*750) + 50), ((int) (Math.random()*550) + 50));
                        powerupChooser = 0;
                    }
                    if (LongerBullets.setCounter == true) {     //Starts counter for the powerup life
                        counter += 1;
                        // System.out.println(counter);
                    }
                    if (counter >= 500) {   
                        LongerBullets.setCounter = false;
                        counter = 0;
                        Bullet.bulletLife = 60;
                    }
                    //Second powerup code
                    if(powerupChooser == 2) {   //If the number 2 is chosen, the extra life powerup is spawned
                        addObject( new ExtraLife(), ((int) (Math.random()*750) + 50), ((int) (Math.random()*550) + 50));
                        powerupChooser = 0;
                    }
                    //Third powerup code
                    if(powerupChooser == 3) {    //If the number 3 is chosen, the larger bullets powerup is spawned
                        addObject( new LargerBullets(), ((int) (Math.random()*750) + 50), ((int) (Math.random()*550) + 50));
                        powerupChooser = 0;
                    }
                    if (LargerBullets.setCounter3 == true) {  //Starts counter for the powerup life
                        counter2 += 1;
                        // System.out.println(counter);
                    }
                    if (counter2 >= 500) {        //Gets rid of powerup after certain amount of time
                        LargerBullets.setCounter3 = false;
                        counter2 = 0;
                        Rocket.bulletSize = 40;
                    }
                    
                    //Restarts game from start screen if 't' is pressed
                    if (Greenfoot.isKeyDown("t")) {    
                        List allObjects = getObjects(null);
                        removeObjects(allObjects);
                        gameState = 0;
                    }
                    
                    //Ends game
                    if (Greenfoot.isKeyDown("b")) {
                        gameState = 4;
                    }
                    
                    //Pauses game
                    while (Greenfoot.isKeyDown("p")) {
                        bgm.pause();
                        Greenfoot.delay(1);
                    }
                    
                    //End game if player loses all lives
                    if (Rocket.playerLives == -1) {
                        Greenfoot.playSound("livesLost.wav");
                        gameState = 4;
                    }

                    break;
            case 4:                                                //End Game Screen
                    if (bgm.isPlaying()) {    //Stops playing background music
                        bgm.stop();
                    }
                    List allObjects = getObjects(null);
                    removeObjects(allObjects);      //Removes all objects in the world
                    
                    if(highScore <= survivalTimer) {        //Sets new highscore if it's better than old time
                        highScore = (int) survivalTimer;
                    }
                    
                    addObject(new Button(false, "GAME OVER"), 400, 150);
                    addObject(new Button(true, "Play Again"), 400, 315);
                    addObject(new Button(false, "Best Score: " + Integer.toString(highScore)), 400, 200);
                    addObject(new Button(true, "Press 'r' to play again!"), 400, 340);
                    addObject(new Button(true, "Press 'ESC' to quit"), 400, 380);
                    
                    
                    if (Greenfoot.isKeyDown("r")) {        //Restarts game if user presses r
                        List allObjects1 = getObjects(null);
                        removeObjects(allObjects1);
                        gameState = 0;
                    }
                    
                    if (Greenfoot.isKeyDown("escape")) {        //Ends program if user presses escape
                        List allObjects2 = getObjects(null);
                        removeObjects(allObjects2);
                        gameState = 0;
                        Greenfoot.stop();
                    }
                    
                    break;
                    
            default: gameState = 0;
        }
        
        
    }
    
    public void playLoop() {      //Looping a track I made
        Greenfoot.playSound("bgm.wav");
    }
    
    public static int getState() {  //Returns gamestate
        return gameState;
    }
    
    public int getTime() {    //Returns gametime
        return gameTime;
    }
}
