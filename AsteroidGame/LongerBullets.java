import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan 
 */
public class LongerBullets extends Actor
{
    Space currentWorld;
    static boolean setCounter = false;
    int timer = 0;
    
    public LongerBullets() { //Changing powerup image size
        GreenfootImage image = getImage(); 
        image.scale(image.getWidth() - 20, image.getHeight() - 20);
        setImage(image);
    }

    
    /**
     * Act - do whatever the LongerBullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        timer += 1;  //Increments timer which starts once powerup spawns
        
        Actor rocket;
        rocket = getOneIntersectingObject(Rocket.class);
        
        if (rocket != null) {    //Detects if rocket is touching powerup
            Bullet.bulletLife = 120;  //Increases bullet life to 120
            setCounter = true;    //Boolean to check if powerup is activated
            currentWorld.removeObject(this);  //Removes powerup circle from screen
        }
        
        if ((rocket == null) && (timer ==500)) {    //Removes powerup after certain time period if it hasn't been collected
            currentWorld.removeObject(this);
        }
        // if (setCounter == true) {
            // counter += 1;
            // System.out.println(counter);
        // }
        
    }    
}
