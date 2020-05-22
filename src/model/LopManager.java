package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import query.JDBCConnection;

public class LopManager {
    public List<LopComboBox> read(){
        List<LopComboBox> lstLopComboBox = new ArrayList<>();
        try {
            String sql = "SELECT MaLop, TenLop FROM tblLop";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                LopComboBox l = new LopComboBox(rs.getString("MaLop"), rs.getString("TenLop"));
                System.out.println("Get:" + l.getMaLop());
                System.out.println("Get" + l.getTenlop());
                lstLopComboBox.add(l);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return lstLopComboBox;
    }
}
