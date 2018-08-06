package org.weekendsoft.mpa.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weekendsoft.mpa.masterdata.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
