package org.hunterxdk.accounts.impl;

import lombok.AllArgsConstructor;
import org.hunterxdk.accounts.constants.AccountsConstants;
import org.hunterxdk.accounts.dto.AccountsDto;
import org.hunterxdk.accounts.dto.CustomerDto;
import org.hunterxdk.accounts.entity.Accounts;
import org.hunterxdk.accounts.entity.Customer;
import org.hunterxdk.accounts.exception.CustomerAlreadyExistsException;
import org.hunterxdk.accounts.exception.ResourceNotFoundException;
import org.hunterxdk.accounts.mapper.AccountsMapper;
import org.hunterxdk.accounts.mapper.CustomerMapper;
import org.hunterxdk.accounts.repository.AccountsRepository;
import org.hunterxdk.accounts.repository.CustomerRepository;
import org.hunterxdk.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {


    // no need of autowiring as we are using constructor injection
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;




    /**
     * Create a new account
     *
     * @param customerDto the customer data for the account
     * @throws CustomerAlreadyExistsException if the customer is already registered with the given mobile number
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber: " + customerDto.getMobileNumber());
        }
        customer.setCreated_at(LocalDateTime.now());
        customer.setCreated_by("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * Create a new account and return it. The account number is a random
     * number between 1000000000 and 1999999999. The account type is always
     * {@link AccountsConstants#SAVINGS} and the address is always
     * {@link AccountsConstants#ADDRESS}.
     *
     * @param customer the customer to create the account for
     * @return the created account
     */
    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreated_at(LocalDateTime.now());
        newAccount.setCreated_by("Anonymous");
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {


        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        return customerDto;
    }

}
