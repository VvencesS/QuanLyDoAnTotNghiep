package service;

import java.util.List;
import model.DangKyDeTai;
import query.DangKyDeTaiQuery;


public class DangKyDeTaiService {
    DangKyDeTaiQuery dangKyDeTaiQuery;
    
    public DangKyDeTaiService(){
        dangKyDeTaiQuery = new DangKyDeTaiQuery();
    }
    public List<DangKyDeTai> getAllDKDTs(){
        return dangKyDeTaiQuery.getAllDangKyDeTais();
    }
    public void addDKDT(DangKyDeTai dangKyDeTai){
        dangKyDeTaiQuery.addDKDT(dangKyDeTai);
    }
    public void deleteDKDT(String tenSV){
        dangKyDeTaiQuery.deleteDKDT(tenSV);
    }
    public DangKyDeTai getDKDTByTenSV(String tenSV){
        return dangKyDeTaiQuery.getDKDTByTenSV(tenSV);
    }
    public void updateDKDT(DangKyDeTai dangKyDeTai){
        dangKyDeTaiQuery.updateDKDT(dangKyDeTai);
    }
}
