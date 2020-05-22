package model;

public class GiangVien {
    private String MaGV;
    private String TenGV;
    private String GioiTinh;
    private String NgaySinh;
    private String Email;
    private String SoDT;
    private String DiaChi;
    private String HocVi;
    private String ChucVu;
    private String IdKhoa;
    
    public GiangVien(){}

    public GiangVien(String MaGV, String TenGV) {
        this.MaGV = MaGV;
        this.TenGV = TenGV;
    }

    public GiangVien(String MaGV, String TenGV, String GioiTinh, String NgaySinh, String Email, String SoDT, String DiaChi, String HocVi, String ChucVu, String IdKhoa) {
        this.MaGV = MaGV;
        this.TenGV = TenGV;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.HocVi = HocVi;
        this.ChucVu = ChucVu;
        this.IdKhoa = IdKhoa;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
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

    public String getHocVi() {
        return HocVi;
    }

    public void setHocVi(String HocVi) {
        this.HocVi = HocVi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getIdKhoa() {
        return IdKhoa;
    }

    public void setIdKhoa(String IdKhoa) {
        this.IdKhoa = IdKhoa;
    }

    @Override
    public String toString() {
        return TenGV;
    }
    
}
