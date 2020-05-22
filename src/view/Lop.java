package view;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.BDTManager;
import model.BacDaoTao;
import model.CRUDLop;
import model.GiangVien;
import model.HDTManager;
import model.HeDaoTao;
import model.Khoa;
import model.KhoaManager;
import model.LopHoc;

public class Lop {

    JFrame f = new JFrame("Lớp");
    JLabel lbTenLop, lbMaLop, lbTenLop1, lbKhoa, lbHDT, lbBDT;
    JTextField txtSearch, txtMaLop, txtTenLop1;
    JButton btnTimKiem, btnXem, btnThem, btnSua, btnXoa,btntitle1,btntitle2,btntitle3,btntitle4,btntitle5, btnThoat;
    JTable tblLop = new JTable();
    JComboBox<String> cbxKhoa = new JComboBox<>();
    JComboBox<String> cbxHDT = new JComboBox<>();
    JComboBox<String> cbxBDT = new JComboBox<>();
    JPanel pnInfo = new JPanel();
    Lop() {
        lbTenLop = new JLabel("Tên lớp: ");
        lbTenLop.setBounds(10, 5, 50, 20);
        txtSearch = new JTextField();
        txtSearch.setBounds(80, 5, 150, 20);
        btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setBounds(250, 5, 90, 20);
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(350, 5, 90, 20);
        f.add(btnThoat);
        pnInfo.setBorder(BorderFactory.createTitledBorder("Thông tin"));
        pnInfo.setBounds(30, 40, 720, 200);
        pnInfo.setLayout(null);
        lbMaLop = new JLabel("Mã lớp: ");
        lbMaLop.setBounds(15, 20, 50, 20);
        pnInfo.add(lbMaLop);
        txtMaLop = new JTextField();
        txtMaLop.setBounds(85, 20, 200, 20);
        pnInfo.add(txtMaLop);
        lbTenLop1 = new JLabel("Tên lớp: ");
        lbTenLop1.setBounds(15, 60, 50, 20);
        pnInfo.add(lbTenLop1);
        txtTenLop1 = new JTextField();
        txtTenLop1.setBounds(85, 60, 200, 20);
        pnInfo.add(txtTenLop1);
        lbKhoa = new JLabel("Khoa: ");
        lbKhoa.setBounds(350, 20, 50, 20);
        pnInfo.add(lbKhoa);
        cbxKhoa.setBounds(450, 20, 200, 20);
        pnInfo.add(cbxKhoa);
        lbHDT = new JLabel("Hệ đào tạo: ");
        lbHDT.setBounds(350, 60, 100, 20);
        pnInfo.add(lbHDT);
        cbxHDT.setBounds(450, 60, 200, 20);
        pnInfo.add(cbxHDT);
        lbBDT = new JLabel("Bậc đào tạo");
        lbBDT.setBounds(350, 100, 100, 20);
        pnInfo.add(lbBDT);
        cbxBDT.setBounds(450, 100, 200, 20);
        pnInfo.add(cbxBDT);
        btnXem = new JButton("Xem");
        btnXem.setBounds(360, 150, 80, 25);
        pnInfo.add(btnXem);
        btnThem = new JButton("Thêm");
        btnThem.setBounds(450, 150, 80, 25);
        pnInfo.add(btnThem);
        btnSua = new JButton("Sửa");
        btnSua.setBounds(540, 150, 80, 25);
        pnInfo.add(btnSua);
        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(630, 150, 80, 25);
        pnInfo.add(btnXoa);
        tblLop.setBounds(30, 275, 720, 300);
        tblLop.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        btntitle1 = new JButton("Mã lớp");
        btntitle1.setBounds(30, 250, 144, 25);
        btntitle1.setBackground(Color.WHITE);
        f.add(btntitle1);
        btntitle2 = new JButton("Tên lớp");
        btntitle2.setBounds(173, 250, 145, 25);
        btntitle2.setBackground(Color.WHITE);
        f.add(btntitle2);
        btntitle3 = new JButton("Khoa");
        btntitle3.setBounds(317, 250, 145, 25);
        btntitle3.setBackground(Color.WHITE);
        f.add(btntitle3);
        btntitle4 = new JButton("Hệ đào tạo");
        btntitle4.setBounds(461, 250, 145, 25);
        btntitle4.setBackground(Color.WHITE);
        f.add(btntitle4);
        btntitle5 = new JButton("Hệ đào tạo");
        btntitle5.setBounds(605, 250, 145, 25);
        btntitle5.setBackground(Color.WHITE);
        f.add(btntitle5);
        tblLop.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });

        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
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
        f.add(tblLop);
        f.add(pnInfo);
        f.add(lbTenLop);
        f.add(txtSearch);
        f.add(btnTimKiem);

        f.setSize(800, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(1366/5, 768/6);
        load();
        loadKhoa();
        loadHDT();
        loadBDT();
    }

    private void load() {
        CRUDLop l = new CRUDLop();
        List<LopHoc> lstLopHoc = l.read();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã lớp");
        dtm.addColumn("Tên lớp");
        dtm.addColumn("Khoa");
        dtm.addColumn("Hệ đào tạo");
        dtm.addColumn("Bậc đào tạo");
        for (LopHoc lopHoc : lstLopHoc) {
            Vector<Object> v = new Vector<>();
            v.add(lopHoc.getMaLop());
            v.add(lopHoc.getTenlop());
            v.add(lopHoc.getTenKhoa());
            v.add(lopHoc.getTenHDT());
            v.add(lopHoc.getTenBDT());
            dtm.addRow(v);
        }
        tblLop.setModel(dtm);
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
    private void loadHDT(){
        HDTManager hdtM = new HDTManager();
        
        List<HeDaoTao> lstHeDaoTao = hdtM.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (HeDaoTao hdt : lstHeDaoTao) {
            dcbm.addElement(hdt);
        }
        cbxHDT.setModel(dcbm);
    }
    private void loadBDT(){
        BDTManager bdtM = new BDTManager();
        
        List<BacDaoTao> lstBacDaoTao = bdtM.read();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (BacDaoTao bdt : lstBacDaoTao) {
            dcbm.addElement(bdt);
        }
        cbxBDT.setModel(dcbm);
    }
    private void tblLopMouseClicked(MouseEvent evt){
        int row = tblLop.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn lớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String maLop = String.valueOf(tblLop.getValueAt(row, 0));
            getClassById(maLop);
        }
    }
    private void btnThemActionPerformed(ActionEvent evt){
        LopHoc lh = new LopHoc();
        CRUDLop l = new CRUDLop();
        loadKhoa();
        loadHDT();
        loadBDT();
        
        lh.setMaLop(txtMaLop.getText());
        lh.setTenlop(txtTenLop1.getText());
        KhoaManager km = new KhoaManager();
        List<Khoa> lstKhoa = km.read();
        String tenKhoa = String.valueOf(cbxKhoa.getSelectedItem());
        for (Khoa khoa : lstKhoa) {
            if (khoa.getTenKhoa().equals(tenKhoa)) {
                lh.setMaKhoa(khoa.getMaKhoa());
            }
        }
        HDTManager hdtM = new HDTManager();
        List<HeDaoTao> lstHDT = hdtM.read();
        String tenHDt = String.valueOf(cbxHDT.getSelectedItem());
        for (HeDaoTao hdt : lstHDT) {
            if (hdt.getTenHDT().equals(tenHDt)) {
                lh.setMaHDT(hdt.getMaHDT());
            }
        }
        BDTManager bdtM = new BDTManager();
        List<BacDaoTao> lstBDT = bdtM.read();
        String tenBDT = String.valueOf(cbxBDT.getSelectedItem());
        for (BacDaoTao bdt : lstBDT) {
            if (bdt.getTenBDT().equals(tenBDT)) {
                lh.setMaBDT(bdt.getMaBDT());
            }
        }
        l.insert(lh);
        load();
        
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.f.dispose();
    }
    private void getClassById(String id){
        loadKhoa();
        loadHDT();
        loadBDT();
        CRUDLop l = new CRUDLop();
        LopHoc lh = l.getClassById(id);
        txtMaLop.setText(lh.getMaLop());
        txtTenLop1.setText(lh.getTenlop());
        KhoaManager km = new KhoaManager();
        List<Khoa> lstKhoa = km.read();
        String tenKhoa = String.valueOf(cbxKhoa.getSelectedItem());
        for (Khoa khoa : lstKhoa) {
            if (khoa.getTenKhoa().equals(tenKhoa)) {
                lh.setMaKhoa(khoa.getMaKhoa());
            }
        }
        HDTManager hdtM = new HDTManager();
        List<HeDaoTao> lstHDT = hdtM.read();
        String tenHDt = String.valueOf(cbxHDT.getSelectedItem());
        for (HeDaoTao hdt : lstHDT) {
            if (hdt.getTenHDT().equals(tenHDt)) {
                lh.setMaHDT(hdt.getMaHDT());
            }
        }
        BDTManager bdtM = new BDTManager();
        List<BacDaoTao> lstBDT = bdtM.read();
        String tenBDT = String.valueOf(cbxBDT.getSelectedItem());
        for (BacDaoTao bdt : lstBDT) {
            if (bdt.getTenBDT().equals(tenBDT)) {
                lh.setMaBDT(bdt.getMaBDT());
            }
        }
    }
    private void btnSuaActionPerformed(ActionEvent evt){
        LopHoc lh = new LopHoc();
        CRUDLop l = new CRUDLop();
        loadKhoa();
        loadHDT();
        loadBDT();
        txtMaLop.setText(lh.getMaLop());
        txtTenLop1.setText(lh.getTenlop());
        KhoaManager km = new KhoaManager();
        List<Khoa> lstKhoa = km.read();
        String tenKhoa = String.valueOf(cbxKhoa.getSelectedItem());
        for (Khoa khoa : lstKhoa) {
            if (khoa.getTenKhoa().equals(tenKhoa)) {
                lh.setMaKhoa(khoa.getMaKhoa());
            }
        }
        HDTManager hdtM = new HDTManager();
        List<HeDaoTao> lstHDT = hdtM.read();
        String tenHDt = String.valueOf(cbxHDT.getSelectedItem());
        for (HeDaoTao hdt : lstHDT) {
            if (hdt.getTenHDT().equals(tenHDt)) {
                lh.setMaHDT(hdt.getMaHDT());
            }
        }
        BDTManager bdtM = new BDTManager();
        List<BacDaoTao> lstBDT = bdtM.read();
        String tenBDT = String.valueOf(cbxBDT.getSelectedItem());
        for (BacDaoTao bdt : lstBDT) {
            if (bdt.getTenBDT().equals(tenBDT)) {
                lh.setMaBDT(bdt.getMaBDT());
            }
        }
        l.update(lh);
        load();
        
    }
    private void setTableData(List<LopHoc> l){
        DefaultTableModel dtm = new DefaultTableModel();
        for (LopHoc lop : l) {
            dtm.addRow(new Object[]{lop.getMaLop(), lop.getTenlop(), lop.getMaKhoa()
                    ,lop.getMaHDT(), lop.getMaBDT()});
        }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt){
        CRUDLop l = new CRUDLop();
        DefaultTableModel dtm = new DefaultTableModel();
        int row = tblLop.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Lớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String maLop = String.valueOf(tblLop.getValueAt(row, 0));
                
                l.delete(maLop);
                dtm.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(l.read());
            }
        }
    }
    public static void main(String[] args) {
        new Lop();
    }

}
