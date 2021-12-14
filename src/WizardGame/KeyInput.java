
// Class: KeyInput

package WizardGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
   
   Handler m_Handler; 
    
   public KeyInput(Handler newHandler) {
       
      this.m_Handler = newHandler;
      
   }
    
   public void keyPressed(KeyEvent ke) {
       
      int iKey = ke.getKeyCode();
      int iCount;
      
      for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
          
         GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
      
         if (tempGameObject.getID() == ID.Player) {
             
            if (iKey == KeyEvent.VK_W || iKey == KeyEvent.VK_UP) {
               m_Handler.setUp(true);
            }
            
            if (iKey == KeyEvent.VK_S || iKey == KeyEvent.VK_DOWN) {
               m_Handler.setDown(true);
            }
            
            if (iKey == KeyEvent.VK_A || iKey == KeyEvent.VK_LEFT) {
               m_Handler.setLeft(true);
            }
            
            if (iKey == KeyEvent.VK_D || iKey == KeyEvent.VK_RIGHT) {
               m_Handler.setRight(true);
            }
             
         }
         
      }
            
   }    
    
   public void keyReleased(KeyEvent ke) {
       
      int iKey = ke.getKeyCode();
      int iCount;
      
      for (iCount = 0; iCount < m_Handler.m_pGameObjects.size(); ++iCount) {
          
         GameObject tempGameObject = m_Handler.m_pGameObjects.get(iCount);
      
         if (tempGameObject.getID() == ID.Player) {
             
            if (iKey == KeyEvent.VK_W || iKey == KeyEvent.VK_UP) {
               m_Handler.setUp(false);
            }
            
            if (iKey == KeyEvent.VK_S || iKey == KeyEvent.VK_DOWN) {
               m_Handler.setDown(false);
            }
            
            if (iKey == KeyEvent.VK_A || iKey == KeyEvent.VK_LEFT) {
               m_Handler.setLeft(false);
            }
            
            if (iKey == KeyEvent.VK_D || iKey == KeyEvent.VK_RIGHT) {
               m_Handler.setRight(false);
            }
             
         }
         
      }   
           
   }  
      
}
