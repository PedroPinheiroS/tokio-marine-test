package com.example.api.repository;

import com.example.api.domain.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query(value = "select * from address where id_customer = 1", nativeQuery = true)
    List<Address> findByCustomer();

}
