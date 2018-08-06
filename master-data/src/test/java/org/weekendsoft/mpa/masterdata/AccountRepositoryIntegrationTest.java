package org.weekendsoft.mpa.masterdata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.weekendsoft.mpa.masterdata.model.Account;
import org.weekendsoft.mpa.masterdata.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class AccountRepositoryIntegrationTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void testFindAll() {
		List<Account> accs = accountRepository.findAll();
		assertThat(accs.size(), is(greaterThanOrEqualTo(0)));
	}
}
