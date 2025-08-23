package org.hunterxdk.accounts.service;

import org.hunterxdk.accounts.dto.CustomerDto;

public interface IAccountsService {

    
    /**
     * Create a new account
     *
     * @param customerDto the customer data for the account
     */
    void createAccount(CustomerDto customerDto);


    /**
     * Fetch an account by its mobile number
     *
     * @param mobileNumber the mobile number of the account to fetch
     * @return the customer data for the account
     */
    CustomerDto fetchAccount(String mobileNumber);

}
