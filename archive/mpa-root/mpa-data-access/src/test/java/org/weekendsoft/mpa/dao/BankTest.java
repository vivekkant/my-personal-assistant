/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.List;

import org.weekendsoft.mpa.entity.Bank;

/**
 * @author Vivek Kant
 *
 */
public class BankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println( "----------- Creating new Bank -----------" ) ;
		Bank bank = new Bank() ;
		bank.setInstanceId( "DEFAULT" ) ;
		bank.setName( "Test Bank" ) ;
		Bank.create( bank ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		Bank bank2 = Bank.get( bank.getId() ) ;
		System.out.println( bank2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		bank2.setName( "Test Bank 2" ) ;
		Bank.modify( bank2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<Bank> all = Bank.getAll( "DEFAULT" ) ;
		for( Bank at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		Bank.delete( bank2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = Bank.getAll( "DEFAULT" ) ;
		for( Bank at : all ) {
			System.out.println( at ) ;
		}
	}

}
