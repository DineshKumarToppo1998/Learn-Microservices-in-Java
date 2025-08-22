package org.hunterxdk.accounts.repository;

import org.hunterxdk.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Find a customer by their mobile number.
     *
     * @param mobileNumber the mobile number to search for
     * @return an Optional containing the customer, if found
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);

}
