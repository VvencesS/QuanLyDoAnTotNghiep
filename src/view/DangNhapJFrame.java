package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.User;
import query.JDBCConnection;

public class DangNhapJFrame {
    public static Boolean checkLogin = false;
    public static Boolean checkRememberPass = false;
    public static String getUserName;
    public static String getPassword;
    User user;
    JFrame f;
    JLabel lbTaiKhoan, lbMatKhau, lbLoi, lblTitle;
    JTextField txtTaiKhoa;
    JPasswordField txtMatKhau;
    JButton btnDangNhap, btnThoat;
    JCheckBox cbxNhoMK;

    public DangNhapJFrame() {
        user = new User();
        
        f = new JFrame("Đăng nhập");
        
        lblTitle = new JLabel("Đăng nhập");
        lblTitle.setBounds(200, 20, 200, 50);
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 25));
        
        lbTaiKhoan = new JLabel("Tài khoản: ");
        lbTaiKhoan.setBounds(36, 92, 98, 24);
        
        lbMatKhau = new JLabel("Mật khẩu: ");
        lbMatKhau.setBounds(36, 149, 91, 24);
        
        txtTaiKhoa = new JTextField();
        txtTaiKhoa.setBounds(154, 89, 267, 29);
        
        txtMatKhau = new JPasswordField();
        txtMatKhau.setBounds(154, 149, 267, 29);
        
        lbLoi = new JLabel("");
        lbLoi.setBounds(154, 175, 200, 20);
        lbLoi.setForeground(new java.awt.Color(255, 0, 0));
        lbLoi.setFont(new java.awt.Font("Tahoma", 0, 10));
        
        cbxNhoMK = new JCheckBox("Nhớ mật khẩu");
        cbxNhoMK.setBounds(154, 195, 100, 20);
        cbxNhoMK.setFont(new java.awt.Font("Tahoma", 0, 10));
        
        btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setBounds(154, 220, 112, 46);
        
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(309, 220, 112, 46);

        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTaiKhoa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền Tài khoản");
                } else if (txtMatKhau.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền Mật khẩu");
                } else {
                    nhoMatKhau();
                    rememberPass();
                    getLogInUser();
                    try {
                        
                        String sql = "SELECT * FROM tblUser WHERE TaiKhoan = ? AND MatKhau = ?";
                        PreparedStatement pStt = JDBCConnection.getJDBCConnection().prepareStatement(sql);
                        pStt.setString(1, txtTaiKhoa.getText());
                        pStt.setString(2, txtMatKhau.getText());
                        
                        ResultSet rs = pStt.executeQuery();
                        if (rs.next()) {
                            changeCheckLogin();
                            new TrangChuFrame().setVisible(true);
                        } else {
                            lbLoi.setText("Tên tài khoản hoặc mật khẩu không đúng!");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Lỗi: " + ex.toString());
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrangChuFrame().setVisible(true);
                f.dispose();
            }
        });
        cbxNhoMK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbxNhoMK.isSelected()){
                    checkRememberPass = true;
                }else{
                    checkRememberPass = false;
                }
            }
        });

        f.setSize(500, 350);
        f.add(lblTitle);
        f.add(lbTaiKhoan);
        f.add(lbMatKhau);
        f.add(txtTaiKhoa);
        f.add(txtMatKhau);
        f.add(lbLoi);
        f.add(cbxNhoMK);
        f.add(btnDangNhap);
        f.add(btnThoat);
        f.add(txtMatKhau);
        f.setLayout(null);
        f.setVisible(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(1366/5, 768/6);
    }
    public void nhoMatKhau(){
        user.setTaiKhoan(txtTaiKhoa.getText());
        user.setMatKhau(txtMatKhau.getText());
        System.out.println("remember username: " + user.getTaiKhoan());
        System.out.println("remember password:" + user.getMatKhau());
    }
    public void rememberPass(){
       
        if(checkRememberPass == true){
            txtTaiKhoa.setText(user.getTaiKhoan());
            txtMatKhau.setText(user.getMatKhau());
        }
    }
    private void changeCheckLogin(){
        checkLogin = true;
    }
    public void getLogInUser(){
        getUserName = txtTaiKhoa.getText();
        getPassword = txtMatKhau.getText();
    }
}
