import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code for rocket movement
 * 
 * Usman Khan 
 * March 3, 2017
 */
public class Rocket extends Mover
{
    //Global Variables to Rocket Class
    double speed = 1.0;
    double maxSpeed = 7;
    Bullet currentBullet;
    Space currentWorld;
    int numberOfBullets = 3;
    int bulletDelay = 20;
    int bulletDelayTimer;
    public static int playerLives = 3;
    public static int X;
    public static int Y;
    static int bulletSize = 40;
    
    
    public Rocket() { //Making rocket smaller
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 30, image.getHeight() - 20);
        setImage(image);
    }
    
    public void bulletUpgrade() {
        numberOfBullets++;
    }
    
    public void act() 
    {
        currentWorld = (Space) getWorld();
        
        //Move the rocket forward
        if (Greenfoot.isKeyDown("w")) {
           if (speed < maxSpeed) {  //Increases rocket speed until max speed is reached
           speed = speed + speed*0.25;
          }
         }
        else {
            //Turns speed back to 1 if player stops pressing 'w' key
            speed = 1;
        }

         //Turn the rocket left
        if (Greenfoot.isKeyDown("a")) {
            turn( (int) -speed);   //Setting turn radius to speed allows rocket to turn faster as it moves faster
         }
        
         //Turn the rocket right
        if (Greenfoot.isKeyDown("d")) {
            turn( (int) speed);
         }
        
         //Stop the rocket when key is pressed
        if (Greenfoot.isKeyDown("s") && speed >= 0.1) {
            speed = speed - speed*0.25; //Slows rocket down to a stop if 'w' key is being pressed; almost instant stop if 'w' isn't being pressed
         }
        
        
         if (Greenfoot.isKeyDown("space")) {  //Creates and shoots bullet if spacebar is pressed
            if ( currentWorld.getObjects(Bullet.class).size() < numberOfBullets )  {
                if (bulletDelayTimer + bulletDelay < currentWorld.getTime() ) {
                 Greenfoot.playSound("pew.wav");
                 currentWorld.addObject( new Bullet( getRotation(), bulletSize), getX(), getY());
                 bulletDelayTimer = currentWorld.getTime();
                }
            }
         }
        
        //getEdge(); //Just made it seperate to keep it clean
        moveSteadily((int)speed);
        
        //Removes asteroid or alien if bullet hits them
        Actor asteroid;
        asteroid = getOneIntersectingObject(Asteroid.class);
        Actor alien;
        alien = getOneIntersectingObject(Alien.class);
        if ((asteroid != null) || (alien != null)) {
            playerLives = playerLives - 1;
            Greenfoot.playSound("nooo.wav");
            if (asteroid != null) {
                currentWorld.removeObject(asteroid);
            }
            if (alien != null) {
                currentWorld.removeObject(alien);
            }
            System.out.println(playerLives);
            Actor newText = new Text();
            currentWorld.addObject(newText, 400, 300);
            Greenfoot.delay(100);  //Stops (delays) program for 100 frames
            currentWorld.removeObject(newText);
        }
        
        //Storing rocket's x and y coordinates
        X = getX();  
        Y = getY();
        
    }    
    
        public static int getLives() {  //Returns playerLives
            return playerLives;
        }
        
        public static int storeX() {   //Returns x coordinate of rocket
            return X;
        }
        
        public static int storeY() {   //Returns y coordinate of rocket
            return Y;
        }

    
    // public void getEdge()  {   //Not needed anymore
            // System.out.println("Edge");  //Detects if rocket is a certain value (that is past the edge), 
            // if(getX() > 850) {           //and then moves it to the other side of the world to create a world wrapping effect
                // setLocation(-50, getY()); 
            // }
            // if(getY() > 650) {
                // setLocation(getX(), -50);  //Chose to spawn the rocket a bit before the world starts to it seems as if it's coming out of the edge.
            // }
            // if(getX() < -50) {
                // setLocation(850, getY()); 
            // }
            // if(getY() < -50) {
                // setLocation(getX(), 650); 
                // }
    // }
}