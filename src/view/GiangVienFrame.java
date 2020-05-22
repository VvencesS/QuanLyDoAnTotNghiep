package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.GiangVien;
import model.Khoa;
import model.KhoaManager;
import service.GiangVienService;
import static view.TrangChuFrame.checkAdmin;

public class GiangVienFrame extends JFrame{
    GiangVienService giangVienService;
    DefaultTableModel defaultTableModel;
    GiangVien giangVien;
    String tenKhoa;
    
    private JButton btnHienThi;
    private JButton btnSua;
    private JButton btnThem;
    private JButton btnTimKiem;
    private JButton btnXoa;
    private JButton btnThoat;
    private ButtonGroup btngGioiTinh;
    private JComboBox<String> cbxKhoa;
    private JFormattedTextField ftxtfNamSinh;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable tblGiangVien;
    private JRadioButton rbtnNu;
    private JRadioButton tbtnNam;
    private JTextField txtfChucVu;
    private JTextField txtfDiaChi;
    private JTextField txtfEmail;
    private JTextField txtfHocVi;
    private JTextField txtfMaGV;
    private JTextField txtfSDT;
    private JTextField txtfTenGV;
    private JTextField txtfTimKiemTenGV;
    JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9,jButton10;
    
    public GiangVienFrame(){
        initComponents();
        loadData();
        loadKhoa();
        System.out.println("checkAdmin: " + checkAdmin);
        _checkAdmin();
    }
    private void loadData(){
        giangVienService = new GiangVienService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tblGiangVien.setModel(defaultTableModel);
        defaultTableModel.addColumn("MaGV");
        defaultTableModel.addColumn("TenGV");
        defaultTableModel.addColumn("GioiTinh");
        defaultTableModel.addColumn("NgaySinh");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SoDT");
        defaultTableModel.addColumn("DiaChi");
        defaultTableModel.addColumn("HocVi");
        defaultTableModel.addColumn("ChucVu");
        defaultTableModel.addColumn("idKhoa");
        
        setTableData(giangVienService.getAllGiangViens());
    }
    private void loadKhoa(){
        KhoaManager km = new KhoaManager();
        
        List<Khoa> lstKhoa = km.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (Khoa khoa : lstKhoa) {
            dcbm.addElement(khoa);
        }
        cbxKhoa.setModel(dcbm);
    }
    private void initComponents(){
        btngGioiTinh = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        txtfTimKiemTenGV = new JTextField();
        btnTimKiem = new JButton();
        btnHienThi = new JButton();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnThoat = new JButton();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtfSDT = new JTextField();
        tbtnNam = new JRadioButton();
        rbtnNu = new JRadioButton();
        txtfTenGV = new JTextField();
        txtfMaGV = new JTextField();
        jLabel7 = new JLabel();
        txtfEmail = new JTextField();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txtfDiaChi = new JTextField();
        txtfHocVi = new JTextField();
        jLabel10 = new JLabel();
        txtfChucVu = new JTextField();
        jLabel11 = new JLabel();
        cbxKhoa = new JComboBox<>();
        ftxtfNamSinh = new JFormattedTextField();
        jScrollPane1 = new JScrollPane(tblGiangVien);
        tblGiangVien = new JTable();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 600));
        setLayout(null);
        setLocation(1366/5, 768/6);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        jPanel1.setBounds(0, 0, 885, 50);
        jPanel1.setLayout(null);
        jPanel1.setVisible(true);
        jPanel1.add(jLabel1);
        jPanel1.add(txtfTimKiemTenGV);
        jPanel1.add(btnTimKiem);
        jPanel1.add(btnHienThi);
        jPanel1.add(btnThem);
        jPanel1.add(btnSua);
        jPanel1.add(btnXoa);
        jPanel1.add(btnThoat);
        add(jPanel1);

        jLabel1.setText("Nhập tên giảng viên:");
        jLabel1.setBounds(10, 20, 100, 20);
        //jLabel1.setBorder(BorderFactory.createEtchedBorder());
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        
        txtfTimKiemTenGV.setText("");
        txtfTimKiemTenGV.setBounds(120, 20, 200, 20);
        
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBounds(330, 20, 75, 20);
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 11));
        
        btnHienThi.setText("Hiển thị");
        btnHienThi.setBounds(450, 20, 75, 20);
        btnHienThi.setFont(new java.awt.Font("Tahoma", 0, 11));
        
        btnThem.setText("Thêm");
        btnThem.setBounds(535, 20, 75, 20);
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 11));

        btnSua.setText("Sửa");
        btnSua.setBounds(620, 20, 75, 20);
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 11));

        btnXoa.setText("Xóa");
        btnXoa.setBounds(705, 20, 75, 20);
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 11));
        
        btnThoat.setText("Thoát");
        btnThoat.setBounds(790, 20, 75, 20);
        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 11));
        
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin giảng viên"));
        jPanel2.setBounds(0, 50, 885, 200);
        jPanel2.setLayout(null);
        jPanel2.setVisible(true);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel4);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel7);
        jPanel2.add(jLabel8);
        jPanel2.add(jLabel9);
        jPanel2.add(jLabel10);
        jPanel2.add(jLabel11);
        jPanel2.add(txtfSDT);
        jPanel2.add(tbtnNam);
        jPanel2.add(rbtnNu);
        jPanel2.add(txtfTenGV);
        jPanel2.add(txtfMaGV);
        jPanel2.add(txtfEmail);
        jPanel2.add(txtfDiaChi);
        jPanel2.add(txtfHocVi);
        jPanel2.add(txtfChucVu);
        jPanel2.add(cbxKhoa);
        jPanel2.add(ftxtfNamSinh);
        jPanel2.add(ftxtfNamSinh);
        add(jPanel2);
        
        jLabel2.setText("Mã giảng viên:");
        jLabel2.setBounds(10, 20, 75, 20);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel3.setText("Tên giảng viên:");
        jLabel3.setBounds(10, 50, 75, 20);
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel4.setText("Giới tính:");
        jLabel4.setBounds(10, 80, 75, 20);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel5.setText("Năm sinh:");
        jLabel5.setBounds(10, 110, 75, 20);
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel6.setText("Số điện thoại:");
        jLabel6.setBounds(10, 140, 75, 20);
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtfSDT.setText("");
        txtfSDT.setBounds(120, 140, 200, 20);

        btngGioiTinh.add(tbtnNam);
        tbtnNam.setText("Nam");
        tbtnNam.setBounds(120, 80, 50, 20);
        tbtnNam.setFont(new java.awt.Font("Tahoma", 0, 10));

        btngGioiTinh.add(rbtnNu);
        rbtnNu.setText("Nữ");
        rbtnNu.setBounds(180, 80, 50, 20);
        rbtnNu.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtfTenGV.setText("");
        txtfTenGV.setBounds(120, 50, 200, 20);

        txtfMaGV.setText("");
        txtfMaGV.setBounds(120, 20, 200, 20);
        
        ftxtfNamSinh.setText("");
        ftxtfNamSinh.setBounds(120, 110, 200, 20);
        ftxtfNamSinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        
        jLabel7.setText("Email:");
        jLabel7.setBounds(500, 20, 75, 20);
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtfEmail.setText("");
        txtfEmail.setBounds(600, 20, 200, 20);
        
        jLabel8.setText("Địa chỉ:");
        jLabel8.setBounds(500, 50, 75, 20);
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel9.setText("Học vị:");
        jLabel9.setBounds(500, 80, 75, 20);
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtfDiaChi.setText("");
        txtfDiaChi.setBounds(600, 50, 200, 20);

        txtfHocVi.setText("");
        txtfHocVi.setBounds(600, 80, 200, 20);

        jLabel10.setText("Chức vụ:");
        jLabel10.setBounds(500, 110, 75, 20);
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtfChucVu.setText("");
        txtfChucVu.setBounds(600, 110, 200, 20);

        jLabel11.setText("Khoa:");
        jLabel11.setBounds(500, 140, 75, 20);
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10));

        //cbxKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "khoa" }));
        cbxKhoa.setBounds(600, 140, 200, 20);
        cbxKhoa.setFont(new java.awt.Font("Tahoma", 0, 10));
        
        jButton1 = new JButton("Mã GV");
        jButton1.setBounds(5, 265, 88, 25);
        jButton1.setBackground(Color.white);
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton1);
        jButton2 = new JButton("Tên GV");
        jButton2.setBounds(92, 265, 88, 25);
        jButton2.setBackground(Color.white);
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton2);
        jButton3 = new JButton("Giới tính");
        jButton3.setBounds(179, 265, 89, 25);
        jButton3.setBackground(Color.white);
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton3);
        jButton4 = new JButton("Ngày sinh");
        jButton4.setBounds(267, 265, 88, 25);
        jButton4.setBackground(Color.white);
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton4);
        jButton5 = new JButton("Email");
        jButton5.setBounds(354, 265, 89, 25);
        jButton5.setBackground(Color.white);
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton5);
        jButton6 = new JButton("SDT");
        jButton6.setBounds(442, 265, 88, 25);
        jButton6.setBackground(Color.white);
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton6);
        jButton7 = new JButton("Dịa chỉ");
        jButton7.setBounds(529, 265, 89, 25);
        jButton7.setBackground(Color.white);
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton7);
        jButton8 = new JButton("Học vị");
        jButton8.setBounds(617, 265, 88, 25);
        jButton8.setBackground(Color.white);
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton8);
        jButton9 = new JButton("Học vị");
        jButton9.setBounds(704, 265, 89, 25);
        jButton9.setBackground(Color.white);
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton9);
        jButton10 = new JButton("Khoa");
        jButton10.setBounds(792, 265, 88, 25);
        jButton10.setBackground(Color.white);
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 10));
        add(jButton10);
        
        tblGiangVien.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaGV", "TenGV", "GioiTinh", "NgaySinh", "Email", "SoDT", "DiaChi", "HocVi", "ChucVu", "idKhoa"
            }
        ));
        tblGiangVien.setBounds(5, 290, 875, 260);
        tblGiangVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblGiangVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jScrollPane1.setViewportView(tblGiangVien);
        add(jScrollPane1);
        add(tblGiangVien);
        
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
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
        cbxKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKhoaActionPerformed(evt);
            }
        });
        tblGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiangVienMouseClicked(evt);
            }
        });
        tblGiangVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblGiangVienKeyReleased(evt);
            }
        });
    }
    private void setTableData(List<GiangVien> giangViens){
        for(GiangVien giangVien : giangViens){
            defaultTableModel.addRow(new Object[]{giangVien.getMaGV(), giangVien.getTenGV(), giangVien.getGioiTinh()
                    ,giangVien.getNgaySinh(), giangVien.getEmail(), giangVien.getSoDT(), giangVien.getDiaChi(), 
                    giangVien.getHocVi(), giangVien.getChucVu(), giangVien.getIdKhoa()});
        }
    }
    private void refreshData(){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(giangVienService.getAllGiangViens());
    }
    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) { 
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(giangVienService.getAllGiangViens());
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt){
        giangVien = new GiangVien();
        loadKhoa();
        
        giangVien.setMaGV(txtfMaGV.getText());
        giangVien.setTenGV(txtfTenGV.getText());
        String gioiTinh = "";
        if(tbtnNam.isSelected()){
            gioiTinh = "Nam";
        }
        if(rbtnNu.isSelected()){
            gioiTinh = "Nữ";
        }
        giangVien.setGioiTinh(gioiTinh);
        giangVien.setNgaySinh(ftxtfNamSinh.getText());
        giangVien.setEmail(txtfEmail.getText());
        giangVien.setSoDT(txtfSDT.getText());
        giangVien.setDiaChi(txtfDiaChi.getText());
        giangVien.setHocVi(txtfHocVi.getText());
        giangVien.setChucVu(txtfChucVu.getText());
        
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        
        System.out.println("Ten khoa chon: " + tenKhoa);
        for(Khoa khoa  : khoas){
            if(khoa.getTenKhoa().equals(tenKhoa)){
                System.out.println("Gia tri Makhoa lay ra: " + khoa.getMaKhoa());
                giangVien.setIdKhoa(khoa.getMaKhoa());
            }
        }
        
        giangVienService.addGiangVien(giangVien);
        refreshData();
        loadData();
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt){
        giangVien = new GiangVien();
        loadKhoa();
        
        giangVien.setMaGV(txtfMaGV.getText());
        giangVien.setTenGV(txtfTenGV.getText());
        String gioiTinh = "";
        if(tbtnNam.isSelected()){
            gioiTinh = "Nam";
        }
        if(rbtnNu.isSelected()){
            gioiTinh = "Nữ";
        }
        giangVien.setGioiTinh(gioiTinh);
        giangVien.setNgaySinh(ftxtfNamSinh.getText());
        giangVien.setEmail(txtfEmail.getText());
        giangVien.setSoDT(txtfSDT.getText());
        giangVien.setDiaChi(txtfDiaChi.getText());
        giangVien.setHocVi(txtfHocVi.getText());
        giangVien.setChucVu(txtfChucVu.getText());
        
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        
        System.out.println("Ten khoa: " + tenKhoa);
        for(Khoa khoa  : khoas){
            if(khoa.getTenKhoa().equals(tenKhoa)){
                System.out.println("Gia tri Makhoa lay ra: " + khoa.getMaKhoa());
                giangVien.setIdKhoa(khoa.getMaKhoa());
            }
        }
        
        giangVienService.updateGiangVien(giangVien);
        refreshData();
        loadData();
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt){
        int row = tblGiangVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn Giảng viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String maGV = String.valueOf(tblGiangVien.getValueAt(row, 0));
                
                giangVienService.deleteGiangVien(maGV);
                defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(giangVienService.getAllGiangViens());
            }
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.dispose();
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(giangVienService.searchGiangVien(txtfTimKiemTenGV.getText()));
    }
    private void cbxKhoaActionPerformed(java.awt.event.ActionEvent evt){
        tenKhoa = String.valueOf(cbxKhoa.getSelectedItem());
    }
    private void _getGiangVienById(String id){
        loadKhoa();
        giangVienService = new GiangVienService();
        giangVien = giangVienService.getGiangVienById(id);
        
        txtfMaGV.setText(giangVien.getMaGV());
        txtfTenGV.setText(giangVien.getTenGV());
        if((giangVien.getGioiTinh()).equals("Nam")){
            tbtnNam.setSelected(true);
        }
        if((giangVien.getGioiTinh()).equals("Nữ")){
            rbtnNu.setSelected(true);
        }
        ftxtfNamSinh.setText(giangVien.getNgaySinh());
        txtfEmail.setText(giangVien.getEmail());
        txtfSDT.setText(giangVien.getSoDT());
        txtfDiaChi.setText(giangVien.getDiaChi());
        txtfHocVi.setText(giangVien.getHocVi());
        txtfChucVu.setText(giangVien.getChucVu());
        
        String tenKhoa = giangVien.getIdKhoa();
        KhoaManager km = new KhoaManager();
        List<Khoa> khoas = km.read();
        cbxKhoa.setSelectedItem(tenKhoa);
        System.out.println("Ten khoa: " + tenKhoa);
//        for(Khoa khoa  : khoas){
//            System.out.println("Ten khoa trong cbx: " + khoa.getMaKhoa());
//            if(khoa.getTenKhoa().equals(maKhoa)){
//                System.out.println("Gia tri Makhoa lay ra: " + khoa.getTenKhoa());
//                String getMaKhoa = khoa.getTenKhoa();
//                cbxKhoa.setSelectedItem(maKhoa);
//            }
//        }
    }
    private void tblGiangVienMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int row = tblGiangVien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn Giảng viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String maGV = String.valueOf(tblGiangVien.getValueAt(row, 0));
            _getGiangVienById(maGV);
        }
    } 
    private void tblGiangVienKeyReleased(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int row = tblGiangVien.getSelectedRow();
            String maGV = String.valueOf(tblGiangVien.getValueAt(row, 0));
            _getGiangVienById(maGV);
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
        new GiangVienFrame().setVisible(true);
    }
}
