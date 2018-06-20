/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.AccountType;

/**
 * @author Vivek Kant
 *
 */
public class AccountTypeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println( "----------- Creating new accountType -----------" ) ;
		AccountType accountType = new AccountType() ;
		accountType.setInstanceId( "DEFAULT" ) ;
		accountType.setName( "Test Account Type" ) ;
		AccountType.create( accountType ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		AccountType accountType2 = AccountType.get( accountType.getId() ) ;
		System.out.println( accountType2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		accountType2.setName( "Test Account Type 2" ) ;
		AccountType.modify( accountType2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<AccountType> all = AccountType.getAll( "DEFAULT" ) ;
		for( AccountType at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		AccountType.delete( accountType2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = AccountType.getAll( "DEFAULT" ) ;
		for( AccountType at : all ) {
			System.out.println( at ) ;
		}
	}

}
