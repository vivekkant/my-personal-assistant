/**
 * 
 */
package org.weekendsoft.mpa.referencedata.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weekendsoft.mpa.referencedata.model.Account;
import org.weekendsoft.mpa.referencedata.repository.AccountRepository;

/**
 * @author Vivek Kant
 *
 */
@RestController
@RequestMapping("api/v1/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
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
		return accountRepository.findOne(id);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable int id, @RequestBody Account account) {
		Account existingAccount = accountRepository.findOne(id);
		BeanUtils.copyProperties(account, existingAccount);
		return accountRepository.saveAndFlush(existingAccount);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.DELETE)
	public Account delete(@PathVariable int id) {
		Account existingAccount = accountRepository.findOne(id);
		accountRepository.delete(existingAccount);
		return existingAccount;
	}
	
}
