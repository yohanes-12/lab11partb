package com.example.asdlab11partb.repo;

import com.example.asdlab11partb.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT DISTINCT a FROM Address a JOIN Patient p ON a.id = p.mailingAddress.id ORDER BY a.city ASC")
    List<Address> getAllAddressesWithPatientSortedByCityASC();
}
