// import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// /**
 // * Code for airplane movement
 // * 
 // * @author (Usman Khan) 
 // * @version (March 3, 2017)
 // */
// public class Airplane extends Mover
// {
    // double speed = 1.0;
    // double maxSpeed = 10;
    // Barrel currentBarrel;
    // Space currentWorld;
    

    // public Airplane() {
        // GreenfootImage image = getImage();
        // image.scale(image.getWidth() - 40, image.getHeight() - 40);
        // setImage(image);
    // }
    
    // public void act() 
    // {
       // currentWorld = (Space) getWorld();
        // //Move the airplane forward
        // // move ( (int)speed );
        // if (Greenfoot.isKeyDown("i")) {
           // if (speed < maxSpeed) {    //Increases speed until it reaches maxSpeed
           // speed = speed + speed*0.25;
          // }
         // }
         // //Turn speed back to 1 if player stops pressing 'i' key
        // else {
            // speed = 1;
        // }
         // //Turn the airplane left
        // if (Greenfoot.isKeyDown("j")) {
            // turn( (int) -speed);   //Setting turn radius to speed allows airplane to turn faster as it moves faster
         // }
        
         // //Turn the airplane right
        // if (Greenfoot.isKeyDown("l")) {
            // turn( (int) speed);
         // }
        
         // //Stop the airplane when key is pressed
        // if (Greenfoot.isKeyDown("k")) {
            // speed = speed - speed*0.25; //Slows airplane down to a stop if 'i' key is being pressed; almost instant stop if 'i' isn't being pressed
         // }
        
         // if (Greenfoot.isKeyDown("p")) {
            // if ( currentWorld.getObjects(Barrel.class).isEmpty() )  {
                // currentWorld.addObject( new Barrel( getRotation()), getX(), getY());
            // }
         // } 
        
         // // getEdge(); 
         // moveSteadily((int)speed);
        
    // }    

    
    // // public void getEdge()  {
            // // System.out.println("Edge");   //Detects if airplane is over a certain value (that is past the edge),
            // // if(getX() > 875) {            //and then moves it to the other side of the world to create a world wrapping effect.
                // // setLocation(-75, getY()); 
            // // }
            // // if(getY() > 675) { 
                // // setLocation(getX(), -75);  //I chose to spawn the airplane behind the start of the world so it looks like it's coming out of the edge.
            // // }
            // // if(getX() < -75) {
                // // setLocation(getWorld().getWidth()+75, getY()); 
            // // }
            // // if(getY() < -75) {
                // // setLocation(getX(), getWorld().getHeight()+75); 
                // // }
    // // }
// }
