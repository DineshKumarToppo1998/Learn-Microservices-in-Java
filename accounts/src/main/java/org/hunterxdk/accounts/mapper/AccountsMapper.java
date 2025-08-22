package org.hunterxdk.accounts.mapper;

import org.hunterxdk.accounts.dto.AccountsDto;
import org.hunterxdk.accounts.entity.Accounts;

public class AccountsMapper {


    /**
     * Maps the given Accounts object to an AccountsDto object.
     *
     * @param accounts       the Accounts object to map
     * @param accountsDto    the AccountsDto object to fill
     * @return the filled AccountsDto object
     */
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return  accountsDto;
    }

    /**
     * Maps the given AccountsDto to the given Accounts object.
     *
     * @param accountsDto the AccountsDto to map from
     * @param accounts the Accounts object to map to
     * @return the updated Accounts object
     */
    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }



}
