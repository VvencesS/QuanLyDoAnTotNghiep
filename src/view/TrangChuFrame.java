package view;

import java.awt.event.*;
import javax.swing.*;
import model.User;
import static view.DangNhapJFrame.checkLogin;
import static view.DangNhapJFrame.getUserName;

public class TrangChuFrame extends JFrame{
    DangNhapJFrame dangNhapJFrame;
    User user;
    public static Boolean checkAdmin = false;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JMenuBar jMenuBar1;
    private JMenu mnuDKDT;
    private JMenu mnuDeTai;
    private JMenu mnuDiem;
    private JMenu mnuGiangVien;
    private JMenu mnuLogin_Logout;
    private JMenu mnuSinhVien;
    private JMenu mnuThongTin;
    private JMenu mnuTrangChu;
    
    
    public TrangChuFrame(){
        initComponents();
        
        System.out.println("org: " + checkLogin);
        login();
        checkAdmin();
    }
    private void initComponents(){
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jMenuBar1 = new JMenuBar();
        mnuTrangChu = new JMenu();
        mnuGiangVien = new JMenu();
        mnuSinhVien = new JMenu();
        mnuDeTai = new JMenu();
        mnuDiem = new JMenu();
        mnuDKDT = new JMenu();
        mnuThongTin = new JMenu();
        mnuLogin_Logout = new JMenu();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 600));
        setLayout(null);
        setLocation(1366/5, 768/6);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setText("Chào mừng bạn đến với hệ thống quản lý đồ án tốt nghiệp sinh viên");
        jLabel1.setBounds(150, 30, 700, 20);
        add(jLabel1);

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/view/Dien_luc_U.jpg"))); 
        jLabel2.setBounds(250, 40, 500, 500);
        add(jLabel2);
        
        jLabel3.setText("Xin chào, Admin!");
        jLabel3.setBounds(760, 0, 120, 20);
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLabel3);

        mnuTrangChu.setText("Trang chủ");
        jMenuBar1.add(mnuTrangChu);

        mnuGiangVien.setText("Giảng viên");
        jMenuBar1.add(mnuGiangVien);

        mnuSinhVien.setText("Sinh viên");
        jMenuBar1.add(mnuSinhVien);

        mnuDeTai.setText("Đề tài");
        jMenuBar1.add(mnuDeTai);

        mnuDiem.setText("Điểm");
        jMenuBar1.add(mnuDiem);

        mnuDKDT.setText("Đăng ký đề tài");
        jMenuBar1.add(mnuDKDT);

        mnuThongTin.setText("Thông tin");
        jMenuBar1.add(mnuThongTin);

        mnuLogin_Logout.setText("Đăng nhập");
        jMenuBar1.add(mnuLogin_Logout);

        setJMenuBar(jMenuBar1);
        
        mnuGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuGiangVienMouseClicked(evt);
            }
        });
        mnuLogin_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuLogin_LogoutMouseClicked(evt);
            }
        });
        mnuSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSinhVienMouseClicked(evt);
            }
        });
        mnuDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDiemMouseClicked(evt);
            }
        });
        mnuDeTai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDeTaiMouseClicked(evt);
            }
        });
        mnuDKDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDKDTMouseClicked(evt);
            }
        });
        mnuThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuThongTinMouseClicked(evt);
            }
        });
    }
    private void mnuGiangVienMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        new GiangVienFrame().setVisible(true);
        this.dispose();
    }
    private void mnuLogin_LogoutMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        System.out.println("CheckLogin: " + checkLogin);
        if(checkLogin == true){
            checkLogin = false;
            login();
        }else{
            new DangNhapJFrame().f.setVisible(true);
            this.dispose();
        }
    }
    private void mnuSinhVienMouseClicked(java.awt.event.MouseEvent evt) { 
        new SinhVienFrame().f.setVisible(true);
        this.dispose();
    }
    private void mnuDiemMouseClicked(java.awt.event.MouseEvent evt) { 
        new PhanBienFrame().f.setVisible(true);
        this.dispose();
    }
    private void mnuDeTaiMouseClicked(java.awt.event.MouseEvent evt) { 
        new DeTaiFrame().f.setVisible(true);
        this.dispose();
    }
    private void mnuDKDTMouseClicked(java.awt.event.MouseEvent evt) { 
        new DangKyDeTaiFrame().f.setVisible(true);
        this.dispose();
    }
    private void mnuThongTinMouseClicked(java.awt.event.MouseEvent evt) { 
        new Lop().f.setVisible(true);
        this.dispose();
    }
    private void login(){
        
//        loginUser.setTaiKhoan(dangNhapJFrame.user.getTaiKhoan());
//        loginUser.setMatKhau(dangNhapJFrame.user.getMatKhau());
        
        if(checkLogin == true){
            mnuLogin_Logout.setText("Đăng xuất");
            
            mnuTrangChu.setEnabled(true);
            mnuGiangVien.setEnabled(true);
            mnuSinhVien.setEnabled(true);
            mnuDKDT.setEnabled(true);
            mnuDeTai.setEnabled(true);
            mnuDiem.setEnabled(true);
            mnuThongTin.setEnabled(true);
            
            dangNhapJFrame = new DangNhapJFrame();
            if(getUserName.equals("admin01")){
                checkAdmin =  true;
            }
            System.out.println("Username: " + getUserName);
            jLabel3.setText("Xin chào, " + getUserName);
            jLabel3.setVisible(true);
        }else{
            mnuLogin_Logout.setText("Đăng nhập");
            
            mnuTrangChu.setEnabled(false);
            mnuGiangVien.setEnabled(false);
            mnuSinhVien.setEnabled(false);
            mnuDKDT.setEnabled(false);
            mnuDeTai.setEnabled(false);
            mnuDiem.setEnabled(false);
            mnuThongTin.setEnabled(false);
            jLabel3.setVisible(false);
        }
    }
    private void checkAdmin(){
        
    }
    public static void main(String[] args) {
        new TrangChuFrame().setVisible(true);
    }
}
