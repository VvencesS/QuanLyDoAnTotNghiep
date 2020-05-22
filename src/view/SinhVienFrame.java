package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.Khoa;
import model.KhoaManager;
import model.LopComboBox;
import model.LopManager;
import model.SinhVien;
import service.SinhVienService;
import static view.TrangChuFrame.checkAdmin;


public class SinhVienFrame {
    SinhVienService sinhVienService;
    DefaultTableModel defaultTableModel;
    SinhVien sinhVien;
    String tenKhoa;
    String tenLop;
    
    JFrame f;
    JLabel lbTimKiem;
    JTextField txtTimKiem;
    JButton btnTimKiem;
    JPanel pTTSinhVien, pChucNang;
    JLabel lbMaSinhVien;
    JLabel lbTenSinhVien;
    JLabel lbGioiTinh;
    JLabel lbNamSinh;
    JLabel lbEmail;
    JLabel lbSDT;
    JLabel lbDiaChi;
    JLabel lbLop;
    JLabel lbKhoa;
    JTextField txtMaSinhVien;
    JTextField txtTenSinhVien;
    ButtonGroup btngGioiTinh;
    JRadioButton rbtnNu;
    JRadioButton tbtnNam;
    JFormattedTextField ftxtfNamSinh;
    JTextField txtEmail;
    JTextField txtSDT;
    JTextField txtDiaChi;
    JComboBox<String> cbKhoa;
    JComboBox<String> cbLop;
    JButton btnXem;
    JButton btnThem;
    JButton btnSua;
    JButton btnXoa;
    JButton btnThoat;
    JTable tblSinhVien;
    JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9;
    
