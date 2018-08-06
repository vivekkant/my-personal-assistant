/**
 * 
 */
package org.weekendsoft.mpa.masterdata.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.weekendsoft.mpa.masterdata.exception.ERROR_CODES;
import org.weekendsoft.mpa.masterdata.exception.RecordNotFoundException;
import org.weekendsoft.mpa.masterdata.model.Account;
import org.weekendsoft.mpa.masterdata.model.ErrorInfo;
import org.weekendsoft.mpa.masterdata.repository.AccountRepository;

/**
 * @author Vivek Kant
 *
 */
@RestController
@RequestMapping("api/v1/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorInfo handleException(RecordNotFoundException ex) {
        ErrorInfo error = new ErrorInfo();
        error.setCode(ERROR_CODES.RECORD_NOT_FOUND);
        error.setMessage("Record with id: " + ex.id);
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }
	
	@RequestMapping("")
	public String home() {
		return "Home URL of Accounts";
	}
	
	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<Account> list() {
		return accountRepository.findAll();
	}

	@RequestMapping(value = "accounts", method = RequestMethod.POST)
	public Account create(@RequestBody Account account) {
		return accountRepository.saveAndFlush(account);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.GET)
	public Account get(@PathVariable int id) {
		Account account = accountRepository.findOne(id);
		if (account == null) throw new RecordNotFoundException(id, "Account ID not found: " + id, null);
		
		return account;
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable int id, @RequestBody Account account) {
		Account existingAccount = accountRepository.findOne(id);
		if (existingAccount == null) throw new RecordNotFoundException(id, "Account ID not found: " + id, null);
		
		BeanUtils.copyProperties(account, existingAccount);
		return accountRepository.saveAndFlush(existingAccount);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.DELETE)
	public Account delete(@PathVariable int id) {
		Account existingAccount = accountRepository.findOne(id);
		if (existingAccount == null) throw new RecordNotFoundException(id, "Account ID not found: " + id, null);
		
		accountRepository.delete(existingAccount);
		return existingAccount;
	}
	
}
