package org.hunterxdk.accounts.mapper;


import org.hunterxdk.accounts.dto.CustomerDto;
import org.hunterxdk.accounts.entity.Customer;

public class CustomerMapper {

    /**
     * Maps the given Customer object to a CustomerDto object.
     *
     * @param customer    the Customer object to map
     * @param customerDto the CustomerDto object to fill
     * @return the filled CustomerDto object
     */
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customerDto.getMobileNumber());
        return customerDto;
    }

    /**
     * Maps the given CustomerDto object to a Customer object.
     *
     * @param customerDto the CustomerDto object to map
     * @param customer    the Customer object to fill
     * @return the filled Customer object
     */
    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
