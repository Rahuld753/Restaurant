
package rest;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Employee extends JFrame {

    int posX,posY;
    Connection connection=null;
    public Employee() {
        initComponents();
        this.setResizable(false);
        connection=GuiConnection.dbconnect();
        refresh();
    }

    public void refresh()
    {
        try{
        String query="select * from emp order by cast(EID as unsigned)";
        PreparedStatement st=connection.prepareStatement(query);
        ResultSet rs=st.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        savebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        eid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Details");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("EID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, -1, 14));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Surname");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, -1, -1));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 114, 89, -1));
        getContentPane().add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 145, 89, -1));

        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 182, 89, -1));

        savebtn.setBackground(new java.awt.Color(0, 255, 51));
        savebtn.setForeground(new java.awt.Color(255, 0, 0));
        savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/addemp.png"))); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        getContentPane().add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 220, 144, -1));

        updatebtn.setBackground(new java.awt.Color(0, 255, 51));
        updatebtn.setForeground(new java.awt.Color(255, 0, 0));
        updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/updatemenu.png"))); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        getContentPane().add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 144, -1));

        deletebtn.setBackground(new java.awt.Color(0, 255, 51));
        deletebtn.setForeground(new java.awt.Color(255, 0, 0));
        deletebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/delmenu.png"))); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 144, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scroll.setViewportView(table);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 72, 490, 290));

        eid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eidKeyTyped(evt);
            }
        });
        getContentPane().add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 76, 89, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("EMPLOYEE DETAILS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 270, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 720, 320));

        jButton2.setBackground(new java.awt.Color(102, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 60));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        try{
        String query="insert into emp values(?,?,?,?)";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,eid.getText());
        st.setString(2,name.getText());
        st.setString(3,surname.getText());
        st.setString(4,age.getText());
        st.execute();
        refresh();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        try{
        String query="update emp set EID='"+eid.getText()+"',Name='"+name.getText()+"',Surname='"+surname.getText()+"',Age='"+age.getText()+"' where EID='"+eid.getText()+"'";
        PreparedStatement st=connection.prepareStatement(query);
        st.execute();
        refresh();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        try{
        String query="delete from emp where EID=?";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,eid.getText());
        st.execute();
        refresh();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void eidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eidKeyReleased
        try{
        String query="select * from emp where EID=?";
        PreparedStatement st=connection.prepareStatement(query);
        int count=0;
        st.setString(1,eid.getText());
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            count++;
            name.setText(rs.getString("Name"));
            surname.setText(rs.getString("Surname"));
            age.setText(rs.getString("Age"));
        }
        if(count==0)
        {
            name.setText("");
            surname.setText("");
            age.setText("");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_eidKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       try{
           int row=table.getSelectedRow();
           String id=(table.getModel().getValueAt(row,0)).toString();
        String query="select * from emp where EID=?";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            eid.setText(rs.getString("EID"));
            name.setText(rs.getString("Name"));
            surname.setText(rs.getString("Surname"));
            age.setText(rs.getString("Age"));
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void eidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eidKeyTyped
       char ch=evt.getKeyChar();
        if(!(Character.isDigit(ch) || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_eidKeyTyped

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
        char ch=evt.getKeyChar();
        if(!(Character.isDigit(ch) || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_ageKeyTyped

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX=evt.getX();
        posY=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(getLocation().x+evt.getX()-posX,getLocation().y+evt.getY()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed


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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField eid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JButton savebtn;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField surname;
    private javax.swing.JTable table;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
