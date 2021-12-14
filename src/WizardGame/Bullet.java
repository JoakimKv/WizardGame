
// Class: Bullet

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet extends GameObject {
    
   public static int BUL_WIDTH = 8;    
   public static int BUL_HEIGHT = 8;
   
   private Handler m_Handler; 

   
   public Bullet(int iX, int iY, ID id, Handler newHandler, int iMouseX, 
                                        int iMouseY, SpriteSheet spriteSheet) {
        
      super(iX, iY, id, spriteSheet);
      this.m_Handler = newHandler;
      
      m_fVelX = (iMouseX - m_iX) / 10;
      m_fVelY = (iMouseY - m_iY) / 10;
        
   }    
  
   public void tick() {
       

      m_iX += m_fVelX;
      m_iY += m_fVelY;
 
      int iCount;     
      
      for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
      
         GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
         
         if (tempGameObject.getID() == ID.Block) {
         
            if (getBounds().intersects(tempGameObject.getBounds())) {
               
               // Remove the Bullet. 
               m_Handler.removeGameObject(this);
               
            }    
             
         }
          
      }      
      
   }
 
   public void render(Graphics g) {
       
      g.setColor(Color.green);
      g.fillOval(m_iX, m_iY, Bullet.BUL_WIDTH, Bullet.BUL_HEIGHT);
 
   }
 
   public Rectangle getBounds() {
       
      return new Rectangle(m_iX, m_iY, Bullet.BUL_WIDTH, Bullet.BUL_HEIGHT);
      
   }
    
}

