
// Class: Camera

package WizardGame;


public class Camera {
    
   private float m_fX;
   private float m_fY;
   
   public Camera(float fX, float fY) {
   
      this.m_fX = fX;
      this.m_fY = fY;
   
   }
   
   public void tick(GameObject gameObject) {
   
      m_fX += ((gameObject.getX() - m_fX) - WizardGame.WIDTH/2) * 0.05f; 
      m_fY += ((gameObject.getY() - m_fY) - WizardGame.HEIGHT/2) * 0.05f;
      
      if (m_fX <= 0) {
         m_fX = 0;
      }
      
      if (m_fX >= 32 + 1032) {
         m_fX = 32 + 1032;
      }      
      
      if (m_fY <= 0) {
         m_fY = 0;
      }
      
      if (m_fY >= 240 + 563 + 48) {
         m_fY = 240 + 563 + 48;
      }         
       
   }
   
   public float getX() {
      return m_fX;
   }
   
   public void setX(float fX) {
      this.m_fX = fX;
   }
   
   public float getY() {
      return m_fY;
   } 
   
   public void setY(float fY) {
      this.m_fY = fY;
   }
   
}
