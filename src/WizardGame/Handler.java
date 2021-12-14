
// Class: Handler

package WizardGame;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {

   LinkedList<GameObject> m_pGameObjects = new LinkedList<GameObject>();
   
   private boolean m_bUp = false;
   private boolean m_bDown = false;
   private boolean m_bRight = false;
   private boolean m_bLeft = false;
   
   
   public void tick() {
   
      int iCount;
      
      for (iCount = 0; iCount < m_pGameObjects.size(); ++iCount) {
      
         GameObject tempGameObject = m_pGameObjects.get(iCount);
         
         tempGameObject.tick();
          
      }
              
   }
   
   public void render(Graphics g) {
   
      int iCount;
      
      for (iCount = 0; iCount < m_pGameObjects.size(); ++iCount) {
      
         GameObject tempGameObject = m_pGameObjects.get(iCount);
         
         tempGameObject.render(g);
          
      }
      
   }
   
   public void addGameObject(GameObject tempGameObject) {
      m_pGameObjects.add(tempGameObject);
   }
   
   public void removeGameObject(GameObject tempGameObject) {
      m_pGameObjects.remove(tempGameObject);
   }   
   
   public boolean isUp() {
      return m_bUp;
   }
   
   public void setUp(boolean bUp) {
      this.m_bUp = bUp;    
   } 
   
   public boolean isDown() {
      return m_bDown;
   }
   
   public void setDown(boolean bDown) {
      this.m_bDown = bDown;    
   }    
   
   public boolean isRight() {
      return m_bRight;
   }
   
   public void setRight(boolean bRight) {
      this.m_bRight = bRight;    
   }    

   public boolean isLeft() {
      return m_bLeft;
   }
   
   public void setLeft(boolean bLeft) {
      this.m_bLeft = bLeft;    
   }    
   
}
