
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JH
 */
public class CallWindow extends javax.swing.JFrame {
   public static Semaphore semaphore;
   private static int value;
   /**
    * Creates new form CallWindow
    */
   public CallWindow(String username) {
      value=-1;
      semaphore=new Semaphore(0);
      initComponents();
      jLabel1.setText(username+" is calling, Anwser?");
   }

   public static synchronized int getValue() throws InterruptedException{
      System.out.println("A");
      semaphore.acquire();
      System.out.println("B");
      return value;
   }

   public static synchronized void setValue(int value) {
      CallWindow.value = value;
   }
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jButtonYes = new javax.swing.JButton();
      jButtonNo = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText(" ");

      jButtonYes.setText("Yes");
      jButtonYes.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonYesActionPerformed(evt);
         }
      });

      jButtonNo.setText("No");
      jButtonNo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonNoActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jButtonYes)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                  .addComponent(jButtonNo))
               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButtonYes)
               .addComponent(jButtonNo))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void jButtonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYesActionPerformed
      setValue(0);
      setVisible(false);
      dispose();
      this.semaphore.release();
   }//GEN-LAST:event_jButtonYesActionPerformed

   private void jButtonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoActionPerformed
      setValue(1);
      setVisible(false);
      dispose();
      this.semaphore.release();
   }//GEN-LAST:event_jButtonNoActionPerformed

   /**
    * @param args the command line arguments
    */
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButtonNo;
   private javax.swing.JButton jButtonYes;
   private javax.swing.JLabel jLabel1;
   // End of variables declaration//GEN-END:variables
}
