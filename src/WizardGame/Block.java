
// Class: Block

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Block extends GameObject {

    public static int BLOCK_WIDTH = 32;
    public static int BLOCK_HEIGHT = 32;    
    
    private BufferedImage m_BuffImageBlock;
    

    public Block(int iX, int iY, ID id, SpriteSheet spriteSheet) {
        
       super(iX, iY, id, spriteSheet);
       m_BuffImageBlock = spriteSheet.grabImage(2, 5, Block.BLOCK_WIDTH, 
                                                          Block.BLOCK_HEIGHT);
        
    }

    public void tick() {
 
    }

    public void render(Graphics g) {
 
       // g.setColor(Color.black);
       // g.fillRect(m_iX, m_iY, 32, 32);
       g.drawImage(m_BuffImageBlock, m_iX, m_iY, null);
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Block.BLOCK_WIDTH, Block.BLOCK_HEIGHT);
       
    }
     
}
