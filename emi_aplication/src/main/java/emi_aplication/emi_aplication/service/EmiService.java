package emi_aplication.emi_aplication.service;

import emi_aplication.emi_aplication.model.Emi;

import java.util.List;

public interface EmiService {
    List<Emi> getEmiByCust(int cust_id);
    boolean saveEmi(Emi emi);
    boolean updateEmi(Emi emi);

}
