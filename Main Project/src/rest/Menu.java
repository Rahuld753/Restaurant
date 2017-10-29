
package rest;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Menu extends JFrame {

    int posX,posY;
    Connection connection=null;
    
    public Menu() {
        initComponents();       
        this.setResizable(false);
        connection=GuiConnection.dbconnect();
        showmenu();
    }
    
    public void showmenu()
    {
        try{
        String query="select * from Menu order by category";
        PreparedStatement st=connection.prepareStatement(query);
        ResultSet rs=st.executeQuery();
        menutable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menutable = new javax.swing.JTable(){public boolean isCellEditable(int row,int col)
            { return false;}};
        catlabel = new javax.swing.JLabel();
        itlabel = new javax.swing.JLabel();
        prlabel = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        itname = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        additem = new javax.swing.JButton();
        deleteitem = new javax.swing.JButton();
        updateitem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(145, 11, 145));
        jLabel1.setText("Menu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 112, -1));

        jScrollPane2.setBackground(new java.awt.Color(51, 255, 51));

        menutable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        menutable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menutableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(menutable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 417, 380));

        catlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        catlabel.setForeground(new java.awt.Color(255, 255, 255));
        catlabel.setText("Category");
        getContentPane().add(catlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 126, 102, -1));

        itlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        itlabel.setForeground(new java.awt.Color(255, 255, 255));
        itlabel.setText("Item Name");
        getContentPane().add(itlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 178, -1, -1));

        prlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prlabel.setForeground(new java.awt.Color(255, 255, 255));
        prlabel.setText("Price");
        getContentPane().add(prlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 230, 102, -1));

        category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                categoryKeyReleased(evt);
            }
        });
        getContentPane().add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 126, 113, -1));

        itname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itnameKeyReleased(evt);
            }
        });
        getContentPane().add(itname, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 178, 113, -1));

        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 230, 113, -1));

        additem.setBackground(new java.awt.Color(0, 153, 0));
        additem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        additem.setForeground(new java.awt.Color(255, 51, 51));
        additem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/addmenu.png"))); // NOI18N
        additem.setText("Add to Menu");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });
        getContentPane().add(additem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 204, 40));

        deleteitem.setBackground(new java.awt.Color(0, 153, 0));
        deleteitem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteitem.setForeground(new java.awt.Color(255, 51, 51));
        deleteitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/delmenu.png"))); // NOI18N
        deleteitem.setText("Delete From Menu");
        deleteitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteitemActionPerformed(evt);
            }
        });
        getContentPane().add(deleteitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 204, -1));

        updateitem.setBackground(new java.awt.Color(0, 153, 0));
        updateitem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateitem.setForeground(new java.awt.Color(255, 51, 51));
        updateitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/updatemenu.png"))); // NOI18N
        updateitem.setText("Update Menu Item");
        updateitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateitemActionPerformed(evt);
            }
        });
        getContentPane().add(updateitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 204, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 410));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 30, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 70));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryKeyReleased
        try{
        String cat=category.getText();
        cat=cat+'%';
        itname.setText("");
        price.setText("");
        String query="select * from Menu where category like ? order by category";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,cat);
        ResultSet rs=st.executeQuery();
        menutable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_categoryKeyReleased

    private void itnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itnameKeyReleased
        try{
        String it=itname.getText();
        String cat=category.getText();
        cat=cat+'%';
        it=it+'%';
        String query="select * from Menu where category like ? and Item_Name like ? order by category";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,cat);
        st.setString(2,it);
        ResultSet rs=st.executeQuery();
        menutable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_itnameKeyReleased

    private void menutableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menutableMouseClicked
        try{
        int row=menutable.getSelectedRow();
        String it=(menutable.getModel().getValueAt(row,1)).toString();
        String query="select * from Menu where Item_Name=?";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,it);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            category.setText(rs.getString("category"));
            itname.setText(rs.getString("Item_Name"));
            price.setText(rs.getString("Price"));
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_menutableMouseClicked

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        try{
        String query="insert into menu values(?,?,?)";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,category.getText());
        st.setString(2,itname.getText());
        st.setString(3,price.getText());
        st.execute();
        showmenu();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_additemActionPerformed

    private void deleteitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteitemActionPerformed
        try{
        String query="delete from menu where Item_Name=?";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,itname.getText());
        st.execute();
        showmenu();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_deleteitemActionPerformed

    private void updateitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateitemActionPerformed
        try{
        String query="update menu set category='"+category.getText()+"',Item_Name='"+itname.getText()+"',Price='"+price.getText()+"' where Item_Name='"+itname.getText()+"'";
        PreparedStatement st=connection.prepareStatement(query);
        st.execute();
        showmenu();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_updateitemActionPerformed

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped
        char ch=evt.getKeyChar();
        if(!(Character.isDigit(ch) || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_priceKeyTyped

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additem;
    private javax.swing.JTextField category;
    private javax.swing.JLabel catlabel;
    private javax.swing.JButton deleteitem;
    private javax.swing.JLabel itlabel;
    private javax.swing.JTextField itname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable menutable;
    private javax.swing.JTextField price;
    private javax.swing.JLabel prlabel;
    private javax.swing.JButton updateitem;
    // End of variables declaration//GEN-END:variables
}
