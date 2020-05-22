package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.DeTai;
import model.DeTaiManager;
import model.GiangVien;
import model.GiangVienManager;
import model.Khoa;
import model.KhoaManager;
import model.LopComboBox;
import model.LopManager;
import model.PhanBien;
import service.PhanBienService;
import static view.TrangChuFrame.checkAdmin;

public class PhanBienFrame {
    PhanBienService phanBienService;
    DefaultTableModel defaultTableModel;
    PhanBien phanBien;
    String tenDT;
    String tenGV;
    
    JFrame f;
    JLabel lbTimKiem;
    JTextField txtTimKiem;
    JButton btnTimKiem;
    JPanel pSuaDiem, pChucNang;
    JLabel lbTenDeTai;
    JLabel lbTenGiangVien;
    JLabel lbDiem;
    JLabel lbNhanXet;
    JComboBox<String> cbTenDeTai;
    JComboBox<String> cbTenGiangVien;
    JTextField txtDiem;
    JTextArea txtNhanXet;
    JButton btnXem;
    JButton btnThem;
    JButton btnSua;
    JButton btnXoa;
    JButton btnThoat;
    JTable tblPhanBien;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
        
    PhanBienFrame(){
        f=new JFrame("Điểm");
        lbTimKiem =new JLabel("Tên đề tài:");
        txtTimKiem =new JTextField();
        btnTimKiem=new JButton("Tìm Kiếm");
        pSuaDiem=new JPanel();
        pChucNang = new JPanel();
        lbTenDeTai =new JLabel("Tên đề tài:");
        lbTenGiangVien =new JLabel("Tên Giảng Viên:");
        lbDiem =new JLabel("Điểm:");
        lbNhanXet =new JLabel("Nhận xét:");
        cbTenDeTai=new JComboBox<>();
        cbTenGiangVien=new JComboBox<>();
        txtDiem =new JTextField();
        txtNhanXet =new JTextArea();
        btnXem=new JButton("Xem");
        btnThem=new JButton("Thêm");
        btnSua=new JButton("Sửa");
        btnXoa=new JButton("Xóa");
        btnThoat=new JButton("Thoát");
        jButton1 = new JButton("Tên đề tài");
        jButton2 = new JButton("Tên giảng viên");
        jButton3 = new JButton("Điểm");
        jButton4 = new JButton("Nhận xét");
        
        tblPhanBien =new JTable();
        tblPhanBien.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TenDeTai", "TenGV", "Diem", "Nhãnet"
            }
        ));
        tblPhanBien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPhanBien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblPhanBien.setBounds(40,270,800,280);
        
        jButton1.setBounds(40, 245, 200, 25);
        jButton1.setBackground(Color.white);
        f.add(jButton1);
        jButton2.setBounds(239, 245, 201, 25);
        jButton2.setBackground(Color.white);
        f.add(jButton2);
        jButton3.setBounds(439, 245, 201, 25);
        jButton3.setBackground(Color.white);
        f.add(jButton3);
        jButton4.setBounds(639, 245, 201, 25);
        jButton4.setBackground(Color.white);
        f.add(jButton4);
        
        f.setLayout(null);
        f.setSize(900,600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(1366/5, 768/6);
        
        pChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        pChucNang.setBounds(40, 10, 800, 55);
        pChucNang.setLayout(null);
        f.add(pChucNang);
        lbTimKiem.setBounds(10, 15, 100, 25);
        pChucNang.add(lbTimKiem);
        txtTimKiem.setBounds(100, 15, 150, 23);
        pChucNang.add(txtTimKiem);
        btnTimKiem.setBounds(260,15,90,23);
        pChucNang.add(btnTimKiem);
        
        btnXoa.setBounds(595,15,70,23);
        pChucNang.add(btnXoa);
        btnSua.setBounds(520,15,70,23);
        pChucNang.add(btnSua);
        btnThem.setBounds(445,15,70,23);
        pChucNang.add(btnThem);
        btnXem.setBounds(370,15,70,23);
        pChucNang.add(btnXem);
        btnThoat.setBounds(670,15,70,23);
        pChucNang.add(btnThoat);
        
        pSuaDiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin điểm"));
        pSuaDiem.setBounds(40, 80, 800, 140);
        pSuaDiem.setLayout(null);
        f.add(pSuaDiem);
        
        lbTenDeTai.setBounds(5, 20,70, 23);
        pSuaDiem.add(lbTenDeTai);
        lbTenGiangVien.setBounds(5, 55,100, 23);
        pSuaDiem.add(lbTenGiangVien);
        
        cbTenDeTai.setBounds(150, 20, 200, 23);
        pSuaDiem.add(cbTenDeTai);
        
        cbTenGiangVien.setBounds(150, 55, 200, 23);
        pSuaDiem.add(cbTenGiangVien);
        lbDiem.setBounds(400, 15, 100, 23);
        pSuaDiem.add(lbDiem);
        lbNhanXet.setBounds(400, 55, 100, 23);
        pSuaDiem.add(lbNhanXet);
        txtDiem.setBounds(500,20,200,23);
        pSuaDiem.add(txtDiem);
        txtNhanXet.setBounds(500,55,200,69);
        txtNhanXet.setBorder(BorderFactory.createEtchedBorder());
        pSuaDiem.add(txtNhanXet);
        
        f.add(tblPhanBien);
        f.setVisible(true);
        
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
        cbTenDeTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenDeTaiActionPerformed(evt);
            }
        });
        cbTenGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenGiangVienActionPerformed(evt);
            }
        });
        tblPhanBien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhanBienMouseClicked(evt);
            }
        });
        tblPhanBien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPhanBienKeyReleased(evt);
            }
        });
        
        loadData();
        loadDeTai();
        loadGiangVien();
        _checkAdmin();
    }
    private void loadData(){
        phanBienService = new PhanBienService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tblPhanBien.setModel(defaultTableModel);
        defaultTableModel.addColumn("TenDT");
        defaultTableModel.addColumn("TenGV");
        defaultTableModel.addColumn("Diem");
        defaultTableModel.addColumn("NhanXet");
        
        setTableData(phanBienService.getAllPhanBiens());
    }
    private void setTableData(List<PhanBien> phanBiens){
        for(PhanBien phanBien : phanBiens){
            defaultTableModel.addRow(new Object[]{phanBien.getTenDeTai(), phanBien.getTenGiangVien(), 
            phanBien.getDiem(), phanBien.getNhanXet()});
        }
    }
    private void loadDeTai(){
        DeTaiManager dtm = new DeTaiManager();
        
        List<DeTai> deTais = dtm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (DeTai deTai : deTais) {
            dcbm.addElement(deTai);
        }
        cbTenDeTai.setModel(dcbm);
    }
    private void loadGiangVien(){
        GiangVienManager gvm = new GiangVienManager();
        
        List<GiangVien> giangViens = gvm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (GiangVien giangVien : giangViens) {
            dcbm.addElement(giangVien);
        }
        cbTenGiangVien.setModel(dcbm);
        
    }
    private void refreshData(){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(phanBienService.getAllPhanBiens());
    }
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) { 
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(phanBienService.getAllPhanBiens());
    }
    private void cbTenDeTaiActionPerformed(java.awt.event.ActionEvent evt){
        tenDT = String.valueOf(cbTenDeTai.getSelectedItem());
    }
    private void cbTenGiangVienActionPerformed(java.awt.event.ActionEvent evt){
        tenGV = String.valueOf(cbTenGiangVien.getSelectedItem());
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt){
        phanBien = new PhanBien();
        loadDeTai();
        loadGiangVien();
        
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        
        System.out.println("Ten DT: " + tenDT);
        for(DeTai deTai  : deTais){
            if(deTai.getTenDT().equals(tenDT)){
                System.out.println("Gia tri MaDT lay ra: " + deTai.getMaDT());
                phanBien.setTenDeTai(deTai.getMaDT());
            }
        }
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        
        System.out.println("Ten GV: " + tenGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getTenGV().equals(tenGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getMaGV());
                phanBien.setTenGiangVien(giangVien.getMaGV());
            }
        }
        phanBien.setDiem(Float.valueOf(txtDiem.getText()));
        phanBien.setNhanXet(txtNhanXet.getText());
        
        phanBienService.addPhanBien(phanBien);
        refreshData();
        loadData();
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt){
        phanBien = new PhanBien();
        loadDeTai();
        loadGiangVien();
        
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        
        System.out.println("Ten DT: " + tenDT);
        for(DeTai deTai  : deTais){
            if(deTai.getTenDT().equals(tenDT)){
                System.out.println("Gia tri MaDT lay ra: " + deTai.getMaDT());
                phanBien.setTenDeTai(deTai.getMaDT());
            }
        }
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        
        System.out.println("Ten GV: " + tenGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getTenGV().equals(tenGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getMaGV());
                phanBien.setTenGiangVien(giangVien.getMaGV());
            }
        }
        phanBien.setDiem(Float.valueOf(txtDiem.getText()));
        phanBien.setNhanXet(txtNhanXet.getText());
        
        phanBienService.updatePhanBien(phanBien);
        refreshData();
        loadData();
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt){
        int row = tblPhanBien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Giảng viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String TenDT = String.valueOf(tblPhanBien.getValueAt(row, 0));
                System.out.println("TenDT da chon: " + TenDT);
//                String maDT = "";
//                DeTaiManager dtm = new DeTaiManager();
//                List<DeTai> deTais = dtm.read();
//                for(DeTai deTai  : deTais){
//                    System.out.println("DS MaDT lay ra: " + deTai.getMaDT());
//                    System.out.println("DS TenDT lay ra: " + deTai.getTenDT());
//                    String cbxTenDT = deTai.getTenDT();
//                    if(cbxTenDT.equals(tenDT)){
//                        System.out.println("Gia tri MaDT lay ra: " + deTai.getMaDT());
//                        maDT = deTai.getMaDT();
//                    }
//                }
                phanBienService.deletePhanBien(TenDT);
                defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(phanBienService.getAllPhanBiens());
            }
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.f.dispose();
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(phanBienService.searchPhanBien(txtTimKiem.getText()));
    }
    private void _getSinhVienById(String TenDT){
        loadDeTai();
        loadGiangVien();
        phanBienService = new PhanBienService();
        phanBien = phanBienService.getPhanBienByTenDT(TenDT);
        
        String maDT = phanBien.getTenDeTai();
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        System.out.println("Ten DT: " + maDT);
        for(DeTai deTai  : deTais){
            if(deTai.getMaDT().equals(maDT)){
                System.out.println("Gia tri TenDT lay ra: " + deTai.getTenDT());
                cbTenDeTai.setSelectedItem(deTai.getTenDT());
            }
        }
        String maGV = phanBien.getTenGiangVien();
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        System.out.println("Ma GV: " + maGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getMaGV().equals(maGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getTenGV());
                cbTenGiangVien.setSelectedItem(giangVien.getTenGV());
            }
        }
        txtDiem.setText(String.valueOf(phanBien.getDiem()));
        txtNhanXet.setText(phanBien.getNhanXet());
    }
    private void tblPhanBienMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int row = tblPhanBien.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Phản biện", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String tenDT = String.valueOf(tblPhanBien.getValueAt(row, 0));
            _getSinhVienById(tenDT);
        }
    } 
    private void tblPhanBienKeyReleased(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int row = tblPhanBien.getSelectedRow();
            String tenDT = String.valueOf(tblPhanBien.getValueAt(row, 0));
            _getSinhVienById(tenDT);
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
        new PhanBienFrame();
    }
}
