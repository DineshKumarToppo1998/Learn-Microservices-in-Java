package org.hunterxdk.accounts.repository;

import org.hunterxdk.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepositoryImplementation<Accounts,Long> {

}
