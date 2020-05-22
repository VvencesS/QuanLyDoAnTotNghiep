package model;

public class LopComboBox {
    private String maLop;
    private String tenlop;
    
    public LopComboBox(){
        
    }

    public LopComboBox(String maLop, String tenlop) {
        this.maLop = maLop;
        this.tenlop = tenlop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    @Override
    public String toString() {
        return tenlop;
    }
    
}
