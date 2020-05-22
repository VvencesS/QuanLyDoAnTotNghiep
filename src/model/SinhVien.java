package model;

public class SinhVien {
    private String MaSV;
    private String TenSV;
    private String GioiTinh;
    private String NgaySinh;
    private String Email;
    private String SoDT;
    private String DiaChi;
    private String Lop;
    private String Khoa;
    
    public SinhVien(){}

    public SinhVien(String MaSV, String TenSV) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
    }
    
    public SinhVien(String MaSV, String TenSV, String GioiTinh, String NgaySinh, String Email, String SoDT, String DiaChi, String Lop, String Khoa) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.Lop = Lop;
        this.Khoa = Khoa;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    @Override
    public String toString() {
        return TenSV;
    }
    
}
