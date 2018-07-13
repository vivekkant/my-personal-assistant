package org.weekendsoft.mpa.referencedata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.weekendsoft.mpa.referencedata.controller.AccountController;
import org.weekendsoft.mpa.referencedata.model.Account;
import org.weekendsoft.mpa.referencedata.repository.AccountRepository;

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
		assertEquals(1, acc.getId());
	}
}
