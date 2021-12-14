
// Class: MouseInput

package WizardGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseInput extends MouseAdapter {

   private Handler m_Handler;
   private Camera m_Camera;
   private WizardGame m_WizardGame;
   private SpriteSheet m_SpriteSheet;
   
   
   public MouseInput(Handler newHandler, Camera newCamera, 
                               WizardGame wizardGame, SpriteSheet spriteSheet) {
   
      this.m_Handler = newHandler;    
      this.m_Camera = newCamera;
      this.m_WizardGame = wizardGame;
      this.m_SpriteSheet = spriteSheet;
      
   }
   
   public void mousePressed(MouseEvent e) {
       
      int iMouseX = (int) (e.getX() + m_Camera.getX());    
      int iMouseY = (int) (e.getY() + m_Camera.getY());
      
      int iCount;
      
      for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
       
         GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
          
         if (tempGameObject.getID() == ID.Player 
                                              && m_WizardGame.m_iAmmo >= 1) {
             
            m_Handler.addGameObject(new Bullet(tempGameObject.getX() + 16, 
                        tempGameObject.getY() + 24, ID.Bullet, m_Handler, 
                         iMouseX, iMouseY, m_SpriteSheet));
            
            --m_WizardGame.m_iAmmo;
             
         }
                     
      }      

   }
 
    
    
    
}
