package service;

import java.util.List;
import model.PhanBien;
import query.PhanBienQuery;

public class PhanBienService {
    PhanBienQuery phanBienQuery;
    
    public PhanBienService(){
        phanBienQuery = new PhanBienQuery();
    }
    public List<PhanBien> getAllPhanBiens(){
        return phanBienQuery.getAllPhanBiens();
    }
    public void addPhanBien(PhanBien phanBien){
        phanBienQuery.addPhanBien(phanBien);
    }
    public void deletePhanBien(String tenDT){
        phanBienQuery.deletePhanBien(tenDT);
    }
    public PhanBien getPhanBienByTenDT(String tenDT){
        return phanBienQuery.getPhanbienByTenDT(tenDT);
    }
    public void updatePhanBien(PhanBien phanBien){
        phanBienQuery.updatePhanBien(phanBien);
    }
    public List<PhanBien> searchPhanBien(String tenDT){
        return phanBienQuery.searchPhanBien(tenDT);
    }
}
