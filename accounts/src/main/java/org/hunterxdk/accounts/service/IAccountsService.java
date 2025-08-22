package org.hunterxdk.accounts.service;

import org.hunterxdk.accounts.dto.CustomerDto;

public interface IAccountsService {

    
    /**
     * Create a new account
     *
     * @param customerDto the customer data for the account
     */
    void createAccount(CustomerDto customerDto);
}
