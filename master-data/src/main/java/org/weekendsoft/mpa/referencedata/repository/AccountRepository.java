package org.weekendsoft.mpa.referencedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weekendsoft.mpa.referencedata.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
