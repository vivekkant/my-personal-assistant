package org.weekendsoft.mpa.masterdata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.weekendsoft.mpa.masterdata.controller.AccountController;
import org.weekendsoft.mpa.masterdata.model.Account;
import org.weekendsoft.mpa.masterdata.repository.AccountRepository;

public class AccountControllerTest {
	
	@InjectMocks	
	private AccountController ac;
	
	@Mock
	private AccountRepository accountRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAccountGet() {
		Account mockAcc = new Account();
		mockAcc.setId(1);
		when(accountRepository.findOne(1)).thenReturn(mockAcc);
		
		Account acc = ac.get(1);
		
		verify(accountRepository).findOne(1);
		//assertEquals(1, acc.getId());
		assertThat(acc.getId(), is(1));
	}
}
