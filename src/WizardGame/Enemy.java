
// Class: Enemy

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Enemy extends GameObject {

    public static int ENEMY_WIDTH = 32;    
    public static int ENEMY_HEIGHT = 32;
    
    private Handler m_Handler;
    private Random m_Random = new Random();
    int m_iChoose = 0;
    int m_iHP = 100;
   
    private BufferedImage[] m_pEnemy;
    
    protected Animation m_Animation;
    
    
    public Enemy(int iX, int iY, ID id, Handler newHandler, 
                                                    SpriteSheet spriteSheet) {
        
        super(iX, iY, id, spriteSheet);
        
        int iCount;        
        
        this.m_Handler = newHandler;
        

        m_pEnemy = new BufferedImage[3];
        
        for (iCount = 0; iCount < 3; ++iCount) {
            
           m_pEnemy[iCount] = spriteSheet.grabImage(1, 4 + iCount, 
                                       Enemy.ENEMY_WIDTH, Enemy.ENEMY_HEIGHT);
           
        }
        
        m_Animation = new Animation(1, m_pEnemy, 3);
        
    }
    
    public void tick() {
        
       int iCount;       

       m_iX += m_fVelX;    
       m_iY += m_fVelY;
       
       m_iChoose = m_Random.nextInt(10);

       
       for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
       
          GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
          
          if (tempGameObject.getID() == ID.Block) {
             
             // Check if the enemy (with larger box around) and a block 
             // intersects. 
             if (getBoundsBig().intersects(tempGameObject.getBounds())) {
             
                m_iX += (m_fVelX * 2) * -1;
                m_iY += (m_fVelY * 2) * -1;
                
                m_fVelX *= -1;
                m_fVelY *= -1;
                 
             }
             
             // Otherwise choose a random direction.
             else if (m_iChoose == 0) {
           
                m_fVelX = (m_Random.nextInt(8) + (-4));
                m_fVelY = (m_Random.nextInt(8) + (-4));
          
             }             
          
          }
          
          if (tempGameObject.getID() == ID.Bullet) {
             
             // Remove Bullet and let the enemy take damage. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
                 
                m_iHP -= 50;
                m_Handler.removeGameObject(tempGameObject);
                
             }
              
          }
                     
       }
       
       m_Animation.runAnimation();
       
       // Remove enemy, if it is dead.
       if (m_iHP <= 0) {
           
          m_Handler.removeGameObject(this);
          
       }
              
    }

    public void render(Graphics g) {

       // g.setColor(Color.yellow);
       // g.fillRect(m_iX, m_iY, Enemy.ENEMY_WIDTH, Enemy.ENEMY_HEIGHT);
       
       // Graphics2D g2d = (Graphics2D) g;
       
       // g.setColor(Color.green);
       // g2d.draw(getBoundsBig());
        
       // g.drawImage(m_Enemy, m_iX, m_iY, null);
        
       m_Animation.drawAnimation(g, m_iX, m_iY, 0);
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Enemy.ENEMY_WIDTH, Enemy.ENEMY_HEIGHT);
       
    }

    public Rectangle getBoundsBig() {
        
       return new Rectangle(m_iX - 16, m_iY - 16, Enemy.ENEMY_WIDTH * 2, 
                                                     Enemy.ENEMY_HEIGHT * 2);
       
    }    
    

    
}
