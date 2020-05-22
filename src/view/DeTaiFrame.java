package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.DeTai;
import service.DeTaiService;
import static view.TrangChuFrame.checkAdmin;

public class DeTaiFrame {
    DeTaiService deTaiService;
    DefaultTableModel defaultTableModel;
    DeTai deTai;
    
    JFrame f;
    JLabel lbTimKiem;
    JTextField txtTimKiem;
    JButton btnTimKiem;
    JPanel pSuaDeTai;
    JPanel pChucNang;
    JLabel lbMaDeTai;
    JLabel lbTenDeTai;
    JLabel lbNamThucHien;
    JLabel lbSSVTG;
    JTextField txtMaDeTai;
    JTextField txtTenDeTai;
    JTextField txtNamThucHien;
    JTextField txtSSVTG;
    JButton btnXem;
    JButton btnThem;
    JButton btnSua;
    JButton btnXoa;
    JButton btnThoat;
    JTable tblDeTai;
    DefaultTableModel dtm;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    
    public DeTaiFrame()  {
        f = new JFrame("Đề Tài");
        lbTimKiem = new JLabel ("Tên đề tài:");
        txtTimKiem = new JTextField();
        btnTimKiem = new JButton("Tìm Kiếm");
        pSuaDeTai = new JPanel();
        pChucNang = new JPanel();
        lbMaDeTai = new JLabel("Mã đề tài:");
        lbTenDeTai = new JLabel("Tên đề tài:");
        lbNamThucHien = new JLabel("Năm thực hiện:");
        lbSSVTG = new JLabel("Số sinh viên tham gia:");
        txtMaDeTai = new JTextField();
        txtTenDeTai = new JTextField();
        txtNamThucHien = new JTextField();
        txtSSVTG = new JTextField();
        btnXem = new JButton("Xem");
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        tblDeTai = new JTable();
        dtm = new DefaultTableModel();
        jButton1 = new JButton("Mã đề tài");
        jButton2 = new JButton("Tên đề tài");
        jButton3 = new JButton("Số sinh viên");
        jButton4 = new JButton("Năm");
        
        f.setLayout(null);
        f.setSize(900, 600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pSuaDeTai.setLayout(null);
        pChucNang.setLayout(null);
        
        pChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        pChucNang.setBounds(40, 5, 800, 55);
        f.add(pChucNang);
        
        lbTimKiem.setBounds(10, 15, 100, 25);
        pChucNang.add(lbTimKiem);
        txtTimKiem.setBounds(100, 15, 150, 23);
        pChucNang.add(txtTimKiem);
        btnTimKiem.setBounds(260, 15, 100, 23);
        pChucNang.add(btnTimKiem);
        
        btnXoa.setBounds(595, 15, 70, 23);
        pChucNang.add(btnXoa);
        btnSua.setBounds(520, 15, 70, 23);
        pChucNang.add(btnSua);
        btnThem.setBounds(445, 15, 70, 23);
        pChucNang.add(btnThem);
        btnXem.setBounds(370, 15, 70, 23);
        pChucNang.add(btnXem);
        btnThoat.setBounds(670, 15, 70, 23);
        pChucNang.add(btnThoat);
        
        pSuaDeTai.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin đề tài"));
        pSuaDeTai.setBounds(40, 80, 800, 120);
        f.add(pSuaDeTai);
        
        lbMaDeTai.setBounds(5, 20, 70, 23);
        pSuaDeTai.add(lbMaDeTai);
        lbTenDeTai.setBounds(5, 55, 100, 23);
        pSuaDeTai.add(lbTenDeTai);
        txtMaDeTai.setBounds(150, 20, 150, 23);
        pSuaDeTai.add(txtMaDeTai);
        txtTenDeTai.setBounds(150, 55, 150, 23);
        pSuaDeTai.add(txtTenDeTai);
        lbNamThucHien.setBounds(350, 15, 120, 23);
        pSuaDeTai.add(lbNamThucHien);
        txtNamThucHien.setBounds(500, 20, 150, 23);
        pSuaDeTai.add(txtNamThucHien);
        lbSSVTG.setBounds(350, 55, 140, 23);
        pSuaDeTai.add(lbSSVTG);
        txtSSVTG.setBounds(500, 55, 150, 23);
        pSuaDeTai.add(txtSSVTG);
        
        tblDeTai.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MaDT", "TenDT", "SoSV", "Nam"
            }
        ));
        tblDeTai.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDeTai.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDeTai.setBounds(40,250,800,280);
        
        jButton1.setBounds(40, 225, 200, 25);
        jButton1.setBackground(Color.white);
        f.add(jButton1);
        jButton2.setBounds(239, 225, 201, 25);
        jButton2.setBackground(Color.white);
        f.add(jButton2);
        jButton3.setBounds(439, 225, 201, 25);
        jButton3.setBackground(Color.white);
        f.add(jButton3);
        jButton4.setBounds(639, 225, 201, 25);
        jButton4.setBackground(Color.white);
        f.add(jButton4);
        
        f.add(tblDeTai);
        f.setVisible(true);
        f.setLocation(1366/5, 768/6);
        
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
        tblDeTai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeTaiMouseClicked(evt);
            }
        });
        tblDeTai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDeTaiKeyReleased(evt);
            }
        });
        
        loadData();
        _checkAdmin();
    }
    private void loadData(){
        deTaiService = new DeTaiService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tblDeTai.setModel(defaultTableModel);
        defaultTableModel.addColumn("MaDT");
        defaultTableModel.addColumn("TenDT");
        defaultTableModel.addColumn("SoSV");
        defaultTableModel.addColumn("Nam");
        
        setTableData(deTaiService.getAllDeTais());
    }
    private void setTableData(List<DeTai> deTais){
        for(DeTai deTai : deTais){
            defaultTableModel.addRow(new Object[]{deTai.getMaDT(), deTai.getTenDT(), deTai.getSoSV(), deTai.getNam()});
        }
    }
    private void refreshData(){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(deTaiService.getAllDeTais());
    }
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) { 
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(deTaiService.getAllDeTais());
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt){
        deTai = new DeTai();
        
        deTai.setMaDT(txtMaDeTai.getText());
        deTai.setTenDT(txtTenDeTai.getText());
        deTai.setSoSV(Integer.valueOf(txtSSVTG.getText()));
        deTai.setNam(Integer.valueOf(txtNamThucHien.getText()));
        
        deTaiService.addDeTai(deTai);
        refreshData();
        loadData();
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt){
        deTai = new DeTai();
        
        deTai.setMaDT(txtMaDeTai.getText());
        deTai.setTenDT(txtTenDeTai.getText());
        deTai.setSoSV(Integer.valueOf(txtSSVTG.getText()));
        deTai.setNam(Integer.valueOf(txtNamThucHien.getText()));
        
        deTaiService.updateDeTai(deTai);
        refreshData();
        loadData();
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt){
        int row = tblDeTai.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Đề tài", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?");
            
            if(confirm == JOptionPane.YES_OPTION){
                String maDT = String.valueOf(tblDeTai.getValueAt(row, 0));
                
                deTaiService.deleteDeTai(maDT);
                defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
                setTableData(deTaiService.getAllDeTais());
            }
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt){
        new TrangChuFrame().setVisible(true);
        this.f.dispose();
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt){
        defaultTableModel.setRowCount(0); //Xóa hết dữ liệu hiện tại
        setTableData(deTaiService.searchDeTai(txtTimKiem.getText()));
    }
    private void _getDeTaiByMaDT(String MaDT){
        deTaiService = new DeTaiService();
        deTai = deTaiService.getDeTaiByMaDT(MaDT);
        
        txtMaDeTai.setText(deTai.getMaDT());
        txtTenDeTai.setText(deTai.getTenDT());
        txtSSVTG.setText(String.valueOf(deTai.getSoSV()));
        txtNamThucHien.setText(String.valueOf(deTai.getNam()));
    }
    private void tblDeTaiMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int row = tblDeTai.getSelectedRow();
        if(row == -1){
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn Đề tài", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            String maDT = String.valueOf(tblDeTai.getValueAt(row, 0));
            _getDeTaiByMaDT(maDT);
        }
    } 
    private void tblDeTaiKeyReleased(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int row = tblDeTai.getSelectedRow();
            String tenDT = String.valueOf(tblDeTai.getValueAt(row, 0));
            _getDeTaiByMaDT(tenDT);
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
        new DeTaiFrame();
    }
}
