
package rest;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
    
    int posX,posY;
    Connection connection=null;
    public Login(){
        initComponents();
        connection=GuiConnection.dbconnect();
        user.setVisible(false);
        pswd.setVisible(false);
        invalid.setVisible(false);
        manager.setSelected(true);
    }
    
    public void logact()
    {
       try{
        String query="select * from login where username=? and password=?";
        int count=0;
        user.setVisible(false);
        pswd.setVisible(false);
        invalid.setVisible(false);
        PreparedStatement st=connection.prepareStatement(query);
        if(uname.getText().equals(""))
            user.setVisible(true);
        if(pass.getText().equals(""))
            pswd.setVisible(true);
        st.setString(1,uname.getText());
        st.setString(2,pass.getText());
        ResultSet rs=st.executeQuery();
        if(uname.getText().length()!=0 && pass.getText().length()!=0)           
        {
        while(rs.next()){
            count++;
        }
        if(count==1)
        {
            if(manager.isSelected() && uname.getText().equalsIgnoreCase("admin"))
            {
                new FirstPage().setVisible(true);
                this.dispose();
            }
            else if(chef.isSelected() && uname.getText().equalsIgnoreCase("chef"))
            {
                new Order_stat().setVisible(true);
                this.dispose();
            }
            else if(waiter.isSelected() && uname.getText().equalsIgnoreCase("customer"))
            {
                new User().setVisible(true);
                this.dispose();
            }
            else
            {
                invalid.setVisible(true);
                uname.setText("");
                pass.setText("");                
            }                
        }
        else
        {
          invalid.setVisible(true);
          uname.setText("");
          pass.setText("");
        }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        clr = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        pswd = new javax.swing.JLabel();
        invalid = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        forgot = new javax.swing.JButton();
        waiter = new javax.swing.JRadioButton();
        chef = new javax.swing.JRadioButton();
        manager = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        setOpacity(0.8F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("LOGIN PAGE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 250, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 119, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                unameKeyPressed(evt);
            }
        });
        getContentPane().add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 200, -1));

        login.setBackground(new java.awt.Color(0, 153, 0));
        login.setForeground(new java.awt.Color(255, 51, 51));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 91, 36));

        clr.setBackground(new java.awt.Color(0, 153, 0));
        clr.setForeground(new java.awt.Color(255, 51, 51));
        clr.setText("Clear");
        clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrActionPerformed(evt);
            }
        });
        getContentPane().add(clr, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 88, 36));

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/log.png"))); // NOI18N
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 144, 147));

        user.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        user.setForeground(new java.awt.Color(255, 51, 51));
        user.setText("*Please Enter User Name");
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 170, -1));

        pswd.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        pswd.setForeground(new java.awt.Color(255, 51, 51));
        pswd.setText("*Please Enter Password");
        getContentPane().add(pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 134, -1));

        invalid.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        invalid.setForeground(new java.awt.Color(255, 51, 51));
        invalid.setText("*Invalid UserName or Password");
        getContentPane().add(invalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 179, -1));

        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 190, 200, -1));

        forgot.setBackground(new java.awt.Color(0, 153, 0));
        forgot.setForeground(new java.awt.Color(51, 51, 255));
        forgot.setText("Forgot Password?");
        forgot.setToolTipText("Click Here to Acess Your Password");
        forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotActionPerformed(evt);
            }
        });
        getContentPane().add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        waiter.setBackground(new java.awt.Color(0, 0, 0));
        waiter.setForeground(new java.awt.Color(255, 255, 255));
        waiter.setText("Waiter/Customer");
        waiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiterActionPerformed(evt);
            }
        });
        getContentPane().add(waiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        chef.setBackground(new java.awt.Color(0, 0, 0));
        chef.setForeground(new java.awt.Color(255, 255, 255));
        chef.setText("Chef");
        chef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chefActionPerformed(evt);
            }
        });
        getContentPane().add(chef, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        manager.setBackground(new java.awt.Color(0, 0, 0));
        manager.setForeground(new java.awt.Color(255, 255, 255));
        manager.setText("Manager");
        manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerActionPerformed(evt);
            }
        });
        getContentPane().add(manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 580, 280));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 80));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrActionPerformed
        uname.setText("");
        pass.setText("");
    }//GEN-LAST:event_clrActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        logact();
    }//GEN-LAST:event_loginActionPerformed

    private void unameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           logact();
    }//GEN-LAST:event_unameKeyPressed

    private void forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotActionPerformed
        new GetPass().setVisible(true);
    }//GEN-LAST:event_forgotActionPerformed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            logact();
    }//GEN-LAST:event_passKeyPressed

    private void managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerActionPerformed
        chef.setSelected(false);
        waiter.setSelected(false);
    }//GEN-LAST:event_managerActionPerformed

    private void waiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiterActionPerformed
        chef.setSelected(false);
        manager.setSelected(false);       
    }//GEN-LAST:event_waiterActionPerformed

    private void chefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chefActionPerformed
        manager.setSelected(false);
        waiter.setSelected(false);
    }//GEN-LAST:event_chefActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          int i=7;
          while(i>0)
          {
            this.setOpacity((float) (this.getOpacity()-0.1));
             try{
               Thread.sleep(20);
             } catch (InterruptedException ex) {
                Logger.getLogger(GetPass.class.getName()).log(Level.SEVERE, null, ex);
             }
             i--;
          }
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX=evt.getX();
        posY=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(getLocation().x+evt.getX()-posX,getLocation().y+evt.getY()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton chef;
    private javax.swing.JButton clr;
    private javax.swing.JButton forgot;
    private javax.swing.JLabel invalid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JButton login;
    private javax.swing.JRadioButton manager;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel pswd;
    private javax.swing.JTextField uname;
    private javax.swing.JLabel user;
    private javax.swing.JRadioButton waiter;
    // End of variables declaration//GEN-END:variables

}
