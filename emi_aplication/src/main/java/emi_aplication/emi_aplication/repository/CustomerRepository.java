package emi_aplication.emi_aplication.repository;

import emi_aplication.emi_aplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
