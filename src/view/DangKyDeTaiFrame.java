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
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.DangKyDeTai;
import model.DeTai;
import model.DeTaiManager;
import model.GiangVien;
import model.GiangVienManager;
import model.SinhVien;
import model.SinhVienManager;
import service.DangKyDeTaiService;
import static view.TrangChuFrame.checkAdmin;

public class DangKyDeTaiFrame {
    DangKyDeTaiService dangKyDeTaiService;
    DangKyDeTai dangKyDeTai;
    DefaultTableModel defaultTableModel;
    
    JFrame f;
    JLabel lbtendetai;
    JLabel lbtengiangvien;
    JLabel lbtensinhvien;
    JComboBox<String> cbtendetai;
    JComboBox<String> cbtengiangvien;
    JComboBox<String> cbtensinhvien;
    JPanel pn1;

    JButton btndangky;
    JButton btnsuadangky;
    JButton btnxoadangky;
    JButton btnThoat;

    JTable tbldangky;
    
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
        
    DangKyDeTaiFrame(){
        f=new JFrame("Đăng ký đề tài");
        lbtendetai = new JLabel("Tên đề tài:");
        lbtengiangvien = new JLabel("Tên giảng viên:");
        lbtensinhvien = new JLabel("Tên sinh viên:");
        cbtendetai = new JComboBox<>();
        cbtengiangvien = new JComboBox<>();
        cbtensinhvien = new JComboBox<>();
        pn1 = new JPanel();
        
        btndangky = new JButton("Đăng ký");
        btnsuadangky = new JButton("Sửa đăng ký");
        btnxoadangky = new JButton("Xóa đăng ký");
        btnThoat = new JButton("Thoát");
        
        tbldangky = new JTable();
        
        jButton1 = new JButton("Tên sinh viên");
        jButton1.setBounds(40, 205, 267, 25);
        jButton1.setBackground(Color.white);
        jButton2 = new JButton("Tên giảng viên");
        jButton2.setBounds(306, 205, 268, 25);
        jButton2.setBackground(Color.white);
        jButton3 = new JButton("Tên đề tài");
        jButton3.setBounds(572, 205, 268, 25);
        jButton3.setBackground(Color.white);
        f.add(jButton1);
        f.add(jButton2);
        f.add(jButton3);
       
        f.setLayout(null);
        f.setSize(900,600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(1366/5, 768/6);
        lbtendetai.setBounds(50,50,100,25);
        f.add(lbtendetai);
        lbtengiangvien.setBounds(50,85,100,25);
        f.add(lbtengiangvien);
        lbtensinhvien.setBounds(50,120,100,25);
        f.add(lbtensinhvien);
        cbtendetai.setBounds(150,50,200,25);
        cbtendetai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenDeTai" }));
        f.add(cbtendetai);
        cbtengiangvien.setBounds(150,85,200,25);
        cbtengiangvien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenGiangVien" }));
        f.add(cbtengiangvien);
        cbtensinhvien.setBounds(150,120,200,25);
        cbtensinhvien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenSinhVien" }));
        f.add(cbtensinhvien);
        btndangky.setBounds(380, 85, 90, 30);
        f.add(btndangky);
        btnsuadangky.setBounds(475,85,105,30);
        f.add(btnsuadangky);
        btnxoadangky.setBounds(585,85,105,30);
        f.add(btnxoadangky);
        btnThoat.setBounds(695,85,105,30);
        f.add(btnThoat);
        pn1.setBounds(40,15,800,150);
        f.add(pn1);
        pn1.setBorder(BorderFactory.createTitledBorder("Chọn đề tài"));
        
        tbldangky.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TenDT", "MaGV", "TenSV"
            }
        ));
        tbldangky.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbldangky.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbldangky.setBounds(40,230,800,300);
        f.add(tbldangky);
        
        f.setVisible(true);
        
        btndangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkyActionPerformed(evt);
            }
        });
        
        btnsuadangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuadangkyActionPerformed(evt);
            }
        });
        
        btnxoadangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoadangkyActionPerformed(evt);
            }
        });
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        
        loadData();
        loadDeTai();
        loadGiangVien();
        loadSinhVien();
    }
    private void loadData(){
        dangKyDeTaiService = new DangKyDeTaiService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tbldangky.setModel(defaultTableModel);
        defaultTableModel.addColumn("TenSV");
        defaultTableModel.addColumn("TenGV");
        defaultTableModel.addColumn("TenDT");
        
        setTableData(dangKyDeTaiService.getAllDKDTs());
    }
    private void setTableData(List<DangKyDeTai> dangKyDeTais){
        for(DangKyDeTai dangKyDeTai : dangKyDeTais){
            defaultTableModel.addRow(new Object[]{dangKyDeTai.getTenSV(), dangKyDeTai.getTenGV(), dangKyDeTai.getTenDT()});
        }
    }
    private void loadDeTai(){
        DeTaiManager dtm = new DeTaiManager();
        
        List<DeTai> deTais = dtm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (DeTai deTai : deTais) {
            dcbm.addElement(deTai);
        }
        cbtendetai.setModel(dcbm);
    }
    private void loadGiangVien(){
        GiangVienManager gvm = new GiangVienManager();
        
        List<GiangVien> giangViens = gvm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (GiangVien giangVien : giangViens) {
            dcbm.addElement(giangVien);
        }
        cbtengiangvien.setModel(dcbm);
    }
    private void loadSinhVien(){
        SinhVienManager svm = new SinhVienManager();
        
        List<SinhVien> sinhViens = svm.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (SinhVien sinhVien : sinhViens) {
            dcbm.addElement(sinhVien);
        }
        cbtensinhvien.setModel(dcbm);
        
    }
    private void refreshData(){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(dangKyDeTaiService.getAllDKDTs());
    }
    
    private void btndangkyActionPerformed(java.awt.event.ActionEvent evt){
        dangKyDeTai = new DangKyDeTai();
        loadDeTai();
        loadGiangVien();
        loadSinhVien();
        
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        String tenDT = String.valueOf(cbtendetai.getSelectedItem());
        System.out.println("Ten DT: " + tenDT);
        for(DeTai deTai  : deTais){
            if(deTai.getTenDT().equals(tenDT)){
                System.out.println("Gia tri MaDT lay ra: " + deTai.getMaDT());
                String getMaDT = deTai.getMaDT();
                dangKyDeTai.setTenDT(getMaDT);
            }
        }
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        String tenGV = String.valueOf(cbtengiangvien.getSelectedItem());
        System.out.println("Ten GV: " + tenGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getTenGV().equals(tenGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getMaGV());
                String getMaGV = giangVien.getMaGV();
                dangKyDeTai.setTenGV(getMaGV);
            }
        }
        SinhVienManager svm = new SinhVienManager();
        List<SinhVien> sinhViens = svm.read();
        String tenSV = String.valueOf(cbtensinhvien.getSelectedItem());
        System.out.println("Ten SV: " + tenSV);
        for(SinhVien sinhVien  : sinhViens){
            if(sinhVien.getTenSV().equals(tenSV)){
                System.out.println("Gia tri MaSV lay ra: " + sinhVien.getMaSV());
                String getMaSV = sinhVien.getMaSV();
                dangKyDeTai.setTenGV(getMaSV);
            }
        }
        
        dangKyDeTaiService.addDKDT(dangKyDeTai);
        refreshData();
        loadData();
    }
    private void btnsuadangkyActionPerformed(java.awt.event.ActionEvent evt){
        dangKyDeTai = new DangKyDeTai();
        loadDeTai();
        loadGiangVien();
        loadSinhVien();
        
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        String tenDT = String.valueOf(cbtendetai.getSelectedItem());
        System.out.println("Ten DT: " + tenDT);
        for(DeTai deTai  : deTais){
            if(deTai.getTenDT().equals(tenDT)){
                System.out.println("Gia tri MaDT lay ra: " + deTai.getMaDT());
                String getMaDT = deTai.getMaDT();
                dangKyDeTai.setTenDT(getMaDT);
            }
        }
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        String tenGV = String.valueOf(cbtengiangvien.getSelectedItem());
        System.out.println("Ten GV: " + tenGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getTenGV().equals(tenGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getMaGV());
                String getMaGV = giangVien.getMaGV();
                dangKyDeTai.setTenGV(getMaGV);
            }
        }
        SinhVienManager svm = new SinhVienManager();
        List<SinhVien> sinhViens = svm.read();
        String tenSV = String.valueOf(cbtensinhvien.getSelectedItem());
        System.out.println("Ten SV: " + tenSV);
        for(SinhVien sinhVien  : sinhViens){
            if(sinhVien.getTenSV().equals(tenSV)){
                System.out.println("Gia tri MaSV lay ra: " + sinhVien.getMaSV());
                String getMaSV = sinhVien.getMaSV();
                dangKyDeTai.setTenGV(getMaSV);
            }
        }
        
        dangKyDeTaiService.updateDKDT(dangKyDeTai);
        refreshData();
        loadData();
    }
    private void btnxoadangkyActionPerformed(java.awt.event.ActionEvent evt){
        int row = tbldangky.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Đề tài", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String maDT = String.valueOf(tbldangky.getValueAt(row, 0));
                
                dangKyDeTaiService.deleteDKDT(maDT);
                defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(dangKyDeTaiService.getAllDKDTs());
            }
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.f.dispose();
    }
    private void _getDKDTByTenSV(String tenSV){
        dangKyDeTaiService = new DangKyDeTaiService();
        dangKyDeTai = dangKyDeTaiService.getDKDTByTenSV(tenSV);
        
        String maDT = dangKyDeTai.getTenDT();
        DeTaiManager dtm = new DeTaiManager();
        List<DeTai> deTais = dtm.read();
        System.out.println("Ten DT: " + maDT);
        for(DeTai deTai  : deTais){
            if(deTai.getMaDT().equals(maDT)){
                System.out.println("Gia tri TenDT lay ra: " + deTai.getTenDT());
                String getTenDT = deTai.getTenDT();
                cbtendetai.setSelectedItem(getTenDT);
            }
        }
        String maGV = dangKyDeTai.getTenGV();
        GiangVienManager gvm = new GiangVienManager();
        List<GiangVien> giangViens = gvm.read();
        System.out.println("Ma GV: " + maGV);
        for(GiangVien giangVien  : giangViens){
            if(giangVien.getMaGV().equals(maGV)){
                System.out.println("Gia tri MaGV lay ra: " + giangVien.getTenGV());
                String getTenGV = giangVien.getTenGV();
                cbtengiangvien.setSelectedItem(getTenGV);
            }
        }
        String maSV = dangKyDeTai.getTenSV();
        SinhVienManager svm = new SinhVienManager();
        List<SinhVien> sinhViens = svm.read();
        System.out.println("Ma SV: " + maSV);
        for(SinhVien sinhVien  : sinhViens){
            if(sinhVien.getMaSV().equals(maSV)){
                System.out.println("Gia tri MaGV lay ra: " + sinhVien.getTenSV());
                String getTenSV = sinhVien.getTenSV();
                cbtengiangvien.setSelectedItem(getTenSV);
            }
        }
        
    }
    private void tblDeTaiMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int row = tbldangky.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Đề tài", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String tenSV = String.valueOf(tbldangky.getValueAt(row, 0));
            _getDKDTByTenSV(tenSV);
        }
    } 
    private void tblDeTaiKeyReleased(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int row = tbldangky.getSelectedRow();
            String tenDT = String.valueOf(tbldangky.getValueAt(row, 0));
            _getDKDTByTenSV(tenDT);
        }
    } 
    public static void main(String[] args) {
        new DangKyDeTaiFrame();
    }
}
