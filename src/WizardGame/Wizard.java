
// Class: Wizard

package WizardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Wizard extends GameObject {
    
    public static int WIZ_WIDTH = 32;    
    public static int WIZ_HEIGHT = 48;

    
    protected Handler m_Handler;
    protected WizardGame m_WizardGame;
    
    private BufferedImage[] m_pWizard;
    
    protected Animation m_Animation;
    

    public Wizard(int iX, int iY, ID id, Handler newHandler, 
                              WizardGame wizardGame, SpriteSheet spriteSheet) {
      
        super(iX, iY, id, spriteSheet);
        
        int iCount;         
        
        this.m_Handler = newHandler;
        this.m_WizardGame = wizardGame;
        
        m_pWizard = new BufferedImage[3];
        
        for (iCount = 0; iCount < 3; ++iCount) {
            
           m_pWizard[iCount] = m_SpriteSheet.grabImage(1, 1 + iCount, 
                                         Wizard.WIZ_WIDTH, Wizard.WIZ_HEIGHT);
           
        }
        
        m_Animation = new Animation(1, m_pWizard, 3);
        
    }    
    
    public void tick() {

       m_iX += m_fVelX; 
       m_iY += m_fVelY;       
       
       collision();
       
       // Movement "up or down" or "right or left".
       if (m_Handler.isUp()) {
          m_fVelY = -5;
       }
       else if (!m_Handler.isDown()) {
          m_fVelY = 0;
       }
 
       if (m_Handler.isDown()) {
          m_fVelY = 5;
       }
       else if (!m_Handler.isUp()) {
          m_fVelY = 0;
       }   
       
       if (m_Handler.isRight()) {
          m_fVelX = 5;
       }
       else if (!m_Handler.isLeft()) {
          m_fVelX = 0;
       }
       
       if (m_Handler.isLeft()) {
          m_fVelX = -5;
       }
       else if (!m_Handler.isRight()) {
          m_fVelX = 0;
       }
       
       m_Animation.runAnimation();
       
    }

    private void collision() {
        
       int iCount;
       
       for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
       
          GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
          
          if (tempGameObject.getID() == ID.Block) {
             
             // Check if the player and a block intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_iX += m_fVelX * -1;
                m_iY += m_fVelY * -1;
                 
             }
          
          }
 
          if (tempGameObject.getID() == ID.Crate) {
             
             // Check if the player and a crate intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_WizardGame.m_iAmmo += 10;
                m_Handler.removeGameObject(tempGameObject);
                 
             }
          
          }  
          
          if (tempGameObject.getID() == ID.Enemy) {
             
             // Check if the player and an enemy intersects. 
             if (getBounds().intersects(tempGameObject.getBounds())) {
             
                m_WizardGame.m_iHP--;
                
                if (m_WizardGame.m_iHP <= 0) {
                    
                   m_WizardGame.m_iHP = 0;
                   
                }
                 
             }
          
          }
          
       }
       
    }
        
    public void render(Graphics g) {
        
       // g.setColor(Color.blue);
       // g.fillRect(m_iX, m_iY, Wizard.WIZ_WIDTH, Wizard.WIZ_HEIGHT);
       
       // If Wizard standing still, don't do any animation. 
       if (m_fVelX == 0 && m_fVelY == 0) { 
          g.drawImage(m_pWizard[0], m_iX, m_iY, null);
       }
       else {
          m_Animation.drawAnimation(g, m_iX, m_iY, 0);
       }
        
    }

    public Rectangle getBounds() {
        
       return new Rectangle(m_iX, m_iY, Wizard.WIZ_WIDTH, Wizard.WIZ_HEIGHT);
       
    }    
    
}
