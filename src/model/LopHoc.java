/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NgoTheHai
 */
public class LopHoc {
    private String maLop;
    private String tenlop;
    private String maKhoa;
    private String tenKhoa;
    private String maHDT;
    private String tenHDT;
    private String maBDT;
    private String tenBDT;

    public LopHoc() {
    }

    public LopHoc(String maLop, String tenlop) {
        this.maLop = maLop;
        this.tenlop = tenlop;
    }
    
    public LopHoc(String maLop, String tenlop, String maKhoa, String tenKhoa, String maHDT, String tenHDT, String maBDT, String tenBDT) {
        this.maLop = maLop;
        this.tenlop = tenlop;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.maHDT = maHDT;
        this.tenHDT = tenHDT;
        this.maBDT = maBDT;
        this.tenBDT = tenBDT;
    }

    public LopHoc(String maLop, String tenlop, String tenKhoa, String tenHDT, String tenBDT) {
        this.maLop = maLop;
        this.tenlop = tenlop;
        this.tenKhoa = tenKhoa;
        this.tenHDT = tenHDT;
        this.tenBDT = tenBDT;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaHDT() {
        return maHDT;
    }

    public void setMaHDT(String maHDT) {
        this.maHDT = maHDT;
    }

    public String getTenHDT() {
        return tenHDT;
    }

    public void setTenHDT(String tenHDT) {
        this.tenHDT = tenHDT;
    }

    public String getMaBDT() {
        return maBDT;
    }

    public void setMaBDT(String maBDT) {
        this.maBDT = maBDT;
    }

    public String getTenBDT() {
        return tenBDT;
    }

    public void setTenBDT(String tenBDT) {
        this.tenBDT = tenBDT;
    }
    
    
}
