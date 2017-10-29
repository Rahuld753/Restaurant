package rest;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public class Accept extends javax.swing.JFrame {

    int posX,posY;
    Connection connection=null;
    public Accept() {
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
        toorder = new javax.swing.JButton();
        ordered = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        menutable = new javax.swing.JTable(){public boolean isCellEditable(int row,int col)
            { return false;}};
        jScrollPane4 = new javax.swing.JScrollPane();
        ordertable = new javax.swing.JTable(){public boolean isCellEditable(int row,int col)
            {
                if(col==3)
                return true;
                else
                return false;
            }
        };
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        itname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        rem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accept Order");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(240, 240, 240));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Accept Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 6, -1, -1));

        toorder.setBackground(new java.awt.Color(0, 153, 0));
        toorder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        toorder.setForeground(new java.awt.Color(255, 0, 51));
        toorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/cart.png"))); // NOI18N
        toorder.setText("Add To Food Cart");
        toorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toorderActionPerformed(evt);
            }
        });
        getContentPane().add(toorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 244, -1));

        ordered.setBackground(new java.awt.Color(0, 153, 0));
        ordered.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordered.setForeground(new java.awt.Color(255, 0, 0));
        ordered.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/check.png"))); // NOI18N
        ordered.setText("Place Order");
        ordered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderedActionPerformed(evt);
            }
        });
        getContentPane().add(ordered, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 503, 239, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*Select Items to Proceed to Order");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*Select Quantities to Place Order ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 480, -1, -1));

        menutable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(menutable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 573, 170));

        ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "category", "Item_Name", "Price", "Choose Quantity"
            }
        ));
        jScrollPane4.setViewportView(ordertable);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 336, 764, 138));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Category");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Item Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 169, -1, -1));

        itname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itnameKeyReleased(evt);
            }
        });
        getContentPane().add(itname, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 197, 110, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("To search Type in");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 77, -1, -1));

        category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                categoryKeyReleased(evt);
            }
        });
        getContentPane().add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 138, 110, -1));

        rem.setBackground(new java.awt.Color(0, 153, 0));
        rem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rem.setForeground(new java.awt.Color(255, 0, 0));
        rem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/rem.png"))); // NOI18N
        rem.setText("Remove From Cart");
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });
        getContentPane().add(rem, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 503, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*Select Items to remove from cart");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 790, 480));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 30, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 70));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toorderActionPerformed
        try{
        int[] rows=menutable.getSelectedRows();
        Vector<Integer> values=new Vector<Integer>();
        for(int i=1;i<31;i++)
            values.add(i);
        JComboBox combo=new JComboBox(values);
        combo.setSelectedIndex(1);
        int r1,r2;
        Object[] row=new Object[4];
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel) ordertable.getModel();
        for(int i=0;i<rows.length;i++)
        {
            row[0]=menutable.getValueAt(rows[i],0);
            row[1]=menutable.getValueAt(rows[i],1);
            row[2]=menutable.getValueAt(rows[i],2);
            row[3]=1;
            model.addRow(row);
            ordertable.isCellEditable(i,3);
        } 
         TableColumn col=ordertable.getColumnModel().getColumn(3);
         col.setCellEditor(new DefaultCellEditor(combo));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_toorderActionPerformed

    private void orderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderedActionPerformed
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel) ordertable.getModel();
        int cnt1=ordertable.getRowCount();
        try{
        int order=1;
        PreparedStatement st1=connection.prepareStatement("select max(cast(order_id as unsigned)) from ord_stat");
        ResultSet rs1=st1.executeQuery();
        if(rs1.next())
        order=rs1.getInt(1)+1;
        for(int i=0;i<cnt1;i++)
        {
        String query="insert into ord_stat values(?,?,?,?,?)";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,String.valueOf(order));
        st.setString(2,String.valueOf(ordertable.getValueAt(i,1)));
        st.setString(3,String.valueOf(ordertable.getValueAt(i,2)));
        st.setString(4,String.valueOf(ordertable.getValueAt(i,3)));
        st.setString(5,"Pending");
        st.execute();
        }
        JOptionPane.showMessageDialog(null,"Order Placed Successfully\nYour Order ID is "+order);
        for(int i=0;i<cnt1;i++)
            model.removeRow(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            for(int i=0;i<cnt1;i++)
                model.removeRow(0);
        }
    }//GEN-LAST:event_orderedActionPerformed

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

    private void categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryKeyReleased
        try{
        String cat=category.getText();
        cat=cat+'%';
        itname.setText("");
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

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        try{
            javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel) ordertable.getModel();
            while(ordertable.getSelectedRow()!=-1)
                model.removeRow(ordertable.getSelectedRow());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }        
    }//GEN-LAST:event_remActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          int i=7;
          while(i>0)
          {
            this.setOpacity((float) (this.getOpacity()-0.1));
             try{
               Thread.sleep(40);
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
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField category;
    private javax.swing.JTextField itname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable menutable;
    private javax.swing.JButton ordered;
    private javax.swing.JTable ordertable;
    private javax.swing.JButton rem;
    private javax.swing.JButton toorder;
    // End of variables declaration//GEN-END:variables
}
