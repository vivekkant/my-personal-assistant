/**
 * 
 */
package org.weekendsoft.mpa.referencedata.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.weekendsoft.mpa.referencedata.model.Account;

/**
 * @author Vivek Kant
 *
 */
@RestController
@RequestMapping("api/v1/")
public class AccountController {
	
	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<Account> list() {
		return AccountStub.list();
	}

	@RequestMapping(value = "accounts", method = RequestMethod.POST)
	public Account create(@RequestBody Account account) {
		return AccountStub.create(account);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.GET)
	public Account get(@PathVariable int id) {
		return AccountStub.get(id);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable int id, @RequestBody Account account) {
		return AccountStub.update(id, account);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.DELETE)
	public Account delete(@PathVariable int id) {
		return AccountStub.delete(id);
	}
	
}