    public SinhVienFrame(){
        f=new JFrame("Sinh Viên");
        lbTimKiem =new JLabel("Tên sinh viên:");
        txtTimKiem =new JTextField();
        btnTimKiem=new JButton("Tìm Kiếm");
        pChucNang=new JPanel();
        pTTSinhVien = new JPanel();
        lbMaSinhVien =new JLabel("Mã sinh viên:");
        lbTenSinhVien =new JLabel("Tên sinh viên:");
        lbGioiTinh =new JLabel("Giới tính:");
        lbNamSinh =new JLabel("Năm sinh:");
        lbEmail =new JLabel("Email:");
        lbSDT =new JLabel("Số điện thoại:");
        lbDiaChi =new JLabel("Địa chỉ:");
        lbLop =new JLabel("Lớp:");
        lbKhoa =new JLabel("Khoa:");
        
        txtMaSinhVien =new JTextField();
        txtTenSinhVien =new JTextField();
        btngGioiTinh = new ButtonGroup();
        tbtnNam = new JRadioButton();
        rbtnNu = new JRadioButton();
        ftxtfNamSinh =new JFormattedTextField();
        txtEmail =new JTextField();
        txtSDT =new JTextField();
        txtDiaChi =new JTextField();
        cbLop=new JComboBox<>();
        cbKhoa=new JComboBox<>();
        
        btnXem=new JButton("Xem");
        btnThem=new JButton("Thêm");
        btnSua=new JButton("Sửa");
        btnXoa=new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        
        tblSinhVien =new JTable();
        
        f.setLayout(null);
        f.setSize(900,600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        pChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        pChucNang.setBounds(40, 5, 800,55);
        pChucNang.setLayout(null);
        f.add(pChucNang);
        
        lbTimKiem.setBounds(10, 15, 100, 25);
        pChucNang.add(lbTimKiem);
        txtTimKiem.setBounds(100, 15, 170, 23);
        pChucNang.add(txtTimKiem);
        btnTimKiem.setBounds(280,15,90,23);
        pChucNang.add(btnTimKiem);
        
        btnXoa.setBounds(600,15,70,23);
        pChucNang.add(btnXoa);
        btnSua.setBounds(525,15,70,23);
        pChucNang.add(btnSua);
        btnThem.setBounds(450,15,70,23);
        pChucNang.add(btnThem);
        btnXem.setBounds(375,15,70,23);
        pChucNang.add(btnXem);
        btnThoat.setBounds(675, 15, 70, 23);
        pChucNang.add(btnThoat);
        
        pTTSinhVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Sinh Viên"));
        pTTSinhVien.setBounds(40, 80, 800,180);
        pTTSinhVien.setLayout(null);
        f.add(pTTSinhVien);
        
        lbMaSinhVien.setBounds(10, 20,80, 23);
        pTTSinhVien.add(lbMaSinhVien);
        lbTenSinhVien.setBounds(10, 50,100, 23);
        pTTSinhVien.add(lbTenSinhVien);
        lbGioiTinh.setBounds(10, 80,70, 23);
        pTTSinhVien.add(lbGioiTinh);
        lbNamSinh.setBounds(10, 110,70, 23);
        pTTSinhVien.add(lbNamSinh);
        lbEmail.setBounds(10, 140,70, 23);
        pTTSinhVien.add(lbEmail);
        lbSDT.setBounds(350,20,150, 23);
        pTTSinhVien.add(lbSDT);
        lbDiaChi.setBounds(350, 50,70, 23);
        pTTSinhVien.add(lbDiaChi);
        lbLop.setBounds(350, 80,70, 23);
        pTTSinhVien.add(lbLop);
        lbKhoa.setBounds(350,110,70,23);
        pTTSinhVien.add(lbKhoa);
        
        txtMaSinhVien.setBounds(140,20,170,23);
        pTTSinhVien.add(txtMaSinhVien);
        txtTenSinhVien.setBounds(140,50,170,23);
        pTTSinhVien.add(txtTenSinhVien);
        btngGioiTinh.add(tbtnNam);
        tbtnNam.setText("Nam");
        tbtnNam.setBounds(140, 80, 50, 23);
        tbtnNam.setFont(new java.awt.Font("Tahoma", 0, 10));
        pTTSinhVien.add(tbtnNam);
        btngGioiTinh.add(rbtnNu);
        rbtnNu.setText("Nữ");
        rbtnNu.setBounds(200, 80, 50, 23);
        rbtnNu.setFont(new java.awt.Font("Tahoma", 0, 10));
        pTTSinhVien.add(rbtnNu);
        ftxtfNamSinh.setText("");
        ftxtfNamSinh.setBounds(140,110,170,23);
        ftxtfNamSinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        pTTSinhVien.add(ftxtfNamSinh);
        txtEmail.setBounds(140,140,170,23);
        pTTSinhVien.add(txtEmail);
        txtSDT.setBounds(490,20,170,23);
        pTTSinhVien.add(txtSDT);
        txtDiaChi.setBounds(490,50,170,23);
        pTTSinhVien.add(txtDiaChi);
        cbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lop" }));
        cbLop.setBounds(490,80,170,23);
        pTTSinhVien.add(cbLop);
        cbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "khoa" }));
        cbKhoa.setBounds(490,110,170,23);
        pTTSinhVien.add(cbKhoa);
        
        tblSinhVien.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "TenSV", "GioiTinh", "NgaySinh", "Email", "SoDT", "DiaChi", "Lop", "Khoa"
            }
        ));
        tblSinhVien.setBounds(40, 300, 800, 250);
        tblSinhVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        f.setLocation(1366/5, 768/6);
        f.add(tblSinhVien);
        
        jButton1 = new JButton("Mã SV");
        jButton1.setBounds(40, 275, 89, 25);
        jButton1.setBackground(Color.white);
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton1);
        jButton2 = new JButton("Tên SV");
        jButton2.setBounds(128, 275, 90, 25);
        jButton2.setBackground(Color.white);
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton2);
        jButton3 = new JButton("Giới tính");
        jButton3.setBounds(217, 275, 90, 25);
        jButton3.setBackground(Color.white);
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton3);
        jButton4 = new JButton("Ngày sinh");
        jButton4.setBounds(306, 275, 90, 25);
        jButton4.setBackground(Color.white);
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton4);
        jButton5 = new JButton("Email");
        jButton5.setBounds(395, 275, 90, 25);
        jButton5.setBackground(Color.white);
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton5);
        jButton6 = new JButton("SDT");
        jButton6.setBounds(484, 275, 90, 25);
        jButton6.setBackground(Color.white);
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton6);
        jButton7 = new JButton("Địa chỉ");
        jButton7.setBounds(573, 275, 90, 25);
        jButton7.setBackground(Color.white);
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton7);
        jButton8 = new JButton("Lớp");
        jButton8.setBounds(662, 275, 90, 25);
        jButton8.setBackground(Color.white);
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton8);
        jButton9 = new JButton("Khoa");
        jButton9.setBounds(751, 275, 89, 25);
        jButton9.setBackground(Color.white);
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 10));
        f.add(jButton9);
        
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        tblSinhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSinhVienKeyReleased(evt);
            }
        });
        
        loadData();
        loadKhoa();
        loadLop();
        _checkAdmin();
    }
    private void loadData(){
        sinhVienService = new SinhVienService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tblSinhVien.setModel(defaultTableModel);
        defaultTableModel.addColumn("MaSV");
        defaultTableModel.addColumn("TenSV");
        defaultTableModel.addColumn("GioiTinh");
        defaultTableModel.addColumn("NgaySinh");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SoDT");
        defaultTableModel.addColumn("DiaChi");
        defaultTableModel.addColumn("Lop");
        defaultTableModel.addColumn("Khoa");
        
        setTableData(sinhVienService.getAllSinhViens());
    }
    private void setTableData(List<SinhVien> sinhViens){
        for(SinhVien sinhVien : sinhViens){
            defaultTableModel.addRow(new Object[]{sinhVien.getMaSV(), sinhVien.getTenSV(), sinhVien.getGioiTinh()
                    ,sinhVien.getNgaySinh(), sinhVien.getEmail(), sinhVien.getSoDT(), sinhVien.getDiaChi(), 
                    sinhVien.getLop(), sinhVien.getKhoa()});
        }
    }
    private void loadKhoa(){
        KhoaManager km = new KhoaManager();
        
        List<Khoa> lstKhoa = km.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Khoa khoa : lstKhoa) {
            dcbm.addElement(khoa);
        }
        cbKhoa.setModel(dcbm);
    }
    private void loadLop(){
        LopManager lm = new LopManager();
        
        List<LopComboBox> lstLopComboBox = lm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (LopComboBox lopComboBox : lstLopComboBox) {
            dcbm.addElement(lopComboBox);
            System.out.println("Set combobox: " + lopComboBox.getMaLop());
            System.out.println("Set combobox: " + lopComboBox.getTenlop());
        }
        cbLop.setModel(dcbm);
        
    }
    private void refreshData(){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(sinhVienService.getAllSinhViens());
    }
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) { 
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(sinhVienService.getAllSinhViens());
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt){
        sinhVien = new SinhVien();
        loadKhoa();
        loadLop();
        
        sinhVien.setMaSV(txtMaSinhVien.getText());
        sinhVien.setTenSV(txtTenSinhVien.getText());
        String gioiTinh = "";
        if(tbtnNam.isSelected()){
            gioiTinh = "Nam";
        }
        if(rbtnNu.isSelected()){
            gioiTinh = "Nữ";
        }
        sinhVien.setGioiTinh(gioiTinh);
        sinhVien.setNgaySinh(ftxtfNamSinh.getText());
        sinhVien.setEmail(txtEmail.getText());
        sinhVien.setSoDT(txtSDT.getText());
        sinhVien.setDiaChi(txtDiaChi.getText());
        
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        
        System.out.println("Ten khoa: " + tenKhoa);
        for(Khoa khoa  : khoas){
            if(khoa.getTenKhoa().equals(tenKhoa)){
                System.out.println("Gia tri Makhoa lay ra: " + khoa.getMaKhoa());
                sinhVien.setKhoa(khoa.getMaKhoa());
            }
        }
        LopManager lm = new LopManager();
        List<LopComboBox> lopComboBoxs = lm.read();
        
        System.out.println("Ten lop: " + tenLop);
        for(LopComboBox lopComboBox  : lopComboBoxs){
            if(lopComboBox.getTenlop().equals(tenLop)){
                System.out.println("Gia tri MaLop lay ra: " + lopComboBox.getMaLop());
                sinhVien.setLop(lopComboBox.getMaLop());
            }
        }
        
        sinhVienService.addSinhVien(sinhVien);
        refreshData();
        loadData();
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt){
        sinhVien = new SinhVien();
        loadKhoa();
        loadLop();
        
        sinhVien.setMaSV(txtMaSinhVien.getText());
        sinhVien.setTenSV(txtTenSinhVien.getText());
        String gioiTinh = "";
        if(tbtnNam.isSelected()){
            gioiTinh = "Nam";
        }
        if(rbtnNu.isSelected()){
            gioiTinh = "Nữ";
        }
        sinhVien.setGioiTinh(gioiTinh);
        sinhVien.setNgaySinh(ftxtfNamSinh.getText());
        sinhVien.setEmail(txtEmail.getText());
        sinhVien.setSoDT(txtSDT.getText());
        sinhVien.setDiaChi(txtDiaChi.getText());
        
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        
        System.out.println("Ten khoa: " + tenKhoa);
        for(Khoa khoa  : khoas){
            if(khoa.getTenKhoa().equals(tenKhoa)){
                System.out.println("Gia tri Makhoa lay ra: " + khoa.getMaKhoa());
                sinhVien.setKhoa(khoa.getMaKhoa());
            }
        }
        LopManager lm = new LopManager();
        List<LopComboBox> lopComboBoxs = lm.read();
        
        System.out.println("Ten lop: " + tenLop);
        for(LopComboBox lopComboBox  : lopComboBoxs){
            if(lopComboBox.getTenlop().equals(tenLop)){
                System.out.println("Gia tri MaLop lay ra: " + lopComboBox.getMaLop());
                sinhVien.setLop(lopComboBox.getMaLop());
            }
        }
        
        sinhVienService.updateSinhVien(sinhVien);
        refreshData();
        loadData();
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt){
        int row = tblSinhVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Giảng viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String maSV = String.valueOf(tblSinhVien.getValueAt(row, 0));
                
                sinhVienService.deleteSinhVien(maSV);
                defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(sinhVienService.getAllSinhViens());
            }
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.f.dispose();
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(sinhVienService.searchSinhVien(txtTimKiem.getText()));
    }
    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt){
        tenKhoa = String.valueOf(cbKhoa.getSelectedItem());
    }
    private void cbLopActionPerformed(java.awt.event.ActionEvent evt){
        tenLop = String.valueOf(cbLop.getSelectedItem());
    }
    private void _getSinhVienById(String id){
        loadKhoa();
        loadLop();
        sinhVienService = new SinhVienService();
        sinhVien = sinhVienService.getSinhVienById(id);
        
        txtMaSinhVien.setText(sinhVien.getMaSV());
        txtTenSinhVien.setText(sinhVien.getTenSV());
        if((sinhVien.getGioiTinh()).equals("Nam")){
            tbtnNam.setSelected(true);
        }
        if((sinhVien.getGioiTinh()).equals("Nữ")){
            rbtnNu.setSelected(true);
        }
        ftxtfNamSinh.setText(sinhVien.getNgaySinh());
        txtEmail.setText(sinhVien.getEmail());
        txtSDT.setText(sinhVien.getSoDT());
        txtDiaChi.setText(sinhVien.getDiaChi());
        
        String maKhoa = String.valueOf(cbKhoa.getSelectedItem());
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        System.out.println("Ten khoa: " + maKhoa);
        for(Khoa khoa  : khoas){
            if(khoa.getMaKhoa().equals(maKhoa)){
                System.out.println("Gia tri Makhoa lay ra: " + khoa.getMaKhoa());
                sinhVien.setKhoa(khoa.getTenKhoa());
            }
        }
        String maLop = String.valueOf(cbLop.getSelectedItem());
        LopManager lm = new LopManager();
        List<LopComboBox> lopComboBoxs = lm.read();
        System.out.println("Ten lop: " + maLop);
        for(LopComboBox lopComboBox  : lopComboBoxs){
            if(lopComboBox.getMaLop().equals(maLop)){
                System.out.println("Gia tri MaLop lay ra: " + lopComboBox.getMaLop());
                sinhVien.setLop(lopComboBox.getTenlop());
            }
        }
    }
    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int row = tblSinhVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Giảng viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String maSV = String.valueOf(tblSinhVien.getValueAt(row, 0));
            _getSinhVienById(maSV);
        }
    } 
    private void tblSinhVienKeyReleased(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int row = tblSinhVien.getSelectedRow();
            String maSV = String.valueOf(tblSinhVien.getValueAt(row, 0));
            _getSinhVienById(maSV);
        }
    } 
    private void _checkAdmin(){
        if(checkAdmin == false){
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
        }else{
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }
    
    public static void main(String[] args) {
        new SinhVienFrame().f.setVisible(true);;
    }

}
