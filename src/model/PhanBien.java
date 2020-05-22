package model;

public class PhanBien {
    private String TenDeTai;
    private String TenGiangVien;
    private float Diem;
    private String NhanXet;
    
    public PhanBien(){}

    public PhanBien(String TenDeTai, String TenGiangVien, float Diem, String NhanXet) {
        this.TenDeTai = TenDeTai;
        this.TenGiangVien = TenGiangVien;
        this.Diem = Diem;
        this.NhanXet = NhanXet;
    }

    public String getTenDeTai() {
        return TenDeTai;
    }

    public void setTenDeTai(String TenDeTai) {
        this.TenDeTai = TenDeTai;
    }

    public String getTenGiangVien() {
        return TenGiangVien;
    }

    public void setTenGiangVien(String TenGiangVien) {
        this.TenGiangVien = TenGiangVien;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

    public String getNhanXet() {
        return NhanXet;
    }

    public void setNhanXet(String NhanXet) {
        this.NhanXet = NhanXet;
    }

}
