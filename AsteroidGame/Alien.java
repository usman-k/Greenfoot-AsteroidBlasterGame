import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class Alien extends Mover
{
    //Global variables
    Space currentWorld;
    
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space)getWorld();
        
        //Move by speed for every tick of the program
        move ( (int) Math.random()*3 + 1); //Randomizes speed of aliens);
        turnTowards(Rocket.X, Rocket.Y);
        //Wraps mover around the screen
        if(getX() > 850) {           
                setLocation(-50, getY()); 
            }
        else if(getY() > 650) {
                setLocation(getX(), -50);  
            }
        else if(getX() < -50) {
                setLocation(850, getY()); 
            }
        else if(getY() < -50) {
                setLocation(getX(), 650); 
                }
        
        Actor bullet;
        bullet = getOneIntersectingObject(Bullet.class);
        
        if (bullet != null) {   //Detects if bullet touches alien and removes both from the world
            currentWorld.removeObject(bullet);
            currentWorld.removeObject(this);
        }
        
    }    
}
