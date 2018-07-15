package org.weekendsoft.mpa.referencedata.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.weekendsoft.mpa.referencedata.model.Account;

public class AccountStub {
	
	private static 	Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	
	static {
		Account exp = new Account(1, "EXPENSE", "DEFAULT", 0, 0, "INR", true, 0.0);
		accounts.put(exp.getId(), exp);
		Account inc = new Account(2, "INCOME", "DEFAULT", 0, 0, "INR", true, 0.0);
		accounts.put(inc.getId(), inc);
		Account acc1 = new Account(3, "Bank Account", "DEFAULT", 0, 0, "INR", true, 0.0);
		accounts.put(acc1.getId(), acc1);
		Account acc2 = new Account(4, "Cash Account", "DEFAULT", 0, 0, "INR", true, 0.0);
		accounts.put(acc2.getId(), acc2);
	}
	
	public static List<Account> list() {
		return new ArrayList<Account>(accounts.values());
	}

	public static Account create(Account account) {
		int id = Collections.max(accounts.keySet()) + 1;
		account.setId(id);
		accounts.put(id, account);
		return account;
	}
	
	public static Account get(int id) {
		return accounts.get(id);
	}
	
	public static Account update(int id, Account account) {
		account.setId(id);
		accounts.put(id, account);
		return account;
	}
	
	public static Account delete(int id) {
		Account account = accounts.get(id);
		accounts.remove(id);
		return account;
	}

}
