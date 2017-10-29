
package rest;
import com.itextpdf.text.*;
import java.util.Date;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Bill extends javax.swing.JFrame{
    int posX,posY;
    Connection connection=null;
    public Bill() {
        initComponents();
        this.setResizable(false);
        connection=GuiConnection.dbconnect();
        tot.setEditable(false);
        progress.setVisible(false);
        crlabel.setVisible(false);
    }
    
    class Doccr extends Thread
    {
        public String em=null;
        @Override
        public void run()
        {
          try
          {
            com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
            PdfWriter.getInstance(doc,new FileOutputStream("Bill.pdf"));
            String query2="select Item_name,Price,Quantity,cast(Price as unsigned)*cast(Quantity as unsigned) 'Total' from ord_stat where order_id=?";
            PreparedStatement st1=connection.prepareStatement(query2);
            st1.setString(1,oid.getText());
            ResultSet rs2=st1.executeQuery();
            doc.open();
             try{
               Thread.sleep(1000);
             } catch (InterruptedException ex) {
                Logger.getLogger(GetPass.class.getName()).log(Level.SEVERE, null, ex);
             }
            Image img=Image.getInstance("fortune.png");
            doc.add(img);
            doc.add(new Paragraph("\nBILL",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.RED)));
            doc.add(new Paragraph(new Date().toString()));
            doc.add(new Paragraph("-------------------------------------------------------------------------------------------------------------------------------\n\n"));
            PdfPTable table=new PdfPTable(4);
             try{
               Thread.sleep(1000);
             } catch (InterruptedException ex) {
                Logger.getLogger(GetPass.class.getName()).log(Level.SEVERE, null, ex);
             }
            PdfPCell cell=new PdfPCell(new Paragraph("You Enjoyed Following Items"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GREEN);
            PdfPCell cell5=new PdfPCell(new Paragraph("Total Bill is "));
            cell5.setColspan(2);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setBackgroundColor(BaseColor.GREEN);
            PdfPCell cell6=new PdfPCell(new Paragraph("Rs."+tot.getText()+"(Inclusive of GST)"));
            cell6.setColspan(2);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell1=new PdfPCell(new Paragraph("Item_Name"));
            cell1.setBackgroundColor(BaseColor.YELLOW);
            PdfPCell cell2=new PdfPCell(new Paragraph("Quantity"));
            cell2.setBackgroundColor(BaseColor.YELLOW);
            PdfPCell cell3=new PdfPCell(new Paragraph("Price"));
            cell3.setBackgroundColor(BaseColor.YELLOW);
            PdfPCell cell4=new PdfPCell(new Paragraph("Total"));
            cell4.setBackgroundColor(BaseColor.YELLOW);
             try{
               Thread.sleep(1000);
             } catch (InterruptedException ex) {
                Logger.getLogger(GetPass.class.getName()).log(Level.SEVERE, null, ex);
             }
            table.addCell(cell);
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            while(rs2.next())
            {
                table.addCell(rs2.getString("Item_Name"));
                table.addCell(rs2.getString("Quantity"));
                table.addCell(rs2.getString("Price"));
                table.addCell(rs2.getString("Total"));
            }          
            table.addCell(cell5);
            table.addCell(cell6);
            doc.add(table);
            doc.close();
           progress.setValue(100);
            progress.setVisible(false);
            crlabel.setVisible(false);
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Bill.pdf");
            } catch (IOException ex) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
         progress.setVisible(false);
         JOptionPane.showMessageDialog(null,e.getMessage());   
        }
        }
   }
    
    class Progperc extends Thread
    {
        @Override
        public void run()
        {
            progress.setVisible(true);
            progress.setValue(0);
            crlabel.setVisible(true);
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
       
    
    public void bilact()
    {
        try{
        int total=0,total1,count=0;
        String query="select Item_name,Price,Quantity,cast(Price as unsigned)*cast(Quantity as unsigned) 'Total' from ord_stat where order_id=?";
        PreparedStatement st=connection.prepareStatement(query);
        st.setString(1,oid.getText());
        ResultSet rs1=st.executeQuery();
        ordtable.setModel(DbUtils.resultSetToTableModel(rs1));
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            total=total+rs.getInt("Total");
            count++;
        }
        if(count==0)
        {
            progress.setVisible(false);
            JOptionPane.showMessageDialog(null,"There is no such Order ID");
            oid.setText("");
        }
        else
        {
        total1=total+(18*total)/100;
        tot.setText(String.valueOf(total1));
        lab.setText("Total Bill is Rs."+total+" + 18% GST Rs. "+(18*total)/100);
        Doccr t1=new Doccr();
        Progperc t2=new Progperc();
        t1.start();
        t2.start();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        ordtable = new javax.swing.JTable(){public boolean isCellEditable(int row,int col)
            { return false;}};
        jLabel2 = new javax.swing.JLabel();
        bil = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tot = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lab = new javax.swing.JLabel();
        oid = new javax.swing.JTextField();
        progress = new javax.swing.JProgressBar();
        crlabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bill");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 11, -1, -1));

        jScrollPane2.setOpaque(false);

        ordtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(ordtable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 736, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Enter the Order ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        bil.setBackground(new java.awt.Color(0, 102, 0));
        bil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bil.setForeground(new java.awt.Color(255, 51, 51));
        bil.setText("Get The Bill");
        bil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilActionPerformed(evt);
            }
        });
        getContentPane().add(bil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 121, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("*You Enjoyed Following Items");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Your Total Bill Is");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 326, -1, -1));
        getContentPane().add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 354, 85, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Please Visit Again...");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 392, -1, -1));

        lab.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 354, 282, 20));

        oid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                oidKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oidKeyTyped(evt);
            }
        });
        getContentPane().add(oid, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 71, -1));

        progress.setForeground(new java.awt.Color(255, 153, 51));
        progress.setStringPainted(true);
        getContentPane().add(progress, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 209, -1));

        crlabel.setForeground(new java.awt.Color(255, 51, 51));
        crlabel.setText("Creating PDF for the bill...");
        getContentPane().add(crlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 156, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/dark back.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 760, 370));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rest/img/backg.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 60));

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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilActionPerformed
            bilact();
    }//GEN-LAST:event_bilActionPerformed

    private void oidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oidKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            bilact();
    }//GEN-LAST:event_oidKeyPressed

    private void oidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oidKeyTyped
        char ch=evt.getKeyChar();
        if(!(Character.isDigit(ch) || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_oidKeyTyped

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX=evt.getX();
        posY=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(getLocation().x+evt.getX()-posX,getLocation().y+evt.getY()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bil;
    private javax.swing.JLabel crlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab;
    private javax.swing.JTextField oid;
    private javax.swing.JTable ordtable;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField tot;
    // End of variables declaration//GEN-END:variables
}
