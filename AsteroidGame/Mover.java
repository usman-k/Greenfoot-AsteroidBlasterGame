import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class Mover extends Actor
{
    //Global variables
    double speed = 1.0;
    double maxSpeed = 5;
    
    public Mover() {
        
    }
    
    public Mover(int direction) {
        turn(direction);  //Turns by the direction input
        
        speed = Math.random()*10;  //Randomizes speed
    }
    
    public Mover(double speedIn) {
        speed = speedIn;
        
        turn( Greenfoot.getRandomNumber(360) ); //Randomizes turn radius
    }
    
    public Mover(int direction, double speedIn) {
        turn(direction);
        speed = speedIn;
    }
    
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveSteadily();   //Calls moveSteadily method
        
    }
    
    /**
     * moveSteadily - Moves the Mover across the screen and wraps the movement 
     * across the edge of the screen
     */
    public void moveSteadily() {
        
        //Move by speed for every tick of the program
        move ( (int)speed );
       
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
    }
    /**
     * moveSteadily - Moves the Mover across the screen and wraps the movement 
     * across the edge of the screen
     */
    public void moveSteadily(int speedIn) {
        speed = speedIn;
        moveSteadily();
    }
}
