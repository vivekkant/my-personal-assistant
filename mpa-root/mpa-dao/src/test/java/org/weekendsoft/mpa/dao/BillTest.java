/**
 * 
 */
package org.weekendsoft.mpa.dao;

import java.util.Date;
import java.util.List;

import org.weekendsoft.mpa.entity.Account;
import org.weekendsoft.mpa.entity.Bill;

/**
 * @author Vivek Kant
 *
 */
public class BillTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println( "----------- Creating test1 account -----------" ) ;
		Account testaccount1 = new Account() ;
		testaccount1.setAccountTypeId( null ) ;
		testaccount1.setBankId( null ) ;
		testaccount1.setCurrencyId( "INR" ) ;
		testaccount1.setInitialBalance( 100.0 ) ;
		testaccount1.setInstanceId( "DEFAULT" ) ;
		testaccount1.setInternal( false ) ;
		testaccount1.setName( "TEST ACCOUNT 1" ) ;
		Account.create( testaccount1 ) ;
		System.out.println( testaccount1 ) ;
		
		System.out.println( "----------- Creating test2 account -----------" ) ;
		Account testaccount2 = new Account() ;
		testaccount2.setAccountTypeId( null ) ;
		testaccount2.setBankId( null ) ;
		testaccount2.setCurrencyId( "INR" ) ;
		testaccount2.setInitialBalance( 100.0 ) ;
		testaccount2.setInstanceId( "DEFAULT" ) ;
		testaccount2.setInternal( false ) ;
		testaccount2.setName( "TEST ACCOUNT 2" ) ;
		Account.create( testaccount2 ) ;
		System.out.println( testaccount2 ) ;

		System.out.println( "----------- Creating new Bill -----------" ) ;
		Bill bill = new Bill() ;
		bill.setInstanceId( "DEFAULT" ) ;
		bill.setName( "Test Bill" ) ;
		bill.setDebitAccount( testaccount1.getId() ) ;
		bill.setCreditAccount( testaccount2.getId() );
		bill.setAmount( 10.0 ) ;
		bill.setFrequency( "YEARLY" ) ;
		bill.setNumPayments( 5 ) ;
		bill.setAutomatic( false ) ;
		bill.setPaymentDate( new Date() ) ;
		Bill.create( bill ) ;
		
		System.out.println( "----------- Get by Id -----------" ) ;
		Bill bill2 = Bill.get( bill.getId() ) ;
		System.out.println( bill2 ) ;
		
		System.out.println( "----------- Modify -----------" ) ;
		bill2.setName( "Test Bill 2" ) ;
		Bill.modify( bill2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		List<Bill> all = Bill.getAll( "DEFAULT" ) ;
		for( Bill at : all ) {
			System.out.println( at ) ;
		}
		
		System.out.println( "----------- Delete -----------" ) ;
		Bill.delete( bill2 ) ;
		
		System.out.println( "----------- Get All -----------" ) ;
		all = Bill.getAll( "DEFAULT" ) ;
		for( Bill at : all ) {
			System.out.println( at ) ;
		}
		
		Account.delete( testaccount1 ) ;
		Account.delete( testaccount2 ) ;
	}

}
