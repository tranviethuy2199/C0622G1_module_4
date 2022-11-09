package com.example.repository.ContractRepo;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract , Integer> {
    @Query(value = "select * from `contract` where status =1" , nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);


}
