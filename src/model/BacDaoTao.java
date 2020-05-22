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
public class BacDaoTao {
    private String maBDT;
    private String tenBDT;

    public BacDaoTao() {
    }

    public BacDaoTao(String maBDT, String tenBDT) {
        this.maBDT = maBDT;
        this.tenBDT = tenBDT;
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

    @Override
    public String toString() {
        return tenBDT;
    }
    
    
}
