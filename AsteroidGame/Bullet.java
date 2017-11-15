import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class Bullet extends Mover
{
    //Global variables
    Space currentWorld;
    static int bulletLife = 60;
    int creationTime = -1;
    int currentSize = 100;
    
    public Bullet(int direction, int sizeIn) {  //Calls Bullet class with direction and size input
        turn(direction);
        speed = maxSpeed;
        currentSize = sizeIn;
        sizeImage();
    }
    
    public void sizeImage() {
        GreenfootImage image = getImage();
        image.scale(currentSize, currentSize);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        // Add your action code here.
        moveSteadily();  //Calls moveSteadily() method from Mover class
        
        if(creationTime == -1) {
            creationTime = currentWorld.getTime();
        }
        
        if (currentWorld.getTime() > (creationTime + bulletLife)) {
            //Destroy this object
            currentWorld.removeObject(this);
        }
    }    
}
