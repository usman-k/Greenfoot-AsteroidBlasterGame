import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */

public class Text extends Actor
{
        
    public Text() {
       textOff();    
    }
    
    public void act() 
    {
        //Add your action code here
    }
    
    public void textOff() { //Displays default text
        GreenfootImage textImage = new GreenfootImage("LIVE LOST", 40, Color.YELLOW, new Color(0, 0, 0, 0));
        textImage.scale(150, 80);
        setImage(textImage);
    }

}
