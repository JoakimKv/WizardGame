
// Class: Crate

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Crate extends GameObject {
    
    public static int CRATE_WIDTH = 32;
    public static int CRATE_HEIGHT = 32;
    
    private BufferedImage m_Crate;
    
    
    public Crate(int iX, int iY, ID id, SpriteSheet spriteSheet) {
        
        super(iX, iY, id, spriteSheet);
        
        m_Crate = spriteSheet.grabImage(2, 6, Crate.CRATE_WIDTH, 
                                                          Crate.CRATE_HEIGHT);
        
    }
    
    public void tick() {
 
    }

    public void render(Graphics g) {
        
       // g.setColor(Color.cyan);
       // g.fillRect(m_iX, m_iY, Crate.CRATE_WIDTH, Crate.CRATE_HEIGHT);
        
       g.drawImage(m_Crate, m_iX, m_iY, null);
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Crate.CRATE_WIDTH, Crate.CRATE_HEIGHT);
       
    }
    
}
