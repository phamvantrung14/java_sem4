package emi_aplication.emi_aplication.repository;

import emi_aplication.emi_aplication.model.Emi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmiRepository extends JpaRepository<Emi,Integer> {
    @Query("SELECT p FROM Emi p WHERE cust_id=?1")
    List<Emi> getEmiByCust(int cust_id);
}
