package model;

public class DeTai {
    private String MaDT;
    private String TenDT;
    private int SoSV;
    private int Nam;
    
    public DeTai(){}

    public DeTai(String MaDT, String TenDT) {
        this.MaDT = MaDT;
        this.TenDT = TenDT;
    }
    
    public DeTai(String MaDT, String TenDT, int SoSV, int Nam) {
        this.MaDT = MaDT;
        this.TenDT = TenDT;
        this.SoSV = SoSV;
        this.Nam = Nam;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getTenDT() {
        return TenDT;
    }

    public void setTenDT(String TenDT) {
        this.TenDT = TenDT;
    }

    public int getSoSV() {
        return SoSV;
    }

    public void setSoSV(int SoSV) {
        this.SoSV = SoSV;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }

    @Override
    public String toString() {
        return TenDT;
    }
    
}
