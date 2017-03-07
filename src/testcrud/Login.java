/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author arumia
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        SignIn = new javax.swing.JButton();
        buttonSignUp = new javax.swing.JButton();
        jtPassword = new javax.swing.JTextField();
        jtUsername = new javax.swing.JTextField();
        buttonEdit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 140, 390, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 20, 380, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 70, 390, 30);

        SignIn.setText("Sign In");
        SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInActionPerformed(evt);
            }
        });
        getContentPane().add(SignIn);
        SignIn.setBounds(250, 230, 80, 30);

        buttonSignUp.setText("Sign Up");
        buttonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSignUp);
        buttonSignUp.setBounds(50, 230, 80, 30);

        jtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jtPassword);
        jtPassword.setBounds(120, 170, 150, 30);

        jtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jtUsername);
        jtUsername.setBounds(120, 100, 150, 30);

        buttonEdit1.setText("Edit");
        getContentPane().add(buttonEdit1);
        buttonEdit1.setBounds(150, 230, 80, 30);

        setBounds(0, 0, 403, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignUpActionPerformed
        
        String username = jtUsername.getText();
        String password = jtPassword.getText();
        
        try{
            try(Statement statement = (Statement) file_koneksi.GetConnection().createStatement())
            {
            statement.executeUpdate("INSERT INTO tb_akun(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat! Anda berhasil Sign Up!");
    }
        catch(Exception t)
        {
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur!");
        }
    }//GEN-LAST:event_buttonSignUpActionPerformed

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInActionPerformed
        Connection connection;
        PreparedStatement ps;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testkoneksi", "root", "");
            ps = connection.prepareStatement("SELECT username,password FROM tb_akun WHERE username = ? AND password = ? ");
            ps.setString(1, jtUsername.getText());
            ps.setString(2, jtPassword.getText());
            ResultSet result = ps.executeQuery();
            
            if(result.next())
            {
                new frmMain().show();
                this.dispose();
            }
            
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                jtPassword.setText("");
                jtUsername.requestFocus();
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, "Gagal! : "+ex);
        }
    }//GEN-LAST:event_SignInActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignIn;
    private javax.swing.JButton buttonEdit1;
    private javax.swing.JButton buttonSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jtPassword;
    private javax.swing.JTextField jtUsername;
    // End of variables declaration//GEN-END:variables
}
