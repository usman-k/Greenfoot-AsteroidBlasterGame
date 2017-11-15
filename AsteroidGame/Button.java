import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class Button extends Actor
{
    boolean buttonState = false;
    String buttonText = "Hello Player!";
        
    public Button() {
       buttonOff();    
    }
    
    public Button(boolean stateIn, String textIn) {
        buttonText = textIn;
        if (stateIn) buttonOn();
        else buttonOff();
    }
    
    public void act() 
    {
        //Add your action code here
    }
    
    public void buttonOff() { //Displays default text
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 40, Color.MAGENTA, new Color(0,0,0,0));
        buttonImage.scale(120, 50);
        setImage(buttonImage);
        buttonState = false;
    }
    
    public void buttonOn() { 
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 20, Color.CYAN, Color.BLACK);
        setImage(buttonImage); //Displays the image
        buttonState = true;
    }
    
    public void buttonToggle() {
        if (buttonState) {
            buttonOff();
        }
        else {
            buttonOn();
        }
    }
}
