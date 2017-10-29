package rest;
import java.awt.event.KeyEvent;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.swing.*;

public class GetPass extends javax.swing.JFrame {

    int posX,posY;
    Connection connection=null;
    static int count;
    public GetPass() {
        initComponents();
        this.setResizable(false);
        connection=GuiConnection.dbconnect();
        progress.setVisible(false);
    }
    
    
    class Progperc extends Thread
    {
        @Override
        public void run()
        {
            progress.setVisible(true);
            progress.setValue(0);
            for(int i=20;i<=80;i=i+20)
            {
                progress.setValue(progress.getValue()+20);
             try{
               Thread.sleep(1000);
             } catch (InterruptedException ex) {
                Logger.getLogger(GetPass.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        }
   }
    
    
    class Emgen extends Thread
    {
      @Override
      public void run()
      {
      try{
      String query="select * from login where username=?",pword=null,em=null;
      PreparedStatement st=connection.prepareStatement(query);
      st.setString(1,usname.getText());
      ResultSet rs=st.executeQuery();
      while(rs.next())
      {
          count++;
          pword=rs.getString("password");
          em=rs.getString("Email");
      }
      if(count==1)
        {
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port",587);
        props.put("mail.smtp.user","rrkk404@gmail.com");
        props.put("mail.smtp.password","0753rrkk");
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg=new  MimeMessage(session);
        try
        {
        msg.setFrom(new InternetAddress("rrkk404@gmail.com"));
        InternetAddress toAddress=new InternetAddress(em);
        msg.addRecipient(Message.RecipientType.TO, toAddress);
        msg.setSubject("Your Password");
        msg.setText("You Can copy your Restaurant Password from here\n"+pword);
        Transport trans=session.getTransport("smtp");
        trans.connect("smtp.gmail.com","rrkk404@gmail.com","0753rrkk");
        trans.sendMessage(msg,msg.getAllRecipients());       
        trans.close();
        progress.setValue(100);
        progress.setVisible(false);
        JOptionPane.showMessageDialog(null,"Password Sent to your Registered Email "+em);
        }
        catch(MessagingException m){
            progress.setVisible(false);
            JOptionPane.showMessageDialog(null,"Connection Problem");
            usname.setText("");
        }
      }
      else
      {
          progress.setVisible(false);
          JOptionPane.showMessageDialog(null,"There is no such UserName.....");
          usname.setText("");
      }

      }catch(Exception e){
         JOptionPane.showMessageDialog(null,e.getMessage());
     }
    }
      
   }
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usname = new javax.swing.JTextField();
        getp = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Get Password");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Enter UserName To Get the Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 360, 50));

        usname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usnameKeyPressed(evt);
            }
        });
        getContentPane().add(usname, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 79, 163, -1));

        getp.setBackground(new java.awt.Color(0, 153, 0));
        getp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getp.setForeground(new java.awt.Color(255, 51, 51));
        getp.setText("Get Password");
        getp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getpActionPerformed(evt);
            }
        });
        getContentPane().add(getp, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 117, -1, -1));

        progress.setForeground(new java.awt.Color(255, 153, 51));
        progress.setStringPainted(true);
        getContentPane().add(progress, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 176, 186, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 500, 160));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 60));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 220));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getpActionPerformed
            Emgen t1=new Emgen();
            Progperc t2=new Progperc();
            t1.start();
            t2.start();
    }//GEN-LAST:event_getpActionPerformed

    private void usnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usnameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            Emgen t1=new Emgen();
            Progperc t2=new Progperc();
            t1.start();
            t2.start();           
        }
    }//GEN-LAST:event_usnameKeyPressed

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
            java.util.logging.Logger.getLogger(GetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new GetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField usname;
    // End of variables declaration//GEN-END:variables
}
