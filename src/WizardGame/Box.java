
// Class: Box

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Box extends GameObject {

   public static int BOX_WIDTH = 32;
   public static int BOX_HEIGHT = 32;      
    
   public Box(int iX, int iY, ID id, SpriteSheet spriteSheet) {
   
      super(iX, iY, id, spriteSheet);    
       
   }
    
    public void tick() {
    
       m_iX += m_fVelX;
       m_iY += m_fVelY;

    }

    public void render(Graphics g) {
        
       g.setColor(Color.blue);
       g.fillRect(m_iX, m_iY, Box.BOX_WIDTH, Box.BOX_HEIGHT);
       
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Box.BOX_WIDTH, Box.BOX_HEIGHT);
       
    }
        
}
