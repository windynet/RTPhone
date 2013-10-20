package view;

import remoteMethodInvocation.Client;
import java.net.Inet4Address;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JH
 */
public class LoginWindow extends javax.swing.JFrame {

    private Client remoteMethodInvocationClient;
    private DefaultServerConfigurationsWindow defaultServerConfigurationsWindow;
    private MainWindow mainWindow;

    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        try {
            initComponents();
            Registry registry = LocateRegistry.createRegistry(9001);
            remoteMethodInvocationClient = new Client(this);
            registry.rebind("RTPhoneClient", remoteMethodInvocationClient);
            System.out.println("start");

            defaultServerConfigurationsWindow = new DefaultServerConfigurationsWindow();
        } catch (RemoteException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public DefaultServerConfigurationsWindow getDefaultServerConfigurationsWindow() {
        return defaultServerConfigurationsWindow;
    }

    
    public Client getRemoteMethodInvocationClient() {
        return remoteMethodInvocationClient;
    }

    public JTextField getjTextFieldHost() {
        return jTextFieldName;
    }

    public JTextField getjTextFieldUsername() {
        return jTextFieldUsername;
    }

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

    public void setRemoteMethodInvocationClient(Client remoteMethodInvocationClient) {
        this.remoteMethodInvocationClient = remoteMethodInvocationClient;
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
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jTextFieldName = new javax.swing.JTextField();
      jTextFieldUsername = new javax.swing.JTextField();
      jPasswordField = new javax.swing.JPasswordField();
      jButtonRegister = new javax.swing.JButton();
      jButtonLogin = new javax.swing.JButton();
      jMenuBar1 = new javax.swing.JMenuBar();
      jMenuConfigurations = new javax.swing.JMenu();
      jMenuItemDefaultDatabaseServer = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText("Name:");

      jLabel2.setText("Username:");

      jLabel3.setText("Password:");

      jTextFieldName.setText("User Zero");

      jTextFieldUsername.setText("user0");

      jPasswordField.setText("password");

      jButtonRegister.setText("Register");
      jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRegisterActionPerformed(evt);
         }
      });

      jButtonLogin.setText("Login");
      jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonLoginActionPerformed(evt);
         }
      });

      jMenuConfigurations.setText("Configurations");

      jMenuItemDefaultDatabaseServer.setText("Default Database Server");
      jMenuItemDefaultDatabaseServer.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItemDefaultDatabaseServerActionPerformed(evt);
         }
      });
      jMenuConfigurations.add(jMenuItemDefaultDatabaseServer);

      jMenuBar1.add(jMenuConfigurations);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel1)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel2)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jTextFieldUsername))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel3)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jPasswordField)))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jButtonRegister)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                  .addComponent(jButtonLogin)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButtonRegister)
               .addComponent(jButtonLogin))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
       try {
           boolean check = defaultServerConfigurationsWindow.getDatabase().exists(this.jTextFieldUsername.getText(), this.jPasswordField.getText());
           if (check) {
               boolean check2 = defaultServerConfigurationsWindow.getDatabase().login(this.jTextFieldUsername.getText(), this.jPasswordField.getText());
               if (check2) {
                  this.setVisible(false);
                  mainWindow = new MainWindow(this);
                  mainWindow.setVisible(true);
               } else {
                  JOptionPane.showMessageDialog(null, "User already logged!");
               }
           } else {
               JOptionPane.showMessageDialog(null, "User unregistered or wrong password!");
           }
       } catch (Exception e) {
           System.out.println(e);
           System.out.println(this.jTextFieldName.getText());
       }
   }//GEN-LAST:event_jButtonLoginActionPerformed

   private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
       try {
           boolean check = defaultServerConfigurationsWindow.getDatabase().exists(this.jTextFieldUsername.getText());
           if (!check) {
               defaultServerConfigurationsWindow.getDatabase().register(this.jTextFieldUsername.getText(), this.jTextFieldName.getText(),this.jPasswordField.getText());
           } else {
               JOptionPane.showMessageDialog(null, "User already registered!");
           }
       } catch (Exception e) {
           System.out.println(e);
       }
   }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jMenuItemDefaultDatabaseServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDefaultDatabaseServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemDefaultDatabaseServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButtonLogin;
   private javax.swing.JButton jButtonRegister;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JMenu jMenuConfigurations;
   private javax.swing.JMenuItem jMenuItemDefaultDatabaseServer;
   private javax.swing.JPasswordField jPasswordField;
   private javax.swing.JTextField jTextFieldName;
   private javax.swing.JTextField jTextFieldUsername;
   // End of variables declaration//GEN-END:variables
}
