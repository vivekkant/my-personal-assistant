/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Account;

/**
 * @author Vivek Kant
 *
 */
public class AccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println( "----------- Creating new account -----------" ) ;
		Account account = new Account() ;
		account.setAccountTypeId( null ) ;
		account.setBankId( null ) ;
		account.setCurrencyId( "INR" ) ;
		account.setInitialBalance( 100.0 ) ;
		account.setInstanceId( "DEFAULT" ) ;
		account.setInternal( false ) ;
		account.setName( "TEST ACCOUNT" ) ;
		Account.create( account ) ;
		
		System.out.println( "----------- Account by Id -----------" ) ;
		Account account2 = Account.get( account.getId() ) ;
		System.out.println( account2 );
		
		System.out.println( "----------- Modify Account -----------" ) ;
		account2.setInitialBalance( 120.0 ) ;
		Account.modify( account2 ) ;
		
		System.out.println( "----------- Account by Id -----------" ) ;
		Account account3 = Account.get( account2.getId() ) ;
		System.out.println( account3 );
		
		System.out.println( "----------- Delete Account -----------" ) ;
		Account.delete( account3 ) ;
		
		System.out.println( "----------- Default Accounts -----------" ) ;
		Account defaultAccount = Account.getIncomeAccount( "DEFAULT" );
		System.out.println( "Income" + defaultAccount ) ;
		defaultAccount = Account.getExpenseAccount( "DEFAULT" ) ;
		System.out.println( "Expense" + defaultAccount ) ;

		System.out.println( "----------- All Accounts -----------" ) ;
		List<Account> accounts = Account.getAll( "DEFAULT" ) ;
		for( Account a : accounts ) {
			System.out.println( a );
		}
	}

}
