package model;

public class DangKyDeTai {
    private String TenDT;
    private String TenGV;
    private String TenSV;
    
    public DangKyDeTai(){}

    public DangKyDeTai(String TenDT, String TenGV, String TenSV) {
        this.TenDT = TenDT;
        this.TenGV = TenGV;
        this.TenSV = TenSV;
    }

    public String getTenDT() {
        return TenDT;
    }

    public void setTenDT(String TenDT) {
        this.TenDT = TenDT;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }
    
}
