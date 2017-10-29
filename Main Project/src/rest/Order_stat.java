package rest;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public class Order_stat extends javax.swing.JFrame {

    int posX, posY;
    Connection connection = null;

    public Order_stat() {
        initComponents();
        this.setResizable(false);
        connection = GuiConnection.dbconnect();
        showorders();
    }

    public void showorders() {
        try {
            Vector<String> values = new Vector();
            values.add("Pending");
            values.add("Delivered");
            values.add("Cancelled");
            JComboBox combo = new JComboBox(values);
            combo.setSelectedIndex(0);
            String query = "select * from ord_stat order by cast(order_id as unsigned)";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            ordertable.setModel(DbUtils.resultSetToTableModel(rs));
            TableColumn col = ordertable.getColumnModel().getColumn(4);
            col.setCellEditor(new DefaultCellEditor(combo));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        del = new javax.swing.JButton();
        uptable = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addup = new javax.swing.JButton();
        oid = new javax.swing.JTextField();
        itname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordertable = new javax.swing.JTable(){public boolean isCellEditable(int row,int col)
            {
                if(col==4)
                return true;
                else
                return false;
            }
        };
        delorders = new javax.swing.JButton();
        qty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order Status");
        setUndecorated(true);
        setOpacity(0.8F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Order Status");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        del.setBackground(new java.awt.Color(0, 153, 0));
        del.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        del.setForeground(new java.awt.Color(255, 0, 0));
        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/delmenu.png"))); // NOI18N
        del.setText("Delete All Cancelled Orders");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        getContentPane().add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 236, -1));

        uptable.setBackground(new java.awt.Color(0, 153, 0));
        uptable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        uptable.setForeground(new java.awt.Color(255, 0, 0));
        uptable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/updatemenu.png"))); // NOI18N
        uptable.setText("Update Order Status");
        uptable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uptableActionPerformed(evt);
            }
        });
        getContentPane().add(uptable, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 238, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        addup.setBackground(new java.awt.Color(0, 153, 0));
        addup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addup.setForeground(new java.awt.Color(255, 0, 0));
        addup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/addmenu.png"))); // NOI18N
        addup.setText("Add/Update Orders");
        addup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addupActionPerformed(evt);
            }
        });
        getContentPane().add(addup, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        oid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oidKeyTyped(evt);
            }
        });
        getContentPane().add(oid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 106, -1));

        itname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itnameKeyReleased(evt);
            }
        });
        getContentPane().add(itname, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 106, -1));

        ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ordertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordertableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ordertable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 505, 320));

        delorders.setBackground(new java.awt.Color(0, 153, 0));
        delorders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delorders.setForeground(new java.awt.Color(255, 0, 0));
        delorders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/del.png"))); // NOI18N
        delorders.setText("Delete All Delivered Orders");
        delorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delordersActionPerformed(evt);
            }
        });
        getContentPane().add(delorders, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 240, -1));

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        getContentPane().add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 106, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Sign Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 110, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 350));

        jButton2.setBackground(new java.awt.Color(102, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 30, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uptableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uptableActionPerformed
        try {
            int cnt = ordertable.getRowCount();
            for (int i = 0; i < cnt; i++) {
                String orid = String.valueOf(ordertable.getValueAt(i, 0));
                String itn = String.valueOf(ordertable.getValueAt(i, 1));
                String pr = String.valueOf(ordertable.getValueAt(i, 2));
                String qnt = String.valueOf(ordertable.getValueAt(i, 3));
                String stat = String.valueOf(ordertable.getValueAt(i, 4));
                String query = "update ord_stat set order_id='" + orid + "',Item_Name='" + itn + "',Price='" + pr + "',Quantity='" + qnt + "',Status='" + stat + "' where order_id='" + orid + "' and Item_Name='" + itn + "'";
                PreparedStatement st = connection.prepareStatement(query);
                st.execute();
            }
            showorders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_uptableActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        try {
            String query = "delete from ord_stat where Status=?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, "Cancelled");
            st.execute();
            showorders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_delActionPerformed

    private void oidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oidKeyReleased
        try {
            String id = oid.getText();
            id = id + '%';
            int count = 0;
            itname.setText("");
            qty.setText("");
            String query = "select * from ord_stat where order_id like ? order by cast(order_id as unsigned)";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            ordertable.setModel(DbUtils.resultSetToTableModel(rs));
            if (ordertable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "There is no such Order ID in Order Status Table...");
                oid.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_oidKeyReleased

    private void itnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itnameKeyReleased
        try {
            String it = itname.getText();
            String id = oid.getText();
            it = it + '%';
            id = id + '%';
            qty.setText("");
            String query = "select * from ord_stat where order_id like ? and Item_Name like ? order by cast(order_id as unsigned)";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, id);
            st.setString(2, it);
            ResultSet rs = st.executeQuery();
            ordertable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_itnameKeyReleased

    private void ordertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordertableMouseClicked
        try {
            int row = ordertable.getSelectedRow();
            String it = (ordertable.getModel().getValueAt(row, 1)).toString();
            String id = (ordertable.getModel().getValueAt(row, 0)).toString();
            String query = "select * from ord_stat where order_id=? and Item_Name=?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, id);
            st.setString(2, it);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                oid.setText(rs.getString("order_id"));
                itname.setText(rs.getString("Item_Name"));
                qty.setText(rs.getString("Quantity"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_ordertableMouseClicked

    private void addupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addupActionPerformed
        try {
            int count = 0;
            PreparedStatement st = connection.prepareStatement("Select * from ord_stat where order_id=? and Item_Name=?");
            st.setString(1, oid.getText());
            st.setString(2, itname.getText());
            ResultSet rs = st.executeQuery();
            PreparedStatement st1 = connection.prepareStatement("Select Price from menu where Item_Name=?");
            st1.setString(1, itname.getText());
            ResultSet rs1 = st1.executeQuery();
            while (rs.next()) {
                count++;
            }
            if (count == 0) {
                while (rs1.next()) {
                    PreparedStatement st2 = connection.prepareStatement("insert into ord_stat values(?,?,?,?,?)");
                    st2.setString(1, oid.getText());
                    st2.setString(2, itname.getText());
                    st2.setString(3, rs1.getString("Price"));
                    st2.setString(4, qty.getText());
                    st2.setString(5, "Pending");
                    st2.execute();
                }
            } else {
                String query2 = "update ord_stat set Quantity='" + qty.getText() + "',Status=? where Item_Name='" + itname.getText() + "' and order_id='" + oid.getText() + "'";
                PreparedStatement st2 = connection.prepareStatement(query2);
                st2.setString(1, "Pending");
                st2.execute();
            }
            showorders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_addupActionPerformed

    private void delordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delordersActionPerformed
        try {
            String query = "delete from ord_stat where Status=?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, "Delivered");
            st.execute();
            showorders();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_delordersActionPerformed

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_qtyKeyTyped

    private void oidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oidKeyTyped
        char ch = evt.getKeyChar();
        if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_oidKeyTyped

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
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(getLocation().x+evt.getX()-posX,getLocation().y+evt.getY()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Order_stat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_stat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_stat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_stat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_stat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addup;
    private javax.swing.JButton del;
    private javax.swing.JButton delorders;
    private javax.swing.JTextField itname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField oid;
    private javax.swing.JTable ordertable;
    private javax.swing.JTextField qty;
    private javax.swing.JButton uptable;
    // End of variables declaration//GEN-END:variables
}
