import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Usman Khan
 */
public class Asteroid extends Mover
{
    //Size of the asteroid in %
    int currentSize = 100;
    int smallestSize = 0;
    int removeSize = 20;
    Space currentWorld;
    double storeSpeed;
    boolean isSpacePressed = false;
    
    public Asteroid() {
        this(100);
    }
    
    public Asteroid (int sizeIn) {
        speed = (Math.random()*4) + 1; //Plus 1 so that there aren't any stationary asteroids
        turn((int)(Math.random()*360));
        currentSize = sizeIn;
        sizeImage();
    }
    
    public void sizeImage() {   //Scales image to currentSize 
        if(currentSize <= removeSize) {
            currentWorld.removeObject(this);
        }
        GreenfootImage image = getImage();
        image.scale(currentSize, currentSize);
        setImage(image);
    }
    
    public void scaleSize (double scaleFactor) {  //Sets currentSize according to scaleFactor
        currentSize = Math.round ( (int) (currentSize*scaleFactor));
    }
    
    public void act() 
    {
        currentWorld = (Space)getWorld();
        moveSteadily();
        
        //Detects if bullet hits asteroid and breaks asteroid into pieces
        Actor bullet;
        bullet = getOneIntersectingObject(Bullet.class);
        
        double currentSize2 = currentSize*0.5;
        
        if (bullet != null) {
             if (currentSize >= 50) {
                currentWorld.addObject( new Asteroid((int) currentSize2), getX(), getY());
             }
            scaleSize(0.5);
            sizeImage();
            currentWorld.removeObject(bullet);
        }
        
        
        //EXTRA CODE THAT ISN'T NEEDED ANYMORE BUT I KEEP JUST IN CASE
        // storeSpeed = speed;
        
        // if (Greenfoot.isKeyDown("p") && isSpacePressed == false) {
            // speed = 0;
            // isSpacePressed = true;
        // }
        
        // if (Greenfoot.isKeyDown("p") && isSpacePressed == true) {
            // speed = storeSpeed;
            // isSpacePressed = false;
        // }
        
        // Actor barrel;
        // barrel = getOneIntersectingObject(Barrel.class);
        
        // if (barrel != null) {
        // //    System.out.println("HIT!" + currentWorld.getTime() + " " + barrel);
            // scaleSize(0.5);
            // sizeImage();
            // currentWorld.removeObject(barrel);
        // }
    }    
}
