package service;

import java.util.List;
import model.DeTai;
import query.DeTaiQuery;


public class DeTaiService {
    DeTaiQuery deTaiQuery;
    
    public DeTaiService(){
        deTaiQuery = new DeTaiQuery();
    }
    public List<DeTai> getAllDeTais(){
        return deTaiQuery.getAllDeTais();
    }
    public void addDeTai(DeTai deTai){
        deTaiQuery.addDeTai(deTai);
    }
    public void deleteDeTai(String maDT){
        deTaiQuery.deleteDeTai(maDT);
    }
    public DeTai getDeTaiByMaDT(String maDT){
        return deTaiQuery.getDeTaiByMaDT(maDT);
    }
    public void updateDeTai(DeTai deTai){
        deTaiQuery.updateDeTai(deTai);
    }
    public List<DeTai> searchDeTai(String maDt){
        return deTaiQuery.searchDeTai(maDt);
    }
}
