/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author HIRUSHA
 */
public class Member extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public Member() {
        initComponents();
        Connect();
        load_trainer();
        table_load();
    }

     //create database connection
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
   
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymmanagement","root","2277"); //database connection
            //System.out.println("database connect successfully");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trainer.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Class not found");
        } catch (SQLException ex) {
            Logger.getLogger(Trainer.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Sql error");
        }
    }
    
    //load mamber table
    public void table_load(){
        try {
            pst = con.prepareStatement("select * from member");
            ResultSet result = pst.executeQuery();
            
            ResultSetMetaData rd = result.getMetaData();
            int columnCount;
            columnCount = rd.getColumnCount();
            df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while (result.next()){
                Vector vector = new Vector();
                
                for (int i = 1; i <= columnCount; i++){
                    vector.add(result.getString("id"));
                    vector.add(result.getString("firstname"));
                    vector.add(result.getString("lastname"));
                    vector.add(result.getString("DateOfBirth"));
                    vector.add(result.getString("mobile"));
                    vector.add(result.getString("gender"));
                    vector.add(result.getString("address"));
                    vector.add(result.getString("subscription"));
                    vector.add(result.getString("amount"));
                    vector.add(result.getString("joindate"));
                    vector.add(result.getString("trainer"));
                      
                }
                
                df.addRow(vector);// add rows to the table
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //load trainers name 
    public void load_trainer(){
        try {
            // select only the name of the trainer
            pst = con.prepareStatement("select Distinct name from trainer");
            
            ResultSet rs;
             rs = pst.executeQuery();
             
             txtTrainer.removeAllItems();
             
             while(rs.next()){
                 txtTrainer.addItem(rs.getString("name"));
             }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMemberFName = new javax.swing.JTextField();
        txtMemberLname = new javax.swing.JTextField();
        txtMemberDOB = new com.toedter.calendar.JDateChooser();
        txtMemberMobile = new javax.swing.JTextField();
        txtMemberAddress = new javax.swing.JTextField();
        txtMemberGender = new javax.swing.JComboBox<>();
        txtSubscription = new javax.swing.JComboBox<>();
        txtAmount = new javax.swing.JTextField();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        txtTrainer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTextField3.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("MEMBER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Date of Birth");

        jLabel5.setText("Mobile");

        jLabel6.setText("Gender");

        jLabel7.setText("Address");

        jLabel8.setText("Subscription");

        jLabel9.setText("Amount");

        jLabel10.setText("Start Date");

        jLabel11.setText("Trainer");

        txtMemberGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        txtSubscription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly", "3 months", "6 months", "1 year" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMemberFName)
                    .addComponent(txtMemberLname, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtMemberDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMemberMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtMemberAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtMemberGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSubscription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTrainer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMemberFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMemberLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMemberDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtMemberMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMemberGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSubscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Date of Birth", "Mobile", "Gender", "Address", "Subscription", "Amount", "Start date", "Trainer"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //add button
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String fName = txtMemberFName.getText();
        String lName = txtMemberLname.getText();
        
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        String dob = dformat.format(txtMemberDOB.getDate());
        
        String mobile = txtMemberMobile.getText();
        String gender = txtMemberGender.getSelectedItem().toString();
        String address = txtMemberAddress.getText();
        String subs = txtSubscription.getSelectedItem().toString();
        String amount = txtAmount.getText();
        String joinDate = dformat.format(txtStartDate.getDate());
        String trainer = txtTrainer.getSelectedItem().toString();
        
        
        try {
            pst = con.prepareStatement("insert into member(firstname,lastname,DateOfBirth,mobile,gender,address,subscription,amount,joindate,trainer)values(?,?,?,?,?,?,?,?,?,?)");//assign information for relavant feilds in the database
            pst.setString(1,fName);
            pst.setString(2,lName);
            pst.setString(3,dob);
            pst.setString(4,mobile);
            pst.setString(5,gender);
            pst.setString(6,address);
            pst.setString(7,subs);
            pst.setString(8,amount);
            pst.setString(9,joinDate);
            pst.setString(10,trainer);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Member added Successfully!");
            
            //after added member clear the all field
            txtMemberFName.setText("");
            txtMemberLname.setText("");
            txtMemberDOB.setDate(null);
            txtMemberMobile.setText("");
            txtMemberGender.setSelectedItem("");
            txtMemberAddress.setText("");
            txtSubscription.setSelectedItem("");
            txtAmount.setText("");
            txtStartDate.setDate(null);
            txtTrainer.setSelectedItem("");
            txtMemberFName.requestFocus();
            
            table_load();//table load
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    //cancel button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    //delete button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow(); //select the row from table to edit
    
        //that row show in the forum
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        try {
            pst = con.prepareStatement("delete from member where id = ?");//delete query
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Member Deleted Successfully!");
            
            //after added member clear the all field
            txtMemberFName.setText("");
            txtMemberLname.setText("");
            txtMemberDOB.setDate(null);
            txtMemberMobile.setText("");
            txtMemberGender.setSelectedItem("");
            txtMemberAddress.setText("");
            txtSubscription.setSelectedItem("");
            txtAmount.setText("");
            txtStartDate.setDate(null);
            txtTrainer.setSelectedItem("");
            txtMemberFName.requestFocus();
            
            table_load();//table load
            jButton1.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    //edit button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow(); //select the row from table to edit
    
        //that row show in the forum
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
         String fName = txtMemberFName.getText();
        String lName = txtMemberLname.getText();
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        String dob = dformat.format(txtMemberDOB.getDate());
        String mobile = txtMemberMobile.getText();
        String gender = txtMemberGender.getSelectedItem().toString();
        String address = txtMemberAddress.getText();
        String subs = txtSubscription.getSelectedItem().toString();
        String amount = txtAmount.getText();
        String joinDate = dformat.format(txtStartDate.getDate());
        String trainer = txtTrainer.getSelectedItem().toString();
        
        
        try {
            pst = con.prepareStatement("update member set firstname=?,lastname = ?,DateOfBirth = ?,mobile = ?,gender = ?,address = ?,subscription = ?,amount = ?,joindate = ?,trainer = ? where id = ?");//update query
            pst.setString(1,fName);
            pst.setString(2,lName);
            pst.setString(3,dob);
            pst.setString(4,mobile);
            pst.setString(5,gender);
            pst.setString(6,address);
            pst.setString(7,subs);
            pst.setString(8,amount);
            pst.setString(9,joinDate);
            pst.setString(10,trainer);
            pst.setInt(11, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Member Updated Successfully!");
            
            //after added member clear the all field
            txtMemberFName.setText("");
            txtMemberLname.setText("");
            txtMemberDOB.setDate(null);
            txtMemberMobile.setText("");
            txtMemberGender.setSelectedItem("");
            txtMemberAddress.setText("");
            txtSubscription.setSelectedItem("");
            txtAmount.setText("");
            txtStartDate.setDate(null);
            txtTrainer.setSelectedItem("");
            txtMemberFName.requestFocus();
            
            table_load();//table load
            jButton1.setEnabled(false);
            
        } catch (SQLException ex) {
            Logger.getLogger(Trainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    //select to edit
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow(); //select the row from table to edit
     try {
        //that row show in the forum
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
         
        txtMemberFName.setText(df.getValueAt(selected, 1).toString());
        txtMemberLname.setText(df.getValueAt(selected, 2).toString());
        
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse((String)df.getValueAt(selected, 3));
        
        txtMemberDOB.setDate(date);
        
        txtMemberMobile.setText(df.getValueAt(selected, 4).toString());
        txtMemberGender.setSelectedItem(df.getValueAt(selected, 5).toString());
        txtMemberAddress.setText(df.getValueAt(selected, 6).toString());
        txtSubscription.setSelectedItem(df.getValueAt(selected, 7).toString());
        txtAmount.setText(df.getValueAt(selected, 8).toString());
        Date StartDate;
       
            StartDate = new SimpleDateFormat("yyyy-mm-dd").parse((String)df.getValueAt(selected, 9));
        
        
        txtStartDate.setDate(StartDate);
        txtTrainer.setSelectedItem(df.getValueAt(selected, 10).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton1.setEnabled(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtMemberAddress;
    private com.toedter.calendar.JDateChooser txtMemberDOB;
    private javax.swing.JTextField txtMemberFName;
    private javax.swing.JComboBox<String> txtMemberGender;
    private javax.swing.JTextField txtMemberLname;
    private javax.swing.JTextField txtMemberMobile;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JComboBox<String> txtSubscription;
    private javax.swing.JComboBox<String> txtTrainer;
    // End of variables declaration//GEN-END:variables
}
