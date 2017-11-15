import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class ExtraLife extends Actor
{
    Space currentWorld;
    int timer = 0;
    
    public ExtraLife() {    //Changing powerup image size
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 20, image.getHeight() - 20);
        setImage(image);
    }

    
    /**
     * Act - do whatever the ExtraLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        timer += 1;    //Increments timer which starts once this powerup spawns
        
        Actor rocket;
        rocket = getOneIntersectingObject(Rocket.class);
        
        if (rocket != null) {   //Detects if rocket is touching powerup
            Rocket.playerLives = Rocket.playerLives + 1;   //Gives player an extra life
            currentWorld.removeObject(this);   //Removes powerup circle from screen
        }
        
        if ((rocket == null) && (timer ==500)) {    //removes powerup after certain time period if it hasn't been collected
            currentWorld.removeObject(this);
        }
        
    }    
}
